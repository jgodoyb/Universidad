package org.ip.sesion05;

import java.util.Scanner;

public class EntradaSalidaArrays {
	
	private static Scanner entrada;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a;
		double[]b;
		int [][]c;
		double[][]d;
		
		
		System.out.print("METODO PARA LEER ARRAY CON NUMEROS REALES ");
		System.out.println();
		b=leerRealesArray1D();
		System.out.println();
		System.out.println("METODO PARA MOSTRAR EL ARRAY DE ENTEROS 1D");
		mostrarArray1D(b);

		System.out.println("\n\n--------------------------------------------------------------------\n");
		System.out.println("METODO PARA LEER ENTEROS ");
		a=leerEnterosArray1D();
		System.out.println();
		System.out.println("METODO PARA MOSTRAR EL ARRAY DE ENTEROS 1D");
		EntradaSalidaArrays.mostrarArray1D(a);
		
		System.out.println("\n\n--------------------------------------------------------------------\n");		
		System.out.print("METODO PARA INICIALIZAR ARRAY DE REALES 1D");
		System.out.println();
		b = inicializarRealesArray1D ();
		System.out.println();
		System.out.println("El array creado es el siguiente");
		mostrarArray1D(b);
		
		System.out.println("\n\n--------------------------------------------------------------------\n");
		System.out.print("METODO PARA INICIALIZAR ARRAY DE ENTEROS 1D");
		System.out.println();
		a = inicializarEnterosArray1D ();
		System.out.println();
		System.out.println("El array creado es el siguiente");
		mostrarArray1D(a);
		
		System.out.println("\n\n--------------------------------------------------------------------\n");
		System.out.println("METODO PARA LEER ARRAY BIDIMENSIONAL");
		c=leerEnterosMatriz2D();
		System.out.println("\n");
		System.out.println("El array creado es el siguiente");
		mostrarMatriz2D(c);
		
		System.out.println("\n--------------------------------------------------------------------\n");
		System.out.println("METODO PARA INICIALIZAR ARRAY BIDIMENSIONAL DE ENTEROS ");
		c=inicializarEnterosMatriz2D();
		System.out.println();
		System.out.println("El array creado es el siguiente");
		mostrarMatriz2D(c);
		
		System.out.println("\n\n--------------------------------------------------------------------\n");
		System.out.println("Para crear un array bidimensional con reales debo crear un método que cree dicho array y lUEgo aplicaré el método de mostrarMatriz2D");
		System.out.println();
		System.out.println("METODO PARA INICIAIZAR ARRAY BIDIMENSIONAL DE REALES");
		d=inicializarRealesMatrices2D();
		System.out.println();
		System.out.println("El array creado es el sigueinte");
		mostrarMatriz2D(d);
	}
	
	
	public static double[] leerRealesArray1D() {
		entrada = new Scanner(System.in);
		System.out.println("Introduce el número de componentes del array de reales: ");
		int numElementos = entrada.nextInt();
		double [] array = new double [numElementos];
		System.out.println("Introduce valores reales en el array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print("Introduce valor " + (i + 1) + "=> ");
			array[i] = (double)entrada.nextDouble();
		}
		return array;
	}

	
	public static int[] leerEnterosArray1D() {
		entrada = new Scanner(System.in);
		System.out.println("Introduce el número de componentes del array de enteros: ");
		
		int numElementos = entrada.nextInt();
		int [] array = new int [numElementos];
		System.out.println("Introduce valores enteros en el array ");
		
		for (int i = 0; i < array.length; i++) {
			System.out.print("Introduce valor " + (i + 1) + "=> ");
			array[i] = entrada.nextInt();
		}
		return array;
	}
	
	
	public static int[] inicializarEnterosArray1D() {
		entrada=new Scanner(System.in);
		System.out.println("Introduce el número de componentes del array de enteros: ");
		
		int numComponente=entrada.nextInt();
		int[]array = new int [numComponente];
		for(int i=0;i<array.length;i++) {
			array[i]=(int)(Math.random()*50+1);		
			}
		return array;		
	}
	
	public static double [] inicializarRealesArray1D() {
		entrada = new Scanner(System.in);
		System.out.println("Introduce el número de componentes del array de reales");
		int numElementos = entrada.nextInt();
		double [] array = new double [numElementos];
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random() * 50 + 1;
		}
		return array;
	}
	public static void mostrarArray1D(double[] array) {
		System.out.print("Mostrar array de reales: [");
		for(int i=0;i<array.length;i++) {
			System.out.printf("%.2f",array[i]);
			if(i<array.length-1) {
				System.out.print(",");
			}else
				System.out.print("]");
		}

	}

	public static void mostrarArray1D(int[] array) {
		System.out.print("Mostrar array de enteros: [");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]);
			if(i<array.length-1) {
				System.out.print(",");
			}else
				System.out.print("]");
		}
	}

	public static int[][] leerEnterosMatriz2D() {
		entrada=new Scanner(System.in);
		System.out.print("Intruduzca el tamaño del array bidimensional: ");
		int tamaño= entrada.nextInt();
		int[][]matriz=new int[tamaño][tamaño];
		
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				System.out.print("Indroduzca valor para ["+i+"] ["+j+"] ==> ");
				matriz[i][j]=entrada.nextInt();
			}
		}return matriz;
	}


	public static int[][] inicializarEnterosMatriz2D() {
		entrada=new Scanner(System.in);
		System.out.println("Introduce el indice de la matriz cuadrada del array bidimensional de reales: ");
		int orden=entrada.nextInt();
		
		int[][]matriz=new int[orden][orden];
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				matriz[i][j]=(int)(Math.random()*50+1);
			}
		}return matriz;
	}
	
	public static double[][]inicializarRealesMatrices2D(){
		entrada=new Scanner(System.in);
		System.out.println("Introduce el indice de la matriz cuadrada del array bidimensional de reales: ");
		int orden=entrada.nextInt();
		
		double[][]matriz=new double[orden][orden];
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				matriz[i][j]=(Math.random()*50+1);
			}
		}return matriz;
		
	}


	public static void mostrarMatriz2D(int[][] matriz) {
		System.out.println("Mostrar array bidimensional : ");
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++) {
				System.out.print(matriz[i][j]+"\t");
			}System.out.println();	
		}
	}

	
	public static void mostrarMatriz2D(double[][] matriz) {
		System.out.println("Mostrar array bidimensional : ");
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++) {
				System.out.print(matriz[i][j]+"\t");
			}System.out.println();
		}
	}
}
