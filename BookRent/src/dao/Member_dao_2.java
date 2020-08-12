package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Member_dto_2;

public class Member_dao_2 {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//도서등록
	public int memberList(Member_dto_2 dto) {
		int result = 0;
		String query = " INSERT INTO b17_book " + 
			   		   " (no, name, publisher, writer, reg_date, rent_gubun)\r\n" + 
				       " VALUES ('"+dto.getNo()+"', '"+dto.getName()+"', '"+dto.getPublicher()+"', '"+dto.getWriter()+"', '"+dto.getReg_date()+"','"+dto.getRent_gubun()+"')";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("memberlist() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("memberlist() 오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		return result;
	}
	
	//도서 조회
	public ArrayList<Member_dto_2> getSearch(String search, String gubun) {
		ArrayList<Member_dto_2> arr = new ArrayList<>();
		String query = " SELECT no, name, publisher, writer, to_char(reg_date, 'yyyy-mm-dd'), rent_gubun\r\n" + 
					   " FROM b17_book\r\n" + 
					   " where "+search+" = '"+gubun+"'";
		try {
				con = common.getConnection();
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next()) {
					String no = rs.getString(1);
					String name = rs.getString(2);
					String publisher = rs.getString(3);
					String writer = rs.getString(4);
					String reg_date = rs.getString(5);
					String rent_gubun = rs.getString(6);
					
					Member_dto_2 dto = new Member_dto_2(no, name, publisher, writer, reg_date, rent_gubun);
					arr.add(dto);
				}
				
		}catch(SQLException se) {
			System.out.println("memberlist() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("memberlist() 오류:"+query);
		}finally {
			common.close(con, ps, rs);
		}
		
		return arr;
	}
	
	//도서 수정을 위한 조회
	public Member_dto_2 getView(String no) {
		Member_dto_2 dto = null;
		String query = " SELECT no, name, publisher, writer, to_char(reg_date, 'yyyy-mm-dd'), rent_gubun\r\n" + 
				   " FROM b17_book\r\n" + 
				   " where no = '"+no+"'";
	try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String nos = rs.getString(1);
				String name = rs.getString(2);
				String publisher = rs.getString(3);
				String writer = rs.getString(4);
				String reg_date = rs.getString(5);
				String rent_gubun = rs.getString(6);
				
				dto = new Member_dto_2(nos, name, publisher, writer, reg_date, rent_gubun);
				
			}
			
	}catch(SQLException se) {
		System.out.println("memberlist() query 오류:"+query);
	}catch(Exception e) {
		System.out.println("memberlist() 오류:"+query);
	}finally {
		common.close(con, ps, rs);
	}
		
		return dto;
	}
	
	//도서 수정
	public int updateName(String no, String name, String publisher, String writer, String reg_date, String rent_gubun) {
		int result = 0;
		String query =  "UPDATE b17_book\r\n" + 
						" set name = '"+name+"',\r\n" + 
						" publisher = '"+publisher+"',\r\n" + 
						" writer = '"+writer+"',\r\n" + 
						" reg_date = '"+reg_date+"',\r\n" + 
						" rent_gubun = '"+rent_gubun+"'\r\n" + 
						" where no = '"+no+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("memberlist() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("memberlist() 오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		
		return result;
	}
	
	//도서 삭제
	public int deleteMember(String no) {
		int result = 0;
		String query = " DELETE FROM b17_book\r\n" + 
					   " WHERE no = '"+no+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("memberlist() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("memberlist() 오류:"+query);
		}finally {
			common.close(con, ps);
		}
		
		return result;
	}
}
