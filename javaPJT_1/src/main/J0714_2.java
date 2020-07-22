package main;

import java.util.ArrayList;

import dto.J0714_2_dto;

public class J0714_2 {

	public static void main(String[] args) {
		ArrayList<J0714_2_dto> arr = new ArrayList<>();    //J_0714_2_dto라는 1차원 배열을 생성 
		J0714_2_dto dto1 = new J0714_2_dto("홍길동","대전",30);  //dto에 기본생성자가 없어서 ()안에 맞춰줘야함
		J0714_2_dto dto2 = new J0714_2_dto("박길수","서울",50);
		arr.add(dto1); //안에 넣을 수 있는 것은 dto만 생성가능	
		arr.add(dto2);
		arr.add(new J0714_2_dto("안상수","부산",40));
//		arr.get(1);											 //B_2에 박길수, 서울, 50이 저장되어있음
//		System.out.print(arr.get(0).getName());
//		System.out.print(arr.get(1).getName());
//		System.out.print(arr.get(2).getName());
		
		
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getArea()+"\t");
			System.out.print(arr.get(k).getAge()+"\n");
		}
		

		
	}

}
