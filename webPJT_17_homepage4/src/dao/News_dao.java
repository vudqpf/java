package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.News_dto;
import dto.Notice_dto;

public class News_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//news_list파일 전체 목록 보여주기
	public ArrayList<News_dto> saveNewsList(String select, String search){
		ArrayList<News_dto> arr = new ArrayList<>();
		String query = " select no, title, reg_name, to_char(reg_date, 'yyyy-MM-dd'), hit \r\n" + 
					   " from h17_news\r\n" +
					   " where "+select+" like '%"+search+"%'"+
					   " order by no desc";
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
				News_dto dto = new News_dto(no, title, "", reg_name, reg_date, hit);
				arr.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("saveNewsList() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("saveNewsList() 오류");
		}finally {
			common.close(connection, ps, rs);
		}
		return arr;
	}
	
	//news_view파일 hit카운트 하기
	public void getNewshit(String no) {
		String query = "UPDATE h17_news\r\n" + 
					   "SET hit = hit +1\r\n" + 
					   "where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			ps.executeUpdate(); 
			//int result = ps.executeUpdate(); /*위에 것과 동일 어차피 리턴 안해도 되니까*/
		}catch(SQLException se) {
			System.out.println("sethitCount() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("sethitCount() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		
	}
	
	//news_view파일 목록 보여주기
	public News_dto newsView(String no) {
		News_dto dto = null;
		String query = " select no, title, content, reg_name, to_char(reg_date, 'yyyy-MM-dd'), hit \r\n" + 
					   " from h17_news\r\n" + 
					   " where no = '"+no+"'";
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			rs 			= ps.executeQuery();
			while(rs.next()) {
				String nn		 = rs.getString(1);
				String title	 = rs.getString(2);
				String content	 = rs.getString(3);
				String reg_name  = rs.getString(4);
				String reg_date  = rs.getString(5);
				int hit 		 = rs.getInt(6);
				dto = new News_dto(no, title, content, reg_name, reg_date, hit);
			}
		}catch(SQLException se) {
			System.out.println("newsView() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("newsView() 오류");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return dto;
	}
	
	//db_save파일 No를 만들기
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
	
	//db_save파일 sql파일에 행 삽입
	public int getNewsSave(News_dto dto) {
		int result = 0;
		String query = " insert into h17_news(no, title, content, reg_name, reg_date)\r\n" + 
					   " values('"+dto.getNo()+"','"+dto.getTitle()+"', '"+dto.getContent()+"', '"+dto.getReg_name()+"', '"+dto.getReg_date()+"')";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result = ps.executeUpdate(); 
			//int result = ps.executeUpdate(); /*위에 것과 동일 어차피 리턴 안해도 되니까*/
		}catch(SQLException se) {
			System.out.println("getNewsSave() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNewsSave() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		return result;		
	}
	
	//db_save파일 sql파일에 행 수정
	public int getNewsUpdate(News_dto dto) {
		int result = 0;
		String query = " update h17_news\r\n" + 
					   " set title = '"+dto.getTitle()+"',\r\n" + 
					   "     content = '"+dto.getContent()+"',\r\n" + 
					   "     reg_name = '"+dto.getReg_name()+"',\r\n" + 
					   "     reg_date = '"+dto.getReg_date()+"'\r\n" + 
					   " where no = '"+dto.getNo()+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result = ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("getNewsUpdate() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNewsUpdate() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		return result;		
	}
	
	
	//db_save파일 sql파일에 행 삭제
	public int getNewsDelete(String no) {
		int result = 0;
		String query = " delete h17_news\r\n" + 
					   " where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result = ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("getNewsDelete() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNewsDelete() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		return result;		
	}
	
	//조회수 증가
	public void setHitCount(String no) {
		String query = " update h17_qna\r\n" + 
					   " set hit = hit + 1\r\n" + 
					   " where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			ps.executeUpdate(); 
			//int result = ps.executeUpdate(); /*위에 것과 동일 어차피 리턴 안해도 되니까*/
		}catch(SQLException se) {
			System.out.println("sethitCount() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("sethitCount() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
	}
}
