package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0716_1_dao_pra;
import dto.J0716_1_dto_pra;

public class J0716_1_pra {
	public static void main(String args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0716_1_dto_pra> arr = new ArrayList<>();
		J0716_1_dao_pra dao = new J0716_1_dao_pra();
		
		System.out.println("몇명 :");
		int count = sc.nextInt();
		for(int k = 0; k < count; k++) {
		System.out.print("이름 :");
		String name = sc.next();
		System.out.println("국어 :");
		int kor = sc.nextInt();
		System.out.println("영어 :");
		int eng = sc.nextInt();
		System.out.println("수학 :");
		int mat = sc.nextInt();
		
		int total = dao.getTotal(kor, eng, mat);
		String ava = dao.getAva(total, 3);
		String result = dao.getResult(ava);
		
		arr.add(new J0716_1_dto_pra(name, ava, result, kor, eng, mat, total));
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
