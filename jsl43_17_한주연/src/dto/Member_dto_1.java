package dto;

public class Member_dto_1 {
	String id, name, address, tel, reg_date;
	int age;
	public Member_dto_1(String id, String name, String address, String tel, String reg_date, int age) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.reg_date = reg_date;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getTel() {
		return tel;
	}
	public String getReg_date() {
		return reg_date;
	}
	public int getAge() {
		return age;
	}
	
}
