package main;

public class J0723_extends {
	public static void main(String[] args) {
		J0723_child child = new J0723_child();
		child.childPrint();
		child.parentsPrint();    
		//만약 출력해야 된다면 자식클래스를 우선적으로 출력한다
		
	}
}
