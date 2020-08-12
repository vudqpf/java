package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.J0804_1_dto;
import dto.J0806_1_dto;

public class J0806_1_dao {
	DBConnectionOracle common = new DBConnectionOracle();//getconnection이란걸 만들어놓고 그걸 가지고 오려고 밑에 cond을 생성
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;       //select에서만 필요
	
	
//등록 - total구하는 방법
	public int getTotal(int kor, int eng, int mat) {
		int total = kor+eng+mat;		
		return total;
	}
//등록 - ava구하는 방법
	public int getAva(int total, int count) {
		int ava = total/ count;		
		return ava;
	}
//등록 - SQL에 입력
	public int saveScore(J0806_1_dto dto) {
	int result = 0;
	String query = "";
	query = " insert into t17_score (no, name, kor, eng, mat, total, ava) " +
			" VALUES ('"+dto.getNo()+"', '"+dto.getName()+"', "+dto.getKor()+", "+dto.getEng()+", "+dto.getMat()+", "+dto.getTotal()+", "+dto.getAva()+")";
	
	try {
		con = common.getConnection();
		ps = con.prepareStatement(query);
		result = ps.executeUpdate();
		
	}catch(SQLException se) {
		System.out.println("saveScore() query 오류:"+query);
	}catch(Exception e) {
		System.out.println("saveScore() 오류:"+query);
	}finally {
		common.close(con, ps, rs);
	}
	
	return result;

	}
	
	
	
//검색	
	public ArrayList<J0806_1_dto> getScoreList(String gubun, String search){
		ArrayList<J0806_1_dto> arr = new ArrayList<>();
		String query = " SELECT no, name, kor, eng, mat, total, ava \r\n " + 
					   " FROM t17_score\r\n "+ 	
					   " where "+gubun+" like '%"+search+"%' ";
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
/*
				String no = rs.getString(1);
				String name = rs.getString(2);
				int kor = rs.getInt(3);
				int eng = rs.getInt(4);
				int mat = rs.getInt(5);
				int tot = rs.getInt(6);
				int ava = rs.getInt(7);
				J0806_1_dto dto = new J0806_1_dto(no, name, kor, eng, mat, tot, ava);
*/
				J0806_1_dto dto = new J0806_1_dto(rs.getString(1),rs.getString(2), rs.getInt(3), 
						rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
				arr.add(dto);
			}

			
		}catch(SQLException se) {
			System.out.println("deleteMember() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("deleteMember() 오류:"+query);
		}finally {
			common.close(con, ps, rs);
		}
			
		return arr;
	}
	
//수정할 정보 조회
	public J0806_1_dto getMemberView(String n) {
		J0806_1_dto dto = null;
		String query = " SELECT * \r\n" + 
					   " FROM t17_score \r\n" + 
				       " where no = '"+n+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			 
			while(rs.next()) {  //1명 이상이면 while이고 1명이면 if를 쓰면 된다
				String no = rs.getString(1);
				String name = rs.getString(2);
				int kor = rs.getInt(3);
				int eng = rs.getInt(4);
				int mat = rs.getInt(5);
				int total = rs.getInt(6);
				int ava = rs.getInt(7);
				dto = new J0806_1_dto(no, name, kor, eng, mat, total, ava);
			}
			
		}catch(SQLException se) {
			System.out.println("getMemberView() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("getMemberView() 오류:"+query);
		}finally {
			common.close(con, ps, rs);
		}
		
		return dto; //만약 String n값이 없으면 null을 return
	}
	
//수정 - 학번 수정
	public int updateScore(String no, int k, int e, int m, int t, int a) {
		int result = 0;
		String query = " update t17_score\r\n" + 
					   " set kor = "+k+",\r\n" + 
				       "    eng = "+e+",\r\n" + 
				       "    mat = "+m+",\r\n" + 
				       "    total = "+t+",\r\n" + 
				       "    ava = "+a+"\r\n" + 
				       " where no = '"+no+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("updateScore() query 오류:"+query);
		}catch(Exception ee) {
			System.out.println("updateScore() 오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		return result;
	}

	//삭제
	public int deleteMember(String no) {
		int result = 0;
		String query = "delete from t17_score where no = '"+no+"'";
		
		try {
			con = common.getConnection();       //데이타베이스에 연결하는 과정
			ps = con.prepareStatement(query);   //실행시킬 준비
			result = ps.executeUpdate();        //실행시킴 결과값을 int로 반환    delete, insert, update만 
			
		}catch(SQLException se) {
			System.out.println("deleteMemger() query 오류:"+query);
		}catch(Exception ee) {
			System.out.println("deleteMemger() 오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		return result;
	}

	

}
