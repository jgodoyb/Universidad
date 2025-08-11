package org.ip.sesion06;

public class TestReloj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Reloj rej1= new Reloj(23,59,59);
		
		rej1.mostrarReloj();
		rej1.incrementaSegundo();
		rej1.mostrarReloj();
		System.out.println();
		
		
		Reloj rej2=new Reloj(24,60,60);
		
		rej2.incrementaSegundo();
		int a=rej2.getSegundo();
		rej2.setSegundo(a);
		rej2.incrementaMinuto();
		int b=rej2.getMinuto();
		rej2.setMinuto(b);
		rej2.incrementaHora();
		int c=rej2.getHora();
		rej2.setHora(c);
		rej2.mostrarReloj();
		rej2.incrementaHora();
		rej2.incrementaMinuto();
		rej2.incrementaSegundo();
		rej2.mostrarReloj();
		
		System.out.println();
		
		
		Reloj rej3=new Reloj(rej1);
		
		rej3.mostrarReloj();
		for(int i=0;i<86400;i++) {
			rej3.incrementaSegundo();
			int d=rej3.getSegundo();
			rej3.setSegundo(d);
		}
		rej3.mostrarReloj();
		System.out.println();
		
		
		Reloj rej4= new Reloj(rej1);
		
		rej4.mostrarReloj();
		for(int j=0;j<1440;j++) {
			rej4.incrementaMinuto();
			int e=rej4.getMinuto();
			rej4.setMinuto(e);
		}
		rej4.mostrarReloj();
		System.out.println();
		
		
		Reloj rej5= new Reloj(rej1);
		
		rej5.mostrarReloj();
		for(int i=0;i<24;i++) {
			rej5.incrementaHora();
			int j=rej5.getHora();
			rej5.setHora(j);
		}
		rej5.mostrarReloj();
		

	}

}
