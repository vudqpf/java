package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Notice_dto;

public class Notice_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//db_notice_save파일 No생성
	public String getNotiveNo() {
		String maxNo="";
		String query=" select max(no) from h17_notice ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery(); //select는  executeQuery이고 리턴 타입은 result set이다
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == null) {
				maxNo ="N001";
			}else {
				String n = maxNo.substring(1); 
				int i = Integer.parseInt(n); 
				i = i + 1; 
				DecimalFormat df = new DecimalFormat("000");
				String newNo = df.format((double)i);
				maxNo = "N"+newNo; 
			}
		}catch(SQLException se) {
			System.out.println("getNotiveNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNotiveNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}
	
	//write.jsp sql에 입력시키기
	public int saveNotice(Notice_dto dto) {
		int result = 0;
		String query="INSERT INTO h17_notice\r\n" + 
					 "(no, title, content, attach, reg_name, reg_date)\r\n" + 
					 "VALUES \r\n" + 
					 "('"+dto.getNo()+"', '"+dto.getTitle()+"', '"+dto.getContent()+"', '"+dto.getAttach()+"', '"+dto.getReg_name()+"', '"+dto.getReg_date()+"')";
		
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			result  	= ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("saveNotice() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("saveNotice() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		return result;
	}
	
	//notice_list파일 목록조회
	public ArrayList<Notice_dto> getNoticeList(String select, String search){
		ArrayList<Notice_dto> arr = new ArrayList<>();
		String query =" SELECT no, title, attach, reg_name, to_char(reg_date, 'yyyy-MM-dd'), hit\r\n" + 
					  " FROM h17_notice\r\n" + 
					  "where "+select+" like '%"+search+"%'" + 
					  " order by no desc";
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			rs 			= ps.executeQuery();
			while(rs.next()) {
				String no		 = rs.getString(1);
				String title	 = rs.getString(2);
				String attach	 = rs.getString(3);
				String reg_name  = rs.getString(4);
				String reg_date  = rs.getString(5);
				int hit 		 = rs.getInt(6);
				Notice_dto dto = new Notice_dto(no, title, "",attach,reg_name, reg_date, hit);
				arr.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("getNoticeList() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNoticeList() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return arr;
	}
	
	//notice_view파일 상세조회
	public Notice_dto NotiveView(String no) {
		Notice_dto dto = null;
		String query=" SELECT no, title, content, attach, reg_name, to_char(reg_date, 'yyyy-MM-dd'), hit\r\n" + 
					 " FROM h17_notice\r\n" + 
					 " where no = '"+no+"'";
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			rs 			= ps.executeQuery();
			if(rs.next()) {
				String nn		 = rs.getString(1);
				String title	 = rs.getString(2);
				String content	 = rs.getString(3);
				String attach	 = rs.getString(4);
				String reg_name  = rs.getString(5);
				String reg_date  = rs.getString(6);
				int hit 		 = rs.getInt(7);
				dto = new Notice_dto(no, title, content, attach,reg_name, reg_date, hit);
			}
		}catch(SQLException se) {
			System.out.println("NotiveView() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("NotiveView() 오류");
		}finally {
			common.close(connection, ps, rs);
		}						
		return dto;
	}
	//조회수 증가
	public void setHitCount(String no) {
		String query = " update h17_notice\r\n" + 
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
	
	//db_update에서 수정
	public int updateNotice(Notice_dto dto) {
		int result = 0;
		String query=" UPDATE h17_notice\r\n" + 
					 " SET title = '"+dto.getTitle()+"',\r\n" + 
					 "     content = '"+dto.getContent()+"',\r\n" + 
					 "     attach = '"+dto.getAttach()+"',\r\n" + 
					 "     reg_name = '"+dto.getReg_name()+"',\r\n" + 
					 "     reg_date = '"+dto.getReg_date()+"'\r\n" + 
					 " where no = '"+dto.getNo()+"'";
		
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			result  	= ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("updateNotice() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("updateNotice() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		return result;
	}

	//db_update에서 삭제
	public int deleteNotice(String no) {
		int result = 0;
		String query=" delete from h17_notice " + 
					 " where no = '"+no+"'";
		
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			result  	= ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("deleteNotice() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("deleteNotice() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		return result;
	}
}
