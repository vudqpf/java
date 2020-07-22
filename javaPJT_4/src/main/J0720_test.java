package main;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class J0720_test {
	public static void main(String[] args) {
		String name = "JSL인재개발원";
		
		String n1 = name.substring(3);     //0,1,2부터 시작해서 3번재부터 출력
		System.out.println("n1 : " +n1);
		
		String n2 = name.substring(3, 5);  //0,1,2부터 시작해서 3번째부터 5미만을 출력
		System.out.println("n2 : " +n2);
		
		String no = "S001";
		no = no.substring(1);               //n = "001";
		int noNum = Integer.parseInt(no);  //noNum = 1; 스트링을 인트로 변환
		noNum++;						   //1을 1증가  즉! 2로 바뀜
		no = Integer.toString(noNum);      //no = "2";  인트를 스트링으로 변환
		System.out.println("no :" +no);    //no = "2";
		int noLength = no.length();        //noLength = 1; nolength는 no의 길이
		System.out.println("noLength :" +noLength);	//출력값 :1; 즉! 0,1칸이니까!
		
		if(noLength == 1) no = "00"+no;     //no ="001";  만약nolength가 1자리와 같다면 "00"+1;
		else if(noLength == 2) no = "0"+no; //no = "002"; 만약 nolength가 2자리와 같다면 "0"+2; 
		
		
		System.out.println("no :" +no);
	}
	
}
