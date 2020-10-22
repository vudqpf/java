package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Member_dto_1;

public class MemberInfo_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<Member_dto_1> getMemberView(String gubun, String member_name) {
		ArrayList<Member_dto_1> arr = new ArrayList<>(); 
		String query = " SELECT id, name, address, tel, age, to_char(reg_date, 'yyyy-MM-dd')\r\n" + 
					   " FROM b17_bookmember\r\n";
		
		if(!gubun.equals("all")) {
			query += "where "+gubun+" like '%"+member_name+"%'";
		}
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String tel = rs.getString(4);
				int age = rs.getInt(5);
				String reg_date = rs.getString(6);
				
				Member_dto_1 dto = new Member_dto_1(id, name, address, tel,reg_date, age);
				arr.add(dto);
				
				
			}
			
		}catch(SQLException se) {
			System.out.println("getMemberView() query 오류:"+query);
		}catch(Exception e) {
			System.out.println("getMemberView() 오류:"+query);
		}finally {
			common.close(con, ps, rs);
		}
		
		return arr;
	}

}
