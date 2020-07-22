package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0715_2_dao;
import dto.J0715_2_dto;

public class J0715_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0715_2_dto> arr = new ArrayList<>();
		J0715_2_dao dao = new J0715_2_dao();
		
		System.out.print("몇명 ?");
		int count = sc.nextInt();
		for(int k = 0; k < count; k++) {
			System.out.print("이름 :");
			String name = sc.next();
			System.out.print("국어 :");
			int kor = sc.nextInt();
			System.out.print("영어 :");
			int eng = sc.nextInt();
			System.out.print("수학 :");
			int mat = sc.nextInt();
			
			int total = dao.getTotal(kor, eng, mat);
//			int ava = dao.getAva(total, count);
			double ava = dao.getAva(total, 3);
			String result = dao.getResult(ava) ;
			
			J0715_2_dto dto = new J0715_2_dto(name, result, kor, eng, mat, total, ava);
			arr.add(dto);
		}
		
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getKor()+"\t");
			System.out.print(arr.get(k).getEng()+"\t");
			System.out.print(arr.get(k).getMat()+"\t");
			System.out.print(arr.get(k).getTotal()+"\t");
			System.out.print(arr.get(k).getAva()+"\t");
			System.out.print(arr.get(k).getResult()+"\n");
			
		}

	}

}



//90점 수
//gettotal, getava, getresult