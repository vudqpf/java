package org.opentutorials.javatutorials.operstor;
import java.io.*;	//출력갑2

public class J201028_method_demo {
	//main설명
	//main = 약속
	//반드시 public static void main가 이끄는 중괄호 안에 실행되기를 기대하는 로직을 위치시켜야함
	//메소드를 한번 만들어 놓으면 재활용 가능, 코드량 감소, 유지보수에 유리
	
/* 메소드의 호출	
	public static void numbering() {	//정의
		int i = 0;
		while(i<10) {
			System.out.println(i);
			i++;
		}
	}
	
	public static void main(String[] args) {
		numbering();			//호출
		numbering();
	    numbering();
	    numbering();
	    numbering();
	}
*/
	
/*	메소드의 매개변수와 인수
 		//매개변수와 인자는 같은 타입이어야 한다
	  public static void numbering(int limit) {	//int limit= 매개변수(parameter)
	        int i = 0;
	        while (i < limit) {
	            System.out.println(i);
	            i++;
	        }
	    }
	 
	    public static void main(String[] args) {
	        numbering(5);						//5 = 인자
	    }
*/
	
/* 복수의 인자
		public static void numbering(int init, int limit) {
	        int i = init;
	        while (i < limit) {
	            System.out.println(i);
	            i++;
	        }
	    }
	 
	    public static void main(String[] args) {
	        numbering(1, 5);
	    }
*/
	
/* 출력값1
    public static String numbering(int init, int limit) {		//String은 main의 변수와 타입이 같아야 한다
   // int i = init;   		//int타입 i로 안받고 직접 init를 써도 된다~  
    String output = "";		//String타입의 output을 선언!(전역변수로서)
    while (init < limit) {
        output += init;
        init++;
    }
    return output;		//main에서 numbering메소드를 부를 때 내보내는 값!
}

public static void main(String[] args) {
	//void가 메소드 이름 앞에 붙으면 return값이 존재하지 않는다 
    String result = numbering(1, 5);	//같은 java파일 안에 있기 때문에 new로 생성해 줄 필요는 없음!
    System.out.println(result);
}
*/
	
/* 출력갑2-1
	    public static String numbering(int init, int limit) {
	        int i = init;
	        String output = "";
	        while (i < limit) {
	            output += i;
	            i++;
	        }
	        return output;
	    }
	    
	    public static int one() {
	        return 1;
//	        return 2;	//한 메소드에는 1나의 return값만 가져야 된다~
	    }
	    public static String num(int i) {
	        if(i==0){
	            return "zero";
	        } else if(i==1){
	            return "one";
	        } else if(i==2){
	            return "two";
	        }
	        return "none";
	    }
	 
	    public static void main(String[] args) {
	        String result = numbering(1, 5);
	        System.out.println(result);
	        try {     // 다음 행은 out.txt 라는 파일에 numbering이라는 메소드가 반환한 값을 저장합니다.
	            BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));	//out.txt라는 파일 생성
	            out.write(result);													//생성한 파일에 result값을 인풋
	            out.close();
	        } catch (IOException e) {
	        }
	        
	        System.out.println(one());
	        System.out.println(num(1));
	    }
*/
	
/* 출력값2-2
	    public static String getMember1() {
	        return "최진혁1";
	    }
	 
	    public static String getMember2() {
	        return "최유빈1";
	    }
	 
	    public static String getMember3() {
	        return "한이람1";
	    }
	    public static String[] getMembers() {
	    	String[] members = {"최혁진2", "최유빈2","한이람2"};
	    	return members;
	    }
	 
	    public static void main(String[] args) {
	        System.out.println(getMember1());
	        System.out.println(getMember2());
	        System.out.println(getMember3());
	        String[] members = getMembers();
	        System.out.println(members.length);
	    }
*/	
	
}
