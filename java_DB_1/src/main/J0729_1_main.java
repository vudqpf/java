package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0729_1_dao;
import dto.J0729_1_dto;

public class J0729_1_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0729_1_dao dao = new J0729_1_dao();
//		ArrayList<J0729_1_dto> arr = new ArrayList<>();
				
		System.out.print("검색 전체조회:1, 이름:2, 지역:3, 나이:4, 종료:0");
		int gubun =sc.nextInt();
		ArrayList<J0729_1_dto> arr = null;
		
		if(gubun == 1) {
//			arr = dao.getListAll();
			arr = dao.getListMember("all","",0,0);
//			ArrayList<J0729_1_dto> arr = dao.getListAll();
//			for(int k = 0; k < arr.size(); k++) {
//				System.out.print(arr.get(k).getId()+"\t");
//				System.out.print(arr.get(k).getName()+"\t");
//				System.out.print(arr.get(k).getArea()+"\t");
//				System.out.print(arr.get(k).getAge()+"\n");
//			}
		}else if(gubun == 2) {
			System.out.print("검색 이름?");
			String name = sc.next();
//			arr = dao.getListName(name);
			arr = dao.getListMember("sName",name,0,0);
//			ArrayList<J0729_1_dto> arr = dao.getListName(name);
//			for(int k = 0; k < arr.size(); k++) {
//				System.out.print(arr.get(k).getId()+"\t");
//				System.out.print(arr.get(k).getName()+"\t");
//				System.out.print(arr.get(k).getArea()+"\t");
//				System.out.print(arr.get(k).getAge()+"\n");
//			}
			
		}else if(gubun == 3) {
			System.out.print("검색 지역?");
			String area = sc.next();
//			arr = dao.getListArea(area);
			arr = dao.getListMember("sArea",area,0,0);
			
		}else if(gubun == 4) {
			System.out.print("몇살 부터?");
			int startAge =sc.nextInt();
			System.out.print("몇살 부터?");
			int endAge =sc.nextInt();
			arr = dao.getListMember("sAge","",startAge,endAge);
//			arr = dao.getListAge(startAge, endAge);
		}
		
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getId()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getArea()+"\t");
			System.out.print(arr.get(k).getAge()+"\n");
		}
		
		sc.close();
	}

}
