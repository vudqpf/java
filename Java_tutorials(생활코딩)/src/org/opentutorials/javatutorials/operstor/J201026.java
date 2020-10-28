package org.opentutorials.javatutorials.operstor;

public class J201026 {
	public static void main(String[] args) {
/* and 논리연산자		
 		if (true && true)   System.out.println(1);
        if (true && false)  System.out.println(2);
        if (false && true)  System.out.println(3);
		if (false && false) System.out.println(4);

		String id  = args[0];
		String password = args[1];
		if(id.equals("egoing")) {
			if(password.equals("111111")) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
		}else {
			System.out.println("wrong");
		}
		
		if((id.equals("egoing"))&&(password.equals("111111"))) {
			System.out.println("right");
		}else {
			System.out.println("wrong");
		}
*/
/* or연산자
	        if (true || true)        System.out.println(1);
	        if (true || false)       System.out.println(2);
	        if (false || true)       System.out.println(3);
	        if (false || false)      System.out.println(4);
	        
	        String id = args[0];
	        String password = args[1];
	        if ((id.equals("egoing") || id.equals("k8805") || id.equals("sorialgi"))
	                && password.equals("111111")) {
	            System.out.println("right");
	        } else {
	            System.out.println("wrong");
*/		
/* not연산자		
		if(!true) 	System.out.println(1);
		else 		System.out.println(2);
*/
/* while반복문		포인트! 종료조건이 필요함!
		int i=0;
		while(i<10) {
			System.out.println("Coding Everybody"+ i);
			i++;
		}
*/
/* for반복문		
		for(int i = 5 i<20; i++) {
			System.out.println("Coding Everybody"+ i);
		}
		for(int i = 5 i<20; i=i+2) {
			System.out.println("Coding Everybody"+ i);
		}
*/
/*break
		for(int i=0; i<10;i++) {
			if(i == 5) break;
			System.out.println("Coding Everybody" + i);
		}
*/
/*continue
		for(int i=0; i<10;i++) {
			if(i == 5) continue;
			System.out.println("Coding Everybody" + i);
		}
*/
/*반복 중첩문
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + "" + j);
            }
		}
*/
		
	}
}
