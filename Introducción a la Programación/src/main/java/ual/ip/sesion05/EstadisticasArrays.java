package org.ip.sesion05;

public class EstadisticasArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array1= {5,10,15,20};
		EstadisticasArrays.mostrarArray(array1);
		System.out.println("Numero Elementos del array de enteros: "+array1.length);
		System.out.println("Minimo del array de enteros: "+EstadisticasArrays.min(array1));
		System.out.println("Máximo del array de enteros: "+EstadisticasArrays.max(array1));
		System.out.println("Media del array de enteros: "+EstadisticasArrays.media(array1));
		System.out.println("Varianza del array de enteros: "+EstadisticasArrays.varianza(array1));
		System.out.println("Desvianza Típica del array de enteros: "+EstadisticasArrays.desviacionTipica(array1)+"\n");
		
		double[]array2= {5.0,25.5,15.75,10.25,12.5};
		EstadisticasArrays.mostrarArray(array2);
		System.out.println("Numero Elementos del array de reales: "+array2.length);
		System.out.println("Mínimo del array de reales: "+EstadisticasArrays.min(array2));
		System.out.println("Minimo del array de reales: "+ EstadisticasArrays.max(array2));
		System.out.println("Media del array de enteros "+EstadisticasArrays.media(array2));
		System.out.println("Varianza del array de reales: "+EstadisticasArrays.varianza(array2));
		System.out.println("Desvianza Típica del array de reales: "+EstadisticasArrays.desviacionTipica(array2));

	
	}
	public static double max(double[] array) {
		double ma;
		ma=array[0];
		for(int i=1;i<array.length;i++) {
			if(ma<array[i]) {
				ma=array[i];
			}		
		}return ma;
	}
	public static int max(int [] array) {
		int ma;
		ma=array[0];
		for(int i=1;i<array.length;i++) {
			if(array[i]>ma) {
				ma=array[i];
			}	
		}return ma;


	}
	public static double min(double[] array) {
		double mi;
		mi=array[0];
		for(int i=1;i<array.length;i++) {
			if(mi>array[i]) {
				mi=array[i];
			}		
		}return mi;
	}
	
	
	public static int min(int [] array) {
		int mi;
		mi=array[0];
		for(int i=1;i<array.length;i++) {
			if(array[i]<mi)
				mi=array[i];	
		}return mi;
	}
	
	
	public static double media(double[] array) {
		double med =array[0];
		for(int i=1;i<array.length;i++) {
			med+=array[i];
		}return med/array.length;
		
	}
	
	
	public static double media(int [] array) {
		double med;
		med=array[0];
		for(int i=1;i<array.length;i++) {
			med+=array[i];
			
		}return (double)med/array.length;
	}
	
	
	public static double varianza(double[] array) {
		double var=0;
		for(int i=0;i<array.length;i++) {
			var+=Math.pow(array[i]-EstadisticasArrays.media(array),2);
		}return var/(array.length-1);
	}
	

	public static double varianza(int [] array) {
		double var=0;
		for(int i=0;i<array.length;i++) {
			var+=(Math.pow(array[i]-EstadisticasArrays.media(array),2));
			
		}return var/(array.length-1); 
	}
	
	
	public static double desviacionTipica(double [] array) {
		return Math.sqrt(EstadisticasArrays.varianza(array));
	}
	
	
	public static double desviacionTipica(int [] array) {
		return Math.sqrt(EstadisticasArrays.varianza(array));	
	}
	
	
	public static void mostrarArray(double [] array2) {
		
		System.out.print("Array de Reales: [");
		for(int i=0;i<array2.length;i++) {
			System.out.print(array2[i]);
			if(i<array2.length-1) {
				System.out.print(", ");	
			}else
				System.out.println("]");
		}	
	}
	
	
	public static void mostrarArray(int [] array1) {
		
		System.out.print("Array de Enteros: [");
		for(int i=0;i<array1.length;i++) {
			System.out.print(array1[i]);
			if(i<array1.length-1) {
				System.out.print(", ");
			}else
				System.out.println("]");
		}
	}
}
