package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import common.DBConnectionOracle;
import dto.J0808_1_dto_pra;

public class J0808_1_dao_pra {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String query = "";
	
	
	//등록 - no지정해 주기
	public String getNo(String n) {
		DecimalFormat df = new DecimalFormat("0000");
		String no = n.substring(1);
		int noNum = Integer.parseInt(no);
		noNum++;
		no = df.format(noNum);
		
		return no;
	}
	//등록 - SQL에 정보 넘겨 주기
	public int saveNo(J0808_1_dto_pra dto){
		int result = 0;
		query = "INSERT INTO t17_score\r\n" + 
				"VALUES ('"+dto.getNo()+"', '"+dto.getName()+"', "+dto.getKor()+", "+dto.getEng()+", "+dto.getMat()+", "+dto.getTotal()+", "+dto.getAva()+")";
		try {
			con = common.getConnection();  //연결클래스
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
	
	//등록 - 통합구하기
	public int getTotal(int k, int e, int m) {
		int total = k + e + m;
		
		return total;	
	}
	//등록 - 평균구하기
	public int getAva(int total) {
		int ava = total/3;
		return ava;
		
	}

	
	
	
}
