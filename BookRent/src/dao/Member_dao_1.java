package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Member_dto_1;

public class Member_dao_1 {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	//회원 등록
	public int memberReg(Member_dto_1 dto) {
		int result = 0;
		String query = "insert into b17_bookmember\r\n" + 
					   "(id, name, address, tel, age, reg_date)\r\n" + 
					   "values('"+dto.getId()+"', '"+dto.getName()+"', '"+dto.getAddress()+"', '"+dto.getTel()+"',"+dto.getAge()+", '"+dto.getReg_date()+"')";

		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("member() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("member() 오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		return result;
	}
	//회원 조회
	public ArrayList<Member_dto_1> getSearch(String search, String gubun){
		ArrayList<Member_dto_1> arr = new ArrayList<>();
		String query = " SELECT id, name, address, tel, age, to_char(reg_date, 'yyyy-mm_dd') \r\n" + 
					   " FROM b17_bookmember \r\n" + 
					   " where "+search+" = '"+gubun+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String tel = rs.getString(4);
				int age = rs.getInt(5);
				String reg_date = rs.getString(6);
				
				Member_dto_1 dto = new Member_dto_1(id, name, address, tel,reg_date, age);
				arr.add(dto);
				
			}
		}catch(SQLException se){
			System.out.println("saveScore() query 오류:"+query);
		}catch(Exception e){
			System.out.println("saveScore() 오류:"+query);
		}finally {
			common.close(con, ps, rs);
		}
		
		
		return arr;
	}
	//회원수정을 위한 회원조회
	public Member_dto_1 getView(String id) {
		Member_dto_1 dto = null;
		String query = " SELECT id, name, address, tel, age, to_char(reg_date, 'yyyy-mm_dd') \r\n" + 
					   " FROM b17_bookmember\r\n" + 
					   " where id = '"+id+"' ";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			 
			while(rs.next()) {  //1명 이상이면 while이고 1명이면 if를 쓰면 된다
				String ids = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String tel = rs.getString(4);
				int age = rs.getInt(5);
				String reg_date = rs.getString(6);
				dto = new Member_dto_1(ids, name, address, tel,reg_date, age);
			}
			
		}catch(SQLException se) {
			System.out.println("getMemberView() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("getMemberView() 오류:"+query);
		}finally {
			common.close(con, ps, rs);
		}
		
		return dto;
	}
	
	
	//회원수정
	public int updateView(String id, String name, String address, String tel, String reg_date, int age) {
		int result = 0;
		String query = " UPDATE b17_bookmember\r\n" + 
					   " set name = '"+name+"',\r\n" + 
					   "    address = '"+address+"',\r\n" + 
					   "    tel = '"+tel+"',\r\n" + 
					   "    age = '"+age+"',\r\n" + 
					   "    reg_date = '"+reg_date+"'\r\n" + 
					   "where id = '"+id+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("member() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("member() 오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		return result;
	}
	
	
	//회원삭제
	public int deleteMember(String id) {
		int result = 0;
		String query = " DELETE from b17_bookmember\r\n" + 
					   " where id = '"+id+"'";
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("member() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("member() 오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		return result;
	}
	

}
