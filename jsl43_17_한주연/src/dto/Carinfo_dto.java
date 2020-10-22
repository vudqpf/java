package dto;

public class Carinfo_dto {

	String no, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn;
	String accident_yn, fuel_type, import_date, rent_gubun;
	
	public void setNo(String no) {
		this.no = no;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	public void setCar_made(String car_made) {
		this.car_made = car_made;
	}

	public void setCar_made_ym(String car_made_ym) {
		this.car_made_ym = car_made_ym;
	}

	public void setAuto_yn(String auto_yn) {
		this.auto_yn = auto_yn;
	}

	public void setOption_yn(String option_yn) {
		this.option_yn = option_yn;
	}

	public void setAccident_yn(String accident_yn) {
		this.accident_yn = accident_yn;
	}

	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}

	public void setImport_date(String import_date) {
		this.import_date = import_date;
	}

	public void setRent_gubun(String rent_gubun) {
		this.rent_gubun = rent_gubun;
	}

	public Carinfo_dto(String no, String model_name, String car_number, String car_made, String car_made_ym,
			String auto_yn, String option_yn, String accident_yn, String fuel_type, String import_date,
			String rent_gubun) {
		super();
		this.no = no;
		this.model_name = model_name;
		this.car_number = car_number;
		this.car_made = car_made;
		this.car_made_ym = car_made_ym;
		this.auto_yn = auto_yn;
		this.option_yn = option_yn;
		this.accident_yn = accident_yn;
		this.fuel_type = fuel_type;
		this.import_date = import_date;
		this.rent_gubun = rent_gubun;
	}

	public String getNo() {
		return no;
	}

	public String getModel_name() {
		return model_name;
	}

	public String getCar_number() {
		return car_number;
	}

	public String getCar_made() {
		return car_made;
	}

	public String getCar_made_ym() {
		return car_made_ym;
	}

	public String getAuto_yn() {
		return auto_yn;
	}

	public String getOption_yn() {
		return option_yn;
	}

	public String getAccident_yn() {
		return accident_yn;
	}

	public String getFuel_type() {
		return fuel_type;
	}

	public String getImport_date() {
		return import_date;
	}

	public String getRent_gubun() {
		return rent_gubun;
	}
	
	
}

//조회, 등록,,,,,,,,,,,,,,,,,,,,,,,,,