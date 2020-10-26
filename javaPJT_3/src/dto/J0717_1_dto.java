package dto;

public class J0717_1_dto {
	String no, name, depart, position;
	int money, positionMoney;
	public J0717_1_dto(String no, String name, String depart, String position, int money, int positionMoney) {
		super();
		this.no = no;
		this.name = name;
		this.depart = depart;
		this.position = position;
		this.money = money;
		this.positionMoney =  positionMoney;
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
		return money;
	}
	public int getPositionMoney() {
		return positionMoney;
	}
	
	
	
}
