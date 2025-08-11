package org.ip.sesion02;

public class FechaCorrecta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int dia, mes, anio;
		boolean fecha;
		dia=29;
		mes=2;
		anio=2019;
		fecha = true;
		
		if(anio<1500 || anio>3000) {     
			fecha=false;
			}
			if(dia<1) {
				fecha=false;
			}else
				switch(mes){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:	
					if(dia>31) {
						fecha=false;	
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if(dia>30) {
						fecha=false;
					}
					break;
				case 2:	
					if(anio %4 ==0 && ! (anio %100 == 0 && anio %400!=0)) {
						if(dia>29) 
							fecha=false;
					}
						else {
							if(dia>28) 
								fecha= false;
							
				}
					break;
				default:
					fecha=false;
					break;
					
				}
			
	
		if(fecha==true) {
			System.out.print("Fecha correcta: "+dia+"/"+mes+"/"+anio);
		}else
			System.out.print("Fecha incorrecta - "+dia+"/"+mes+"/"+anio);
		
				}
		
	}
	


			
			