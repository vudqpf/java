package main;

public class J0724_child_two extends J0724_parent{
	@Override
	public int getTotal(int kor, int eng) {
		return kor + eng;
	}
	@Override
	public int getAva(int t, int c) {
		return t / c;
	}
	public String getName() {
		return "홍길동";
	}
	
}
