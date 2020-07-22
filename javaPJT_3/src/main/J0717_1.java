package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0717_1_dao;
import dto.J0717_1_dto;

public class J0717_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0717_1_dto> arr = new ArrayList<>();
		J0717_1_dao dao = new J0717_1_dao();
		
		System.out.print("몇명 :");
		int count = sc.nextInt();
		
		for(int k = 0; k < count; k++) {
			System.out.print("사번 :");
			String no = sc.next();
			System.out.print("이름 :");
			String name = sc.next();
			System.out.print("부서  ? 1:총무, 2:영업, 3:인사 4:관리");
			String depart = sc.next();
			System.out.print("직급 ? 1:사원, 2:대리, 3:과장, 4:부장");
			String position = sc.next();
			
			
			String departName = dao.getDepartName(depart);
			String positionName = dao.getPosition(position);
			int money = dao.getMoney(position); 
			int positionMoney = dao.getPositionMoney(money);
			arr.add(new J0717_1_dto(no, name, departName, positionName, money,positionMoney ));
			
		}
		
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getNo()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getDepart()+"\t");
			System.out.print(arr.get(k).getPosition()+"\t");
			System.out.print(dao.getMoneyDis(arr.get(k).getMoney())+"\t");
			System.out.print(dao.getMoneyDis(arr.get(k).getPositionMoney())+"\n");
			
		}
	}

}
