package org.ip.sesion04;

import java.util.Scanner;

public class PrintCalendario {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

	
		System.out.print("Introduzca un anio completo (e.g., 2001): ");
		int anio = entrada.nextInt();
		System.out.print("Introduzca un mes como un numero entre 1 y 12: ");
		int mes = entrada.nextInt();

		printMes(anio, mes);
		entrada.close();
	}

	
	public static void printMes(int anio, int mes) {
		printTituloMes(anio, mes);
		printCuerpoMes(anio, mes);
	}

	
	public static void printTituloMes(int anio, int mes) {
		System.out.println("         " + getNombreMes(mes) + " " + anio);
		System.out.println("-----------------------------");
		System.out.println(" Lun Mar Mie Jue Vie Sab Dom");
	}

	
	public static String getNombreMes(int mes) {
		String nombreMes = "";
		switch (mes) {
			case 1:
				nombreMes = "Enero";
				break;
			case 2:
				nombreMes = "Febrero";
				break;
			case 3:
				nombreMes = "Marzo";
				break;
			case 4:
				nombreMes = "Abril";
				break;
			case 5:
				nombreMes = "Mayo";
				break;
			case 6:
				nombreMes = "Junio";
				break;
			case 7:
				nombreMes = "Julio";
				break;
			case 8:
				nombreMes = "Agosto";
				break;
			case 9:
				nombreMes = "Septiembre";
				break;
			case 10:
				nombreMes = "Octubre";
				break;
			case 11:
				nombreMes = "Noviembre";
				break;
			case 12:
				nombreMes = "Diciembre";
		}

		return nombreMes;
	}

	
	public static void printCuerpoMes(int anio, int mes) {
		int diaInicio = getDiaInicio(anio, mes);
		int numeroDeDiasDelMes = getNumeroDeDiasDelMes(anio, mes);
	    if (diaInicio == 0){
	    	diaInicio = 7;
	    }

	    int i;
		for (i = 1; i < diaInicio; i++)
			System.out.print("    ");
		for (i = 1; i <= numeroDeDiasDelMes; i++) {
			System.out.printf("%4d", i);
			if ((i + diaInicio - 1) % 7 == 0)
				System.out.println();
		}
		System.out.println();
	}

	
	public static int getDiaInicio(int anio, int mes){
		int d = 1;
		int y0 = anio - (14 - mes) / 12;
		int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
		int m0 = mes + 12 * ((14 - mes) / 12) - 2;
		int d0 = (d + x + (31 * m0) / 12) % 7;
		return d0;
	}


	public static int getNumeroDeDiasDelMes(int anio, int mes) {
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8
				|| mes == 10 || mes == 12)
			return 31;

		if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
			return 30;

		if (mes == 2)
			return esBisiesto(anio) ? 29 : 28;

		return 0; 
	}


	public static boolean esBisiesto(int anio) {
		return ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)));
	}
}
