package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.HistoryMember;
import dto.Rent_1_dto;

public class Rent_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 회원별 대출이력
	public ArrayList<HistoryMember> getHistoryMember(String memberId){
		ArrayList<HistoryMember> arr = new ArrayList<>();
		String query="select a.no, b.name, c.no, c.name, "+
				" to_char(a.rent_date,'yyyy-MM-dd'), decode(a.return_date,null,'대여중',to_char(a.return_date,'yyyy-MM-dd')) \r\n" + 
				" from b00_rent a, b00_bookmember b, b00_book c \r\n" + 
				" where a.member_id = b.id \r\n" + 
				" and a.book_no = c.no \r\n" + 
				" and a.member_id ='"+memberId+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String rNo 			= rs.getString(1);
				String memberName 	= rs.getString(2);
				String bookNo 		= rs.getString(3);
				String bookName 	= rs.getString(4);
				String rentDate 	= rs.getString(5);
				String returnDate 	= rs.getString(6);

				HistoryMember dto = new HistoryMember(rNo,memberName,bookNo,
						bookName,rentDate,returnDate);
				arr.add(dto);
				
			}
			
		}catch(SQLException se) {
			System.out.println("getMaxRentNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getMaxRentNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		
		
		return arr;
	}
	
	public int returnBook(String rentNo){
		int result =0;
		String query=" update b00_book \r\n" + 
				" set rent_gubun = 'y' \r\n" + 
				" where no =(select book_no \r\n" + 
				"           from b00_rent where no='"+rentNo+"')";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("returnBook() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("returnBook() 오류");
		}finally {
			common.close(connection, ps);
		}		
		return result;
	}
	
	
	//반납
	public int returnRent(String rentNo, String returnDate){
		int result =0;
		String query=" update b00_rent \r\n" + 
				" set return_date ='"+returnDate+"' \r\n" + 
				" where no ='"+rentNo+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("returnRent() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("returnRent() 오류");
		}finally {
			common.close(connection, ps);
		}		
		return result;
	}
	
	public ArrayList<Rent_1_dto> getRentList(String mId){
		ArrayList<Rent_1_dto> arr = new ArrayList<>();
		String query = "select a.no, b.id,b.name, c.no,c.name, "+
						" to_char(a.rent_date,'yyyy-MM-dd'), c.rent_gubun "+
						" from b00_rent a, b00_bookmember b, b00_book c "+
						" where a.member_id = b.id "+
						" and a.book_no = c.no "+
						" and a.member_id ='"+mId+"' "+
						" order by c.rent_gubun ";
		
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			while(rs.next()) {
				String rentNo 		= rs.getString(1);
				String memberId 	= rs.getString(2);
				String memberName 	= rs.getString(3);
				String bookNo 		= rs.getString(4);
				String bookName 	= rs.getString(5);
				String rentDate 	= rs.getString(6);
				String rentGubun 	= rs.getString(7);
				Rent_1_dto dto = new Rent_1_dto(rentNo,memberId,memberName,
												bookNo,bookName,rentDate,rentGubun);
				arr.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("getCheckMemberId() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getCheckMemberId() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return arr;
	}
	
	public int getCheckValue(String gubun, String val){
		int result = 0;
		String query="";
		if(gubun.equals("member")) {
			 query="select count(*) \r\n" + 
					" from b00_bookmember \r\n" + 
					" where id ='"+val+"'";				
		} else {
			query="select count(*) \r\n" + 
					" from b00_book \r\n" + 
					" where no ='"+val+"' "+
					" and rent_gubun ='y'";			
		}
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException se) {
			System.out.println("getCheckVule() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getCheckVule() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
		
	
	
	public int getCheckBookNo(String bookNo){
		int result = 0;
		String query="select count(*) \r\n" + 
				" from b00_book \r\n" + 
				" where no ='"+bookNo+"' "+
				" and rent_gubun ='y'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException se) {
			System.out.println("getMaxRentNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getMaxRentNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	
	
	public int getCheckMemberId(String memberId){
		int result = 0;
		String query="select count(*) \r\n" + 
				" from b00_bookmember \r\n" + 
				" where id ='"+memberId+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException se) {
			System.out.println("getCheckMemberId() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getCheckMemberId() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	
	public String getMaxRentNo() {
		String maxNo="";
		String query=" select max(no) from b00_rent ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
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
				String newNo = df.format((double)i);
				maxNo = "R"+newNo; // maxNO ="R0005"
			}
			
		}catch(SQLException se) {
			System.out.println("getMaxRentNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getMaxRentNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}
	
	
	
	
	public int setBookRentGugun(String bookNo){
		int result =0;
		String query=" update b00_book\r\n" + 
				" set rent_gubun ='n'\r\n" + 
				" where no ='"+bookNo+"'";		
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("bookNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("bookNo() 오류");
		}finally {
			common.close(connection, ps);
		}
		
		
		return result;
	}
	
	public int saveRent(String rentNo,String memberId,
			            String bookNo,String rentDate){
		int result =0;
		String query=" insert into b00_rent\r\n" + 
				" (no, member_id, book_no, rent_date)\r\n" + 
				" values\r\n" + 
				" ('"+rentNo+"','"+memberId+"','"+bookNo+"','"+rentDate+"')";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("saveRent() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("saveRent() 오류");
		}finally {
			common.close(connection, ps);
		}			
		return result;
	}
	
	
}








