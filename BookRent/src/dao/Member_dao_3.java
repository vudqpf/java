package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Member_dto_2;
import dto.Member_dto_3;

public class Member_dao_3 {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//대여no 지정해 주기
	public String getMaxRentNo() {
		String maxNo="";
		String query=" select max(no) from b17_rent ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo.equals("null")) {
				maxNo ="R0001";
			}else {
				//maxNo = "R0004";
				String n = maxNo.substring(1); //n = "0004"
				int i = Integer.parseInt(n); // i = 4
				i = i + 1; // i = 5
				DecimalFormat df = new DecimalFormat("0000");
				String newNo = df.format((double)i); //newNo = "0005"
				maxNo = "R"+newNo; // maxNO ="R0005"
			}
			
		}catch(SQLException se) {
			System.out.println("getMaxRentNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getMaxRentNo() 오류");
		}finally {
			common.close(con, ps, rs);
		}		
		return maxNo;
	}
	
	//book_no를 도서목록에서 대여상태[n]으로 변환시켜주기
	public int setBookRentGubun(String bookno) {
		int result = 0;
		String query = " update b17_book\r\n" + 
					   " set rent_gubun = 'n'\r\n" + 
					   " where no = '"+bookno+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("setBookRentGubun() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("setBookRentGubun()  오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		return result;
	}
	
	
	//대여 입력
	public int saveRent(Member_dto_3 dto) {
		int result = 0;
		String query = " INSERT INTO b17_rent(no, member_id, book_no, rent_date)\r\n" + 
					   " VALUES ('"+dto.getNo()+"', '"+dto.getMember_id()+"', '"+dto.getBook_no()+"', '"+dto.getRent_date()+"')";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("saveRent() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("saveRent()  오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		return result;
		
	}
	
	//대여 - 회원아이디 존재여부
	public int getCheckValue(String gubun, String val) {
		int result = 0;
		String query;
		if(gubun.equals("member")) {
			query = " select count(*)\r\n" + 
					   " from b17_bookmember\r\n" + 
					   " where id = '"+val+"'";	
		}else {
		query = " select count(*)\r\n" + 
					   " from b17_book\r\n" + 
					   " where no = '"+val+"'" +
					   " and rent_gubun = 'y'";
		}
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);

			}
		}catch(SQLException se) {
			System.out.println("getCheckValue() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("getCheckValue()  오류:"+query);
		}finally {
			common.close(con, ps, rs);
		}
		
		
		return result;
	}
/*	
	public ArrayList<Member_dto_3> getRentList(String memberID){
		ArrayList<Member_dto_3> arr = new ArrayList<>();
		String query = " select a.no, b.id, b.name, c.no, c.name, a.rent_date, c.rent_gubun\r\n" + 
				   " from b17_rent a, b17_bookmember b, b17_book c\r\n" + 
				   " where a.member_id = b.id\r\n" + 
				   " and a.book_no = c.no\r\n" + 
				   " and a.member_id = '"+member_id+"'\r\n" + 
				   " order by c.rent_gubun desc";
	}
*/	
	
	//반납할 회원 조회하기~!
	public ArrayList<Member_dto_3> getRentList(String member_id) {
		ArrayList<Member_dto_3> arr = new ArrayList<>();
		String query = " select a.no, b.id, b.name, c.no, c.name,  to_char(a.rent_date, 'yyyy-mm-dd'), c.rent_gubun\r\n" + 
					   " from b17_rent a, b17_bookmember b, b17_book c\r\n" + 
					   " where a.member_id = b.id\r\n" + 
					   " and a.book_no = c.no\r\n" + 
					   " and a.member_id = '"+member_id+"'\r\n" + 
					   " order by c.rent_gubun desc";
		
		System.out.println(query);
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {			
				String no = rs.getString(1);
				String memberId = rs.getString(2);			
				String memberName = rs.getString(3);
				String bookNo = rs.getString(4);
				String bookName = rs.getString(5);
				String rentDate = rs.getString(6);
				String rentGubun = rs.getString(7);

				Member_dto_3 dto = new Member_dto_3(no, memberId, memberName, bookNo, bookName, rentDate, rentGubun);
				arr.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("getCheckId() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("getCheckId()  오류:"+query);
		}finally {
			common.close(con, ps, rs);
		}
		
		return arr;
	}
	
	//반납날짜 입력
	public int returnRent(String rNo, String returnDate) {
		int result = 0;
		String query = " UPDATE b17_rent\r\n" + 
					   " set return_date = '"+returnDate+"'\r\n" + 
					   " where no = '"+rNo+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("returnRent() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("returnRent()  오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		
		return result;
	}
	public int returnBook(String rNo) {
		int result = 0;
		String query = " update b17_book\r\n" + 
					   " set rent_gubun = 'y'\r\n" + 
					   " where no = (SELECT book_no FROM b17_rent where no = '"+rNo+"')";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("returnRent() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("returnRent()  오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		
		return result;
	}
	
}
