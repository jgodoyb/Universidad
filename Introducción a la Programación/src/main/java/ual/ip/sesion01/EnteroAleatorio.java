package org.ip.sesion01;

public class EnteroAleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int M,N;
		M=-15;
		N=15;
		System.out.println("Vamos a generar un entero aleatorio entre "+M+" y "+N+"\n");
		System.out.print("El entero generado aletoriamente es: "+(int)(Math.random()*(N-M+1)+M));
	}

}
