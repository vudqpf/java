package dto;

public class Member_dto {
	String id, name, pw, area, address, tel_1, tel_2, tel_3, mf, hobby_t, hobby_r, hobby_s, reg_date;

	public Member_dto(String id, String name, String pw, String area, String address, String tel_1, String tel_2,
			String tel_3, String mf, String hobby_t, String hobby_r, String hobby_s, String reg_date) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.area = area;
		this.address = address;
		this.tel_1 = tel_1;
		this.tel_2 = tel_2;
		this.tel_3 = tel_3;
		this.mf = mf;
		this.hobby_t = hobby_t;
		this.hobby_r = hobby_r;
		this.hobby_s = hobby_s;
		this.reg_date = reg_date;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPw() {
		return pw;
	}

	public String getArea() {
		return area;
	}

	public String getAddress() {
		return address;
	}

	public String getTel_1() {
		return tel_1;
	}

	public String getTel_2() {
		return tel_2;
	}

	public String getTel_3() {
		return tel_3;
	}

	public String getMf() {
		return mf;
	}

	public String getHobby_t() {
		return hobby_t;
	}

	public String getHobby_r() {
		return hobby_r;
	}

	public String getHobby_s() {
		return hobby_s;
	}

	public String getReg_date() {
		return reg_date;
	}
	
}
