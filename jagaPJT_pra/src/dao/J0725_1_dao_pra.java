package dao;

import java.text.DecimalFormat;

public class J0725_1_dao_pra {
	public String getNo(String n) {
	DecimalFormat df =  new DecimalFormat("0000");
	String no = n.substring(1);
	int sno = Integer.parseInt(n);
	sno++;
	no = df.format(sno);
	return no;
		
	}
}
