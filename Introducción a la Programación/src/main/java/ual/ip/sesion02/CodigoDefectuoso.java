package org.ip.sesion02;

public class CodigoDefectuoso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x;
		
		x=25000;
		
		if(x>=14681 && x<=15681 ) {
			System.out.print("El codigo "+ x+" corresponde a un articulo DEFECTUOSO");
			
		}else 
			if(x>=70001 && x<=7999) {
				System.out.print("El codigo "+ x+" corresponde a un articulo DEFECTUOSO");
		     }else 
				if(x>=99999 && x<=110110) {
					System.out.print("El codigo "+ x+" corresponde a un articulo DEFECTUOSO");
					
			}else
				System.out.print("El codigo "+ x+" corresponde a un articulo NO DEFECTUOSO");
		
		
		
		}
		
		
}


