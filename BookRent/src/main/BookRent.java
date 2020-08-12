package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.Member_dao_1;
import dao.Member_dao_2;
import dto.Member_dto_1;
import dto.Member_dto_2;


public class BookRent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member_dao_1 dao = new Member_dao_1();
		Member_dao_2 dao2 = new Member_dao_2();
		ArrayList<Member_dto_1> arr = new ArrayList<>();
		ArrayList<Member_dto_2> arr2 = new ArrayList<>();
		
		

		int workGubun;
		
		do {		
		//회원관리
			System.out.print(" 회원관리[1], 도서관리[2], 대여[3], 반납[4], 시스템종료[0]");
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
							System.out.println("조회 ID : ");
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
						}else if(search == 0) {
							System.out.println(" ====검색 내용 없음==== ");
						}
						
					}while(search != 0);
					
					
				//회원등록	
				}else if(gubun == 2) {
					System.out.print("등록 ID : ");
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
					System.out.println("수정 회원: ");
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
						
						System.out.println("도서조회 도서명:[1], 작가명:[2] ");
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
					
					System.out.println("빌린 여부 : ");
					String rent_gubun = sc.next();
					
					Member_dto_2 dto2 = new Member_dto_2(no, name, publisher, writer, reg_date, rent_gubun);
					int result = dao2.memberList(dto2);
					
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
							
							System.out.println("수정 여/부 : ");
							String rent_gubun = sc.next();
							
							int result = dao2.updateName(no, name, publisher, writer, reg_date, rent_gubun);
							
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
		
			
		//반납	
		}else if(workGubun == 4) {
			
		
		}
		
		
		}while(workGubun != 0);
		
		sc.close();
		System.out.println(" ==== 시스템 종료 ==== ");
	}

}
