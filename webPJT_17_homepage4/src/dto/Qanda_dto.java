package dto;

public class Qanda_dto {
	String no, title, content, answer, q_reg_id, q_reg_name, q_reg_date;
	String a_reg_id, a_reg_name, a_reg_date;
	int hit;

	//목록 조회
	public Qanda_dto(String no, String title, String answer, String q_reg_name, String q_reg_date, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.answer = answer;
		this.q_reg_name = q_reg_name;
		this.q_reg_date = q_reg_date;
		this.hit = hit;
	}
	//질문등록
	public Qanda_dto(String no, String title, String content, String q_reg_id, String q_reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.q_reg_id = q_reg_id;
		this.q_reg_date = q_reg_date;
	}
	//전체 생성자
	public Qanda_dto(String no, String title, String content, String answer, String q_reg_id, String q_reg_name,
			String q_reg_date, String a_reg_id, String a_reg_name, String a_reg_date, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.answer = answer;
		this.q_reg_id = q_reg_id;
		this.q_reg_name = q_reg_name;
		this.q_reg_date = q_reg_date;
		this.a_reg_id = a_reg_id;
		this.a_reg_name = a_reg_name;
		this.a_reg_date = a_reg_date;
		this.hit = hit;
	}
	//질문상세보기
	public Qanda_dto(String no, String title, String content, String q_reg_id, String q_reg_name, String q_reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.q_reg_id = q_reg_id;
		this.q_reg_name = q_reg_name;
		this.q_reg_date = q_reg_date;
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

	public String getAnswer() {
		return answer;
	}

	public String getQ_reg_id() {
		return q_reg_id;
	}

	public String getQ_reg_name() {
		return q_reg_name;
	}

	public String getQ_reg_date() {
		return q_reg_date;
	}

	public String getA_reg_id() {
		return a_reg_id;
	}

	public String getA_reg_name() {
		return a_reg_name;
	}

	public String getA_reg_date() {
		return a_reg_date;
	}

	public int getHit() {
		return hit;
	}
	

	
}
