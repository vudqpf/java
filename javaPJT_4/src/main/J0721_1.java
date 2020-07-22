package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0721_1_dao;
import dto.J0721_1_dto;

public class J0721_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0721_1_dto> arr = new ArrayList<>();
		J0721_1_dao dao = new J0721_1_dao();
		
		J0721_1_dto dto1 = new J0721_1_dto("N001", "홍길동", "총무", "사원", 25);
		arr.add(dto1);
		arr.add(new J0721_1_dto("N002", "안상수", "인사", "대리", 35));
		arr.add(new J0721_1_dto("N003", "김이수", "총무", "대리", 28));           //arr배열의 숫자는 3
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getNo()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getDepart()+"\t");
			System.out.print(arr.get(k).getPosition()+"\t");
			System.out.print(arr.get(k).getAge()+"\n");			
		}
		System.out.println("==============================================");
		System.out.print("등록:0 이름검색:1, 부서검색:2, 정보수정:3  삭제:4        선택?");
		int gubun = sc.nextInt();
		
		if(gubun == 0) {
			System.out.print("이름 ?");
			String name  = sc.next();
			System.out.print("부서명?");
			String depart  = sc.next();
			System.out.print("직위명 ?");
			String position  = sc.next();
			System.out.print("나이?");
			int age  = sc.nextInt();
			
			String no = arr.get(arr.size()-1).getNo();   //N003
			String newNo = dao.getNo(no);
			J0721_1_dto dto = new J0721_1_dto(newNo, name, depart, position, age);
			arr.add(dto);
			
			for(int k = 0; k < arr.size(); k++) {
				System.out.print(arr.get(k).getNo()+"\t");
				System.out.print(arr.get(k).getName()+"\t");
				System.out.print(arr.get(k).getDepart()+"\t");
				System.out.print(arr.get(k).getPosition()+"\t");
				System.out.print(arr.get(k).getAge()+"\n");	
			}
			System.out.println("-----------등록 종료------------");
			
			
		}else if(gubun == 1) {
			System.out.print("검색 이름 ?");
			String search = sc.next();
			for(int k = 0; k < arr.size(); k++) {
				if(arr.get(k).getName().indexOf(search) != -1) {
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");	
				}
			}
			
			System.out.println("============이름검색 종료==============");
		}else if(gubun == 2) {
			System.out.print("부서 이름 ?");
			String search = sc.next();
			for(int k = 0; k < arr.size(); k++) {
				if(arr.get(k).getDepart().indexOf(search) != -1) {
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");	
				}
			}
			System.out.println("============부서검색 종료==============");
			
		}else if(gubun == 3) {
			System.out.print("수정사번 ?");
			String no = sc.next();
			int updateNo = -1;                                           //N002을 넣어주면
			for(int k = 0; k < arr.size(); k++) {
				if(arr.get(k).getNo().equals(no)) {  					 //N002이 있는지 확인하기 없으면 밑에 if문으로 넘어감
					updateNo = k;    									//N002은 1번재 자리에 있으니까 k=1 updateNo에 1을 넣어줌
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");	
				}
				
			}
			if (updateNo == -1) {
				System.out.print("수정 정보 없음");
			}else {
				System.out.print("수정할 이름 ?");
				String name  = sc.next();
				System.out.print("수정할 부서명?");
				String depart  = sc.next();
				System.out.print("수정할 직위명 ?");
				String position  = sc.next();
				System.out.print("수정할 나이?");
				int age  = sc.nextInt();
				
				J0721_1_dto d = new J0721_1_dto(no, name, depart, position, age);
				arr.set(updateNo, d);
				
//				arr.get(updateNo).setName(name);
//				arr.get(updateNo).setDepart(depart);
//				arr.get(updateNo).setPosition(position);
//				arr.get(updateNo).setAge(age);
				
				
			for(int k = 0; k < arr.size(); k++) {
					updateNo = k;
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");	
				}
				System.out.println("------------수정 종료-------------------------");
			}
			}else if(gubun == 4) {
				System.out.print("수정사번 ?");
				String no = sc.next();
				int deleteNo = -1;        
				if(gubun == 4) {
					for(int k = 0; k < arr.size(); k++) {
						if(arr.get(k).getNo().equals(no)) {  					 
							deleteNo = k;    									
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getDepart()+"\t");
							System.out.print(arr.get(k).getPosition()+"\t");
							System.out.print(arr.get(k).getAge()+"\n");	
						}
					
					}
				if (deleteNo == -1) {
					System.out.print("수정 정보 없음");
				}else {
					System.out.println("정말 삭제 하시겠습니까?   예:Y");
					String yn = sc.next();
					if(yn.equals("Y") || yn.equals("y") || yn.equals("ㅛ")){
						arr.remove(deleteNo);				
					}
					for(int k = 0; k < arr.size(); k++) {
						System.out.print(arr.get(k).getNo()+"\t");
						System.out.print(arr.get(k).getName()+"\t");
						System.out.print(arr.get(k).getDepart()+"\t");
						System.out.print(arr.get(k).getPosition()+"\t");
						System.out.print(arr.get(k).getAge()+"\n");	
					}
					System.out.println("-----------삭제 종료-----------");
					
				
			}
			
		}
		
	}
}
}