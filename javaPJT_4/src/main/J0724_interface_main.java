package main;

public class J0724_interface_main extends J0724_parent
implements J0724_interface_1, J0724_interface_2{
	public String getName() {
		return "홍";
	}
	public int getEng() {
		return 90;
	}
	@Override
	public int getTotal(int kor, int eng) {
		return kor + eng;
	}
	@Override
	public int getAva(int total, int count) {
		return total / count;
	}
	@Override
	public String getResult(int ava) {
		return "우";
	}
	

}

//interface에서 상속 받을 경우, extends 사용X implements를 사용.
//interface에 가지고 있는 메소드를 전부 사용해 줘야 한다.
//일반 클래스가 아닌 interface를 사용할 때, 오직 추상메소드를 사용.
//interface는 1개 이상 가지고 올 수 있음. 가지고 올 때는 ','를 사용
//추상클래스는 1개 이상 가지고 올 수 없음
//interface를 사용한다고 해서 main메소드에서는 일반 메소드도 사용가능.
