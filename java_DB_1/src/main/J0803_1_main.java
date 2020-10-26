package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0803_1_dao;
import dto.J0803_1_dto;

public class J0803_1_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0803_1_dao dao = new J0803_1_dao();
		ArrayList<J0803_1_dto> arr = new ArrayList<>();
		int gubun;
		do {
			System.out.print("검색 사번:1, 성명:2, 부서명:3, 종료:0, 선택:?");
			gubun = sc.nextInt();
			if(gubun == 1) {
				System.out.print("사번?");
				String no = sc.next();
//				arr = dao.getListNo(no);
				arr = dao.getListAll("no",no);
			}else if(gubun == 2) {
				System.out.print("성명?");
				String name = sc.next();
				name = name.toUpperCase(); //소문자를 대문자로 변환시켜주는
//				arr = dao.getListName(name);
				arr = dao.getListAll("name",name);
				
			}else if(gubun == 3) {
				System.out.print("부서명?");
				String dname = sc.next();
				dname = dname.toUpperCase(); //소문자를 대문자로 변환시켜주는
				arr = dao.getListAll("dname",dname);
				
			}
			if(gubun != 0) {
				System.out.println("========================================");
				System.out.println("사번\t 성명\t 업무 \t 급여\t 부서명\t");
				System.out.println("----------------------------------------");
				for(int k = 0; k < arr.size(); k++) {
					System.out.print(arr.get(k).getEmpno()+"\t");
					System.out.print(arr.get(k).getEname()+"\t");
					System.out.print(arr.get(k).getJob()+"\t");
					System.out.print(arr.get(k).getSal()+"\t");
					System.out.print(arr.get(k).getDname()+"\n");
				}
			}
		}while(gubun != 0);
		

		
		
		sc.close();
		System.out.println("==== 종료 ====");
	}
}