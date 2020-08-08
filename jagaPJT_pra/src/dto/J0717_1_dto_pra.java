package dto;

public class J0717_1_dto_pra {
 String no, name, depart, position;
 int money;
public J0717_1_dto_pra(String no, String name, String depart, String position, int money) {
	super();
	this.no = no;
	this.name = name;
	this.depart = depart;
	this.position = position;
	this.money = money;
}
public String getNo() {
	return no;
}
public String getName() {
	return name;
}
public String getDepart() {
	return depart;
}
public String getPosition() {
	return position;
}
public int getMoney() {
//	DecimalFormat df = new DecimalFormat(",###");
//	double result = df. 
	return money;
}

 
}
