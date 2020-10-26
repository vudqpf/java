package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.Member_dao_1;
import dao.Member_dao_2;
import dao.Member_dao_3;
import dao.Member_dao_5;
import dto.Member_dto_1;
import dto.Member_dto_2;
import dto.Member_dto_3;
import dto.Member_dto_5;


public class BookRent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member_dao_1 dao = new Member_dao_1();
		Member_dao_2 dao2 = new Member_dao_2();
		Member_dao_3 dao3 = new Member_dao_3();
		Member_dao_5 dao5 = new Member_dao_5();
		ArrayList<Member_dto_1> arr = new ArrayList<>();
		ArrayList<Member_dto_2> arr2 = new ArrayList<>();
		ArrayList<Member_dto_3> arr3 = new ArrayList<>();
		
		

		int workGubun;
		
		do {		
		//회원관리
			System.out.print(" 회원관리[1], 도서관리[2], 대여[3], 반납[4], 대출이력[5], 시스템종료[0]");
			workGubun = sc.nextInt();	

			
		if(workGubun == 1) {			
			int gubun = 0;
			do {
				System.out.print("회원 조회[1], 등록[2], 수정[3], 삭제[4] 이전[0]");
				gubun = sc.nextInt();
				
				//회원조회
				if(gubun == 1) {
					int search = 0;
					do {
						System.out.println("회원조회  ID:[1], 이름[2] 이전[0]");
						search = sc.nextInt();
						
						//ID조회
						if(search == 1) {
							System.out.println("조회 ID : 4자리 숫자");
							String searchId = sc.next();
							arr = dao.getSearch("ID", searchId);
						//이름조회	
						}else if(search == 2) {
							System.out.println("조회 이름 : ");
							String searchName = sc.next();
							arr = dao.getSearch("name", searchName);
						}
						if(search != 0) {
							for(int k = 0; k < arr.size(); k++) {
								System.out.println("===================================================");
								System.out.println("ID\t성명\t주소\t전번\t\t등록일\t\t나이");
								System.out.print(arr.get(k).getId()+"\t"); 
								System.out.print(arr.get(k).getName()+"\t"); 
								System.out.print(arr.get(k).getAddress()+"\t"); 
								System.out.print(arr.get(k).getTel()+"\t"); 
								System.out.print(arr.get(k).getReg_date()+"\t"); 
								System.out.print(arr.get(k).getAge()+"\n"); 
							}
							if(search == 0) {
								System.out.println(" ====검색 내용 없음==== ");
						}
						}
						
					}while(search != 0);
					
					
				//회원등록	
				}else if(gubun == 2) {
					System.out.print("등록 ID(4자리 숫자) : ");
					String id = sc.next();
//					String id;
//					if(arr.size() == 0) {
//						id = "B0001";
//					}else {
//						id = arr.get(arr.size()-1).getId();
//						String ids = dao.getId(id);
//					}
					
					
					System.out.print("등록 이름 : ");
					String name = sc.next();
					
					System.out.print("등록 주소 : ");
					String address = sc.next();
					
					System.out.print("등록 전번 : ");
					String tel = sc.next();
					
					System.out.print("등록 나이 : ");
					int age = sc.nextInt();

					System.out.print("등록 날짜 : ");
					String reg_date = sc.next();
					
					Member_dto_1 dto = new Member_dto_1(id, name, address, tel, reg_date, age);
					int result = dao.memberReg(dto);
					
					if(result == 1) {
						System.out.println(" ==== 등록 성공 ==== ");
					}else {
						System.out.println(" ==== 등록 실패 ==== ");
					}
					
				//회원수정	
				}else if(gubun == 3) {
					System.out.println("수정 회원ID(4자리 숫자) : ");
					String id = sc.next();
					Member_dto_1 dto = dao.getView(id);
					if(dto == null) {
						System.out.println(" ==== 수정 정보 없음 ==== ");
					}else if(dto != null) {
						System.out.println("===================================================");
						System.out.println("ID\t성명\t주소\t전번\t\t등록일\t\t나이");
						System.out.print(dto.getId()+"\t"); 
						System.out.print(dto.getName()+"\t"); 
						System.out.print(dto.getAddress()+"\t"); 
						System.out.print(dto.getTel()+"\t"); 
						System.out.print(dto.getReg_date()+"\t"); 
						System.out.print(dto.getAge()+"\n");
					}
					if(dto != null) {
						System.out.println("수정 하시겠습니까? 예[Y] 아니오[N]");
						String yon = sc.next();
						if(yon.equals("Y")||yon.equals("y")||yon.equals("ㅛ")) {
							System.out.print("수정 이름 : ");
							String name = sc.next();
							
							System.out.print("수정 주소 : ");
							String address = sc.next();
							
							System.out.print("수정 전번 : ");
							String tel = sc.next();
							
							System.out.print("수정 나이 : ");
							int age = sc.nextInt();

							System.out.print("수정 날짜 : ");
							String reg_date = sc.next();
							
							int result  = dao.updateView(id, name, address, tel, reg_date, age);
							
							if(result == 1) {
								System.out.println(" ==== 수정 완료 ==== ");
							}
							
						}else if(yon.equals("ㅜ")||yon.equals("N")||yon.equals("n")) {
							System.out.println(" ==== 수정 취소 ==== ");
						}
					}
					
				//회원삭제	
				}else if(gubun == 4) {
					System.out.println("삭제 회원: ");
					String id = sc.next();
					Member_dto_1 dto = dao.getView(id);
					if(dto == null) {
						System.out.println(" ==== 삭제 정보 없음 ==== ");
					}else if(dto != null) {
						System.out.println("===================================================");
						System.out.println("ID\t성명\t주소\t전번\t\t등록일\t\t나이");
						System.out.print(dto.getId()+"\t"); 
						System.out.print(dto.getName()+"\t"); 
						System.out.print(dto.getAddress()+"\t"); 
						System.out.print(dto.getTel()+"\t"); 
						System.out.print(dto.getReg_date()+"\t"); 
						System.out.print(dto.getAge()+"\n");
						
						
						System.out.println("삭제하겠습니까? 예:[Y] 아니오:[N]");
						String yn = sc.next();
						
						if(yn.equals("y")||yn.equals("Y")||yn.equals("ㅛ")) {
							int result = dao.deleteMember(id);
							if(result == 1) {
								System.out.println(" ==== 삭제 완료 ==== ");
							}
							}else if(yn.equals("n")||yn.equals("N")||yn.equals("ㅜ")) {
								System.out.println(" ==== 삭제 실패 ==== ");
						}
					}
				}
			
			
			}while(gubun != 0);
			
		//도서관리	
		}else if(workGubun == 2) {
			int gubun = 0;
			
			do {
				System.out.print("도서 조회[1], 등록[2], 수정[3], 삭제[4] 이전[0]");
				gubun = sc.nextInt();
				//도서조회
				if(gubun == 1) {
					int search;
					do {
						
						System.out.println("도서조회 도서명:[1], 작가명:[2] 이전:[0]");
						search = sc.nextInt();
						if(search == 1) {
							System.out.println("도서명 조회 : ");
							String searchName = sc.next();
							arr2 = dao2.getSearch("Name", searchName);
						}else if(search == 2) {
							System.out.println("작가명 조회 : ");
							String searchWriter = sc.next();
							arr2 = dao2.getSearch("writer", searchWriter);
						}
						
						if(search != 0) {
							for(int k = 0; k < arr2.size(); k++) {
								System.out.println("===================================================");
								System.out.println("도서코드\t도서명\t출판사\t작가명\t등록일\t\t빌린 여부");
								System.out.print(arr2.get(k).getNo()+"\t"); 
								System.out.print(arr2.get(k).getName()+"\t"); 
								System.out.print(arr2.get(k).getPublicher()+"\t"); 
								System.out.print(arr2.get(k).getWriter()+"\t"); 
								System.out.print(arr2.get(k).getReg_date()+"\t"); 
								System.out.print(arr2.get(k).getRent_gubun()+"\n"); 
							}	
						if(arr2.size() == 0) {
								System.out.println(" ==== 검색 내용 없음 ==== ");
							}
								
						}
					
					}while(search != 0);
					
				//도서등록	
				}else if(gubun == 2) {
					System.out.println("도서 넘버: ");
					String no = sc.next();

					
					System.out.println("도서명 : ");
					String name = sc.next();
					
					System.out.println("출판사 : ");
					String publisher = sc.next();
					
					System.out.println("작가명 : ");
					String writer = sc.next();
					
					System.out.println("등록 날짜 : ");
					String reg_date = sc.next();
					
	
					
					Member_dto_2 dto2 = new Member_dto_2(no, name, publisher, writer, reg_date, "");
					int result = dao2.bookInsert(dto2);
					
					if(result == 1) {
						System.out.println(" ==== 등록 성공 ==== ");
					}else {
						System.out.println(" ==== 등록 실패 ==== ");
					}
					
				//도서수정
				}else if(gubun == 3) {
					System.out.println("수정 도서 코드: ");
					String no = sc.next();
					Member_dto_2 dto = dao2.getView(no);
					
					if(dto == null) {
						System.out.println(" ==== 검색 내용 없음 ==== ");
						
					}else {
							System.out.println("===================================================");
							System.out.println("도서코드\t도서명\t출판사\t작가명\t등록일\t\t빌린 여부");
							System.out.print(dto.getNo()+"\t"); 
							System.out.print(dto.getName()+"\t"); 
							System.out.print(dto.getPublicher()+"\t"); 
							System.out.print(dto.getWriter()+"\t"); 
							System.out.print(dto.getReg_date()+"\t"); 
							System.out.print(dto.getRent_gubun()+"\n"); 
					}
					if(dto != null) {
						System.out.println("수정하시겠습니까 예:[Y], 아니오:[N] ");
						String yn = sc.next();
						
						if(yn.equals("Y")||yn.equals("y")||yn.equals("ㅛ")) {
							System.out.println("수정 이름 : ");
							String name = sc.next();
							
							System.out.println("수정 출판사: ");
							String publisher = sc.next();
							
							System.out.println("수정 작가명");
							String writer = sc.next();
							
							System.out.println("수정 날짜 : ");
							String reg_date = sc.next();
							
							System.out.println("렌트 여/부 : ");
							//String rent_gubun = sc.next();
							
							int result = dao2.updateName(no, name, publisher, writer, reg_date);
							
							if(result == 1) {
								System.out.println(" ==== 수정 완료 ==== ");
							}else {
								System.out.println(" ==== 수정 실패 ==== ");
							}
							
						}else {
							System.out.println(" ==== 수정 취소 ==== ");
						}
					}
					
					
							
				
				//도서삭제	
				}else if(gubun == 4 ) {
					System.out.println("삭제 도서 코드  : ");
					String no = sc.next();
					Member_dto_2 dto = dao2.getView(no);
					
					if(dto == null) {
						System.out.println(" ==== 검색 내용 없음 ==== ");
						
					}else {
							System.out.println("===================================================");
							System.out.println("도서코드\t도서명\t출판사\t작가명\t등록일\t\t빌린 여부");
							System.out.print(dto.getNo()+"\t"); 
							System.out.print(dto.getName()+"\t"); 
							System.out.print(dto.getPublicher()+"\t"); 
							System.out.print(dto.getWriter()+"\t"); 
							System.out.print(dto.getReg_date()+"\t"); 
							System.out.print(dto.getRent_gubun()+"\n"); 
							
							System.out.println("삭제하시겠습니까 ? 예:[Y], 아니오:[N]");
							String yn = sc.next();
							if(yn.equals("Y")||yn.equals("y")||yn.equals("ㅛ")) {
								int result = dao2.deleteMember(no);
									System.out.println(" ==== 삭제 완료 ==== ");
								
								
							}else if(yn.equals("N")||yn.equals("n")||yn.equals("ㅜ")) {
								System.out.println(" ==== 삭제 취소 ==== ");
							}
					}
				}
			}while(gubun != 0);
			
		//대여	
		}else if(workGubun == 3) {
			//대여1일때 렌트넘버가 자동 생성되도록 
			
			int gubun = 0;
			do {
				System.out.println("대여입력:[1] 이전:[0]");
				gubun = sc.nextInt();
				
				//대여 입력
				if(gubun == 1) {
					
					//회원아이디 존재여부				
					int ingYN;
					String member_id;
					do {
						System.out.println(" 회원 ID : ");
						member_id = sc.next();
					

						ingYN = dao3.getCheckValue("member", member_id);
						if(ingYN == 0) System.out.println(" ==== 회원ID 입력오류 ==== ");
					}while(ingYN == 0); //ingYN이 0이면 계속 물어보기
					
					//도서아이디 존재여부				
					String book_no;
					do {
						System.out.println(" 도서 NO : ");
						book_no = sc.next();
					

						ingYN = dao3.getCheckValue("book", book_no);
						if(ingYN == 0) System.out.println(" ==== 책No 입력오류 ==== ");
				
					}while(ingYN == 0);
					
					System.out.println(" 대여 날짜 : ");
					String rent_date = sc.next();
					
					
					String rentNo = dao3.getMaxRentNo();

					Member_dto_3 dto3 = new Member_dto_3(rentNo, member_id, book_no, rent_date, "");
					int result = dao3.saveRent(dto3);
					int updateResult = 0;
					if(result == 1) {
						updateResult = dao3.setBookRentGubun(book_no);
					}
					if(updateResult == 1) {
						System.out.println(" ==== 대여 완료 ==== ");
					}else {
						System.out.println(" ==== 대여 실패 ==== ");
					}
	
				}
				
			}while(gubun != 0);
		
			
			
		//반납	
		}else if(workGubun == 4) {
			
			String member_id = "";
			int ingYn = 0;
				System.out.println("반납 회원 ID : ");
				member_id = sc.next();
			
				ArrayList<Member_dto_3> arr4 = dao3.getRentList(member_id);
				for(int k = 0; k < arr4.size(); k++) {
					System.out.print(arr4.get(k).getRentNo()+"\t");
					System.out.print(arr4.get(k).getMemberId()+"\t");
					System.out.print(arr4.get(k).getMemberName()+"\t");
					System.out.print(arr4.get(k).getBookNo()+"\t");
					System.out.print(arr4.get(k).getBookName()+"\t");
					System.out.print(arr4.get(k).getRentDate()+"\t");
					System.out.print(arr4.get(k).getRentGubun()+"\n");
				}
			
				System.out.print("반납 대여 No : ");
				String rNo = sc.next();
				
				System.out.print("반납 일자: ");
				String returnDate = sc.next();
				
				int procFirst = dao3.returnRent(rNo, returnDate);
				int procSecond = 0;
				if(procFirst == 1) {
					procSecond = dao3.returnBook(rNo);
				}
				if(procSecond == 1) {
					System.out.println(" ==== 반납 완료 ==== ");
				}else {
					System.out.println(" ==== 반납 오류 ==== ");
				}
				
								
			
		//대출이력
		}else if(workGubun == 5) {
			int hisGubun = 0;
			do {
			System.out.print(" 회원대출이력[1], 도서대출이력[2], 이전[0] ");
			hisGubun = sc.nextInt();
			if(hisGubun == 1) {
				System.out.println(" 회원 ID : ");
				String memberId = sc.next();
				
				ArrayList<Member_dto_5> arr5 = dao5.getHistoryMember(memberId);
				
				System.out.println("=====================================================");
				System.out.println("대출번호\t회원명\t도서번호\t도서명\t대출일자\t\t반납일자\t");
				System.out.println("-----------------------------------------------------");
				for(int k = 0; k < arr5.size(); k++) {
					System.out.print(arr5.get(k).getRentNo()+"\t");
					System.out.print(arr5.get(k).getMemberName()+"\t");
					System.out.print(arr5.get(k).getBookNo()+"\t");
					System.out.print(arr5.get(k).getBookName()+"\t");
					System.out.print(arr5.get(k).getRentDate()+"\t");
					System.out.print(arr5.get(k).getReturnDate()+"\n");
				}
				
				
			}else if(hisGubun == 2) {
				
				
			}
			
			}while(hisGubun != 0);
			
		}
		
		
		}while(workGubun != 0);
		
		sc.close();
		System.out.println(" ==== 시스템 종료 ==== ");
	}

}
