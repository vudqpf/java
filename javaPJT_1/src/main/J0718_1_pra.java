package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0717_1_dao_pra;
import dto.J0717_1_dto_pra;

public class J0718_1_pra {
	public static void maint(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0717_1_dto_pra> arr = new ArrayList<>();
		J0717_1_dao_pra dao = new J0717_1_dao_pra();
		
		System.out.print("몇명 :");
		int count = sc.nextInt();
		for(int k = 0; k < count; k++) {
			System.out.print("사번 :");
			String no = sc.next();
			System.out.println("이름 :");
			String name = sc.next();
			System.out.println("부서? 1:총무  2:영업  3:인사 4:관리");
			String depart = sc.next();
			System.out.println("직책? 1:사원 2:대리 3:과장 4:부장");
			String position = sc.next();
			
			String departName = dao.getDepart(depart);
			String positionName = dao.getPosition(position);
			int moneyLine = dao.getMoney(position);
			
			arr.add(new J0717_1_dto_pra(no, name, departName, positionName, moneyLine));
			
		}
		 for(int k = 0; k < arr.size(); k++) {
			 System.out.print(arr.get(k).getNo()+"\t");
			 System.out.print(arr.get(k).getName()+"\t");
			 System.out.print(arr.get(k).getDepart()+"\t");
			 System.out.print(arr.get(k).getPosition()+"\t");
			 System.out.print(dao.getMoneyLie(arr.get(k).getMoney())+"\n");

		 }
	}
}
