package main;   //J0714라는 클래스파일을 메인이라고 하는 패키지에 포함시키겠다

import java.util.ArrayList;

public class J0714 {
	public static void main(String[] args) {
		//ArrayList는 배열을 정한것이 아닌 고무줄처럼 칸수를 늘리고 줄일수 있음
		ArrayList<String> arr = new ArrayList<>() ;    //고무줄 배열인데 String타입이다
		arr.add("AAA");   //추가할때는 add메소드
		arr.add("BBB");
		arr.add("CCC");
		System.out.println("===:"+arr.get(0));  // 가져올때는 get
		System.out.println("===:"+arr.get(1));		
		System.out.println("===:"+arr.get(2));	
		
		for(int k = 0; k < arr.size(); k++) {   //지금까지는 length로 칸수를 지정했지만 ArrayList는 사이즈로 받는다
			System.out.println("=for==:"+arr.get(k));
		}
		
		arr.remove(1);
		for(int k = 0; k < arr.size(); k++) {
			System.out.println("=remove==:"+arr.get(k));   //현재까지는 0칸에는 AAA 1칸에는 CCC가 들어있음
		}
		
		arr.add(1, "bbb");
		for(int k = 0; k < arr.size(); k++) {
			System.out.println("=끼워넣기==:"+arr.get(k));  //25재줄에서 1칸에 bbb를 끼워넣으라고 함
		}
		arr.clear();                                   //전체 삭제
		System.out.println("==clear==:"+arr.size());
		
		arr.add("A");
		arr.add("B");
		for(int k = 0; k < arr.size(); k++) {
			System.out.println("===:"+arr.get(k));
		}
		
		arr.set(1, "C");    //set은 수정을 해주는   현재1칸에는 B가 들어있는데 C로 바꿔주라는 뜻
		for(int k = 0; k < arr.size(); k++) {
			System.out.println("=set==:"+arr.get(k));
		}		
		
	}

}
