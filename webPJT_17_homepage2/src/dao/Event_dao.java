package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Event_dto;

public class Event_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection 	  = null;
	PreparedStatement ps 	  = null;
	ResultSet rs 			  = null;
	
	//db_saved의 no생성
	public String getEventNo() {
		String query ="select max(no) from h17_event";
		String maxNo = "";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString(1);
			}	
			if(maxNo == "null") {
				maxNo = "E0001";
			}else {
				String i = maxNo.substring(1); 
				int n = Integer.parseInt(i);
				n = n + 1; 
				DecimalFormat df = new DecimalFormat("0000");
				String newNo = df.format(n);
				maxNo = "E"+newNo; 
					
			}
		}catch(SQLException se) {
			System.out.println("getEventNo() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("getEventNo()  오류:");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return maxNo;
		
	}
	
	//db_save파일 SQL에 정보 업로드
	public int eventSave(Event_dto dto) {
		int result = 0;
		String query = " INSERT INTO h17_event\r\n" + 
					   " (no, title, content, s_date, e_date, reg_name, reg_date)\r\n" + 
					   " VALUES ('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getS_date()+"',"
					   		+ "'"+dto.getE_date()+"','"+dto.getReg_name()+"','"+dto.getReg_date()+"')";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("eventSave() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("eventSave() 오류:"+query);
		}finally {
			common.close(connection, ps, rs);
		}
		
		return result;
	}
	
	//event_list파일 게시물에 목록 전체조회
	public ArrayList<Event_dto> getEventList(String select, String search){
		ArrayList<Event_dto> arr = new ArrayList<>();
		String query = " SELECT no, title, to_char(s_date,'yyyy-MM-dd'), to_char(e_date,'yyyy-MM-dd'), reg_name,  to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
					   " FROM h17_event"+
					   " where "+select+" like '%"+search+"%'" + 
					   " order by no desc";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no       = rs.getString(1);
				String title    = rs.getString(2);
				String s_date  = rs.getString(3);
				String e_date = rs.getString(4);
				String reg_name = rs.getString(5);
				String reg_date = rs.getString(6);
				int hit         = rs.getInt(7);
				Event_dto dto = new Event_dto(no, title,"", s_date, e_date, reg_name, reg_date, hit);
				arr.add(dto);
			}
		}catch(SQLException se){
			System.out.println("getEventList() query 오류:"+query);
		}catch(Exception e){
			System.out.println("getEventList() 오류:"+query);
		}finally {
			common.close(connection, ps, rs);
		}
		return arr;
	}
	
		public Event_dto getEventView(String no) {
			Event_dto dto = null;
			String query = " SELECT title, content, to_char(s_date,'yyyy-MM-dd') as s_date, to_char(e_date,'yyyy-MM-dd') as e_date, reg_name,  to_char(reg_date,'yyyy-MM-dd') as reg_date, hit\r\n" + 
						   " FROM h17_event\r\n" + 
						   " where no = '"+no+"'";
			hitCount(no);
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				if(rs.next()) {
					String title     = rs.getString(1);
					String content   = rs.getString(2);
					String s_date    = rs.getString(3);
					String e_date    = rs.getString(4);
					String reg_name  = rs.getString(5);
					String reg_date  = rs.getString(6);
					int hit          = rs.getInt(7);
					dto = new Event_dto(no, title, content, s_date, e_date, reg_name, reg_date, hit);
				}
			}catch(SQLException se){
				System.out.println("getEventList() query 오류:"+query);
			}catch(Exception e){
				System.out.println("getEventList() 오류:"+query);
			}finally {
				common.close(connection, ps, rs);
			}
			
			return dto;
		}
		
		//event_view hit카운트 해주기
		public void hitCount(String no) {
			String query = " update h17_event\r\n" + 
						   " set hit= hit+1\r\n" + 
						   " where no = '"+no+"'";
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				ps.executeUpdate();
			}catch(SQLException se) {
				System.out.println("hitCount() query 오류:"+query);
			}catch(Exception e) {
				System.out.println("hitCount() 오류:"+query);
			}finally {
				common.close(connection, ps, rs);
			}

		}
		
		public int eventUpdate(Event_dto dto) {
			int result = 0;
			String query = " update h17_event\r\n" + 
						   " set title = '"+dto.getTitle()+"',\r\n" + 
						   "     content = '"+dto.getContent()+"',\r\n" + 
						   "     s_date = '"+dto.getS_date()+"',\r\n" + 
						   "     e_date = '"+dto.getE_date()+"',\r\n" + 
						   "     reg_name = '"+dto.getReg_name()+"',\r\n" + 
						   "     reg_date = '"+dto.getReg_date()+"'\r\n" + 
						   " where no = '"+dto.getNo()+"'";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				result = ps.executeUpdate();
			}catch(SQLException se) {
				System.out.println("eventUpdate() query 오류:"+query);
			}catch(Exception e) {
				System.out.println("eventUpdate() 오류:"+query);
			}finally {
				common.close(connection, ps, rs);
			}
			
			return result;
		}
		
		public int eventDelete(String no) {
			int result = 0;
			String query = " delete from h17_event" + 
						   " where no = '"+no+"'";
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				result = ps.executeUpdate();
			}catch(SQLException se) {
				System.out.println("eventDelete() query 오류:"+query);
			}catch(Exception e) {
				System.out.println("eventDelete() 오류:"+query);
			}finally {
				common.close(connection, ps, rs);
			}
			
			return result;
		}
}
