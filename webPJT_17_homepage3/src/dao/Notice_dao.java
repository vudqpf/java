package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.Common;
import common.DBConnectionOracle;
import dto.Notice_dto;

public class Notice_dao extends Common{
	/*extends(확장)는 Common을 상속 받겠다~*/
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	//db_notice_save파일 SQL에 정보 넘겨주기
	public int saveNotice(Notice_dto dto) {
		int result = 0;
		String query = 	" insert into h17_notice \r\n" + 
						" (no, title, content, attach, reg_name, reg_date) \r\n" + 
						" values \r\n" + 
						" ('"+dto.getNo()+"', '"+dto.getTitle()+"', '"+dto.getContent()+"', '"+dto.getAttach()+"', '"+dto.getReg_name()+"', '"+dto.getReg_date()+"') ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate(); 
			//insert, update, delete는 executeUpdate이고 리턴 타입은 인트이다
		}catch(SQLException se) {
			System.out.println("saveNotice() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("saveNotice() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	//자동으로 번호 생성(N001부터, 4자리)	
	public String getNoticeNo() {
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
			System.out.println("getNoticeNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNoticeNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}
	
	//notice_list파일 목록조회
	public ArrayList<Notice_dto> getNoticeList(String selectValue, String searchValue){
		ArrayList<Notice_dto> arr = new ArrayList<>();
		String query = " select no, title, attach, reg_name, to_char(reg_date, 'yyyy-MM-dd'), hit\r\n" + 
					   " from h17_notice\r\n" + 
					   " where "+selectValue+" like '%"+searchValue+"%'" +
					   " order by no desc";
		try {
			connection = common.getConnection();  /*SQL에 연결*/
			ps  = connection.prepareStatement(query); /*query를 준비*/
			rs  = ps.executeQuery();  /*query를 실행*/
			while(rs.next()) {   /*SQL의 행수만큼 반복이 돌아감*/
				String no 		= rs.getString(1);
				String title 	= rs.getString(2);
				String attach 	= rs.getString(3);
				String reg_name = rs.getString(4);
				String reg_date = rs.getString(5);
				int hit 		= rs.getInt(6);
				
				Notice_dto dto = new Notice_dto(no, title, "", attach, reg_name, reg_date, hit);
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
	
	//notice_view파일 조회수 증가
	public void hitCount(String no) {
		String query = " update h17_notice\r\n" + 
					   " set hit = hit + 1\r\n" + 
					   " where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			ps.executeUpdate(); 
			//int result = ps.executeUpdate(); /*위에 것과 동일 어차피 리턴안하니까*/
		}catch(SQLException se) {
			System.out.println("hitCount() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("hitCount() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
	}
	
	
	//notice_view파일 sql에서 받아오기
	//notice_updateForm파일 sql에서 받아오기
	public Notice_dto viewNotice(String no){
		Notice_dto dto = null;
		String query = " select no, title, content, nvl(attach, ' '), reg_name, to_char(reg_date, 'yyyy-MM-dd'), hit\r\n" + 
					   " from h17_notice\r\n" + 
					   " where no = '"+no+"'" +
					   " order by no desc";
		hitCount(no); /*같은 클래스에 있기 때문에 굳이 dao = new를 해줄 필요가 없음*/
		try {
			connection = common.getConnection();  /*SQL에 연결*/
			ps  = connection.prepareStatement(query); /*query를 준비*/
			rs  = ps.executeQuery();  /*query를 실행*/
			if(rs.next()) {   /*SQL의 행수만큼 반복이 돌아감*/
				String nos 		= rs.getString(1);
				String title 	= rs.getString(2);
				String content  = rs.getString(3);
				String attach 	= rs.getString(4);
				String reg_name = rs.getString(5);
				String reg_date = rs.getString(6);
				int hit 		= rs.getInt(7);
				
				dto = new Notice_dto(no, title, content, attach, reg_name, reg_date, hit);
			}
		}catch(SQLException se) {
			System.out.println("viewNotice() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("viewNotice() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return dto;			
	}
	//db_notice_update파일 SQL에 정보 넘겨주기(수정)
	public int updateNotice(Notice_dto dto) {
		int result = 0;
		String query = " update h17_notice\r\n" + 
					   " set title = '"+dto.getTitle()+"',\r\n" + 
					   "     content = '"+dto.getContent()+"',\r\n" + 
					   "     attach = '"+dto.getAttach()+"',\r\n" + 
					   "     reg_name = '"+dto.getReg_name()+"',\r\n" + 
					   "     reg_date = '"+dto.getReg_date()+"'\r\n" + 
					   " where no = '"+dto.getNo()+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("updateNotice() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("updateNotice() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	//db_notice_delete파일 SQL에 정보 넘겨주기(삭제)
	public int deleteNotice(String no) {
		int result = 0;
		String query = " delete h17_notice" +
					   " where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate(); 
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