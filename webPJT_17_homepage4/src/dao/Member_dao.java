package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionOracle;
import dto.Member_dto;

public class Member_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//회원가입
	public int saveMember(Member_dto dto) {
		int result = 0;
		String query = " insert into h17_member\r\n" + 
					   " (id, name, pw, area, address, tel_1, tel_2, tel_3, mf, hobby_t, hobby_r, hobby_s, reg_date)\r\n" + 
					   " values('"+dto.getId()+"', '"+dto.getName()+"', '"+dto.getPw()+"', '"+dto.getArea()+"','"+dto.getAddress()+"'," +
					   " '"+dto.getTel_1()+"', '"+dto.getTel_2()+"', '"+dto.getTel_3()+"', '"+dto.getMf()+"', '"+dto.getHobby_t()+"','"+dto.getHobby_r()+"','"+dto.getHobby_s()+"', '"+dto.getReg_date()+"')";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result = ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("getNewsSave() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNewsSave() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		return result;		
	}
	
	//로그인
	public String getLoginName(String id, String pw) {
		String name = null;
		String query =  " select name from h17_member\r\n" + 
					    " where id = '"+id+"' and pw = '"+pw+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery(); 
			if(rs.next()) {
				name = rs.getString(1);
			}
		}catch(SQLException se) {
			System.out.println("getLoginName() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getLoginName() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		return name;
	}
	
	//ID 중복체크
	public int idCheckCount(String id) {
		int count = 0;
		String query =  " select count(*)\r\n" + 
					    " from h17_member\r\n" + 
					    " where id = '"+id+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery(); 
			if(rs.next()) count = rs.getInt(1);
		}catch(SQLException se) {
			System.out.println("idCheckCount() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("idCheckCount() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		return count;
	}
}
