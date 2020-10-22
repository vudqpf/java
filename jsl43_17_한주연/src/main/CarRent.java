package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.CarInfo_dao;
import dao.MemberInfo_dao;
import dao.RentInfo_dao;
import dto.Carinfo_dto;
import dto.Member_dto_1;
import dto.Rent_dto;

public class CarRent {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		CarInfo_dao dao1 = new CarInfo_dao();
		MemberInfo_dao dao2 = new MemberInfo_dao();
		RentInfo_dao dao3 = new RentInfo_dao();
		ArrayList<Carinfo_dto> arr = new ArrayList<>();
		ArrayList<Member_dto_1> arr2 = new ArrayList<>(); 
		ArrayList<Rent_dto> arr3 = new ArrayList<>();
		
		
		
		int workGubun;
		
		do {
			System.out.print("차량관리[1], 회원관리[2], 차량렌트[3], 시스템 종료[0]");
			workGubun = sc.nextInt();
			
			//차량관리
			if(workGubun == 1) {
				
				int gubun;
				do {
					System.out.print("차량등록[1], 차량조회[2], 차량수정[3], 차량삭제[4] 이전[0]");
					gubun = sc.nextInt();
					
					//차량등록
					if(gubun == 1) {
						System.out.println("등록차량 No : 예)C000");
						String No = sc.next();
						
						System.out.println("차량 모델명: ");
						String model_name = sc.next();
						
						System.out.println("차량 등록번호 : 예)00가0000");
						String car_number = sc.next();
						
						System.out.println("차량 제조사 : 현대[10], 기아[20], 르노삼성[30], 쌍용[40], 쉐보레[50], 빤츠[60], 뱜떠블유[70], 아우디[80], 테슬라[90]");
						String car_made = sc.next();
						
						System.out.println("차량 제조년월 : YY-MM");
						String car_made_ym = sc.next();
						
						System.out.println("차량 기어 : 오토[Y], 스틱[N]");
						String auto_yn = sc.next();
						
						System.out.println("차량 옵션여부 : 옵션O[Y], 옵션X[N]");
						String option_yn = sc.next();
						
						System.out.println("차량사고여부 : 사고O[Y], 사고X[N]");
						String accident_yn = sc.next();
						
						System.out.println("차량 오일타입 : 가솔린[1], 디젤[2], LPG[3], 전기[4]");
						String fuel_type = sc.next();
						
						System.out.println("차량 매입일자 : yyyy-mm-dd");
						String import_date = sc.next();
						
						Carinfo_dto dto1 = new Carinfo_dto(No, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn, accident_yn, fuel_type, import_date, "y");
						int result = dao1.carinfo(dto1);
						
						if(result == 1) {
							System.out.println(" ==== 등록 성공 ==== ");
						}else {
							System.out.println(" ==== 등록 실패 ==== ");
						}
						
						
						
					//차량조회	
					}else if(gubun == 2) {
						int search = 0;
						do {
						System.out.println("조회할 차량 제조사:[1], 모델명:[2], 전체조회[9], 이전:[0]");
						search = sc.nextInt();
						
						//조회 - 제조사
						if(search == 1){
							System.out.println("차량 제조사 : 현대[10], 기아[20], 르노삼성[30], 쌍용[40], 쉐보레[50], 빤츠[60], 뱜떠블유[70], 아우디[80], 테슬라[90]");
							String car_made = sc.next();
							arr = dao1.getSearch("a.car_made", car_made);
							
						//조회 - 모델명	
						}else if(search == 2) {
							System.out.println("차량 모델명 : ");
							String model_name = sc.next();
							arr = dao1.getSearch("a.model_name", model_name);
						
						//조회 - 차량전체조회
						}else if(search == 9) {
							arr = dao1.getSearch("aaa", "");
	
						}
						
						if(search != 0) {
							System.out.println("======================================================================================");
							System.out.println("No\t모델명\t차량번호\t제조사\t제조일\t기어종류\t옵션여부\t사고여부\t매입날짜\t\t렌트여부\t");
							System.out.println("--------------------------------------------------------------------------------------");
							for(int k = 0; k < arr.size(); k++) {
								System.out.print(arr.get(k).getNo()+"\t");
								System.out.print(arr.get(k).getModel_name()+"\t");
								System.out.print(arr.get(k).getCar_number()+"\t");
								System.out.print(arr.get(k).getCar_made()+"\t");
								System.out.print(arr.get(k).getCar_made_ym()+"\t");
								System.out.print(arr.get(k).getAuto_yn()+"\t");
								System.out.print(arr.get(k).getOption_yn()+"\t");
								System.out.print(arr.get(k).getAccident_yn()+"\t");
								System.out.print(arr.get(k).getImport_date()+"\t");
								System.out.print(arr.get(k).getRent_gubun()+"\n");
							}
							System.out.println("======================================================================================");	
						}
						
						}while(search != 0);
						
						
						
					
					//차량수정	
					}else if(gubun == 3) {
						System.out.println("수정할 차량 No : ");
						String no = sc.next();
						
						//수정을 위한 조회
						Carinfo_dto dto = dao1.getView(no);
						
						if(dto == null) {
							System.out.println(" ==== 수정 정보 없음 ==== ");
						}else {
							System.out.println("======================================================================================");
							System.out.println("No\t모델명\t차량번호\t제조사\t제조일\t기어종류\t옵션여부\t사고여부\t매입날짜\t\t렌트여부\t");
							System.out.println("--------------------------------------------------------------------------------------");
							System.out.print(dto.getNo()+"\t");
							System.out.print(dto.getModel_name()+"\t");
							System.out.print(dto.getCar_number()+"\t");
							System.out.print(dto.getCar_made()+"\t");
							System.out.print(dto.getCar_made_ym()+"\t");
							System.out.print(dto.getAuto_yn()+"\t");
							System.out.print(dto.getOption_yn()+"\t");
							System.out.print(dto.getAccident_yn()+"\t");
							System.out.print(dto.getImport_date()+"\t");
							System.out.print(dto.getRent_gubun()+"\n");
							System.out.println("======================================================================================");
						}
						
						int result = 0;
							if(dto != null) {
							System.out.println("수정하시겠습니까 예:[Y], 아니오:[N] ");
							String yn = sc.next();
							
							if(yn.equals("Y")||yn.equals("y")||yn.equals("ㅛ")) {
								
								System.out.println("차량 모델명: ");
								String model_name = sc.next();
								
								System.out.println("차량 등록번호 : 예)00가0000");
								String car_number = sc.next();
								
								System.out.println("차량 제조사 : 현대[10], 기아[20], 르노삼성[30], 쌍용[40], 쉐보레[50], 빤츠[60],뱜떠블유[70], 아우디[80], 테슬라[90]");
								String car_made = sc.next();
								
								System.out.println("차량 제조년월 : YY-MM");
								String car_made_ym = sc.next();
								
								System.out.println("차량 기어 : 오토[Y], 스틱[N]");
								String auto_yn = sc.next();
								
								System.out.println("차량 옵션여부 : 옵션O[Y], 옵션X[N]");
								String option_yn = sc.next();
								
								System.out.println("차량사고여부 : 사고O[Y], 사고X[N]");
								String accident_yn = sc.next();
								
								System.out.println("차량 오일타입 : 가솔린[1], 디젤[2], LPG[3], 전기[4]");
								String fuel_type = sc.next();
								
								System.out.println("차량 매입일자 : yyyy-mm-dd");
								String import_date = sc.next();
								
								result = dao1.updateNo(no, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn, accident_yn, fuel_type, import_date);
								
								
							}
							
							if(result == 1) {
								System.out.println(" ==== 수정 등록 완료 ==== ");
							}else {
								System.out.println(" ==== 수정 등록 오류 ==== ");
							}
							
						}

						
					//차량삭제
					}else if(gubun == 4){
						System.out.println("삭제할 차량 No : ");
						String no = sc.next();
						
						//삭제를 위한 조회
						Carinfo_dto dto = dao1.getView(no);
						
						if(dto == null) {
							System.out.println(" ==== 수정 정보 없음 ==== ");
						}else {
							System.out.println("======================================================================================");
							System.out.println("No\t모델명\t차량번호\t제조사\t제조일\t기어종류\t옵션여부\t사고여부\t매입날짜\t\t렌트여부\t");
							System.out.print(dto.getNo()+"\t");
							System.out.print(dto.getModel_name()+"\t");
							System.out.print(dto.getCar_number()+"\t");
							System.out.print(dto.getCar_made()+"\t");
							System.out.print(dto.getCar_made_ym()+"\t");
							System.out.print(dto.getAuto_yn()+"\t");
							System.out.print(dto.getOption_yn()+"\t");
							System.out.print(dto.getAccident_yn()+"\t");
							System.out.print(dto.getImport_date()+"\t");
							System.out.print(dto.getRent_gubun()+"\n");
							System.out.println("======================================================================================");
						}
						
						int result = 0;
						if(dto != null) {
							System.out.println("삭제하시겠습니까 예:[Y], 아니오:[N] ");
							String yn = sc.next();
							
							if(yn.equals("Y")||yn.equals("y")||yn.equals("ㅛ")) {
								result = dao1.deleteNo(no);
								
							}
						}
							
							if(result == 1) {
								System.out.println(" ==== 삭제 완료 ==== ");
							}else {
								System.out.println(" ==== 삭제 실패 ==== ");
							}
							
							

						
						
					}
					
				}while(gubun != 0);
			
			//회원관리
			}else if(workGubun == 2) {
				
				int gubun = 0;
				do {
				System.out.println("회원조회 이름조회[1], 전체조회[9], 이전[0]");
				gubun = sc.nextInt();
				
				//조회 - 이름조회
				if(gubun == 1) {
					
					System.out.println("조회할 이름 : ");
					String member_name = sc.next(); 
					arr2 = dao2.getMemberView("name", member_name);
					
					
					
					
				//조회 - 전체조회	
				}else if(gubun == 9) {
					arr2 = dao2.getMemberView("all", "");
					
					
				}
				//조회를 위한 for문
				if(gubun != 0) {
					System.out.println("===================================================================");
					System.out.println(" ID\t이름\t주소\t전화번호\t\t등록일\t\t나이");
					System.out.println("-------------------------------------------------------------------");
					for(int k = 0; k<arr2.size(); k++) {
						System.out.print(arr2.get(k).getId()+"\t"); 
						System.out.print(arr2.get(k).getName()+"\t"); 
						System.out.print(arr2.get(k).getAddress()+"\t"); 
						System.out.print(arr2.get(k).getTel()+"\t"); 
						System.out.print(arr2.get(k).getReg_date()+"\t"); 
						System.out.print(arr2.get(k).getAge()+"\n"); 
					}
					System.out.println("==================================================================");
				}
				
				}while(gubun != 0);
			
			//렌트
			}else if(workGubun == 3) {
				int gubun = 0;
				do {
					
					System.out.println("렌트:[1], 반납:[2], 렌트이력조회[3], 이전:[0]");
					gubun = sc.nextInt();
					
					//렌트~
					String member_id = "";
					int member_yn = 0;
					String car_no = "";
					int car_yn = 0;
					String car_rent_yn = "";
					
					if(gubun == 1) {
						
						//회원 아이디 존재여부확인
						do {
						System.out.println("회원 ID : 예)B0000");
						member_id = sc.next();
						member_yn = dao3.member_idview("id",member_id);
							if(member_yn == 0) System.out.println(" ==== 회원 정보 없음 ==== ");
						}while(member_yn == 0);
						
						//차량 넘버 존재여부확인
						do {
						System.out.println("차량 No : C000");
						car_no = sc.next();
						car_yn = dao3.member_idview("no", car_no);
						car_rent_yn = dao3.car_rent_yn(car_no);
							if(car_yn == 0) System.out.println(" ==== 차량 정보 없음 ==== ");	
							if(car_rent_yn.equals("n")) System.out.println(" ==== 차량 대여 중 ==== ");
							
						}while(car_yn == 0||car_rent_yn.equals("n"));
						
						
						System.out.println(" 대여일 : yyyy-mm-dd");
						String rent_date = sc.next();
						
						System.out.println(" 반납 예정일 : yyyy-mm-dd");
						String return_day = sc.next();
						
						//렌트 no자동 지정~
						String rentNo = dao3.getMaxRentNo();
						
						Rent_dto dto = new Rent_dto(rentNo, member_id, "",car_no, rent_date, return_day, "", "");
						int result = dao3.insertRent(dto);
											
						//차량 상태[y] → [n]로 변경해주기
						int carUpadate = 0;
						if(result == 1) {
							carUpadate = dao3.carInfoUpdate(car_no);
						}
						
						if(carUpadate == 1) {
							System.out.println(" ==== 렌트 완료 ==== ");
						}else {
							System.out.println(" ==== 렌트 오류 ==== ");
						}
						
					//반납
					}else if(gubun == 2) {
						
						Rent_dto dto = null;
						String carNo = "";
						String returnnope = "";
						do {
							System.out.println("반납할 렌트 No : R0000");
							carNo = sc.next();
							
							//반납할 이력조회
							dto = dao3.carRentView(carNo);
							//렌트가 되어있는 차량이 반납완료되면 반납 불가능 하도록
							returnnope = dao3.returnnope(carNo);
					//		if(returnnope != null) System.out.println(" ==== 반납 완료인 상태 ====");
							if(dto == null) {
								System.out.println(" ==== 반납 렌트No 오류 ==== ");
							}else if(dto != null||returnnope != null){
								System.out.println(" ==== 반납 완료인 상태 ====");
							}else {
								System.out.println("==============================================================");
								System.out.println("렌트넘버\t회원넘버\t회원이름\t모델명\t렌트일\t\t반납예정일\t\t렌트여부");
								System.out.println("--------------------------------------------------------------");
								System.out.print(dto.getRent_no()+"\t");
								System.out.print(dto.getMember_no()+"\t");
								System.out.print(dto.getMember_name()+"\t");
								System.out.print(dto.getCar_no()+"\t");
								System.out.print(dto.getRent_date()+"\t");
								System.out.print(dto.getReturn_day()+"\t");
								System.out.print(dto.getRent_gubun()+"\n");
								System.out.println("==============================================================");
								}
							
							
						}while(dto == null);
						
						
			
						
					
						
						if(dto != null||returnnope.equals("null")) {
							System.out.println("반납하시겠습니까? 예[Y], 아니오[N]");
							String rent_yn = sc.next();
							
							int returnUpdate = 0;
							int rentGubun = 0;
							
							if(rent_yn.equals("Y")||rent_yn.equals("y")) {
								
								System.out.println("반납할 날짜 : yyyy-mm-dd");
								String returnDate = sc.next();
								//차량반납
								returnUpdate = dao3.returnUpdate(carNo, returnDate);
								
								
								if(returnUpdate == 1) {
									rentGubun = dao3.rentChange(carNo);
								}else {
									System.out.println(" ==== 반납 불가 ==== ");
								}
								
								}while(returnUpdate != 0 );
								
								if(rentGubun == 1) {
									System.out.println(" ==== 반납 완료 ==== ");
								}else {
									System.out.println(" ==== 반납 오류 ==== ");
								}
								
								
							
							}
						
						
				
						
					//렌트이력
					}else if(gubun == 3) {
						int viewGubun = 0;
						do {
							System.out.println("회원ID조회:[1], 전체조회:[9], 이전:[0]");
							viewGubun = sc.nextInt();
							
							if(viewGubun == 1) {
								System.out.println("조회 회원ID : ");
								String memberView = sc.next();
								arr3 = dao3.rentView("aaa", memberView);
								
							}else if(viewGubun == 9) {
								arr3 = dao3.rentView("all", "");
							}
							
							if(viewGubun != 0) {
								System.out.println("==================================================================================");
								System.out.println("렌트넘버\t회원이름\t모델명\t렌트일\t\t반납예정일\t\t반납일");
								System.out.println("----------------------------------------------------------------------------------");
								for(int k = 0; k < arr3.size(); k++) {
									System.out.print(arr3.get(k).getRent_no()+"\t");
									System.out.print(arr3.get(k).getMember_no()+"\t");
									System.out.print(arr3.get(k).getMember_name()+"\t");
									System.out.print(arr3.get(k).getCar_no()+"\t");
									System.out.print(arr3.get(k).getRent_date()+"\t");
									System.out.print(arr3.get(k).getReturn_day()+"\t");
									System.out.print(arr3.get(k).getReturn_date()+"\n");
									}
								System.out.println("==================================================================================");
								}
							
							
									
						}while(viewGubun != 0);
					}
					
				}while(gubun != 0);
				
				
			}
			
		}while(workGubun != 0);
		System.out.println(" ==== 시스템 종료 ==== ");
	}

}
