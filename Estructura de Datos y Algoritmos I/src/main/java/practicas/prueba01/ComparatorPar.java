package practicas.prueba01;
import java.util.ArrayList;
import java.util.Comparator;
import practicas.auxiliar.Par;

// La clase debe implementar la interfaz 'Comparator' de Java
public class ComparatorPar<K extends Comparable<K>, V extends Comparable<V>> implements Comparator<Par<K,V>>{
	
	@Override
	public int compare(Par<K,V> p1, Par<K,V> p2) {
		
		// 1. Primero se compara la clave como criterio principal.
		int cmp = p1.getKey().compareTo(p2.getKey());
		// 2.Si son iguales se emplea el valor como criterio secundario.
		return cmp != 0 ? cmp : p1.getValue().compareTo(p2.getValue());
	}
	
	public static void main(String[] args) {
		ArrayList<Par<String, String>> pares = new ArrayList<>();
		pares.add(new Par<>("z", "h"));
		pares.add(new Par<>("a", "m"));
		pares.add(new Par<>("a", "a"));
		pares.add(new Par<>("j", "a"));
		pares.add(new Par<>("j", "z"));
		pares.add(new Par<>("n", "a"));
		
		pares.sort(new ComparatorPar<>());

		String salidaEsperada = "[a <a>, a <m>, j <a>, j <z>, n <a>, z <h>]";
		System.out.println(pares.toString().equals(salidaEsperada) ? "¡OK!!!" : "¡¡¡Error!!!");
	}
}