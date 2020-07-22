package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0716_2_dao;
import dto.J0716_2_dto;

public class J0716_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0716_2_dto> arr = new ArrayList<>();
		
		J0716_2_dao dao = new J0716_2_dao();
		
		System.out.print("몇명 :");
		int count = sc.nextInt();
		for(int k = 0; k < count; k++) {
			System.out.print("사번 :");
			String no = sc.next();
			System.out.print("성명 :");
			String name = sc.next();
			System.out.println("부서코드 :");
			int depart = sc.nextInt();
			System.out.println("직급코드 :");
			String position = sc.next();
			
			String departName = dao.getDepartName(depart);
			String positionName = dao.getPositionName(position);
			arr.add(new J0716_2_dto(no, name, departName, positionName));
			
		}
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getNo()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getDepart()+"\t");
			System.out.print(arr.get(k).getPosition()+"\n");
			
		}

		
	}

}
