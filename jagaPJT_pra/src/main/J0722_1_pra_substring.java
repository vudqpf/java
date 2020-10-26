package main;

import java.text.DecimalFormat;

public class J0722_1_pra_substring {
	public static void main(String[] args){
		String a = "S001-DE";
		a = a.substring(1, 4);
		int n = Integer.parseInt(a);
		n++;
		a = Integer.toString(n);
		if(a.length() == 1) a = "00"+a;
		else if(a.length() == 2) a = "0"+a;
		
		a = "S"+a+"-DE";
		System.out.println("a :"+a);
		
	}
}