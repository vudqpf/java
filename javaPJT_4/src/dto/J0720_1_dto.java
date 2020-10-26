package dto;

public class J0720_1_dto {
	String no, name, depart, position;
	int salaryMon, positionMoney, bonus, salaryYear;  //월급, 직책수당, 보너스, 연봉
	public J0720_1_dto(String no, String name, String depart, String position, int salaryMon, int positionMoney,
			int bonus, int salaryYear) {
		super();
		this.no = no;
		this.name = name;
		this.depart = depart;
		this.position = position;
		this.salaryMon = salaryMon;
		this.positionMoney = positionMoney;
		this.bonus = bonus;
		this.salaryYear = salaryYear;
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
	public int getSalaryMon() {
		return salaryMon;
	}
	public int getPositionMoney() {
		return positionMoney;
	}
	public int getBonus() {
		return bonus;
	}
	public int getSalaryYear() {
		return salaryYear;
	}
	
	
}
