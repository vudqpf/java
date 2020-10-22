package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.News_dto;

//writeForm 작성하는
public class News_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection 	  = null;
	PreparedStatement ps 	  = null;
	ResultSet rs 			  = null;
	
	public int saveNews(String no, String title, String content,
					    String reg_name, String reg_date) {
		int result = 0;
		String query = " insert into h17_news(no, title, content, reg_name, reg_date)\r\n" + 
					   " values" +
					   "('"+no+"','"+title+"','"+content+"','"+reg_name+"','"+reg_date+"')";
		
	//	System.out.println(query);
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("saveNews() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("saveNews() 오류:"+query);
		}finally {
			common.close(connection, ps);
		}
		

		return result;		
	}
	
	//No 지정해 주는 
	public String getNewsNo() {
		String query =" select max(no) from h17_news";
		String maxNo = "";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString(1);
			}	
			if(maxNo == "null") {
				maxNo = "N001";
			}else {
				String i = maxNo.substring(1); 
				int n = Integer.parseInt(i);
				n = n + 1; 
				DecimalFormat df = new DecimalFormat("000");
				String newNo = df.format(n);
				maxNo = "N"+newNo; 
					
			}
		}catch(SQLException se) {
			System.out.println("getNewsNo() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("getNewsNo()  오류:");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return maxNo;
		
	}
	
	//news_list에서 목록 조회하도록
	public ArrayList<News_dto> getNewsList(String select, String search){
		ArrayList<News_dto> arr = new ArrayList<>();
		String query = " select no, title, reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
					   " from h17_news\r\n" + 
					   "where "+select+" like '%"+search+"%'" + 
					   " order by no desc";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no  = rs.getString(1);
				String title = rs.getString(2);
				String reg_name = rs.getString(3);
				String reg_date = rs.getString(4);
				int hit = rs.getInt(5);
				News_dto dto = new News_dto(no, title, "", reg_name, reg_date, hit);
				arr.add(dto);
			}
		}catch(SQLException se){
			System.out.println("getNewsList() query 오류:"+query);
		}catch(Exception e){
			System.out.println("getNewsList() 오류:"+query);
		}finally {
			common.close(connection, ps, rs);
		}		
		return arr;
	}
	
	//news_view조회해오기
	public News_dto getNewsView(String no) {
		News_dto dto = null;
		String query = " select no, title, content, reg_name, \r\n" + 
					   "        to_char(reg_date, 'yyyy-MM-dd'), hit\r\n" + 
					   " from h17_news\r\n" + 
					   " where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				String nn       = rs.getString(1);
				String title    = rs.getString(2);
				String content  = rs.getString(3);
				String reg_name = rs.getString(4);
				String reg_date = rs.getString(5);
				int hit         = rs.getInt(6);
				dto = new News_dto(nn, title, content, reg_name, reg_date, hit);
			}
		}catch(SQLException se){
			System.out.println("getNewsView() query 오류:"+query);
		}catch(Exception e){
			System.out.println("getNewsView() 오류:"+query);
		}finally {
			common.close(connection, ps, rs);
		}	
		return dto;
	}
	
	//목록 클릭했을 때 hit(조회수)가 올라가도록
	public int hitCount(String no) {
		int result = 0;
		String query = " update h17_news\r\n" + 
					   " set hit = hit+1\r\n" + 
					   " where no = '"+no+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("hitCount() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("hitCount() 오류:"+query);
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
	//updateForm의 게시글 수정하는 것
	public int updateNews(String no, String title, String content,
					    String reg_name, String reg_date) {
			int result = 0;
			String query = " update h17_news\r\n" + 
						   " set title = '"+title+"',\r\n" + 
						   "     content = '"+content+"',\r\n" + 
						   "     reg_name = '"+reg_name+"',\r\n" + 
						   "     reg_date = '"+reg_date+"'\r\n" + 
						   " where no = '"+no+"'";
			
			//	System.out.println(query);
			try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
			}catch(SQLException se) {
				System.out.println("updateNews() query 오류:"+query);
			}catch(Exception e) {
				System.out.println("updateNews() 오류:"+query);
			}finally {
				common.close(connection, ps);
			}

			return result;		
			}
	
	//news_delete 
	public int deleteNews(String no) {
			int result = 0;
			String query = " delete from H17_NEWS\r\n" + 
						   " where no = '"+no+"'";
			
			try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
			}catch(SQLException se) {
				System.out.println("deleteNews() query 오류:"+query);
			}catch(Exception e) {
				System.out.println("deleteNews() 오류:"+query);
			}finally {
				common.close(connection, ps);
			}
			
			return result;		
			}
}
