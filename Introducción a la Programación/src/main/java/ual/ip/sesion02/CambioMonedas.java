package org.ip.sesion02;

public class CambioMonedas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double dinero;
		int cantidad,cent;
		
		dinero=19.53;
		cent=(int)(dinero*100);
		
		System.out.println("Para devolver "+dinero+" euros en monedas, hay que dar: ");
		
		cantidad=cent/200;
		cent=cent % 200;
		if(cantidad !=0) 
			System.out.println(cantidad+" monedas de 2 euros");         
		
		
	
		cantidad =cent/100;
		cent=cent % 100;
		if(cantidad !=0) 
			System.out.println(cantidad+" monedas de 1 euro");
		
		
		
		cantidad =cent / 50;
		cent=cent % 50;
		if(cantidad != 0) 
			System.out.println(cantidad+" monedas de 50 centimos");	
		
		
		
		cantidad =cent / 20;
		cent=cent % 20;
		if(cantidad != 0)
			System.out.println(cantidad+" monedas de 20 centimos");	
		
		
		
		cantidad =cent / 10;
		cent=cent % 10;
		if(cantidad != 0) 
			System.out.println(cantidad+" monedas de 10 centimos");	
		
		
		
		cantidad =cent/5;
		cent=cent % 5;
		if(cantidad != 0) 
			System.out.println(cantidad+" monedas de 5 centimos");	
		
		
		
		cantidad =cent/2;
		cent=cent % 2;
		if(cantidad !=0) 
			System.out.println(cantidad+" monedas de 2 centimos");	
		
		
		
		cantidad =cent;
		if(cantidad !=0) 
			System.out.println(cantidad+" monedas de 1 centimo");	
	}

}
