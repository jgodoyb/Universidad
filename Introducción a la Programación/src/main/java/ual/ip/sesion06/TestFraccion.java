package org.ip.sesion06;

public class TestFraccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fraccion frac1=new Fraccion(1,5);
		Fraccion frac2=new Fraccion(4,5);
		Fraccion frac3=new Fraccion(-11,22);
		Fraccion frac4=new Fraccion(frac2);
		
		System.out.println("LAS FRACCIONES CREADAS SON \n");
		System.out.println("PRIMERA FRACCION => "+frac1.toString());
		System.out.println("SEGUNDA FRACCION => "+frac2.toString());
		System.out.println("TERCERA FRACCION => "+frac3.toString());
		System.out.println("CUARTA FRACCION => "+frac4.toString()+"\n");
		System.out.println("El numero de fracciones creadas es "+Fraccion.getNumFracciones());
		
		if(frac1.equals(frac2)) {
			System.out.println("La primera fraccion ES IGUAL a la segunda");
		}else
			System.out.println("La primera fraccion NO ES IGUAL a la segunda");
		
		if(frac2.equals(frac4)) {
			System.out.println("La seguna fraccion ES IGUAL a la cuarta");
		}else {
			System.out.println("La segunda fraccion NO ES IGUAL a la cuarta");
		}
		System.out.println("El numerador de la tercera fraccion es => "+frac3.getNumerador());
		System.out.println("El denominador de la primera fraccion es => "+frac1.getDenominador());
		
		System.out.println("La suma, utilizando el metodo de clase de "+frac1.toString()+" + "+frac2.toString()+" es "+Fraccion.suma(frac1, frac2));
		Fraccion frac5=frac1.sumar(frac2);
		System.out.println("La suma, utilizando el metodo de objeto de "+frac1.toString()+" + "+frac2.toString()+" es "+frac5+" simplificada "+frac5.simplificar());
		Fraccion frac6=frac1.restar(frac2);
		System.out.println("La resta de "+frac1+" - "+frac2+" es "+frac6+" simplificada "+frac6.simplificar());
		System.out.println("El producto "+frac1+" x "+frac2+" es "+ frac1.multiplicar(frac2));
		System.out.println("La division de "+frac1+" / "+" es "+frac3+" es "+frac1.dividir(frac3));
		System.out.println("La fraccion "+frac3+" simplificada es "+frac3.simplificar());
		System.out.println("El numero de fracciones creadas es "+Fraccion.getNumFracciones());
	
		 
	
	} 
	
	}


