package dto;

public class Rent_dto {
	String rent_no, member_no, member_name, car_no, rent_date, return_day, return_date;
	String rent_gubun;
	
	public String getMember_name() {
		return member_name;
	}



	public String getRent_gubun() {
		return rent_gubun;
	}

	public Rent_dto(String rent_no, String member_no, String member_name,String car_no, String rent_date, String return_day,
			String return_date, String rent_gubun) {
		super();
		this.rent_no = rent_no;
		this.member_no = member_no;
		this.member_name = member_name;
		this.car_no = car_no;
		this.rent_date = rent_date;
		this.return_day = return_day;
		this.return_date = return_date;
		this.rent_gubun = rent_gubun;
	}

	public String getRent_no() {
		return rent_no;
	}

	public String getMember_no() {
		return member_no;
	}

	public String getCar_no() {
		return car_no;
	}

	public String getRent_date() {
		return rent_date;
	}

	public String getReturn_day() {
		return return_day;
	}

	public String getReturn_date() {
		return return_date;
	}
	
	
	
}
