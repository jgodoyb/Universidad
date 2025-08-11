package org.ip.sesion02;

public class TarifaTaxi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int km;
		double dinero = 0;
		
		
		km=777;
		
		if(km<=30) {
			dinero =18;
		}else
			if(km<100 && km>18) {
				dinero=(18+(km-30)*0.85);
			}else
				if(km>100) {
					dinero=(18+(70*0.85)+(km-100)*0.65);
				}
		System.out.print("CALCULO TARIFA TAXI \n \n");
		System.out.println("Kilometros recorridos => "+km);
		System.out.print("El importe total a pagar es " + dinero);
		
		
		
	}

}
