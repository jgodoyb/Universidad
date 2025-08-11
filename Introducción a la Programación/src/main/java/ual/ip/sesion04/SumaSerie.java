package org.ip.sesion04;

import java.util.Locale;

public class SumaSerie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j=10;
		System.out.println("i \t SUMA");
		for(int i=1;i<=j;i++) {
			System.out.printf(Locale.ENGLISH,"%2d\t%7.6f\n", i, sumaSerie(i));
		}
	}
	public static double sumaSerie(int i) {
		if(i==0) {
			return 0;
			
		}else
			return (double)i /(i+1) +SumaSerie.sumaSerie(i-1);
		
	}

}
