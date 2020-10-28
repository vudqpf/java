package org.opentutorials.javatutorials.operstor;

public class J201028 {
	public static void main(String[] args) {
/* 배열의 정의
		String[] classGroup = {"최진혁","최유빈","한이람","이고잉"};
		System.out.println(classGroup[0]);
		System.out.println(classGroup[1]);
		System.out.println(classGroup[2]);
		System.out.println(classGroup[3]);
*/	
/* 배열의 제어
		String[] classGroup = new String[4];  //문자열 배열을 4개 생성
        classGroup[0] = "최진혁";
        System.out.println(classGroup.length);	
        classGroup[1] = "최유빈";
        System.out.println(classGroup.length);
        classGroup[2] = "한이람";
        System.out.println(classGroup.length);
        classGroup[3] = "이고잉";
        System.out.println(classGroup.length);	//맨처음에 배열 4개를 생성 했기 때문에 classGroup의 length는 커지지 않음
*/
/* 배열의 반복문
		 String[] members = { "최진혁", "최유빈", "한이람" };
	        for (int i = 0; i < members.length; i++) {
	            String member = members[i];
	            System.out.println(member + "이 상담을 받았습니다");
	        }
*/
/* 배열의 for-each
		String[] members = { "최진혁", "최유빈", "한이람" };
        for (String e : members) {							//members에 있는 값들이 for반복문에 도는동안 e에 하나씩 들어감
            System.out.println(e + "이 상담을 받았습니다");
        }
*/
/* 배열의 오류와 한계
		String[] members = { "최진혁", "최유빈", "한이람" };
		System.out.println(members[3]);     
		
//밑에 있는 오류는 members배열의 크기를 벗어나는 값을 요구할 때 일어나는 오류
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
    at ot_array.ExceptionDemo.main(ExceptionDemo.java:38)
*/		
		
		
	}
}
