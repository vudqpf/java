
package dao;

import java.text.DecimalFormat;

public class J0717_1_dao_pra {
	DecimalFormat df = new DecimalFormat(",###");
	public String getDepart(String depart) {
		String departName = "";
		if(depart.equals("1")) departName = "총무";
		else if(depart.equals("2")) departName = "영업";
		else if(depart.equals("3")) departName = "인사";
		else if(depart.equals("4")) departName = "관리";
		else departName = "부서없음";
		return departName;
	}
	public String getPosition(String position) {
		String positionName = "";
		if(position.equals("1")) positionName = "사원";
		else if(position.equals("2")) positionName = "대리";
		else if(position.equals("3")) positionName = "과장";
		else if(position.equals("4")) positionName = "부장";
		else positionName = "직급없음";
		return positionName;
	}
	public int getMoney(String position) {
		int money = 0;
		if(position.equals("1")) money = 1200000;
		else if(position.equals("2")) money = 1400000;
		else if(position.equals("3")) money = 1600000;
		else if(position.equals("4")) money = 1800000;
				
		return money;
		
		
//getMoney를 int가 아닌 String으로 바꿔서 써보기		
	}
	public String getMoneyLie(int money) {
		DecimalFormat df = new DecimalFormat(",###");
		String result = df.format((double)money);
		return result;
	}
	
}
