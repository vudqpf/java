package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.J0803_1_dto;
/*
public class J0803_1_dao {
	DBConnectionOracle common = new DBConnectionOracle();//getconnection이란걸 만들어놓고 그걸 가지고 오려고 밑에 cond을 생성
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<J0803_1_dto> getListNo(String no) {
		ArrayList<J0803_1_dto> arr = new ArrayList<>();
		String query = " SELECT a.empno, a.ename, a.job, a.sal, b.dname \r\n" + 
						" FROM emp a, dept b \r\n" +
						" WHERE a.deptno = b.deptno \r\n" +
						" and a.empno like '%"+no+"%'  \r\n";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String	 n		 = rs.getString(1);
				String	 name 	 = rs.getString(2);
				String	 job 	 = rs.getString(3);
				int 	 sal 	 = rs.getInt(4);
				String   dname 	 = rs.getString(5);
				
				J0803_1_dto dto = new J0803_1_dto(n, name, job, dname, sal);
				arr.add(dto);
			}			
		}catch(SQLException se) {
			System.out.println("getListNo query 오류"+query);//try안에 query에 문제가 생기면 출력
		}catch(Exception e) {
			System.out.println("getListNo 오류");
		}finally { //위에서 오류가 나든 안나든 무조건 실행됨. 
			common.close(connection, ps, rs);
		}
		return arr;
	}

	public ArrayList<J0803_1_dto> getListName(String name) {
		ArrayList<J0803_1_dto> arr = new ArrayList<>();
		String query = " SELECT a.empno, a.ename, a.job, a.sal, b.dname \r\n" + 
						" FROM emp a, dept b \r\n" +
						" WHERE a.deptno = b.deptno \r\n" +
						" and a.empno like '%"+name+"%'  \r\n";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String	 n		 = rs.getString(1);
				String	 na 	 = rs.getString(2);
				String	 job 	 = rs.getString(3);
				int 	 sal 	 = rs.getInt(4);
				String   dname 	 = rs.getString(5);
				
				J0803_1_dto dto = new J0803_1_dto(n, na, job, dname, sal);
				arr.add(dto);
			}			
		}catch(SQLException se) {
			System.out.println("getListNo query 오류"+query);//try안에 query에 문제가 생기면 출력
		}catch(Exception e) {
			System.out.println("getListNo 오류");
		}finally { //위에서 오류가 나든 안나든 무조건 실행됨. 
			common.close(connection, ps, rs);
		}
		return arr;
	}
	public ArrayList<J0803_1_dto> getListJob(String job) {
		ArrayList<J0803_1_dto> arr = new ArrayList<>();
		String query = " SELECT a.empno, a.ename, a.job, a.sal, b.dname \r\n" + 
						" FROM emp a, dept b \r\n" +
						" WHERE a.deptno = b.deptno \r\n" +
						" and a.dname like '%"+job+"%'  \r\n";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String	 n		 = rs.getString(1);
				String	 na 	 = rs.getString(2);
				String	 jo 	 = rs.getString(3);
				int 	 sal 	 = rs.getInt(4);
				String   dname 	 = rs.getString(5);
				
				J0803_1_dto dto = new J0803_1_dto(n, na, jo, dname, sal);
				arr.add(dto);
			}			
		}catch(SQLException se) {
			System.out.println("getListNo query 오류"+query);//try안에 query에 문제가 생기면 출력
		}catch(Exception e) {
			System.out.println("getListNo 오류");
		}finally { //위에서 오류가 나든 안나든 무조건 실행됨. 
			common.close(connection, ps, rs);
		}
		return arr;
	}
*/
public class J0803_1_dao {
	DBConnectionOracle common = new DBConnectionOracle();//getconnection이란걸 만들어놓고 그걸 가지고 오려고 밑에 cond을 생성
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<J0803_1_dto> getListAll(String gubun, String search) {
		ArrayList<J0803_1_dto> arr = new ArrayList<>();
		String query = " SELECT a.empno, a.ename, a.job, a.sal, b.dname \r\n" + 
						" FROM emp a, dept b \r\n" +
						" WHERE a.deptno = b.deptno \r\n";
		if(gubun.equals("no")) {
			query = query + " and a.empno like '%"+search+"%'  \r\n";
		}else if(gubun.equals("name")){
			query = query + " and a.empno like '%"+search+"%'  \r\n";
		}else if(gubun.equals("dname")) {
			query = query + " and b.dname like '%"+search+"%'  \r\n";
		}

		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String	 n		 = rs.getString(1);
				String	 na 	 = rs.getString(2);
				String	 job 	 = rs.getString(3);
				int 	 sal 	 = rs.getInt(4);
				String   dna 	 = rs.getString(5);
				
				J0803_1_dto dto = new J0803_1_dto(n, na, job, dna, sal);
				arr.add(dto);
			}			
		}catch(SQLException se) {
			System.out.println("getListNo query 오류"+query);//try안에 query에 문제가 생기면 출력
		}catch(Exception e) {
			System.out.println("getListNo 오류");
		}finally { //위에서 오류가 나든 안나든 무조건 실행됨. 
			common.close(connection, ps, rs);
		}
		return arr;
	}
}
