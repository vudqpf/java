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
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//등록
	public int getTotal(int kor, int eng, int mat) {
		int total = kor+eng+mat;		
		return total;
	}
	public int getAva(int total, int count) {
		int ava = total/ count;		
		return ava;
	}
	
	public int saveScore(J0806_1_dto dto) {
	int result = 0;
	String query = "";
	query = " insert into t17_score (no, name, kor, eng, mat, total, ava) " +
			" VALUES ('"+dto.getNo()+"', '"+dto.getName()+"', "+dto.getKor()+", "+dto.getEng()+", "+dto.getMat()+", "+dto.getTotal()+", "+dto.getAva()+")";
	
	try {
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		result = ps.executeUpdate();
		
	}catch(SQLException se) {
		System.out.println("saveScore() query 오류:"+query);
	}catch(Exception e) {
		System.out.println("saveScore() 오류:"+query);
	}finally {
		common.close(connection, ps, rs);
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
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
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
			common.close(connection, ps, rs);
		}
				
				
			
		return arr;
	}
	
	
	
}
