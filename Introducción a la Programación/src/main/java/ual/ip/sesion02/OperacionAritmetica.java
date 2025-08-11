package org.ip.sesion02;

public class OperacionAritmetica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x,y;
		char ope;
		x=1;
		y=0;
		ope='/';
		
		System.out.print("Los datos son : \n");
		System.out.printf("x = %d, y = %d \n" , x,y );
		System.out.println("La operación elegida es: " + ope+"\n");
		
		switch(ope) {
		
		case '+':
			System.out.printf("EL resultado de la operacion es: %d + %d = %d ",x,y,x+y);
			break;
		case '-':	
			System.out.printf("EL resultado de la operacion es: %d - %d = %d",x,y,x-y);
			break;
		case '*':
			System.out.printf("EL resultado de la operacion es: %d * %d = %d",x,y,x*y);
			break;
		case '/':
			if(y==0) {
				System.out.printf("EL resultado de la operacion es: %d / %d = ERROR", x,y);
			}else
				System.out.printf("EL resultado de la operacion es: %d / %d = %.2f" ,x ,y,(double) x/y);
			break;
		}
	}

}
