package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.Rent_dao;
import dto.HistoryMember;
import dto.Rent_1_dto;

public class BookRent1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Rent_dao dao = new Rent_dao();
		int workGugun = 0;
		do {
			System.out.print(" 회원관리[1], 도서관리[2], 대여[3], 반납[4], 대출이력[5], 시스템종료[0] ? ");
			workGugun = sc.nextInt();
//			workGugun = 2;
			if(workGugun == 1) {
				
				int gubun =0;
				do {
					System.out.print(" 회원 조회[1], 등록[2], 수정[3], 삭제[4], 이전[0] ? ");
					gubun = sc.nextInt();
					if(gubun == 1) {
						
					} else if(gubun == 2) {
						
						
						
					} else if(gubun == 3) {
						
					} else if(gubun == 4) {
						
					}	
					
				}while(gubun != 0);
				
				
			} else if(workGugun == 2) {
				
			} else if(workGugun == 3) {
			
				// 대여
				int ingYN = 0;
				String memberId ="";
				do {
					System.out.print(" 회원 ID ? ");
					memberId = sc.next();
//					ingYN = dao.getCheckMemberId(memberId);
					ingYN = dao.getCheckValue("member",memberId);
					if(ingYN == 0) System.out.println("회원ID 입력오류~");
				}while(ingYN == 0);	
				
				String bookNo ="";
				do {
					System.out.print(" 도서 NO ? ");
					bookNo = sc.next();
//					ingYN = dao.getCheckBookNo(bookNo);
					ingYN = dao.getCheckValue("book",bookNo);
				}while(ingYN == 0);	
				
				System.out.print(" 대여날짜(yyyy-mm-dd) ? ");
				String rentDate = sc.next();				
				
				String rentNo = dao.getMaxRentNo();
				
				int result = dao.saveRent(rentNo,memberId,bookNo,rentDate);
				int updateResult =0;
				if(result == 1) {
					updateResult = dao.setBookRentGugun(bookNo);
				}
				if(updateResult == 1) {
					System.out.println("대여 완료~");
				} else {
					System.out.println("대여 실패~");
				}
				
				
				
			} else if(workGugun == 4) {
				System.out.print(" 반납할 회원 ID ? ");
				String memberId = sc.next();
				ArrayList<Rent_1_dto> arr = dao.getRentList(memberId);
				for(int k=0; k < arr.size(); k++) {
					System.out.print(arr.get(k).getRentNo()+"\t");
					System.out.print(arr.get(k).getMemberId()+"\t");
					System.out.print(arr.get(k).getMemberName()+"\t");
					System.out.print(arr.get(k).getBookNo()+"\t");
					System.out.print(arr.get(k).getBookName()+"\t");
					System.out.print(arr.get(k).getRentDate()+"\t");
					System.out.print(arr.get(k).getRentGubun()+"\n");
				}
				System.out.print(" 반납 대여 번호 ? ");
				String rNo = sc.next();
				System.out.print(" 반납 일자 ? ");
				String returnDate = sc.next();
				
				int procFirst = dao.returnRent(rNo, returnDate);
				int procSecond = 0;
				if(procFirst == 1) {
					procSecond = dao.returnBook(rNo);
				}
				if(procSecond == 1 ) System.out.println(" 반납 완료~ ");
				else System.out.println(" 반납 오류~ ");


				
				
			} else if(workGugun == 5) { // 대출이력	
				int hisGubun = 0;
				do {
					System.out.print(" 회원대출이력[1], 도서대출이력[2], 이전[3] ? ");
					hisGubun = sc.nextInt();
					if(hisGubun == 1) {
						System.out.print(" 회원 ID ? ");
						String memberId = sc.next();
						ArrayList<HistoryMember> arr = dao.getHistoryMember(memberId);
						System.out.println("=====================================================");
						System.out.println("대출번호\t 회원명\t 도서번호\t 도서명\t 대출일자\t 반납일자\t");
						System.out.println("-----------------------------------------------------");
						for(int k=0; k < arr.size(); k++) {
							System.out.print(arr.get(k).getRentNo()+"\t");
							System.out.print(arr.get(k).getMemberName()+"\t");
							System.out.print(arr.get(k).getBookNo()+"\t");
							System.out.print(arr.get(k).getBookName()+"\t");
							System.out.print(arr.get(k).getRentDate()+"\t");
							System.out.print(arr.get(k).getReturnDate()+"\n");
						}
						System.out.println("-----------------------------------------");
						
					} else if(hisGubun == 2) {
						
					}
				}while(hisGubun != 0);	
			}

			
			
		}while(workGugun != 0);	
		
		sc.close();
		System.out.println(" 시스템 종료~~~");
	}

}






