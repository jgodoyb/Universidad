
package org.mp.sesion04;

import java.util.StringTokenizer;

public class Evaluador{
	
	private GenericStack<Integer> pila;
	
	public Evaluador() {
		pila = new GenericStack<Integer>();
	}
	
	public String[] eliminarBlancos(String expresion) {
		StringTokenizer elemento=new StringTokenizer(expresion,"+-*/ ",true);
		GenericQueue<String> a=new GenericQueue<>();
		
		while(elemento.hasMoreTokens()) {
			String b=new String(elemento.nextToken());
			if(!b.equals(" ")) {
				a.enqueue(b);
			}
		}
		String[]c=new String[a.getSize()];
		for(int i=0;i<c.length;i++) {
			c[i]=a.dequeue();
		}
		return c;
	}
	
	public void procesarUnOperador(char op, GenericStack<Integer> operadoresPila) {
		Integer a=operadoresPila.pop();
		Integer b=operadoresPila.pop();
		Integer c=new Integer(0);
		
		switch(op) {
		case '+':
			c=b+a;
			break;
		case '-':
			c=b-a;
			break;
		case'*':
			c=a*b;
			break;
		case '/':
			if(a==0) {
				throw new RuntimeException("No es posible una división por cero");
			}
			c=b/a;
			break;
		}
		operadoresPila.push(c);
	}
	
	public int evaluarExpresion(String expresion) {
		String[] a =eliminarBlancos(expresion);
		String numeros="";
		String token="";
		
		for(int i=0;i<a.length;i++) {
			numeros+=a[i];
		}
		if(soloDigitos(numeros)) {
			pila.push(new Integer(numeros));
		}else {
			for(int i=0;i<a.length;i++) {
				token=a[i];
				if(!esOperador(token)) {
					pila.push(new Integer(token));
				}
				else {
					char f=token.charAt(0);
					procesarUnOperador(f,pila);
					
				}
			}
		}
		return (int)pila.peek();
	}
	
	
	
	
	
	private boolean soloDigitos(String expresion) {
		for(int i=0;i<expresion.length();i++) {
			if(!Character.isDigit(expresion.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	private boolean esOperador(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}
	
}

