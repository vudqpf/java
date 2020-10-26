package dao;

import java.text.DecimalFormat;

public class J0716_1_dao {
	
	public int getTotal(int k, int e) {
		int total = k + e;
		return total;
	} 
	public String getAva(int total, int count) {
		DecimalFormat df = new DecimalFormat("0.00");    

		double ava = total / (double)count;    //정리안된 ava가 나옴
		String result = df.format(ava);        // df.format(더블);을 넣어서 String로 바꿔주기때문에 
		return result;
		
	}
	public String getResult(String avarage) {
		double ava = Double.parseDouble(avarage);  //현재 ava는 String으로 되어있어서 double로 바꿔줘야됨.
												   //그래야 ava를 if문에 사용할 수 있기 때문이지!
		String result = "가";
		if(ava >= 90) result = "수";
		else if(ava >= 80) result = "우";
		else if(ava >= 70) result = "미";
		else if(ava >= 60) result = "양";
		
		return result;
	}

}
//총점, 평규, 수우미양가 만드는 메소드만들기
//