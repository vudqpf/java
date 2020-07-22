package main;

import java.text.DecimalFormat;

public class J0721_1_pra {
	public static void main(String[] args) {
		String a = "S001-DE";
		a = a.substring(1, 4);
		System.out.println("a :"+a);
		int n = Integer.parseInt(a);
		System.out.println("n :"+n);
		n = n + 1;
		a = Integer.toString(n);
		if(a.length() == 1) a = "00"+a;
		else if(a.length() == 2) a = "0"+a;
		
		System.out.println("a :"+a);
		a = "S"+a+"-DE";
		System.out.println("a :"+a);


		DecimalFormat df = new DecimalFormat("0000");
		String ar = "KB_0024_A";
		a = a.substring(3, 7);
		System.out.println(a);
		int nr = Integer.parseInt(a);
		nr++;
		ar = df.format(n);
		df.format

				
		arr = Integer.toString(n);
		System.out.println(a);
		if(a.length() == 1) a = "000"+a;
		else if(a.length() == 2) a = "00"+a;
	
		a = "KB_"+a+"_A";
		System.out.println(a);
		
		/*		
		String a = "S001-DE";
		a = a.substring(1, 4);
		System.out.println("a :"+a);
		int n = Integer.parseInt(a);
		System.out.println("n :"+n);
		n = n + 1;
		a = Integer.toString(n);
		if(a.length() == 1) a = "00"+a;
		else if(a.length() == 2) a = "0"+a;
		
		System.out.println("a :"+a);
		a = "S"+a+"-DE";
		System.out.println("a :"+a);


		DecimalFormat df = new DecimalFormat("0000");
		String a = "KB_0024_A";
		a = a.substring(3, 7);
		System.out.println(a);
		int n = Integer.parseInt(a);
		n++;
		a = df.format(n);
		df.f

				
		a = Integer.toString(n);
		System.out.println(a);
		if(a.length() == 1) a = "000"+a;
		else if(a.length() == 2) a = "00"+a;
	
		a = "KB_"+a+"_A";
		System.out.println(a);
*/	
	}
}		