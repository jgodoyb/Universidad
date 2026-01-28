package practicas.practica04;

import java.util.ArrayList;

public class MyMath{
	public static double getCosineDistance(ArrayList<Double> arr1, ArrayList<Double> arr2) {

		if(arr1.size() != arr2.size()) {
			throw new IllegalArgumentException("Los arrays deben tener la misma longitud");
		}
		double sumaArrays = 0, sumaCuadrado1 = 0, sumaCuadrado2 = 0;
		for(int i = 0; i < arr1.size(); i++) {
			sumaArrays += arr1.get(i) * arr2.get(i);
			sumaCuadrado1 += Math.pow(arr1.get(i), 2);
			sumaCuadrado2 += Math.pow(arr2.get(i), 2);
		}

		return (sumaCuadrado1*sumaCuadrado2) == 0 ? -1 : 1 - (sumaArrays / (Math.sqrt(sumaCuadrado1*sumaCuadrado2)));
	}
} 
