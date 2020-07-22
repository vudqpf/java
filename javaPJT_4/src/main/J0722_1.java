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
		int gubun = 0;
		do {
			System.out.print("검색:1 , 등록:2, 수정:3, 삭제:4, 종료:0 ");
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
							System.out.print(arr.get(k).getAge()+"\t");	
						}	
					}
				}else if(search == 2) {
					System.out.println("지역검색 : ");
					int searchArea = sc.nextInt();
					for(int k = 0; k < arr.size(); k++) {
						if(arr.get(k).getName().indexOf(searchArea) != -1) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\t");	
						}	
					}
					
				}else if(search == 3) {
					System.out.println("나이검색 : ");
					int searchAge = sc.nextInt();
					for(int k = 0; k < arr.size(); k++) {
						if(arr.get(k).getName().indexOf(searchAge) != -1) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\t");	
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
					if(arr.get(k).getNo().equals("no")) {
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
					
					J0722_1_dto dao = J0722_1_dto()
				}
				System.out.println("-----------------수정 종료-------------------");				
			}else if(gubun == 4){
				
			}
			
		}while(gubun != 0);
	}
}
