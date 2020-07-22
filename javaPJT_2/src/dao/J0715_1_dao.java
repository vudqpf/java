package dao;

public class J0715_1_dao {
	public int getTotal(int k, int e, int m){   //public이 붙는 이유
												//다른 클래스나 패키지에서 가져오려면 필요함
												//넓은 범위로 공개?허용하겠다!
		int total = k + e + m;
		return total;
	}
	public int getAva(int total, int count) {
		int ava = total / count;
		return ava;
	}
}