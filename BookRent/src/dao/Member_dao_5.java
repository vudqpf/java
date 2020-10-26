package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Member_dto_5;

public class Member_dao_5 {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<Member_dto_5> getHistoryMember(String memberId){
		ArrayList<Member_dto_5> arr = new ArrayList<>();
		String query = " SELECT a.no, b.name, c.no, c.name, to_char(a.rent_date, 'yyyy-mm-dd'),\r\n" + 
					   " decode(a.return_date,null,'대여중', TO_CHAR(a.return_date,'yyyy-MM-dd'))\r\n" + 
					   " FROM B17_rent a, b17_bookmember b, b17_book c\r\n" + 
					   " where a.member_id = b.id\r\n" + 
					   " and a.book_no = c.no\r\n" + 
					   " and a.member_id = '"+memberId+"'";
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
				while(rs.next()) {
				String rNo = rs.getNString(1);
				String memberName = rs.getNString(2);
				String bookNo = rs.getNString(3);
				String bookName = rs.getNString(4);
				String rentDate = rs.getNString(5);
				String returnDate = rs.getNString(6);
				
				
				Member_dto_5 dto = new Member_dto_5(rNo, memberName, bookNo, bookName, rentDate, returnDate);
				arr.add(dto);
			}
			
		}catch(SQLException se) {
			System.out.println("getMaxRentNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getMaxRentNo() 오류");
		}finally {
			common.close(con, ps, rs);
		}
		
		
		return arr;
	}
}
