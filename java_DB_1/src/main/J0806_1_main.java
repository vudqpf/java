package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0806_1_dao;
import dto.J0806_1_dto;

public class J0806_1_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0806_1_dao dao = new J0806_1_dao();
		ArrayList<J0806_1_dto> arr = new ArrayList<>();
		
		int gubun = 0;
		do {
			System.out.println(" 검색:[1], 등록:[2], 수정:[3], 삭제:[4], 종료:0? ");
			gubun = sc.nextInt();
			
			
			//검색
			if(gubun == 1) {
				int searchGubun;
				do {
					
				System.out.println("검색 학번[1], 성명[2], 이전[0] ?");
				searchGubun = sc.nextInt();
				 if(searchGubun == 1) {
					 System.out.println("학번 ?");
					 String no = sc.next();
					 arr = dao.getScoreList("no", no);
				 }else if(searchGubun == 2) {
				 	System.out.println("성명 ?");
				 	String name = sc.next();
				 	arr = dao.getScoreList("name", name);
				 }
				 if(searchGubun != 0) {
					 System.out.println("===================================================");
					 System.out.println("학번\t성명\t국어\t영어\t수학\t총점\t평균");
					 for(int k = 0; k < arr.size(); k++) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getKor()+"\t");
							System.out.print(arr.get(k).getEng()+"\t");
							System.out.print(arr.get(k).getMat()+"\t");
							System.out.print(arr.get(k).getTotal()+"\t");
							System.out.print(arr.get(k).getAva()+"\n");
							}
					 if(arr.size() == 0) {
						 System.out.println(" ====검색 내용 없음==== ");
					 }
					 System.out.println("===================================================");
				 }
				 	
				}while(searchGubun != 0);
			
				
				
			
			//등록	
			}else if(gubun == 2) {
				System.out.println("등록 번호: ");
				String no = sc.next();
				if(no.length() > 4) {
					do {
						System.out.println("등록 번호는 1~4사이 ");
						no = sc.next();	
					}while(no.length() > 4);
				}
				
/*				
				do {
					System.out.println("등록 번호: ");
					String no = sc.next();
					for(no.length() < 4) {
						System.out.println("등록 번호는 1~4사이 ");
						no = sc.next();
					}
				}while(no.length() > 4);
*/				
				System.out.println("등록 이름: ");
				String name = sc.next();
				
				System.out.println("국어 점수: ");
				int kor = sc.nextInt();
					if(kor > 100 || kor < 0) {
						do {
							System.out.println("점수는 0~100사이 : ");
							kor = sc.nextInt();
						}while(kor > 100 || kor <0);
					}
					
				int eng;
				do {
				System.out.println("영어 점수: ");
				eng = sc.nextInt();
					if(eng > 100 || eng < 0) {
						System.out.println("점수는 0~100사이 : ");
					}
				}while(eng > 100 || eng < 0);
				
				int mat;
				do {
				System.out.println("수학 점수: ");
				mat = sc.nextInt();
					if(mat > 100 || mat < 0)
						System.out.println("점수는 0~100사이 : ");
				}while(mat > 100 || mat < 0);
				
				int total = dao.getTotal(kor, eng, mat);
				int ava = dao.getAva(total, 3);
				J0806_1_dto dto = new J0806_1_dto(no, name, kor, eng, mat, total, ava);
				int result = dao.saveScore(dto); //sesult에 dto의 주소값을 넘겨줌
				
				if(result == 1) {
					System.out.println(" ====등록 성공==== ");
				}else {
					System.out.println(" ====등록 실패==== ");
				}
				
			//수정	
			}else if(gubun == 3) {
				System.out.println(" 수정 학번: ");
				String no = sc.next();
				J0806_1_dto dto = dao.getMemberView(no);
				if(dto == null) {
					System.out.println(" ==== 수정 정보 없읍 ==== ");
				}else {
				    System.out.println("===================================================");
					System.out.println("학번\t성명\t국어\t영어\t수학\t총점\t평균");
					System.out.print(dto.getNo()+"\t");
					System.out.print(dto.getName()+"\t");
					System.out.print(dto.getKor()+"\t");
					System.out.print(dto.getEng()+"\t");
					System.out.print(dto.getMat()+"\t");
					System.out.print(dto.getTotal()+"\t");
					System.out.print(dto.getAva()+"\n");
				}
				
				if(dto  != null) {
					System.out.println("수정하시겠습니까? 예:[Y] 아니오:[N] ");
					String yon = sc.next();
					if(yon.equals("n")||yon.equals("N")||yon.equals("ㅜ")) {
						System.out.println(" ==== 수정 취소 ==== ");
					}else if(yon.equals("y")||yon.equals("Y")||yon.equals("y")){
						System.out.println("국어 점수: ");
						int kor = sc.nextInt();
							if(kor > 100 || kor < 0) {
								do {
									System.out.println("점수는 0~100사이 : ");
									kor = sc.nextInt();
								}while(kor > 100 || kor <0);
							}
						
						int eng;
						do {
						System.out.println("영어 점수: ");
						eng = sc.nextInt();
							if(eng > 100 || eng < 0) {
								System.out.println("점수는 0~100사이 : ");
							}
						}while(eng > 100 || eng < 0);
					
						int mat;
						do {
						System.out.println("수학 점수: ");
						mat = sc.nextInt();
							if(mat > 100 || mat < 0)
								System.out.println("점수는 0~100사이 : ");
						}while(mat > 100 || mat < 0);
						
						int total = dao.getTotal(kor, eng, mat);
						int ava = dao.getAva(total, 3);
						int result = dao.updateScore(no, kor, eng, mat, total, ava);
					
						if(result == 1) {
							System.out.println(" ==== 수정 완료 ==== ");
						}else {
							System.out.println(" ==== 수정 실패 ==== ");
						}
					}
				}
				
				
			
			//삭제	
			}else if(gubun == 4) {
				System.out.println(" 삭제 학번: ");
				String no = sc.next();
				J0806_1_dto dto = dao.getMemberView(no);
				if(dto == null) {
					System.out.println(" ==== 삭제 정보 없음 ==== ");
				}else {
				    System.out.println("===================================================");
					System.out.println("학번\t성명\t국어\t영어\t수학\t총점\t평균");
					System.out.print(dto.getNo()+"\t");
					System.out.print(dto.getName()+"\t");
					System.out.print(dto.getKor()+"\t");
					System.out.print(dto.getEng()+"\t");
					System.out.print(dto.getMat()+"\t");
					System.out.print(dto.getTotal()+"\t");
					System.out.print(dto.getAva()+"\n");
					
					System.out.println("삭제하겠습니까? 예:[Y] 아니오:[N]");
					String yn = sc.next();
					

					if(yn.equals("y")||yn.equals("Y")||yn.equals("ㅛ")) {
						int result = dao.deleteMember(no);
						if(result == 1) {
							System.out.println(" ==== 삭제 완료 ==== ");
						}else {
							System.out.println(" ==== 삭제 실패 ==== ");
						}
					}
				
				
				}
			}
			
			
		}while(gubun != 0);
		System.out.println("==== 종 료 ====");
		sc.close();
		
	}
}
