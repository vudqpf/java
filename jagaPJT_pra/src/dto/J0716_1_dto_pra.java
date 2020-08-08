package dto;

public class J0716_1_dto_pra {
	String name, ava, result;
	int kor, eng, mat, total;
	public J0716_1_dto_pra(String name, String ava, String result, int kor, int eng, int mat, int total) {
		super();
		this.name = name;
		this.ava = ava;
		this.result = result;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public String getAva() {
		return ava;
	}
	public String getResult() {
		return result;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}
	public int getTotal() {
		return total;
	}
	
}
