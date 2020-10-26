package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Notice_dto;
import dto.Qanda_dto;

public class Qanda_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//Qanaa_list파일 전체 목록 보여주기
	public ArrayList<Qanda_dto> getQandaList(String select, String search){  //select안에는 title or content
		ArrayList<Qanda_dto> arr = new ArrayList<Qanda_dto>();
		String query= " select q.no, q.title, q.answer, m.name, to_char(q.q_reg_date, 'yyyy-MM-dd'), q.hit \r\n" + 
					  " from h17_qna q, h17_member m \r\n" + 
					  " where q.q_reg_id = m.id" +
					  "	and q."+select+" like '%"+search+"%' " +
					  " order by q.no desc";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString(1);
				String title = rs.getString(2);
				String answer = rs.getString(3);
				String name = rs.getString(4);
				String reg_date = rs.getString(5);
				int hit = rs.getInt(6);
				Qanda_dto dto = new Qanda_dto(no, title, answer, name, reg_date, hit);
				arr.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("getQandaList query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getQandaList 오류");
		}finally {
			common.close(connection, ps, rs);
		}
		return arr;
	}
	
	//db_question_save파일 No생성
	public String getQandaNo() {
		String maxNo="";
		String query=" select max(no) from h17_QNA";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == null) {
				maxNo ="Q001";
			}else {
				String n = maxNo.substring(1); 
				int i = Integer.parseInt(n); 
				i = i + 1; 
				DecimalFormat df = new DecimalFormat("000");
				String newNo = df.format((double)i);
				maxNo = "Q"+newNo; 
			}
		}catch(SQLException se) {
			System.out.println("getQandaNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getQandaNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}
	
	//db_question_save sql에 입력시키기
	public int saveQuestion(Qanda_dto dto) {
		int result = 0;
		String query=" insert into h17_qna\r\n" + 
					 " (no, title, content, q_reg_id, q_reg_date)\r\n" + 
					 " values('"+dto.getNo()+"', '"+dto.getTitle()+"', '"+dto.getContent()+"', '"+dto.getQ_reg_id()+"', '"+dto.getQ_reg_date()+"')";
		
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			result  	= ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("saveQuestion() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("saveQuestion() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
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
	//qanda_view파일 상세조회	
	public Qanda_dto getQandaView(String no) {
		Qanda_dto dto = null;
		String query=" select a.no, a.title, a.content, a.q_reg_id, b.name, to_char(a.q_reg_date, 'yyyy-MM-dd'),\r\n" + 
					 "        a.answer, a.a_reg_id, c.name, to_char(a.a_reg_date, 'yyyy-MM-dd'), a.hit\r\n" + 
					 " from h17_qna a, h17_member b, h17_member c\r\n" + 
					 " where a.q_reg_id = b.id\r\n" + 
					 " and   a.a_reg_id = c.id(+)\r\n" + 
					 " and   a.no = '"+no+"'";
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			rs 			= ps.executeQuery();
			if(rs.next()) {
				String nn 			= rs.getString(1);
				String title 		= rs.getString(2);
				String content 		= rs.getString(3);
				String q_reg_id 	= rs.getString(4);
				String q_name 		= rs.getString(5);
				String q_reg_date 	= rs.getString(6);
				String answer 		= rs.getString(7);
				String a_reg_id		= rs.getString(8);
				String a_name 		= rs.getString(9);
				String a_reg_date 	= rs.getString(10);
				int hit				= rs.getInt(11);
				
				dto = new Qanda_dto(nn, title, content, answer, q_reg_id, q_name, q_reg_date,
								    a_reg_id, a_name, a_reg_date, hit);
			}
		}catch(SQLException se) {
			System.out.println("getQandaView() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getQandaView() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return dto;
	}
	//질문 삭제
	public int deleteQuestion(String no) {
		int result = 0;
		String query = " delete from h17_qna" + 
					   " where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result = ps.executeUpdate(); 
			//int result = ps.executeUpdate(); /*위에 것과 동일 어차피 리턴 안해도 되니까*/
		}catch(SQLException se) {
			System.out.println("deleteQuestion() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("deleteQuestion() 오류");
		}finally {
			common.close(connection, ps, rs);
		}
		return result;
	}	
	
	//qanda_view파일 상세조회	
	public Qanda_dto getQuestionInfo(String no) {
		Qanda_dto dto = null;
		String query=" select a.no, a.title, a.content, a.q_reg_id, b.name, to_char(a.q_reg_date, 'yyyy-MM-dd')\r\n" + 
				 	 " from h17_qna a, h17_member b\r\n" + 
				 	 " where a.q_reg_id = b.id\r\n" + 
				 	 " and   a.no = '"+no+"'";
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			rs 			= ps.executeQuery();
			if(rs.next()) {
				String nn 			= rs.getString(1);
				String title 		= rs.getString(2);
				String content 		= rs.getString(3);
				String q_reg_id 	= rs.getString(4);
				String q_name 		= rs.getString(5);
				String q_reg_date 	= rs.getString(6);
				
				dto = new Qanda_dto(no, title, content, q_reg_id, q_name, q_reg_date);
			}
		}catch(SQLException se) {
			System.out.println("getQuestionInfo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getQuestionInfo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return dto;
	}
	//db_question_update 질문 수정
	public int updateQuestion(Qanda_dto dto) {
		int result = 0;
		String query=" UPDATE h17_qna\r\n" + 
					 " SET title = '"+dto.getTitle()+"',\r\n" + 
					 "     content = '"+dto.getContent()+"',\r\n" + 
					 "     q_reg_date = '"+dto.getQ_reg_date()+"'\r\n" + 
					 " where no = '"+dto.getNo()+"'";
		
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			result  	= ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("updateQuestion() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("updateQuestion() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	//db_answer_save 답변 등록, 수정
	public int saveAnswer(String no, String answer, String reg_id, String reg_date) {
		int result = 0;
		String query=" UPDATE h17_qna\r\n" + 
					 " SET answer = '"+answer+"',\r\n" + 
					 "     a_reg_id = '"+reg_id+"',\r\n" + 
					 "     a_reg_date = '"+reg_date+"'\r\n" + 
					 " where no = '"+no+"'";
		
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			result  	= ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("saveAnswer() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("saveAnswer() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	//db_answer_delete 답변만 삭제
	public int deleteAnswer(String no) {
		int result = 0;
		String query=" UPDATE h17_qna\r\n" + 
					 " SET answer = '',\r\n" + 
					 "     a_reg_id = '',\r\n" + 
					 "     a_reg_date = ''\r\n" + 
					 " where no = '"+no+"'";
		
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			result  	= ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("deleteAnswer() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("deleteAnswer() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
}
