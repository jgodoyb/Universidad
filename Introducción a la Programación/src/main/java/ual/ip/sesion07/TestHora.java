package org.ip.sesion07;

public class TestHora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hora hora1=new Hora(11,30);
		System.out.println(hora1.toString());
		for(int i=1;i<=61;i++) {
			hora1.incrementar();
		}
		System.out.println(hora1.toString());
		for(int i=1;i<=60*11;i++)
			hora1.incrementar();
		System.out.println(hora1.toString());
		for(int i=1;i<=61;i++) {
			hora1.incrementar();
		}
		System.out.println(hora1.toString());
		System.out.println();
		Hora reloj12 = new Hora12 (11, 10, Hora12.Meridiano.AM);
		System.out.println(reloj12.toString());
		for(int i=1;i<=61;i++) {
			reloj12.incrementar();
		}
		System.out.println(reloj12.toString());
		System.out.println(reloj12.toString());
		for(int i=1;i<=5*12+1;i++) {
			reloj12.incrementar();
		}
		System.out.println(reloj12.toString());
		System.out.println();
		
		Hora HoraExacta=new HoraExacta(0,0,31);
		System.out.println("Hora exacta del reloj: "+HoraExacta.toString());
		for(int i=1;i<=61;i++) {
			HoraExacta.incrementar();
		}
		System.out.println("Hora exacta del reloj: "+HoraExacta.toString());
		for(int i=1;i<=23*3600;i++) {
			HoraExacta.incrementar();
		}
		System.out.println("Hora exacta del reloj: "+HoraExacta.toString());
		for(int i=1;i<3600+60*7-19;i++) {
			HoraExacta.incrementar();
		}
		System.out.println("Hora exacta del reloj: "+HoraExacta.toString());
		
		HoraExacta momentoExacto1 = new HoraExacta (1, 2, 3);
		HoraExacta momentoExacto2 = new HoraExacta (1, 2, 3);
		HoraExacta momentoExacto3 = new HoraExacta (10, 20, 30);
		System.out.println();
		System.out.println("COMPROBACION DE MOMENTOS EXACTOS");
		System.out.println("Los momentos exactos son "+momentoExacto1+", "+momentoExacto2+" y "+momentoExacto3);
		if(momentoExacto1.equals(momentoExacto2)) {
			System.out.println(momentoExacto1+" ES IGUAL A "+momentoExacto2);
		}else {
			System.out.println(momentoExacto1+" NO ES IGUAL A "+momentoExacto2);
		}
		if(momentoExacto1.equals(momentoExacto3)) {
			System.out.println(momentoExacto1+" ES IGUAL A "+momentoExacto3);
		}else {
			System.out.println(momentoExacto1+" NO ES IGUAL A "+momentoExacto3);
		}
		
		switch(momentoExacto1.compareTo(momentoExacto3)){
		case 1:
			System.out.println(momentoExacto1+" ES MAYOR QUE "+momentoExacto3);
			break;
		case 0:
			System.out.println(momentoExacto1+" ES IGUAL A "+momentoExacto3);
			break;
		case -1:
			System.out.println(momentoExacto1+" ES MENOR QUE "+momentoExacto3);
		}
		
		switch(momentoExacto3.compareTo(momentoExacto1)){
		case 1:
			System.out.println(momentoExacto3+" ES MAYOR QUE "+momentoExacto1);
			break;
		case 0:
			System.out.println(momentoExacto3+" ES IGUAL A "+momentoExacto1);
			break;
		case -1:
			System.out.println(momentoExacto3+" ES MENOR QUE "+momentoExacto1);
		}
		
		switch(momentoExacto1.compareTo(momentoExacto2)){
		case 1:
			System.out.println(momentoExacto2+" ES MAYOR QUE "+momentoExacto1);
			break;
		case 0:
			System.out.println(momentoExacto2+" ES IGUAL A "+momentoExacto1);
			break;
		case -1:
			System.out.println(momentoExacto2+" ES MENOR QUE "+momentoExacto1);
	
		}
		
		
		
		
		
		
		
			
			
		
	}

}
