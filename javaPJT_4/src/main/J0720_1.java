package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0720_1_dao;
import dto.J0720_1_dto;

public class J0720_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0720_1_dto> arr = new ArrayList<>();
		J0720_1_dao dao = new J0720_1_dao();
		String no = "";
		
		System.out.println("몇명 : ");
		int count = sc.nextInt();
		for(int k = 0; k < count; k++) {
//			System.out.println("사번 :");
//			String no = sc.next();
			
			if(arr.size() == 0) no = "S001";
			else no = dao.getMemberNo(arr.get(arr.size()-1).getNo());
			
			System.out.println("이름 :");
			String name = sc.next();
			System.out.println("부서 :");
			String depart = sc.next();
			System.out.println("직책 :");
			String position = sc.next();
			
			String departName = dao.getDepartName(depart); //부서명
			String positionName = dao.getPosition(position);//직책
			int salaryMon = dao.getSalaryMon(position);//월급
			int positionMoney = dao.getPositionMon(salaryMon);//직책수당
			int bonus = dao.getBonus(salaryMon); //보너스
			int salaryYear = dao.getSalaryYear(salaryMon, positionMoney, bonus); //연봉
			arr.add(new J0720_1_dto(no, name, departName, positionName, salaryMon,positionMoney, bonus, salaryYear));
		}
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getNo()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getDepart()+"\t");
			System.out.print(arr.get(k).getPosition()+"\t");
			System.out.print(dao.getResult(arr.get(k).getSalaryMon())+"\t");
			System.out.print(dao.getResult(arr.get(k).getPositionMoney())+"\t");
			System.out.print(dao.getResult(arr.get(k).getBonus())+"\t");
			System.out.print(dao.getResult(arr.get(k).getSalaryYear())+"\n");
			
		}
	}

}
