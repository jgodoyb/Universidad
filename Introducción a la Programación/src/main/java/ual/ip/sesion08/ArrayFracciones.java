package org.ip.sesion08;

public class ArrayFracciones implements Comparable<Object> {
	
	
	private Fraccion[] array;
	
	public ArrayFracciones(int numeroElementos) {
		array= new Fraccion[numeroElementos];
		for(int i=0;i<array.length;i++) {
			array[i]=new Fraccion();
		}	
	}
	
	public ArrayFracciones(Fraccion[]array) {
		this.array=new Fraccion[array.length];
		for(int i=0;i<array.length;i++) {
			this.array[i]=new Fraccion(array[i]);
		}	
	}
	
	public ArrayFracciones(ArrayFracciones arrayFracciones) {
		this.array=new Fraccion[arrayFracciones.array.length];
		for(int i=0;i<this.array.length;i++) {
			this.array[i]=new Fraccion (arrayFracciones.array[i]);
		}
	}
	
	public Fraccion[] getArray() {
		return array;
	}
	
	public int getNumeroElementos() {
		return array.length;
	}
	
	public void setArray(Fraccion valor) {
		for(int i=0;i<array.length;i++) {
			array[i]=new Fraccion(valor);
		}
	}
	
	public Fraccion getValorElemento(int posicion) {
		return array[posicion];
	}
	
	public boolean setValorElemento(int posicion, Fraccion valor) {
		if(posicion<0 || posicion>=array.length) {
			return false;
		}
		array[posicion]= new Fraccion(valor);
		return true;
	}
	
	public Fraccion getMinimo() {
		Fraccion min=array[0];
		for(int i=1;i<array.length;i++) {
			if(min.compareTo(array[i])>0) {
				min=array[i];	
			}	
		}
		return min;
	}
	
	public Fraccion getMaximo() {
		Fraccion max=array[0];
		for(int i =1;i<array.length;i++) {
			if(max.compareTo(array[i])<0) {
				max=array[i];
			}
		}
		return max;
	}
	
	public Fraccion getSumaArray() {
		Fraccion a=new Fraccion();
		for(int i=0;i<array.length;i++) {
			a=a.sumar(array[i]);
			
		}
		int b=a.getDenominador();
		int c=a.getNumerador();
		if(a.getNumerador()<0 && a.getDenominador()<0) {
			a.setNumerador((-1)*c);
			a.setDenominador((-1)*b);
		}
		return a.simplificar();
	}
	
//"ArrayFracciones: [<1/7>, <1/7>, <1/7>, <1/7>, <1/7>]";
	public String toString() {
		String frase=("ArrayFracciones: [");
		for(int i=0;i<array.length;i++) {
			frase+=("<"+array[i].toString() + ">");
			if(i<array.length-1) {
				frase+=(", ");
			}else
				frase+=("]");
			
		}
		return frase;
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if ( ! (obj instanceof ArrayFracciones))
			return false;
		
		ArrayFracciones otro = (ArrayFracciones)obj;
		
		boolean verda=true;
		for(int i = 0;i<array.length;i++) {
			if(array[i].equals(otro.array[i])) {
				verda=true;
				
			}
		}
		if(verda==true) {
			return true;
		}
		return false;
	
		
		
		
	}
	
	public int compareTo(Object obj) {
		ArrayFracciones o=(ArrayFracciones) obj;
		Fraccion a=this.getSumaArray();
		Fraccion b=o.getSumaArray();
		
		if(a.compareTo(b)==1) {
			return 1;
		}
		if(a.compareTo(b)==-1) {
			return -1;
		}
		return 0;
		
			
			
		
	}
	
	
	
}
