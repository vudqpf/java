package org.opentutorials.javatutorials.operstor;

public class J201020 {
	public static void main(String[] args) {
/*		int a= 10;
		int b=3;
		
		float c = 10.0F;
		float d = 3.0F;
		
		System.out.println(a/b);    //3
		System.out.println(c/d);    //3.3333
		System.out.println(a/d);	//3.3333
*/		
/*		
		System.out.println(1 == 2);  //false
		System.out.println(1 != 2);  //true
		System.out.println(1 == 1);	 //true
		System.out.println("one" == "one");	 //true
		System.out.println("one" == "two");  //false
		System.out.println("one" != "two");  //true
*/
/*
		System.out.println(10>20);		//false
		System.out.println(10>2);		//true
		System.out.println(10>10);		//false
		System.out.println(10>=10);		//true
*/
/* 
		String a = "Hello world";
		String b = new String("Hello world");
		System.out.println(a==b);			//false
		System.out.println(a.equals(b));	//true
*/
/*		
		if(false) {
			System.out.println(1);
			System.out.println(2);
			System.out.println(3);
			System.out.println(4);
		}
		System.out.println(5);
*/
/*		
		int a = 10;
		int b = 4;
		System.out.printf("%d + %d = %d%n",a, b, a + b);
		System.out.printf("%d - %d = %d%n",a, b, a - b);
		System.out.printf("%d * %d = %d%n",a, b, a * b);
		System.out.printf("%d / %f = %f%n",a, (float)b, a / (float)b);
*/		
		int a = 1_000_000;		//10의 6제곱
		int b = 2_000_000;		//10의 6제곱
		
		//a * b = 2,000,000,000,000 
		long c = a * b;				//오버플로우 발생  
			 c = a * (long)b;		//둘 중 하나의 값을 형변환이 필요함
		System.out.println(c);     //
	}
}
