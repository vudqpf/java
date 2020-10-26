package main;

public class J0723_child extends J0723_parents{ 
	//J0723_parents란 부모클래스에서 전부 다 상속받아 올 수 있음
	public J0723_child() {
		System.out.println("J0723_child 생성자");
	}
	@Override    //부모클래스가 가지고 있는 메소드를 다시 사용할 때 표시해 주는 거
	public void parentsPrint() {
		System.out.println("child_print~~~");
		}
	
	public void childPrint() {
		System.out.println("J0723_print~~~");	
	}
}
