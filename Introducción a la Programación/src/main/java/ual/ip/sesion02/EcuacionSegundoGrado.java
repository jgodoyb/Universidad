package org.ip.sesion02;

public class EcuacionSegundoGrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a,b,c;
		double x1,x2;
		a=1;
		b=-4;
		c=4;
		
		x1=(-b+Math.sqrt(Math.pow(b, 2)-(4*a*c)))/(2*a);
		x2=(-b-Math.sqrt(Math.pow(b, 2)-(4*a*c)))/(2*a);
		
		System.out.println("SOLUCION DE UNA ECUACION DE SEGUNDO GRADO \n");
		System.out.println("Valores de los coeficientes \n");
		System.out.println("a = "+a+", b = "+b+", c = "+c+"\n");
		
		if(a==0) {
			System.out.print("No es una ecuación de segundo grado");
		}else
			if((Math.pow(b, 2)-(4*a*c))<0) {
				System.out.print("No tiene solución real");
			}else
				if(x1!=x2) {
				System.out.printf("Dos raices de valores \n \n");
				System.out.println("x1 = "+x1);
				System.out.println("x2 = "+x2);
				}
				else {
			System.out.println("Una única raiz de valor doble");
			System.out.print("x = "+x1);
	
		
				}
		}
					
	
	}	
		
	


