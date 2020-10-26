package dto;

public class Member_dto_2 {
	String no, name, publicher, writer, reg_date, rent_gubun;

	public Member_dto_2(String no, String name, String publicher, String writer, String reg_date, String rent_gubun) {
		super();
		this.no = no;
		this.name = name;
		this.publicher = publicher;
		this.writer = writer;
		this.reg_date = reg_date;
		this.rent_gubun = rent_gubun;
	}

	public String getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getPublicher() {
		return publicher;
	}

	public String getWriter() {
		return writer;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getRent_gubun() {
		return rent_gubun;
	}
	
	
}
