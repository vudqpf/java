package main;

public interface J0724_interface_1 {

	public int getTotal(int kor, int eng) ;
	public int getAva(int total, int count) ;
}

//interface는 일반 메소드는 존재X, 오직 추상메소드만 존재함.
//abstract를 굳이! 써주지 않아도 추상 메소드로 인식.