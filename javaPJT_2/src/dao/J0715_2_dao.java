package dao;

import java.text.DecimalFormat;

public class J0715_2_dao {
	public int getTotal(int k, int e, int m) {
		int total = k+e+m;
		return total;
	}	
	public double getAva (int total, int count) {
		DecimalFormat df = new DecimalFormat("0.0");
		
		double ava = total / (double)count;   //ava = 91.1234
		String result = df.format(ava);       //result = "91.1";
		double re = Double.parseDouble(result);  //re = 91.1;
		
		return re;
 }
	public String getResult(double ava) {
		String result = "가";
		if(ava > 90) {
			result = "수";
		}else if(ava > 80) {
			result = "우";
		}else if(ava > 70) {
			result = "미";
		}else if(ava > 60) {
			result = "양";
		}
		
		return result;
	}
}
