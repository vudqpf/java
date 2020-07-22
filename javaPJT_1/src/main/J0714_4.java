package main;

import java.util.ArrayList;
import java.util.Scanner;

import dto.J0714_3_dto;

public class J0714_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0714_3_dto> arr = new ArrayList<>();
		
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
			
			arr.add(new J0714_3_dto(name, kor, eng, mat));
			
		}
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getKor()+"\t") ;
			System.out.print(arr.get(k).getEng()+"\t");
			System.out.print(arr.get(k).getMat()+"\n");
		}
		
		sc.close();
	} 
}
