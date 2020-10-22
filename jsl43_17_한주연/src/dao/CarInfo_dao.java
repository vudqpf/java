package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Carinfo_dto;


public class CarInfo_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	//차량 등록
	public int carinfo(Carinfo_dto dto1) {
		int result = 0;
		String query = " insert INTO c17_car( no, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn, accident_yn, fuel_type, import_date)\r\n" + 
					   " VALUES ('"+dto1.getNo()+"', '"+dto1.getModel_name()+"', '"+dto1.getCar_number()+"', '"+dto1.getCar_made()+"', '"+dto1.getCar_made_ym()+"', '"+dto1.getAuto_yn()+"', '"+dto1.getOption_yn()+"', '"+dto1.getAccident_yn()+"', '"+dto1.getFuel_type()+"', '"+dto1.getImport_date()+"')";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("carinfo() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("carinfo() 오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		
		return result;
	}

	//차량 조회
	public ArrayList<Carinfo_dto> getSearch(String search, String gubun) {
		ArrayList<Carinfo_dto> arr = new ArrayList<>();
		String query = " SELECT a.no, a.model_name, a.car_number, b.made_name, a.car_made_ym, a.auto_yn, a.option_yn, a.accident_yn, c.fuel_name, to_char(a.import_date, 'yyyy-mm_dd'), a.rent_gubun\r\n" + 
					   " FROM c17_car a, car_common_made b, car_common_fuel c\r\n" + 
					   " where a.car_made = b.made_code\r\n" + 
					   " and a.fuel_type = c.fuel_type\r\n";
		
		if(!search.equals("aaa")) query += " and "+search+" like '%"+gubun+"%'";
		
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString(1);
				String model_name = rs.getString(2);
				String car_number = rs.getString(3);
				String made_name = rs.getString(4);
				String car_made_ym = rs.getString(5);
				String auto_yn = rs.getString(6);
				String option_yn = rs.getString(7);
				String accident_yn = rs.getString(8);
				String fuel_name = rs.getString(9);
				String import_date = rs.getString(10);
				String rent_gubun = rs.getString(11);
				
				
				Carinfo_dto dto = new Carinfo_dto(no, model_name, car_number, made_name, car_made_ym, auto_yn, option_yn, accident_yn, fuel_name, import_date, rent_gubun);
				arr.add(dto);
				
			}
		}catch(SQLException se){
			System.out.println("gerSearch() query 오류:"+query);
		}catch(Exception e){
			System.out.println("gerSearch() 오류:"+query);
		}finally {
			common.close(con, ps, rs);
		}
		
		return arr;
	}
/*	
	//조회 - 전체조회
	public carinfo_dto getView() {
		ArrayList<carinfo_dto> arr = new ArrayList<>();
		String query = " SELECT a.no, a.model_name, a.car_number, b.made_name, a.car_made_ym, a.auto_yn, a.option_yn, a.accident_yn, c.fuel_name, to_char(a.import_date, 'yyyy-mm_dd'), a.rent_gubun\r\n" + 
					   " FROM c17_car a, car_common_made b, car_common_fuel c\r\n" + 
					   " where a.car_made = b.made_code\r\n" + 
					   " and a.fuel_type = c.fuel_type\r\n";
		
		try {
		con = common.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		if(rs.next()) {
			String nos = rs.getString(1);
			String model_name = rs.getString(2);
			String car_number = rs.getString(3);
			String made_name = rs.getString(4);
			String car_made_ym = rs.getString(5);
			String auto_yn = rs.getString(6);
			String option_yn = rs.getString(7);
			String accident_yn = rs.getString(8);
			String fuel_name = rs.getString(9);
			String import_date = rs.getString(10);
			String rent_gubun = rs.getString(11);
			
			
			arr = new carinfo_dto(nos, model_name, car_number, made_name, car_made_ym, auto_yn, option_yn, accident_yn, fuel_name, import_date, rent_gubun);

		}
		
	}catch(SQLException se) {
		System.out.println("View() query 오류:"+query);
	}catch(Exception e) {
		System.out.println("View() 오류:"+query);
	}finally {
		common.close(con, ps, rs);
	}
	
		return arr;
	}
*/
	
	//수정, 삭제을 위한 조회
	public Carinfo_dto getView(String no) {
		Carinfo_dto dto = null;
		String query = " SELECT a.no, a.model_name, a.car_number, b.made_name, a.car_made_ym, a.auto_yn, a.option_yn, \r\n" + 
					   "       a.accident_yn, c.fuel_name, to_char(a.import_date, 'yyyy-mm_dd'), decode(a.rent_gubun,'y','대여가능','n','대여불가') \r\n" + 
					   " FROM c17_car a, car_common_made b, car_common_fuel c\r\n" + 
					   " where a.car_made = b.made_code\r\n" + 
					   " and a.fuel_type = c.fuel_type\r\n" + 
					   " and a.no = '"+no+"'";
		
		try {
		con = common.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		if(rs.next()) {
			String nos = rs.getString(1);
			String model_name = rs.getString(2);
			String car_number = rs.getString(3);
			String made_name = rs.getString(4);
			String car_made_ym = rs.getString(5);
			String auto_yn = rs.getString(6);
			String option_yn = rs.getString(7);
			String accident_yn = rs.getString(8);
			String fuel_name = rs.getString(9);
			String import_date = rs.getString(10);
			String rent_gubun = rs.getString(11);
			
			
			dto = new Carinfo_dto(nos, model_name, car_number, made_name, car_made_ym, auto_yn, option_yn, accident_yn, fuel_name, import_date, rent_gubun);

		}
		
	}catch(SQLException se) {
		System.out.println("getView() query 오류:"+query);
	}catch(Exception e) {
		System.out.println("getView() 오류:"+query);
	}finally {
		common.close(con, ps, rs);
	}
	
		return dto;
	}

	//차량 정보 수정
	public int updateNo(String no, String model_name, String car_number, String car_made, String car_made_ym,
			String auto_yn, String option_yn, String accident_yn, String fuel_type, String import_date) {
		
		int result = 0;
		String query = " UPDATE c17_car\r\n" + 
					   " set model_name = '"+model_name+"',\r\n" + 
					   " car_number = '"+car_number+"',\r\n" + 
					   " car_made = '"+car_made+"',\r\n" + 
					   " car_made_ym = '"+car_made_ym+"',\r\n" + 
					   " auto_yn = '"+auto_yn+"',\r\n" + 
					   " option_yn = '"+option_yn+"',\r\n" + 
					   " accident_yn = '"+accident_yn+"',\r\n" + 
					   " fuel_type = '"+fuel_type+"',\r\n" + 
					   " import_date = '"+import_date+"'\r\n" + 
					   " where no = '"+no+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("updateNo() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("updateNo() 오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		
		return result;
	}

	//차량 삭제
	public int deleteNo(String no) {
		int result = 0;
		String query = " DELETE FROM c17_car \r\n" + 
					   " WHERE no = '"+no+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("carinfo() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("carinfo() 오류:"+query);
		}finally {
			common.close(con, ps);
		}

		return result;
	}
	

}
