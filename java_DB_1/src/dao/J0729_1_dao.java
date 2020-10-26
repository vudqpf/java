package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.J0729_1_dto;

public class J0729_1_dao {
	DBConnectionOracle common = new DBConnectionOracle();//getconnection이란걸 만들어놔서 그걸 가지고 오려고 밑에 cond을 생성
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//여러개검색
	public ArrayList<J0729_1_dto> getListMember(String gubun,String search, 
												int startAge, int endAge) {
		ArrayList<J0729_1_dto> arr = new ArrayList<>();
		String query = " select id, name, area, age from member ";
		
		if(gubun.equals("sName")) {
			query = query + " where name like '%"+search+"%' ";
		}else if(gubun.equals("sArea")) {
			query = query + " where area like '%"+search+"%' ";
		}else if(gubun.equals("sAge")) {
			query = query + "  where age >= "+startAge+" and age <= "+endAge+" ";
		}

		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String area = rs.getString("area");
				int age = rs.getInt(4);
				
				J0729_1_dto dto = new J0729_1_dto(id, name, area, age);
				arr.add(dto);
			}			
		}catch(SQLException se) {
			System.out.println("getListAll query 오류"+query);//try안에 query에 문제가 생기면 출력
		}catch(Exception e) {
			System.out.println("getListAll 오류");
		}finally { //위에서 오류가 나든 안나든 무조건 실행됨. 
			common.close(connection, ps, rs);
		}
		return arr;
	}
/*	
	//전체조회
	public ArrayList<J0729_1_dto> getListAll() {
		ArrayList<J0729_1_dto> arr = new ArrayList<>();
		String query = "select id, name, area, age from member";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String area = rs.getString("area");
				int age = rs.getInt(4);
				
				J0729_1_dto dto = new J0729_1_dto(id, name, area, age);
				arr.add(dto);
			}			
		}catch(SQLException se) {
			System.out.println("getListAll query 오류"+query);//try안에 query에 문제가 생기면 출력
		}catch(Exception e) {
			System.out.println("getListAll 오류");
		}finally { //위에서 오류가 나든 안나든 무조건 실행됨. 
			common.close(connection, ps, rs);
		}
		return arr;
	}
	//이름조회
		public ArrayList<J0729_1_dto> getListName(String search) {
			ArrayList<J0729_1_dto> arr = new ArrayList<>();
			String query = " select id, name, area, age from member "+
							" where name like '%"+search+"%' ";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					String area = rs.getString("area");
					int age = rs.getInt(4);
					
					J0729_1_dto dto = new J0729_1_dto(id, name, area, age);
					arr.add(dto);
				}			
			}catch(SQLException se) {
				System.out.println("getListAll query 오류"+query);//try안에 query에 문제가 생기면 출력
			}catch(Exception e) {
				System.out.println("getListAll 오류");
			}finally { //위에서 오류가 나든 안나든 무조건 실행됨. 
				common.close(connection, ps, rs);
			}
			return arr;
}
		//지역검색
		public ArrayList<J0729_1_dto> getListArea(String search) {
			ArrayList<J0729_1_dto> arr = new ArrayList<>();
			String query = " select id, name, area, age from member "+
							" where area like '%"+search+"%' ";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					String area = rs.getString("area");
					int age = rs.getInt(4);
					
					J0729_1_dto dto = new J0729_1_dto(id, name, area, age);
					arr.add(dto);
				}			
			}catch(SQLException se) {
				System.out.println("getListAll query 오류"+query);//try안에 query에 문제가 생기면 출력
			}catch(Exception e) {
				System.out.println("getListAll 오류");
			}finally { //위에서 오류가 나든 안나든 무조건 실행됨. 
				common.close(connection, ps, rs);
			}
			return arr;
		}
		//나이검색
		public ArrayList<J0729_1_dto> getListAge(int startAge, int endAge) {
			ArrayList<J0729_1_dto> arr = new ArrayList<>();
			String query = " select id, name, area, age from member "+
							"  where age >= "+startAge+" and age <= "+endAge+" ";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					String area = rs.getString("area");
					int age = rs.getInt(4);
					
					J0729_1_dto dto = new J0729_1_dto(id, name, area, age);
					arr.add(dto);
				}			
			}catch(SQLException se) {
				System.out.println("getListAll query 오류"+query);//try안에 query에 문제가 생기면 출력
			}catch(Exception e) {
				System.out.println("getListAll 오류");
			}finally { //위에서 오류가 나든 안나든 무조건 실행됨. 
				common.close(connection, ps, rs);
			}
			return arr;
		}		
*/
	
}
