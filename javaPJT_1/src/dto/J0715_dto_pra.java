package dto;

public class J0715_dto_pra {
 String name, result;
 int kor, eng, mat, total, ava;

public J0715_dto_pra(String name, String result, int kor, int eng, int mat, int total, int ava) {
	super();
	this.name = name;
	this.result = result;
	this.kor = kor;
	this.eng = eng;
	this.mat = mat;
	this.total = total;
	this.ava = ava;
}
public String getName() {
	return name;
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
public int getAva() {
	return ava;
}
 
}
