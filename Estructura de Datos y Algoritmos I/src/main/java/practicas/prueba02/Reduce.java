package practicas.prueba02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Reduce {
	TreeMap<String, TreeMap<String, ArrayList<Double>>> datosOrigen = new TreeMap<>();
	HashMap<Double, TreeMap<String, Integer>> datosDestino = new HashMap<>();
	
	public void add(String mainKey, String secondKey, Double...values) {
		TreeMap<String, ArrayList<Double>> mainValues = this.datosOrigen.get(mainKey);
		if (mainValues == null) this.datosOrigen.put(mainKey, mainValues = new TreeMap<>());
		ArrayList<Double> secondValues = mainValues.get(secondKey);
		if (secondValues == null) mainValues.put(secondKey, secondValues = new ArrayList<>());
		secondValues.addAll(List.of(values));
	}
	
	public void reduce() {
		for (String claveP : this.datosOrigen.keySet()) {
			for (ArrayList<Double> lista : this.datosOrigen.get(claveP).values()) {
				for (Double valor : lista) {
					TreeMap<String, Integer> mp = this.datosDestino.get(valor);
					if (mp == null) {
						this.datosDestino.put(valor, mp = new TreeMap<>());
					}
					Integer fr = mp.get(claveP);
					mp.put(claveP, fr == null ? 1 : fr + 1);
				}
			}
		}
	}
	
	public boolean check() {
		boolean val01 = this.datosDestino.get(4.5).toString().equals("{al01=6, al02=2, al03=1}"); 
		boolean val02 = this.datosDestino.get(7.5).toString().equals("{al01=1, al02=4, al03=4}"); 
		boolean val03 = this.datosDestino.get(9.5).toString().equals("{al01=3, al02=2, al03=1}"); 
		boolean val04 = this.datosDestino.get(10.).toString().equals("{al02=3}"); 
		return val01 && val02 && val03 && val04;
	}
	
	@Override
	public String toString() {
		return this.datosOrigen.toString() + "\n" + this.datosDestino.toString();

	}
	public static void main(String[] args) {
		Reduce ejercicio = new Reduce();
		ejercicio.add("al01",  "as01", 4.5, 4.5, 4.5, 4.5, 9.5);
		ejercicio.add("al01",  "as02", 9.5, 9.5, 4.5, 7.5, 4.5);
		ejercicio.add("al02",  "as01", 4.5, 7.5, 7.5, 9.5, 10., 10.);
		ejercicio.add("al02",  "as02", 4.5, 10., 9.5, 7.5, 7.5);
		ejercicio.add("al03",  "as03", 4.5, 9.5, 7.5, 7.5, 7.5, 7.5);
		
		ejercicio.reduce();
	//	System.out.println(ejercicio.toString());
		System.out.println(ejercicio.check() ? "¡¡¡OK!!!" : "¡¡¡Error!!!");
	}
}
