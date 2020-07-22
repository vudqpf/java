package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0716_1_dao;
import dto.J0716_1_dto;

public class J0716_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0716_1_dto> arr = new ArrayList<>();
		J0716_1_dao dao = new J0716_1_dao();
		
		
	   System.out.println("몇명 :");
	   int count = sc.nextInt();
	   for(int k = 0; k < count; k++) {
		   System.out.println("이름 :");
		   String name = sc.next();
		   System.out.println("국어 :");
		   int kor = sc.nextInt();
		   System.out.println("영어 :");
		   int eng = sc.nextInt();
		   
		   int total = dao.getTotal(kor, eng);
		   String ava = dao.getAva(total, 2);
		   String result = dao.getResult(ava);
		   

		   
		   arr.add(new J0716_1_dto(name, ava, result, kor, eng, total));
		   
	   }
	   for(int k = 0; k < arr.size(); k++) {
		   System.out.print(arr.get(k).getName()+"\t");
		   System.out.print(arr.get(k).getKor()+"\t");
		   System.out.print(arr.get(k).getEng()+"\t");
		   System.out.print(arr.get(k).getTotal()+"\t");
		   System.out.print(arr.get(k).getAva()+"\n");
		   
	   }
		
		

	}

}
