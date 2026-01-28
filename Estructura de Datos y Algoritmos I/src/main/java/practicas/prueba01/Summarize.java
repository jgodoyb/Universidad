package practicas.prueba01;

import java.util.ArrayList;
import java.util.List;

import practicas.auxiliar.Par;

public class Summarize {
	private ArrayList<Par<String, ArrayList<Integer>>> datosOrigen = new ArrayList<>();
	private ArrayList<Par<String, ArrayList<Par<Integer, Integer>>>> datosDestino = new ArrayList<>();

	public void add(String clave, Integer... valores) {
		ArrayList<Integer> aux = null;
		int posCurr = this.datosOrigen.indexOf(new Par<>(clave, null));
		if (posCurr == -1) {
			this.datosOrigen.add(new Par<>(clave, aux = new ArrayList<>()));
		} else {
			aux = this.datosOrigen.get(posCurr).getValue();
		}
		aux.addAll(List.of(valores));
	}

	public void summarize() {
			// Iteramos sobre cada Par<String, ArrayList<Integer>> en datosOrigen
			for (Par<String, ArrayList<Integer>> parOrigen : this.datosOrigen) {
				String clave = parOrigen.getKey();
				ArrayList<Integer> listaValores = parOrigen.getValue();
				ArrayList<Par<Integer, Integer>> v2_compactada = new ArrayList<>();
				
				for (Integer numero : listaValores) {
					int pos = v2_compactada.indexOf(new Par<>(numero, null));
					if (pos == -1) {
						// Si no esta la añadiños con la frecuencia 1
						v2_compactada.add(new Par<>(numero, 1));
					} else {
						// En el caso de uqe ya exista se incrementa +1
						Par<Integer, Integer> parExistente = v2_compactada.get(pos);
						parExistente.setValue(parExistente.getValue() + 1);
					}
				}
				v2_compactada.sort(null);
				this.datosDestino.add(new Par<>(clave, v2_compactada));
			}
			this.datosDestino.sort(null);
		}

	@Override
	public String toString() {
		return this.datosOrigen.toString() + "\n" + this.datosDestino.toString();
	}

	public static void main(String[] args) {
		Summarize prueba = new Summarize();
		prueba.add("clave03", 3, 3, 3);
		prueba.add("clave02", 5, 1, 4, 5, 4);
		prueba.add("clave03", 1, 2, 3, 4, 5, 4, 5);
		prueba.add("clave01", 1, 2, 3, 4, 4, 3, 2, 1);
		prueba.summarize();
		String salidaEsperada = "[clave03 <[3, 3, 3, 1, 2, 3, 4, 5, 4, 5]>, clave02 <[5, 1, 4, 5, 4]>, clave01 <[1, 2, 3, 4, 4, 3, 2, 1]>]\n"
				+
				"[clave01 <[1 <2>, 2 <2>, 3 <2>, 4 <2>]>, clave02 <[1 <1>, 4 <2>, 5 <2>]>, clave03 <[1 <1>, 2 <1>, 3 <4>, 4 <2>, 5 <2>]>]";
		System.out.println(prueba.toString().equals(salidaEsperada) ? "¡OK!!!" : "¡¡¡Error!!!");
	}
}
