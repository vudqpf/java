package dao;

import java.text.DecimalFormat;

public class J0722dao {
 public String getNo(String no) {
      DecimalFormat df =new DecimalFormat("0000");
      String sNo = no.substring(1);
      int n = Integer.parseInt(sNo);
      n++;
       sNo = df.format(n);
      return "S"+sNo; 
    
 }
   
   
}
