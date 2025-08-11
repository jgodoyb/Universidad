package org.ip.sesion01;

public class CalculoIntereses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		double dinero;
		dinero=2500.00;
		
		System.out.println("***Calculo de intereses***");
		System.out.printf("Dinero ingresado: %.2f €\n",+dinero);
		System.out.println("Interes anual: 1,75%");
		System.out.printf("Intereses a los 6 meses: %.2f €\n",+((dinero*1.75)/100)/2);
    	System.out.printf("Retención realizada: %.2f €\n",+(((((dinero*1.75)/100)/2))*21)/100);
    	System.out.printf("Interese cobrados: %.2f €",+(((dinero*1.75)/100)/2)-(((((dinero*1.75)/100)/2))*21)/100);
	}

}
