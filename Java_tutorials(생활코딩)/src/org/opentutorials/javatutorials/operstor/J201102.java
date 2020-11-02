package org.opentutorials.javatutorials.operstor;

import java.io.File;				//입력과 출력6
import java.io.FileNotFoundException;
import java.util.Scanner;	//입력과 출력4,5


public class J201102 {
/* 입력과 출력2	
	public static void main(String[] args) {	//String[]문자열을 받을 수 있는 배열 args라는 매개변수
		System.out.println(args.length);		//args배열에 길이를 확인 하는것!
	}
*/
/* 입력과 출력3
	public static void main(String[] args) {	
		for(String e : args) {
			System.out.println(e);
		}
	}
*/	
	
/* 입력과 출력4 : Scanner1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력 하시오 : ");
        int i = sc.nextInt();
        System.out.println(i+"*1000 : "+  i*1000);
        sc.close();	
    }	
*/	

/* 입력과 출력5 : Scanner2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);		//System.in은 사용자에게 값을 가져와라~
               while(sc.hasNextInt()) {				//hasNextInt는 실행이 안되고 대기하고 있는 상태
        											//사용자가 엔터를 치면 중지되어 있던 것을 엔터쳐서 실행, int는 true 그 외에는 false
            	   System.out.println(sc.nextInt()*1000);
        }
        sc.close();	
    }	
*/	
	
	 public static void main(String[] args) {
	        try {
	            File file = new File("out.txt");
	            Scanner sc = new Scanner(file);	//out.txt을 가지고 있는 file변수를 입력값으로 가져와라~
	            while(sc.hasNextInt()) {
	                System.out.println(sc.nextInt()*1000); 
	            }
	            sc.close();
	        } catch(FileNotFoundException e){		//예외 : "out.txt"file을 못찾는다면
	            e.printStackTrace();				//에러의 내요을 출력해라
	        }
	         
	    }
	
	
	
}
