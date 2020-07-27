package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnectionOracle;

public class DB_test {
	public static void main(String[] args) {
		DBConnectionOracle dbconnection = new DBConnectionOracle();
		Connection con = dbconnection.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select id, name, area, age from member";
		try {
			ps = con.prepareStatement(query); 
			rs = ps.executeQuery();   //여기에는 jsl_db에 들어있는 4명의 값이 들어가 있음
			while(rs.next()) {   	//rs의 행수 만큼 돈다는 얘기 즉!5행부터는 while문 종료
				String id = rs.getString(1);  //1컬럼을 뜻함 즉! id를 야기함
				String name = rs.getString("name");  //컬럼명과 정확히 일치해야 된다
				String area = rs.getString(3);
				int age = rs.getInt(4);
				
				System.out.println("id :"+id+"\t"+" name :"+name+"\t"+" area :"+area+"\t"+" age :"+age);
			}
			
		}catch(Exception e) {
			System.out.println(" db 오류 1 ~~");
		}
		
	}

}
