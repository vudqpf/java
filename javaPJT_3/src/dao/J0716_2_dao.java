package dao;

public class J0716_2_dao {
 public String getDepartName(int code){
	 String name = "";
	 if(code == 1) name = "총무";
	 else if(code == 2) name = "영업";
	 else if(code == 3) name = "인사";
	 else if(code == 4) name = "관리";
	 else name = "부서없음";
	 
	 return name;   //11번째 줄에서 
 }
 
 public String getPositionName(String code) {
	 String name = "";
	 if(code.equals("1")) name = "사원";        //code.equals("1") code와 ("1")이  같으면 true값을 return해줌
	 else if(code.equals("2")) name = "대리";   //문자열이 같은지 틀린지 
	 else if(code.equals("3")) name = "과장";
	 else if(code.equals("4")) name = "부장";
	 
	 
	 return name;
 }
}
 //부서명 물어보는거 dao에 만들기..ㅜㅜㅜ
//직급도 dao에 만들기