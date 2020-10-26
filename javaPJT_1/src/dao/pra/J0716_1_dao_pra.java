package dao.pra;

import java.text.DecimalFormat;

public class J0716_1_dao_pra {
	public int getTotal(int k, int e, int m) {
		int total = k + e + m;
		return total;
	}
	public String getAva(int total, int count) {
		DecimalFormat df = new DecimalFormat("0.00");
		
		double ava = total / (double) count;
		String result = df.format(ava);
		return result;
	}
	public String getResult(String avarage) {
	    double ava = Double.parseDouble(avarage);
	    
		String result = "가";
		if(ava > 90) result = "수";
		else if(ava > 80) result = "우";
		else if(ava > 70) result = "미";
		else if(ava > 60) result = "양";
		return result;
	}

}
