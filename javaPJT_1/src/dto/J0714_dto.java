package dto;

public class J0714_dto {
	String name;
	int kor, eng, mat, total, ava;
	public J0714_dto(String name, int kor, int eng, int mat, int total, int ava) {
//		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total = total;
		this.ava = ava;
	}
	public String getName() {
		return name;
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
	public int getAva() {
		return ava;
	}
		
	
}
