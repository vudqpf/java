package main;

public abstract class J0724_parent {
	public String getName() {
		return "";
	}
	public abstract int getTotal(int kor, int eng) ;
	public abstract int getAva(int total, int count) ;
	public abstract int getEng() ;
	
	

}

//abstract를 쓰려면 최소 1개의 메소드가 필요함.
//abstract를 붙이면 추상 메소드가 됨.
//abstract를 붙이면 뒤에 {}가 아닌 ;으로 끝난다.
//abstract는 한개라도 포함하고 있을 경우 추상 클래스가 되어야 한다.
//추상 메소드는 리턴 타입이 없다.
//