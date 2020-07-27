package pra;

import java.util.ArrayList;
import java.util.Scanner;

import dao.pra.J0715_dao_pra;
import dto.pra.J0715_dto_pra;

public class J0715_pra {
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 ArrayList<J0715_dto_pra> arr = new ArrayList<>();
	 J0715_dao_pra dao = new J0715_dao_pra();
	 
	 System.out.print("몇명 :");
	 int count = sc.nextInt();
	 for(int k = 0; k < count; k++) {
		 System.out.println("이름 :");
		 String name = sc.next();
		 System.out.println("국어 :");
		 int kor = sc.nextInt();
		 System.out.print("영어 :");
		 int eng = sc.nextInt();
		 System.out.println("수학 :");
		 int mat = sc.nextInt();
		 
		 int total = dao.getTotal(kor, eng, mat);
		 int ava = dao.getAva(total, count);
		 String result = dao.getResult(ava);
		 arr.add(new J0715_dto_pra(name, result, kor, eng, mat, total, ava));
		 
		 
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
