package dao;

import java.text.DecimalFormat;

public class J0720_1_dao {
//	DemicalFormat df = new DemicalFormat();
	public String getDepartName(String code) {  //부서명
		String depart ="";
		if(code.equals("1")) depart = "총무";
		else if(code.equals("2")) depart = "영업";
		else if(code.equals("3")) depart = "인사";
		else if(code.equals("4")) depart = "관리";
		else depart = "부서없음";
		return depart;
	}
	public String getPosition(String code) {   //직책
		String position = "";
		if(code.equals("1")) position = "사원";
		else if(code.equals("2")) position = "대리";
		else if(code.equals("3")) position = "과장";
		else if(code.equals("4")) position = "부장";
		else position = "직책없음";
		return position;
	}
	public int getSalaryMon(String code) {  //월급
		int positionMoney = 0;
		if(code.equals("1")) positionMoney = 1100000;
		else if(code.equals("2")) positionMoney = 1200000;
		else if(code.equals("3")) positionMoney = 1300000;
		else if(code.equals("4")) positionMoney = 1400000; 
		return positionMoney;
	}
	public String getResult(int salaryMon) { //금액나누기
		DecimalFormat df = new DecimalFormat(",###");
		String result = df.format((double)salaryMon);
		return result;
	}
	public int getPositionMon(int position) { //직책수당
		double positionMon = (double)position * 0.1;
		int positionMoney = (int)positionMon;
		return positionMoney;
	}
	public int getBonus(int position) {  //보너스
		double bonusMon = (position*12) * 0.5;
		int bouns = (int)bonusMon;
		return bouns;
	}
	public int getSalaryYear(int money, int position, int bouns) {
		int salaryYear = ((money + position) * 12) + bouns;
		return salaryYear;
	}
//	public int getSalaryYear(int money) {  //3개의 메소드를 불러오는 것이 아닌 월급만 불러올겨ㅇ우
//		int po = getPositionMon(money); //위에서  직책수당을 불러와주면 따로 계산안하면 됨~!
//		int bp = getBonus(money);
//		int result = (money + po) * 12 +bo;
//		return salaryYear;
	
	public String getMemberNo(String no) {
		no = no.substring(1);              
		int noNum = Integer.parseInt(no); 
		noNum++;
		no = Integer.toString(noNum);      
		int noLength = no.length();      
		
		if(noLength == 1) no = "00"+no;     
		else if(noLength == 2) no = "0"+no; 
		return "S"+no;
	}
	
}
	

