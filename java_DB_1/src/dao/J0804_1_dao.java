package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.J0804_1_dto;
import dto.J0806_1_dto;

public class J0804_1_dao {
	DBConnectionOracle common = new DBConnectionOracle();//getconnection이란걸 만들어놓고 그걸 가지고 오려고 밑에 cond을 생성
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<J0804_1_dto> getMemberList(String gubun, String search){
		ArrayList<J0804_1_dto> arr = new ArrayList<>();
		String query = " SELECT a.no, a.name, b.area_name, a.age, nvl(a.age, 0) as age \r\n" + 
				      " FROM t17_Member a, a_area_info b\r\n" + 
				      " where a.area = b.area_code \r\n"+
				      "and "+ gubun+" like'%"+search+"%'";
				      
	/*
		if(gubun.equals("no")) {
			query = query + "and a.no like'%"+search+"%'";
//			query +=		"and a.no like'%"+no+"%'";
		}else if(gubun.equals("name")){
			query = query + "and a.name like'%"+search+"%'";
		}else if(gubun.equals("area")) {
			query = query + "and b.area_name like'%"+search+"%'";
		}
	*/
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String name = rs.getString("name");
				String area = rs.getString("area_name"); //SQL의 콘솔창과 동일한 이름으로 지정해야만 함!
				int age = rs.getInt("age");
				J0804_1_dto dto = new J0804_1_dto(no, name, area, age);
				arr.add(dto);
			}
			
		}catch(SQLException se) {  //SQL오류나면 이리 넘어옴
			System.out.println("getMemberLsit() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("getMemberLsit() 오류:");
		}finally {
			common.close(connection, ps, rs);
		}
		return arr;
	}
	
	//등록
	public int saveMember(J0804_1_dto dto){
		int result = 0;
		String query = " insert into t17_member (no, name, area, age) "+
					   " values('"+dto.getNo()+"', '"+dto.getName()+"', '"+dto.getArea()+"', "+dto.getAge()+")";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
//			rs = ps.executeQuery();      //insert시키기 때문에 필요가 없음  셀렉트 문에만 필요
			result = ps.executeUpdate(); //insert시키는 query문에 문제가 없으면 1을 리턴, 문제있으면 0을 리턴
										 //update시키는 query문에 문제가 없으면 1을 리턴, 문제있으면 0을 리턴
										 //delete시키는  query문에 문제가 없으면 1을 리턴, 문제있으면 0을 리턴
			
			
		}catch(SQLException se) {
			System.out.println("saveMember(dto) query 오류:"+query);
		}catch(Exception e) {
			System.out.println("saveMember(dto) 오류:"+query);
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}

	//등록
	public int saveMember(String no, String name, String area, int age) {
		int result = 0;
		String query = " insert into t17_member (no, name, area, age) "+
					   " values('"+no+"', '"+name+"', '"+area+"', "+age+")";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
//			rs = ps.executeQuery();      //insert시키기 때문에 필요가 없음  셀렉트 문에만 필요
			result = ps.executeUpdate(); //insert시키는 query문에 문제가 없으면 1을 리턴, 문제있으면 0을 리턴
										 //update시키는 query문에 문제가 없으면 1을 리턴, 문제있으면 0을 리턴
										 //delete시키는  query문에 문제가 없으면 1을 리턴, 문제있으면 0을 리턴
			
			
		}catch(SQLException se) {
			System.out.println("saveMember() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("saveMember() 오류:"+query);
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
	
	//수정하기 위해 조회
	public J0804_1_dto getMemberView(String no) {
		J0804_1_dto dto = null;
		String query = 		" select a.no, a.name, b.area_name, nvl(a.age,0) as age  " +
							" from t17_member a, a_area_info b "+
							" where a.area = b.area_code " +
							" and a.no = '"+no+"'";
	
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();      //insert시키기 때문에 필요가 없음  셀렉트 문에만 필요
										//query문이 실행되고 결과값이 rs에 입력됨
			while(rs.next()) {
				String nn = rs.getString(1);
				String name = rs.getString(2);
				String area = rs.getString(3);
				int age = rs.getInt(4);
				dto = new J0804_1_dto(nn, name, area, age);
			}
			
		}catch(SQLException se) {
			System.out.println("saveMember() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("saveMember() 오류:"+query);
		}finally {
			common.close(connection, ps);
		}
		
	return dto;
	}
	
	//수정
	public int updateMember(String no, String name, String area, int age){
		int result = 0;
		String query = " update t17_member \r\n" + 
					   " set name ='"+name+"', area = '"+area+"', age = "+age+" \r\n" + 
			       	   " where no = '"+no+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
//			rs = ps.executeQuery();      //insert시키기 때문에 필요가 없음  셀렉트 문에만 필요
			result = ps.executeUpdate(); //insert시키는 query문에 문제가 없으면 1을 리턴, 문제있으면 0을 리턴
										 //update시키는 query문에 문제가 없으면 1을 리턴, 문제있으면 0을 리턴
										 //delete시키는  query문에 문제가 없으면 1을 리턴, 문제있으면 0을 리턴
			
			
		}catch(SQLException se) {
			System.out.println("updateMember() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("updateMember() 오류:"+query);
		}finally {
			common.close(connection, ps);
		}
		return result; //문제 없으면 '1'이 리턴! 
	}
	
	
	//삭제
	public int deleteMember(String no) {
		int result = 0;
		String query = "delete from t17_member where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
//			rs = ps.executeQuery();      //insert시키기 때문에 필요가 없음  셀렉트 문에만 필요
			result = ps.executeUpdate(); //insert시키는 query문에 문제가 없으면 1을 리턴, 문제있으면 0을 리턴
										 //update시키는 query문에 문제가 없으면 1을 리턴, 문제있으면 0을 리턴
										 //delete시키는  query문에 문제가 없으면 1을 리턴, 문제있으면 0을 리턴
			
			
		}catch(SQLException se) {
			System.out.println("deleteMember() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("deleteMember() 오류:"+query);
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
	//검색

	
	
}
