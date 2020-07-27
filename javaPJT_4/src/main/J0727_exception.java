package main;

import java.io.IOException;
import java.util.Scanner;

public class J0727_exception {

	public static void main(String[] args) {
		J0727_2 ex = new J0727_2();
		Scanner sc = new Scanner(System.in);
		
		
		try {
			System.in.read();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		System.out.print("첫 번째 점수:");
		String a = sc.next();
		
		System.out.print("두 번째 점수:");
		String b = sc.next();
		
		
		int total = 0;
		try {
			total = ex.getTotal(a, b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("total :"+total);
	}
}
		
		
		
		
//		String a = "홍";
//		int i = 0;
//		try{
///		i = Integer.parseInt(a);
//		}catch(Exception e) {
//			System.out.println("오류~~~~~~");
//			i = -1;
//		}
//		System.out.println("i : "+i);
//
//	}
//
//}

//오류가 발생할 수 있는 문장을 try에 넣어주고 오류가 발생하면, catch로 넘겨준다
//오류가 발생 안하면 catch부분으로 들어가지 않음