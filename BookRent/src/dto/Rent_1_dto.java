package dto;

public class Rent_1_dto {
	String rentNo, memberId,memberName,bookNo,bookName,rentDate,rentGubun;

	public Rent_1_dto(String rentNo, String memberId, String memberName, String bookNo, String bookName, String rentDate,
			String rentGubun) {
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
}
