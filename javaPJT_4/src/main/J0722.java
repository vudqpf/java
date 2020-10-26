package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0722dao;
import dto.J0722dto;



public class J0722 {

   public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   J0722dao dao = new J0722dao();
   ArrayList<J0722dto>arr = new ArrayList<>();
   arr.add(new J0722dto("S0001", "홍길동", "서울", 25));
   arr.add(new J0722dto("S0002", "홍길무",  "대전", 25));
   

   
   int gubun = 0;
   do {
   System.out.print("검색:1, 등록:2, 수정:3, 삭제:4, 종료:0");
   gubun = sc.nextInt();
   
   if(gubun ==1 ) {
      int gu;
      do {   
      
         System.out.print("이름검색 :1, 지역:2, 나가기:0 ");   
         gu = sc.nextInt();
            if(gu ==1) {
                        System.out.print("이름? ");     
                        String name = sc.next();   
         for(int k = 0; k <arr.size(); k++){
            if(arr.get(k).getName().indexOf(name) != -1){
               System.out.print(arr.get(k).getName()+"\t");
               System.out.print(arr.get(k).getArea()+"\t");
               System.out.print(arr.get(k).getAge()+"\n");   
            }
            }
            }else if(gu ==2){
            System.out.print("지역검색 입력:");
            String area = sc.next();   
         for(int k = 0; k <arr.size(); k++){
            if(arr.get(k).getArea().indexOf(area) != -1){
               System.out.print(arr.get(k).getName()+"\t");
               System.out.print(arr.get(k).getArea()+"\t");
               System.out.print(arr.get(k).getAge()+"\n");   
               }
               }   
              
              
         
            }
      }while(gu != 0);
      
   
      
         
      
   }else if(gubun ==2 ) {
               String no = "";
               if(arr.size()==0) {
                 no = "S0001";   
               }else {
                 no = arr.get(arr.size()-1).getNo();   
                 no = dao.getNo(no);   
               }
               System.out.println("토우로쿠 나마에");
               String name = sc.next();
               
               System.out.println("토우로쿠 치이키");
               String area = sc.next();
               
               System.out.println("토우로쿠 토시");
               int age = sc.nextInt();
               
      
      arr.add(new J0722dto(no, name, area, age));
      
      for(int k =0; k< arr.size(); k++) {
         System.out.println(arr.get(k).getNo()+"\t");
         System.out.println(arr.get(k).getName()+"\t");
         System.out.println(arr.get(k).getArea()+"\t");
         System.out.println(arr.get(k).getAge()+"\n");
         
     
      
   }

   }else if(gubun == 3){
       System.out.println("정보 수정?");
       String no = sc.next();
       int updateNo = -1;
         for(int k =0; k< arr.size(); k++) {
         if(arr.get(k).getNo().equals(no)) {
            updateNo = k;
            System.out.println(arr.get(k).getNo()+"\t");
         System.out.println(arr.get(k).getName()+"\t");
         System.out.println(arr.get(k).getArea()+"\t");
         System.out.println(arr.get(k).getAge()+"\n");   
            
  }        
  }
        
         
  if(updateNo == -1) {
         System.out.println("수정정보 없음~~~"); 
  }else {
         System.out.println("수정 이름? ");
         String name = sc.next();
         
         System.out.println("수정 지역? ");
         String area = sc.next();
         
         System.out.println("수정 나이? ");
         int age = sc.nextInt();

    
 
         arr.set(updateNo, new J0722dto(no, name, area, age));
    
         for(int k =0; k< arr.size(); k++) {
     
             System.out.println(arr.get(k).getNo()+"\t");
            System.out.println(arr.get(k).getName()+"\t");
            System.out.println(arr.get(k).getArea()+"\t");
            System.out.println(arr.get(k).getAge()+"\n");   

    }
    }

   } else if(gubun == 4) {
       System.out.println("살제할 사번");
          String no = sc.next();
          int deleteNo = -1;   
          for(int k =0; k< arr.size(); k++) {
               if(arr.get(k).getNo().equals(no)) {
                  deleteNo = k;
           System.out.println(arr.get(k).getNo()+"\t");
         System.out.println(arr.get(k).getName()+"\t");
         System.out.println(arr.get(k).getArea()+"\t");
         System.out.println(arr.get(k).getAge()+"\n");   
                  
          }        
          }
          if(deleteNo == -1) {
          System.out.println("삭제 정보 없음~~~"); 
           }else {
          System.out.println("증말 삭제?~~~   예:Y, 아니오:N "); 
          String yn = sc.next();
          if(yn.equals("Y") ||yn.equals("ㅛ") ||yn.equals("y")) {
          arr.remove(deleteNo);
          for(int k =0; k< arr.size(); k++) {
                  
           System.out.println(arr.get(k).getNo()+"\t");
          System.out.println(arr.get(k).getName()+"\t");
          System.out.println(arr.get(k).getArea()+"\t");
          System.out.println(arr.get(k).getAge()+"\n");   
        
            }
           System.out.println("================== 삭 제 =======================");   
          }
          }
          
              }
             
                 
      
   } while (gubun != 0);
   }

}