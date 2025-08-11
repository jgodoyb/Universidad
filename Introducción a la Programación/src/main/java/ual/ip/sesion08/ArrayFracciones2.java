package org.ip.sesion08;

public class ArrayFracciones2 implements Comparable<Object>{
	
	private Fraccion[]array;
	
	public ArrayFracciones2(int numeroElementos) {
		array=new Fraccion[numeroElementos];
		for(int i=0;i<array.length;i++) {
			array[i]=new Fraccion();
		}
	}
	
	public ArrayFracciones2(Fraccion[]array) {
		this.array=new Fraccion[array.length];
		for(int i=0;i<array.length;i++) {
			this.array[i]=new Fraccion(array[i]);
		}
	}
	
	public ArrayFracciones2(ArrayFracciones2 arrayFracciones) {
		this.array=new Fraccion[arrayFracciones.array.length];
		for(int i=0;i<this.array.length;i++) {
			this.array[i]=new Fraccion(arrayFracciones.array[i]);
		}
	}
	
	public Fraccion[] getArray() {
		return this.array;
	}
	
	public int getNumeroElementos() {
		return array.length;
	}
	
	public void setArray(Fraccion valor) {
		for(int i=0;i<array.length;i++) {
			array[i]=new Fraccion(valor);
		}
	}
	
	public Fraccion getValorElemento(int valor) {
		return array[valor];
	}
	
	public boolean setValorElemento(int posicion, Fraccion valor) {
		if(posicion>array.length || posicion<0) {
			return false;
		}
		else {
			array[posicion]=new Fraccion(valor);
			return true;
		}
	}
	
	public Fraccion getMinimo() {
		Fraccion min= array[0];
		for(int i=1;i<array.length;i++) {
			if(min.compareTo(array[i])>0) {
				min=array[i];
			}
		}
		return min;	
	}
	
	public Fraccion getSumaArray() {
		Fraccion suma=array[0];
		for(int i = 1;i<array.length;i++) {
			suma=suma.sumar(array[i]);
		}
		
		return suma;
	}
	
	public String toString() {
		String frase=new String("El array de fracciones es el siguiente: [");
		for(int i=0;i<array.length;i++) {
			frase+=(super.toString());
			if(i<array.length-1) {
				frase+=(", ");
			}else {
				frase+=("]");
			}
			
		}
		return frase;
	}
	
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(obj==this) {
			return true;
		}
		if(!(obj instanceof ArrayFracciones2)) {
			return false;
		}
		ArrayFracciones2 a=(ArrayFracciones2)obj;
	
		for(int i =0;i<this.array.length;i++) {
			if(this.array[i].compareTo(a.array[i])!=0) {
				return false;
			}
		}
		return true;
		
	}
	
	public int compareTo(Object obj) {
		ArrayFracciones2 b=(ArrayFracciones2)obj;
		Fraccion a= this.getSumaArray();
		Fraccion c=b.getSumaArray();
		
		return a.compareTo(c);
	}	
		
		
	
	
	

}
