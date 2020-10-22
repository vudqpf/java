package dto;

public class HistoryMember {
	String rentNo, memberName, bookNo, bookName, rentDate, returnDate;

	public HistoryMember(String rentNo, String memberName, String bookNo, String bookName, String rentDate,
			String returnDate) {
		super();
		this.rentNo = rentNo;
		this.memberName = memberName;
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}

	public String getRentNo() {
		return rentNo;
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

	public String getReturnDate() {
		return returnDate;
	}
	
}
