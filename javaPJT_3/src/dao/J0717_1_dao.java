package dao;

import java.text.DecimalFormat;

public class J0717_1_dao {
	public String getDepartName(String code) {
		String depart = "";
		if(code.equals("1")) depart = "총무";
		else if(code.equals("2")) depart = "영업";
		else if(code.equals("3")) depart = "인사";
		else if(code.equals("4")) depart = "관리";
		else depart = "직급없음";
		return depart;
	}

	public String getPosition(String code) {
		String position = "";
		if(code.equals("1")) position = "사원";
		else if(code.equals("2")) position = "대리";
		else if(code.equals("3")) position = "과장";
		else if(code.equals("4")) position = "부장";
		else position = "직급없음";
		return position;
	}
	public int getMoney(String position) {
		int money = 0;
		if(position.equals("1")) money = 1200000;
		else if(position.equals("2")) money = 1400000;
		else if(position.equals("3")) money = 1600000;
		else if(position.equals("4")) money = 1800000;	
		return money;
		}
	
	public String getMoneyDis(int money) {
		DecimalFormat df = new DecimalFormat(",###");
		String result = df.format((double)money);
		return result;
	}
	public int getPositionMoney(int position) {
		double money = position* 0.1;
		return (int)money;
	}
	}
