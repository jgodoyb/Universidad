package org.ip.sesion01;

public class Circunferencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double r;
		r=4.57;
		
		System.out.print("Radio = " +r+"\n\n");
		System.out.printf("Diámetro de la circunferencia = %.2f \n",+ 2*r);
		System.out.printf("Perímetro de la circunferencia = %.3f \n",+ (2*Math.PI*r));
		System.out.printf("Area de la circunferencia = %.3f", + Math.PI*Math.pow(r, 2) );
		
		
	}

}
