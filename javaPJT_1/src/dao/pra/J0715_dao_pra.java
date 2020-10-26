package dao.pra;

public class J0715_dao_pra {
	public int getTotal(int k, int e, int m) {
		int total = k+e+m;
		return total;
	}		
	public int getAva(int total, int count) {
		int ava = total / count;
		return ava;
	}
	public String getResult(int ava) {
		String result = "가";
		if(ava >= 90) result = "수";
		else if(ava >= 80) result = "우";
		else if(ava >= 70) result = "미";
		else if(ava >= 60) result = "양";
		return result;		
	}
}
