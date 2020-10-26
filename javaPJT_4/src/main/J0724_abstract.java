package main;

public class J0724_abstract {
	public static void main(String[] args) {
//		J0724_child child  = new J0724_child();
		
		J0724_parent child  = new J0724_child();
		int a = child.getTotal(50, 60);
//		String result = child.getResult(50);
				
//		int total = child.getTotal(50, 60);
//		int ava = child.getAva(total, 2);
		
//		J0724_child_two child2  = new J0724_child_two();
		J0724_parent child2  = new J0724_child_two();
		int  b = child2.getAva(100,2);
		
		
	}
}

//J0724_child는 J0724_parent로 변경해도 문제 없음
//자식 클래스는 부모타입으로 들어갈 수 있지만 부모클래스가 가지고 있는 것만 사용가능
//어떠한 클래스를 상속받은 자식 클래스는 부모 클래스가 가지고 있는 메소드만 사용이 가능하다
//