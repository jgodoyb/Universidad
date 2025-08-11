package org.ip.sesion04;

import java.util.Scanner;

public class ValidarFecha {

	public static boolean esFechaCorrecta(int dia, int mes, int anio) {
		boolean fecha=true;
		if(anio<=0) {
			fecha=false;
		}switch(mes) {
		
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:	
		case 10:
		case 12:
			if(dia<=0 || dia>31) {
				fecha=false;
			}break;
		case 4:
		case 6:	
		case 9:
		case 11:
			if(dia<=0 || dia>30) {
				fecha=false;
			}break;
			
		case 2:	
			if(ValidarFecha.esBisiesto(anio)==true) {
				if(dia>29) 
					fecha=false;
				
			}
			else {	
				if(dia>28) {
						fecha= false;}
				}
			break;
			
		default:
			fecha=false;
			break;
		}	
		return fecha;
	}
	
	public static boolean esBisiesto(int anio) {
		return (anio% 4 == 0 && !(anio % 100 ==0 && anio % 400 != 0)); 
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner pant=new Scanner(System.in);
		int dia,mes,anio;
		
		
		do {	
			System.out.println("Introduce el día");
			dia= pant.nextInt();
			System.out.println("Introduce el mes");
			mes=pant.nextInt();
			System.out.println("Introduce el anio");
			anio=pant.nextInt();
			if(ValidarFecha.esFechaCorrecta(dia,mes,anio)==false) {
				System.out.println("FECHA INCORRECTA, INTRODUCE NUEVOS VALORES");
			}
		}while(ValidarFecha.esFechaCorrecta(dia,mes,anio)==false);
		
		System.out.print("FECHA CORRECTA");
		
		
		pant.close();	
	}

}
