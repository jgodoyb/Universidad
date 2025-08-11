package org.ip.sesion05;

public class PracticarConArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []array= {5,10,15,2,4,23,7,13,8,17,27};
		int[] hola,b;
		int[]a= {1,1,3,2,1,6,3,4,4,4,5,2,1,2,6,4,7,5,6,7,1,8};
		
		PracticarConArrays.mostrarArray(array);
		System.out.println("Indice del menor valor del array de enteros: "+PracticarConArrays.indiceMinimoValor(array));
		System.out.println("Indice del mayor valor del array de enteros: "+PracticarConArrays.indiceMaximoValor(array));
		hola=invertir(array);
		mostrarArray(hola);
		System.out.println("Indice del menor valor del array de enteros: "+PracticarConArrays.indiceMinimoValor(hola));
		System.out.println("Indice del mayor valor del array de enteros: "+PracticarConArrays.indiceMaximoValor(hola));
		System.out.println("Desplazando el array una posicion ...");
		desplazar(array);
		mostrarArray(array);
		System.out.println("Desplazando el array 5 posiciones ...");
		for(int i=0;i<5;i++) {
			desplazar(array);
		}
		mostrarArray(array);
		mostrarArray(a);
		b=eliminarDuplicados(a);
		mostrarArray(b);
	
		
	}
	public static int [] invertir(int [] array) {
		int[]array2=new int [array.length];
		int j=array.length-1;
		
		for(int i=0;i<array.length;i++) {
			array2[i]=array[j];
			j--;
		}return array2;
	}
		
	public static void desplazar(int [] array) {
		int a=array[0];
		for(int i=1;i<array.length;i++) {
			array[i-1]=array[i];
		}
		array[array.length-1]=a;
	}
		
	
	public static int indiceMaximoValor(int [] array) {
		int max=0;
		max=array[0];
		for(int i=1;i<array.length;i++) {
			if(max<array[i]) {
				max=i;
			}
		}return max;
	}
	public static int indiceMinimoValor(int [] array) {
		int mi;
		mi=array[0];
		for(int i=1;i<array.length;i++) {
			if(mi>array[i]) {
				mi=i;
			}		
		}return mi;
	}
	public static int [] eliminarDuplicados(int [] array) {
		int []a = new int [array.length];
		int cont = 0;
		for (int i=0; i<array.length; i++) {
			int k=0;
			boolean encon = false;
			while (k<cont && ! encon) {
				if (a[k] == array[i])
					encon = true;
				k++;
			}
			if ( ! encon) {  
				a[cont] = array[i];
				cont++;
			}
		}
		int []b = new int [cont];
		for (int i=0; i<cont; i++) {
			b[i] = a[i];
		}
		return b;
		
	}
		
	
	public static void mostrarArray(int [] array) {
		System.out.print("Array de Enteros: [");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]);
			if(i<array.length-1) {
				System.out.print(", ");
			}else
				System.out.println("]");
		}
	}

}
