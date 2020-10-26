package main;

import java.util.ArrayList;
import java.util.Scanner;

import dto.J0714_2_dto;

public class J0714_1_pra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0714_2_dto> arr = new ArrayList<>();
		System.out.print("몇명 ?");
		int count = sc.nextInt();
		
		for(int k = 0; k < count; k++) {
			System.out.print("이름 ?");
			String name = sc.next();
			System.out.print("지역 ?");
			String area = sc.next();
			System.out.print("나이 ?");
			int age = sc.nextInt();
			
			arr.add(new J0714_2_dto(name, area, age));
		}
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getArea()+"\t");
			System.out.print(arr.get(k).getAge()+"\n");
		}
		sc.close();
	}
}
