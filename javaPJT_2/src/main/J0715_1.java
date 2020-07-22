package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0715_1_dao;
import dto.J0715_1_dto;

public class J0715_1 {
	public static void main(String[] main) {
	Scanner sc = new Scanner(System.in);
	ArrayList<J0715_1_dto> arr = new ArrayList<>();
	J0715_1_dao dao = new J0715_1_dao();
	
	 System.out.print("몇명 ?");
	 int count = sc.nextInt();
	 for(int k = 0; k < count; k++) {
		 System.out.print("이름 ?");
		 String name = sc.next();
		 System.out.print("국어 ?");
		 int kor = sc.nextInt();
		 System.out.print("영어 ?");
		 int eng = sc.nextInt();
		 System.out.print("수학 ?");
		 int mat = sc.nextInt();
		
		 int total = dao.getTotal(kor, eng, mat);		 
//		 int ava = total /3;
		 
		 
		 int ava = dao.getAva(total,3);

		 arr.add(new J0715_1_dto(name, kor, eng, mat, total, ava));	
	 }		 
	 
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getKor()+"\t");
			System.out.print(arr.get(k).getEng()+"\t");
			System.out.print(arr.get(k).getMat()+"\t");	
			System.out.print(arr.get(k).getTotal()+"\t");
			System.out.print(arr.get(k).getAva()+"\n");
		}
		 sc.close();	 
	 }
 }