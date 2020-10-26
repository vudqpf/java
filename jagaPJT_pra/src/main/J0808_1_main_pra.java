package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0808_1_dao_pra;
import dto.J0808_1_dto_pra;

public class J0808_1_main_pra {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0808_1_dto_pra> arr = new ArrayList<>();
		J0808_1_dao_pra dao = new J0808_1_dao_pra();
		
		int gubun;
		do {
			System.out.println(" 검색:[1], 등록:[2], 수정:[3], 삭제:[4], 종료:0? ");
			gubun = sc.nextInt();
			
			//검색
			if(gubun == 1) {
				int searchgubun;
				System.out.println(" 학번:[1], 이름:[2], 이전[0] ");
				searchgubun = sc.nextInt();
			
			//등록	
			}else if(gubun == 2) {
				String no;
				if(arr.size() == 0) {
					no = "0001";
				}else {
					no = arr.get(arr.size() - 1).getNo();
					String newno = dao.getNo(no);
				}
				
				System.out.println(" 등록 이름: ");
				String name = sc.next();
				
				System.out.println(" 국어 점수: ");
				int kor = sc.nextInt();
				
				System.out.println(" 영어 점수: ");
				int eng = sc.nextInt();
				
				System.out.println(" 수학 점수: ");
				int mat = sc.nextInt();
				
				
				int total = dao.getTotal(kor, eng, mat);
				int ava =  dao.getAva(total);
				J0808_1_dto_pra dto = new J0808_1_dto_pra(no, name, kor, eng, mat, total, ava);
				int result = dao.saveNo(dto);
				
				if(result == 1) {
					System.out.println(" ==== 등록 성공 ====");
				}else {
					System.out.println(" ==== 등록 실패 ====");
				}
				
				
				
			//수정	
			}else if(gubun == 3) {
				
			//삭제	
			}else if(gubun == 4 ){
				
			}
			
			
		}while(gubun != 0);
		
		
	}

}
