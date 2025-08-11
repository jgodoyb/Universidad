package org.ip.sesion07;

import org.ip.sesion07.Disco.Genero;
import org.ip.sesion07.Multimedia.Formato;

public class TestMultimedia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Multimedia multi1=new Multimedia("Million Dollar Baby", "Clint Eastwood", Formato.dvd, 137.30);
		Multimedia multi2=new Multimedia("The Bridges of Madison County", "Clint Eastwood", Formato.dvd, 134.10);
		
		Multimedia multi4=new Multimedia("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson",Formato.dvd, 155.15);
		Multimedia multi5=new Multimedia("Mar adentro", "Alejandro Amenabar", Formato.mpg, 125.05);
		Multimedia multi6=new Multimedia(multi5);
		
		Pelicula pelic1=new Pelicula("Million Dollar Baby", "Clint Eastwood", Formato.dvd, 137.30,"Clint Eastwood","Hillary Swank");
		Pelicula pelic2=new Pelicula("The Bridges of Madison County", "Clint Eastwood", Formato.dvd, 134.10, "Clint Eastwood", "Meryl Streep");
		
		Pelicula pelic4 =new Pelicula("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson",Formato.dvd, 155.15, "Elijah Wood", "Liv Tyler");
		Pelicula pelicula5=new Pelicula("Mar adentro", "Alejandro Amenabar", Formato.mpg, 125.05, "Javier Bardem","Belen Rueda");
		Pelicula pelicula6 = new Pelicula(pelicula5);
		
		
		Multimedia multi8=new Multimedia("How to Dismantle an Atomic Bomb", "U2", Formato.cdAudio, 49.20);
		Multimedia multi9=new Multimedia("Quitate las Gafas", "Melendi", Formato.mp3, 47.24);
		Multimedia multi10=new Multimedia("Southside", "Texas", Formato.mp3, 44.53);
		Multimedia multi11=new Multimedia("Soy Gitano", "Camaron", Formato.cdAudio, 32.21);
		Multimedia multi12=new Multimedia(multi11);
		
		
		Disco disco2=new Disco("How to Dismantle an Atomic Bomb", "U2", Formato.cdAudio, 49.20, Genero.rock, 11);
		Disco disco3=new Disco("Quitate las Gafas", "Melendi", Formato.mp3, 47.24, Genero.pop, 12);
		Disco disco4=new Disco("Southside", "Texas", Formato.mp3, 44.53, Genero.rock, 11);
		Disco disco5=new Disco("Soy Gitano", "Camaron", Formato.cdAudio, 32.21, Genero.flamenco, 8);
		Disco disco6 = new Disco(disco5);
		
		System.out.println(multi4);
		System.out.println(pelic4);
		System.out.println();
		System.out.println(multi1);
		System.out.println(pelic1);
		System.out.println(" Y");
		System.out.println(multi2);
		System.out.println(pelic2);
		if(multi1.equals(multi2) && pelic1.equals(pelic2)) {
			System.out.println("SON IGUALES ===");
		}else {
			System.out.println("SON DIFERENTES XXX");
		}
		System.out.println();
		System.out.println(multi5);
		System.out.println(pelicula5);
		System.out.println(" Y");
		System.out.println(multi6);
		System.out.println(pelicula6);
		if(multi5.equals(multi6) && pelicula5.equals(pelicula6)) {
			System.out.println("SON IGUALES ===");
		}else {
			System.out.println("SON DIFERENTES XXX");
		}
		System.out.println();
		System.out.println(multi10);
		System.out.println(disco4);
		System.out.println();
		System.out.println(multi8);
		System.out.println(disco2);
		System.out.println(" Y");
		System.out.println(multi9);
		System.out.println(disco3);
		if(multi8.equals(multi9) && disco2.equals(disco3)) {
			System.out.println("SON IGUALES ===");
		}else {
			System.out.println("SON DIFERENTES XXX");
		}
		System.out.println();
		System.out.println(multi11);
		System.out.println(disco5);
		System.out.println(" Y");
		System.out.println(multi12);
		System.out.println(disco6);
		if(multi11.equals(multi12) && disco5.equals(disco6)) {
			System.out.println("SON IGUALES ===");
		}else {
			System.out.println("SON DIFERENTES XXX");
		}
	}
}