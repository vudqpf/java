package dto;

public class Member_dto_3 {
	String no, member_id, book_no, rent_date, return_date;
	
	String rentNo, memberId, memberName, bookNo, bookName, rentDate, rentGubun;



	public Member_dto_3(String rentNo, String memberId, String memberName, String bookNo, String bookName,
			String rentDate, String rentGubun) {
		super();
		this.rentNo = rentNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.rentDate = rentDate;
		this.rentGubun = rentGubun;
	}

	public String getRentNo() {
		return rentNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getBookNo() {
		return bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public String getRentDate() {
		return rentDate;
	}

	public String getRentGubun() {
		return rentGubun;
	}



	public Member_dto_3(String no, String member_id, String book_no, String rent_date, String return_date) {
		super();
		this.no = no;
		this.member_id = member_id;
		this.book_no = book_no;
		this.rent_date = rent_date;
		this.return_date = return_date;
	}

	public String getNo() {
		return no;
	}

	public String getMember_id() {
		return member_id;
	}

	public String getBook_no() {
		return book_no;
	}

	public String getRent_date() {
		return rent_date;
	}

	public String getReturn_date() {
		return return_date;
	}
	
}
