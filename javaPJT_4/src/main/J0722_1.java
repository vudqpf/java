package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0722_1_dao;
import dto.J0721_1_dto;
import dto.J0722_1_dto;

public class J0722_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0722_1_dao dao = new J0722_1_dao();
		ArrayList<J0722_1_dto> arr = new ArrayList<>();
		
		arr.add(new J0722_1_dto("S0001", "홍길동", "대전", 25));
		arr.add(new J0722_1_dto("S0002", "안길동", "부산", 28));
		arr.add(new J0722_1_dto("S0003", "김이수", "공주", 40));
		
		
		int gubun = 0;
		do {
			System.out.print("검색:1 , 등록:2, 수정:3, 삭제:4, 종료:0");
			gubun = sc.nextInt();
			if(gubun == 1) {
				System.out.print("이름검색:1 지역검색:2 나이검색:3");
				int search = sc.nextInt();
				if(search == 1) {
					System.out.println("이름 검색:");
					String searchName = sc.next();
					for(int k = 0; k < arr.size(); k++) {
						if(arr.get(k).getName().indexOf(searchName) != -1) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\n");	
						}	
					}
				}else if(search == 2) {
					System.out.println("지역검색:");
					String searchArea = sc.next();
					for(int k = 0; k < arr.size(); k++) {
						if(arr.get(k).getArea().indexOf(searchArea) != -1) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\n");	
						}	
					}
					
				}else if(search == 3) {
					System.out.println("나이검색:3");
					int searchAge = sc.nextInt();
					for(int k = 0; k < arr.size(); k++) {
						if(arr.get(k).getAge()==searchAge) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\n");	
						}	
					}
				}
				System.out.println("-------------------검색 종료-----------------");	
				
			}else if(gubun == 2){
				String no = "";
				if(arr.size() == 0) {
					no = "S0001";
				}else {
					String n = arr.get(arr.size()-1).getNo();
					no = dao.getNo(n);
				}
					System.out.print("이름: ");
					String name = sc.next();
					System.out.print("지역: ");
					String area = sc.next();
					System.out.print("나이: ");
					int age = sc.nextInt();
				
					arr.add(new J0722_1_dto(no, name, area, age));
					
						for(int k = 0; k < arr.size(); k++) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\n");	
						}
				System.out.println("-----------------등록 종료-------------------");
				
				
			}else if(gubun == 3){
				System.out.println("수정 사번: ");
				String no = sc.next();
				int updateNo = -1;
				for(int k = 0; k < arr.size(); k++) {
					if(arr.get(k).getNo().equals(no)) {
						updateNo = k;
						System.out.print(arr.get(k).getNo()+"\t");
						System.out.print(arr.get(k).getName()+"\t");
						System.out.print(arr.get(k).getArea()+"\t");
						System.out.print(arr.get(k).getAge()+"\n");
					}
					
				}if(updateNo == -1) {
					System.out.println("수정 정보 없음");
				}else{
					System.out.print("수정할 이름 :");
					String name = sc.next();
					System.out.print("수정할 지역 :");
					String area = sc.next();
					System.out.println("수정할 나이 :");
					int age = sc.nextInt();
					
					J0722_1_dto dto = new J0722_1_dto(no, name, area, age);
					arr.set(updateNo,dto);
					
					for(int k = 0; k < arr.size(); k++) {
						System.out.print(arr.get(k).getNo()+"\t");
						System.out.print(arr.get(k).getName()+"\t");
						System.out.print(arr.get(k).getArea()+"\t");
						System.out.print(arr.get(k).getAge()+"\n");
					}
					
				}
				System.out.println("-----------------수정 종료-------------------");				
			}else if(gubun == 4){
				System.out.print("삭제할 사번 :");
				String delete = sc.next();
				int remove = -1;
					for(int k = 0; k < arr.size(); k++) {
							if(arr.get(k).getNo().equals(delete)) {
								remove = k;
								System.out.print(arr.get(k).getNo()+"\t");
								System.out.print(arr.get(k).getName()+"\t");
								System.out.print(arr.get(k).getArea()+"\t");
								System.out.print(arr.get(k).getAge()+"\n");
						}
					}if(remove == -1) {
						System.out.print("수정정보 없음");
					}else {
						System.out.print("정말 삭제 하시겠습니까 예:Y  아니오:N");
						String yn = sc.next();
						if(yn.equals("Y")||yn.equals("y")) {
							arr.remove(remove);	
							for(int k = 0; k < arr.size(); k++) {
								System.out.print(arr.get(k).getNo()+"\t");
								System.out.print(arr.get(k).getName()+"\t");
								System.out.print(arr.get(k).getArea()+"\t");
								System.out.print(arr.get(k).getAge()+"\n");
							}
						}
						
						
					}
						
						
					
			}
			
					

		}while(gubun != 0);
	}
}
