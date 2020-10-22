package dto;

public class Event_dto {
	String no, title, content, s_date, e_date, reg_name, reg_date;
	int hit;
	
	public Event_dto(String no, String title, String content, String s_date, String e_date, String reg_name,
			String reg_date, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.s_date = s_date;
		this.e_date = e_date;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.hit = hit;
	}
	public String getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getS_date() {
		return s_date;
	}
	public String getE_date() {
		return e_date;
	}
	public String getReg_name() {
		return reg_name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public int getHit() {
		return hit;
	}
	
}
