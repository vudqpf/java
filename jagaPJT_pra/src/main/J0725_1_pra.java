package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0725_1_dao_pra;
import dto.J0725_1_dto_pra;

public class J0725_1_pra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0725_1_dto_pra> arr = new ArrayList<>();
		J0725_1_dao_pra dao = new J0725_1_dao_pra();
		
		arr.add(new J0725_1_dto_pra("S0001", "홍길동", "대전", 25));
		arr.add(new J0725_1_dto_pra("S0002", "안길동", "부산", 28));
		arr.add(new J0725_1_dto_pra("S0003", "김이수", "공주", 40));
		
		int k = 0;
		int gubun = 0;
		do {
			System.out.print("검색:1 , 등록:2, 수정:3, 삭제:4, 종료:0 ");
			gubun = sc.nextInt();
			if(gubun == 1) {
				System.out.print("이름검색:1, 지역:2, 나이:3");
				String search = sc.next();
				if(search.equals("1")) {
					System.out.print("이름검색: ");
					String searchName = sc.next();
					for(k = 0; k < arr.size(); k++) {
						if(arr.get(k).getName().indexOf(searchName) != -1) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\n");
						}
					}
				}else if(search.equals("2")) {
					System.out.print("지역검색: ");
					String searchArea = sc.next();
					for(k = 0; k < arr.size(); k++) {
						if(arr.get(k).getArea().indexOf(searchArea) != -1) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\n");
						}
					}
					
					
				}else if(search.equals("3")) {
					System.out.print("나이검색: ");
					int searchAge = sc.nextInt();
					for(k = 0; k < arr.size(); k++) {
						if(arr.get(k).getAge() == searchAge) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\n");
						}
					}
				}
				System.out.print("-----------검색 종료-------------");
			}else if(gubun == 2) {
				String no = "";
					if(arr.size() == 0) {
						no = "S0001";
					}else {
						String n = arr.get(arr.size()-1).getNo();
						no = dao.getNo(n);
					}
					System.out.print("이름은 :");
					String name = sc.next();
					System.out.println("지역은 :");
					String area = sc.next();
					System.out.println("나이는 :");
					int age = sc.nextInt();
					
					
					
					
						
				System.out.print("-----------등록 종료-------------");
			}else if(gubun == 3) {
				
				System.out.print("-----------수정 종료-------------");
			}else if(gubun == 4) {
				
				System.out.print("-----------삭제 종료-------------");
			}
			
		}while(gubun != 0);
		
		
	}
}
