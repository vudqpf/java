package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Rent_dto;

public class RentInfo_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//회원아이디, 차량넘버 존재여부
	public int member_idview(String gubun, String search) {
		int result = 0;
		String query = "";
		if(gubun.equals("id")) {
		query = " select count(*)\r\n" + 
				" from b17_bookmember\r\n" + 
				" where "+gubun+" = '"+search+"'";
		}else {
			query = " select count(*)\r\n" + 
				    " from c17_car\r\n" + 
					" where "+gubun+" = '"+search+"'";
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

	//렌트  no지정해주기
	public String getMaxRentNo() {
		String result = "";
		String query =" select max(rent_no) from c17_carrent";
		
		String maxNo = "";
		String nos = "";
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString(1);
				
				if(maxNo.equals("null")) {
					maxNo = "R0001";
				}else {
					String no = maxNo.substring(1);
					int n = Integer.parseInt(no);
					n = n + 1;
					DecimalFormat df = new DecimalFormat("0000");
					maxNo = df.format(n);
					
					
				}
			}
		}catch(SQLException se) {
			System.out.println("getMaxRentNo() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("getMaxRentNo()  오류:");
		}finally {
			common.close(con, ps, rs);
		}
		
		return "R"+maxNo;
		
	}

	//insert해주기
	public int insertRent(Rent_dto dto) {
		int result = 0;
		String query = "INSERT INTO c17_carrent(rent_no, member_no, car_no, rent_date, return_day)\r\n" + 
					   "VALUES ('"+dto.getRent_no()+"', '"+dto.getMember_no()+"', '"+dto.getCar_no()+"', '"+dto.getRent_date()+"', '"+dto.getReturn_day()+"')";
		
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("insertRent() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("insertRent()  오류:");
		}finally {
			common.close(con, ps);
		}
		
		return result;
		
	}
	
	//차량 상태[y] → [n]로 변경해주기~
	public int carInfoUpdate(String car_no) {
		int result = 0;
		String query = " UPDATE c17_car\r\n" + 
					   " set rent_gubun = 'n'\r\n" + 
					   " where no = '"+car_no+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("carInfoUpdate() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("carInfoUpdate()  오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		
		return result;
	}

	//반납할 이력조회
	public Rent_dto carRentView(String carNo) {
		Rent_dto dto = null;
		String query = " SELECT a.rent_no, b.name, b.id, c.model_name, to_char(a.rent_date, 'yyyy-MM-dd'), \r\n" + 
					   "       to_char(a.return_day, 'yyyy-MM-dd'), decode(c.rent_gubun,'y','대여가능','n','대여불가')\r\n" + 
					   " FROM c17_carrent a, b17_bookmember b, c17_car c\r\n" + 
					   " where a.member_no = b.id\r\n" + 
					   " and a.car_no = c.no" + 
					   " and a.rent_no = '"+carNo+"'";
	///////////////////////////////////////////////////	
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				String rent_no = rs.getString(1);
				String member_no = rs.getString(2);
				String member_name = rs.getString(3);
				String car_no = rs.getString(4);
				String rent_date = rs.getString(6);
				String return_day = rs.getString(7);
				String rent_gubun = rs.getString(8);
			
				
				dto = new Rent_dto(rent_no, member_no, member_name, car_no, rent_date, return_day, "", rent_gubun);
				
			}
			
		}catch(SQLException se) {
			System.out.println("carRentView() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("carRentView()  오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		
		
		return dto;
	}

	//차량반납 쿼리문
	public int returnUpdate(String carNo, String returnDate) {
		int result = 0;
		String query = " UPDATE c17_carrent\r\n" + 
					   " set return_date = '"+returnDate+"'\r\n" + 
					   " where rent_no = '"+carNo+"'";
		
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("returnUpdate() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("returnUpdate()  오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		return result;
	}

	//차량 상태를 [y]→[n] 으로 변경해주기
	public int rentChange(String carNo) {
		int result = 0;
		String query = " update c17_car\r\n" + 
					   " set rent_gubun = 'y'\r\n" + 
					   " where no = (select car_no from c17_carrent where Rent_no = '"+carNo+"')";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("rentChange() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("rentChange()  오류:"+query);
		}finally {
			common.close(con, ps);
		}	
		
		return result;
	}

	//회원이력조회
	public ArrayList<Rent_dto> rentView(String gubun, String memberView) {
		ArrayList<Rent_dto> arr = new ArrayList<Rent_dto>();
		String query = "";
		if(gubun.equals("all")) {
			query = " SELECT a.rent_no, b.name, b.id, c.model_name, to_char(a.rent_date, 'yyyy-MM-dd'), to_char(a.return_day, 'yyyy-MM-dd'),decode(a.return_date,null,'대여중', TO_CHAR(a.return_date,'yyyy-MM-dd')), c.rent_gubun\r\n" + 
					" FROM c17_carrent a, b17_bookmember b, c17_car c\r\n" + 
					" where a.member_no = b.id\r\n" + 
					" and a.car_no = c.no\r\n";
		}else {
			query = " SELECT a.rent_no, b.name, b.id, c.model_name, to_char(a.rent_date, 'yyyy-MM-dd'), to_char(a.return_day, 'yyyy-MM-dd'),decode(a.return_date,null,'대여중', TO_CHAR(a.return_date,'yyyy-MM-dd')), c.rent_gubun\r\n" + 
					" FROM c17_carrent a, b17_bookmember b, c17_car c\r\n" + 
					" where a.member_no = b.id\r\n" + 
					" and a.car_no = c.no\r\n" + 
					" and b.name like '%"+memberView+"%'";
		}
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String rent_no = rs.getString(1);
				String member_no = rs.getString(2);
				String member_name = rs.getString(3);
				String car_no = rs.getString(4);
				String rent_date = rs.getString(5);
				String return_day = rs.getString(6);
				String return_date = rs.getString(7);
				String rent_gubun = rs.getString(8);
				
				Rent_dto dto = new Rent_dto(rent_no, member_no, member_name, car_no, rent_date, return_day, return_date, rent_gubun);
				arr.add(dto);
			}
			
		}catch(SQLException se) {
			System.out.println("rentView() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("rentView() 오류:"+query);
		}finally {
			common.close(con, ps, rs);
		}	
		
		return arr;
	}

	//차량 렌트상태가 n이면 대여불가능하도록 
	public String car_rent_yn(String car_no) {
		String result = "";
		String query = " select rent_gubun\r\n" + 
					   " from c17_car\r\n" + 
					   " where no = '"+car_no+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
		}catch(SQLException se) {
			System.out.println("car_rent_yn() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("car_rent_yn()  오류:"+query);
		}finally {
			common.close(con, ps, rs);
		}
		
		
		
		return result;
	}

	//렌트가 되어있는 차량이 반납완료되면 반납 불가능 하도록
	public String returnnope(String carNo) {
		String result = "";
		String query = " select to_char(return_date,'yyyy-mm-dd')\r\n" + 
					   " from c17_carrent\r\n" + 
					   " where rent_no = '"+carNo+"'";
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
		}catch(SQLException se) {
			System.out.println("car_rent_yn() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("car_rent_yn()  오류:"+query);
		}finally {
			common.close(con, ps, rs);
		}

		
		return result;
	}
	
}
