package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.News_dto;

public class News_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//news_writeForm파일 No생성
	public String getNewsNo() {
		String maxNo="";
		String query=" select max(no) from h17_news ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery(); //select는  executeQuery이고 리턴 타입은 result set이다
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == null) {
				maxNo ="W001";
			}else {
				String n = maxNo.substring(1); 
				int i = Integer.parseInt(n); 
				i = i + 1; 
				DecimalFormat df = new DecimalFormat("000");
				String newNo = df.format((double)i);
				maxNo = "W"+newNo; 
			}
		}catch(SQLException se) {
			System.out.println("getNewsNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNewsNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}
	
	//등록, 수정, 삭제
	public int newsQuery(String query) {
		int result = 0;
		
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			result  	= ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("newsQuery() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("newsQuery() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	//news_list파일 전체 목록 조회
	public ArrayList<News_dto> getNewsList(String select, String search, String sort){
		ArrayList<News_dto> arr = new ArrayList<>();
		String query =" select no, title, reg_name, to_char(reg_date, 'yyyy_MM-dd'), hit\r\n" + 
					  " from h17_news\r\n" + 
					  " where "+select+" like '%"+search+"%'" + 
					  " order by "+sort+" desc";
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			rs 			= ps.executeQuery();
			while(rs.next()) {
				String no		 = rs.getString(1);
				String title	 = rs.getString(2);
				String reg_name  = rs.getString(3);
				String reg_date  = rs.getString(4);
				int hit 		 = rs.getInt(5);
				News_dto dto = new News_dto(no, title, "",reg_name, reg_date, hit);
				arr.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("getNewsList() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNewsList() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return arr;
	}

}
