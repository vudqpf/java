package main;

import java.text.DecimalFormat;

public class test {
	public static void main(String[] args) {
	double a = 91.89;
	
	DecimalFormat df = new DecimalFormat("0.0");
	String result = df.format(a);
	System.out.print("result :" + result);
	}
}



