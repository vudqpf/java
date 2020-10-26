package main;

public class J0727_2 {
	public int getTotal(String a, String b) throws Exception {
	int result = Integer.parseInt(a) + 
			Integer.parseInt(b);
	return result;
	
	}
}

//throws를 쓰면 호출한 메소드에 다시 던져줌
//throws를 쓰려면 메인 클래스에 try catch문으로 처리를 해줘야 됨