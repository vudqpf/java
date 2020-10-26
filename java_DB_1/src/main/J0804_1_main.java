package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0804_1_dao;
import dto.J0804_1_dto;

public class J0804_1_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0804_1_dao dao = new J0804_1_dao();
		ArrayList<J0804_1_dto> arr = new ArrayList<>();
				
		int gubun = 0;
		do {
			System.out.println(" 검색:[1], 등록:[2], 수정:[3], 삭제:[4], 종료:0? ");
			gubun = sc.nextInt();
			
			//검색
			if(gubun == 1) {
				int searchGubun = 0;
				do {
					System.out.print(" 검색 사번:[1], 이름:[2], 지역:[3], 종료:0 ");
					searchGubun = sc.nextInt();
					if(searchGubun == 1) {
						System.out.print(" 검색 사번? ");
						String no = sc.next();
						arr = dao.getMemberList("a.no", no);
						
					}else if(searchGubun == 2) {
						System.out.print(" 검색 이름? ");
						String name = sc.next();
						arr = dao.getMemberList("a.name", name);
						
					}else if(searchGubun == 3) {
						System.out.print(" 검색 지역? ");
						String area = sc.next();
						arr = dao.getMemberList("b.area_name", area);
					}
					if(searchGubun != 0) {
						System.out.println("============================");
						System.out.println(" 사번\t성명\t지역\t나이 ");
						System.out.println("----------------------------");
						if(arr.size() == 0) {
						System.out.println("==== 검색 내용 없음 =====");
						}
						for(int k = 0; k <arr.size(); k++) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\n");
						}
					}
					
				}while(searchGubun != 0);

				
			//등록	
			}else if(gubun == 2) {
				System.out.println(" 사번? ");
				String no = sc.next();
				
				System.out.println(" 성명? ");
				String name = sc.next();
				
				System.out.println(" 지역코드? 서울:[10], 대전:[20], 부산:[30] ");
				String area = sc.next();
				
				System.out.println(" 나이? ");
				int age = sc.nextInt();
				
//				int result = dao.saveMember(no, name, area, age);
				//dao에 넘겨줘서 만드는 방법
				
				J0804_1_dto dto = new J0804_1_dto(no, name, area, age);
				int result = dao.saveMember(dto); //←오버로딩    오버라이딩 -부모클래스에 상속받을때
												  //dto에 넘겨주고 dao에서 넘겨받아 생성하는 방법
				
				if(result == 1 ) {
					System.out.println("==== 등록 완료 ====");
				}else {
					System.out.println("==== 등록 실패 ====");
				}
				
			//수정	
			}else if(gubun == 3) {
				System.out.print(" 수정 사번 ? ");
				String no = sc.next();
				J0804_1_dto dto = dao.getMemberView(no);
				if(dto == null) {
					System.out.println("==== 사번 정보 없음 ====");
				}else {
					System.out.print("사번 :"+no+"\t");
					System.out.print("성명 :"+dto.getName()+"\t");
					System.out.print("지역 :"+dto.getArea()+"\t");
					System.out.print("나이 :"+dto.getAge()+"\n");
					
					System.out.println(" 수정하겠습니까? 예:Y 아니오:N ");
					String updateGubun = sc.next();
					if(updateGubun.equals("Y")||updateGubun.equals("y")||updateGubun.equals("ㅛ")) {
						System.out.println(dto.getName()+"→ 수정 성명? ");
						String name = sc.next();
						System.out.println(dto.getArea()+"→ 수정 지역?서울:[10], 대전:[20], 부산:[30] ");
						String area = sc.next();
						System.out.println(dto.getAge()+ "→　수정 나이? ");
						int age = sc.nextInt();
						int result = dao.updateMember(no, name, area, age); //반영된 행의 수가 리턴되기 때문에 int로 받아야함
																		//result가 1이 아니면 잘 못 됨. 1사람의 정보를 넘기는데....
						if(result == 1) {
							System.out.println("==== 수정 완료 ====");
						}else {
							System.out.println("==== 수정 오류 ====");
						}
						
					}
					
				}
				
				
			//삭제	
			}else if(gubun == 4) {
				System.out.println("삭제 사번?");
				String no = sc.next();
				J0804_1_dto dto = dao.getMemberView(no);
				if(dto== null) {
					System.out.println("==== 사번 정보 없음 ====");
				}else {
					System.out.print("사번 :"+no+"\t");
					System.out.print("성명 :"+dto.getName()+"\t");
					System.out.print("지역 :"+dto.getArea()+"\t");
					System.out.print("나이 :"+dto.getAge()+"\n");
					
						System.out.println("삭제하겠습니까? 예:Y 아니오:N ");
						String deleteGubun = sc.next();
						if(deleteGubun.equals("Y")||deleteGubun.equals("y")||deleteGubun.equals("ㅛ")) {
							int result = dao.deleteMember(no);
							if(result == 1) {
								System.out.println("==== 삭제 완료 ====");
							}else {
								System.out.println("==== 삭제 오류 ====");
							}
						}
				
				}
			
			}
		}while(gubun != 0);
		System.out.println("==== 종 료 ====");
		
		
	}

}
