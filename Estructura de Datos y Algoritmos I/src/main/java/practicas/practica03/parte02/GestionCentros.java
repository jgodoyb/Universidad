package practicas.practica03.parte02;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

import practicas.auxiliar.Format;

public class GestionCentros implements Iterable<Entry<String, TreeMap<String, ArrayList<Double>>>> {
	protected final TreeMap<String, TreeMap<String, TreeMap<String, ArrayList<Double>>>> datos = new TreeMap<>();

	public boolean load(String fileName) {
		Scanner scan;
		String line;
		String[] items;
		this.datos.clear();
		try {
			scan = new Scanner(new File(fileName));
		} catch (IOException e) {
			return false;
		}
		while (scan.hasNextLine()) {
			line = scan.nextLine().trim();
			if (line.isEmpty() || line.startsWith("%"))
				continue;
			items = line.split("[\t ]+");
			if (items.length < 4)
				continue;
			String[] tamana = Arrays.copyOfRange(items, 3, items.length);
			Double[] notas = new Double[tamana.length];
			for (int i = 0; i < tamana.length; i++) {
				notas[i] = Double.parseDouble(tamana[i]);
			}
			add(items[0], items[1], items[2], notas);
		}
		scan.close();
		return true;
	}

	public void add(String centroId, String estudianteId, String asignaturaId, Double... notas) {
		TreeMap<String, TreeMap<String, ArrayList<Double>>> aux1 = this.datos.get(centroId);
		if (aux1 == null) {
			this.datos.put(centroId, aux1 = new TreeMap<>());
		}
		TreeMap<String, ArrayList<Double>> aux2 = aux1.get(estudianteId);
		if (aux2 == null) {
			aux1.put(estudianteId, aux2 = new TreeMap<>());
		}
		ArrayList<Double> aux3 = aux2.get(asignaturaId);
		if (aux3 == null) {
			aux2.put(asignaturaId, aux3 = new ArrayList<>());
		}
		aux3.addAll(List.of(notas));
	}

	public void clear() {
		this.datos.clear();
	}

	public int size() {
		return this.datos.size();
	}

	@Override
	public String toString() {
		String result = this.datos.size() + " centro" + (this.datos.size() == 1 ? "" : "s") + ":\n";
		for (Entry<String, TreeMap<String, TreeMap<String, ArrayList<Double>>>> it : this.datos.entrySet()) {
			int cont = 0;
			for (TreeMap<String, ArrayList<Double>> it2 : it.getValue().values()) {
				cont += it2.size();
			}
			result += "\t" + it.getKey() + " -> " + it.getValue().size() + " estudiante"
					+ (it.getValue().size() == 1 ? "" : "s") +
					" y " + cont + " asignatura" + (cont == 1 ? "" : "s") + "\n";
		}
		return result;
	}

	public TreeSet<String> getAsignaturasCentro(String centroId) {
		TreeMap<String, TreeMap<String, ArrayList<Double>>> aux = this.datos.get(centroId);
		if (aux == null)
			return null;
		TreeSet<String> result = new TreeSet<>();
		for (TreeMap<String, ArrayList<Double>> it : aux.values()) {
			result.addAll(it.keySet());
		}

		return result;
	}

	public TreeSet<String> getEstudiantesAsignatura(String asignatura) {
		TreeSet<String> result = new TreeSet<>();
		for (TreeMap<String, TreeMap<String, ArrayList<Double>>> it : this.datos.values()) {
			for (Entry<String, TreeMap<String, ArrayList<Double>>> it2 : it.entrySet()) {
				if (it2.getValue().containsKey(asignatura)) {
					result.add(it2.getKey());
				}
			}
		}
		return result.isEmpty() ? null : result;
	}

	public TreeSet<String> getEstudiantesCentro(String centroId) {
		TreeMap<String, TreeMap<String, ArrayList<Double>>> aux = this.datos.get(centroId);
		if (aux == null)
			return null;
		return new TreeSet<>(aux.keySet());
	}

	public String getNotaMediaCentro(String centroId) {
		TreeMap<String, TreeMap<String, ArrayList<Double>>> aux = this.datos.get(centroId);
		if (aux == null)
			return null;
		ArrayList<Double> notas = new ArrayList<>();
		for (TreeMap<String, ArrayList<Double>> it : aux.values()) {
			for (ArrayList<Double> it2 : it.values()) {
				notas.addAll(it2);
			}
		}
		return Format.formatDouble(MyMath.calculaMedia(notas));
	}

	public String getNotaMediaEstudiante(String estudianteId) {
		ArrayList<Double> result = new ArrayList<>();
		for (TreeMap<String, TreeMap<String, ArrayList<Double>>> it : this.datos.values()) {
			TreeMap<String, ArrayList<Double>> aux = it.get(estudianteId);
			if (aux == null)
				continue;
			for (ArrayList<Double> it2 : aux.values()) {
				result.addAll(it2);
			}
		}
		return result.isEmpty() ? null : Format.formatDouble(MyMath.calculaMedia(result));
	}

	public String getNotaMediaAsignatura(String asignaturaId) {
		ArrayList<Double> result = new ArrayList<>();
		boolean check = false;
		for (TreeMap<String, TreeMap<String, ArrayList<Double>>> it : this.datos.values()) {
			for (TreeMap<String, ArrayList<Double>> it2 : it.values()) {
				ArrayList<Double> aux = it2.get(asignaturaId);
				if (aux == null)
					continue;
				result.addAll(aux);
				check = true;
			}
			if (check)
				break;
		}

		return result.isEmpty() ? null : Format.formatDouble(MyMath.calculaMedia(result));
	}

	public boolean checkEstudiantes() {
		for (String centro0 : this.datos.keySet()) {
			TreeSet<String> aux1 = getEstudiantesCentro(centro0);
			for (String centroS : this.datos.keySet()) {
				if (centro0.equals(centroS))
					continue;
				TreeSet<String> aux2 = getEstudiantesCentro(centroS);
				aux2.retainAll(aux1);
				if (aux2.size() > 0)
					return false;

			}

		}

		return true;
	}

	public boolean checkAsignaturas() {

		for (String centro0 : this.datos.keySet()) {
			TreeSet<String> aux1 = getAsignaturasCentro(centro0);
			for (String centroD : this.datos.keySet()) {
				if (centro0.equals(centroD))
					continue;
				TreeSet<String> aux2 = getAsignaturasCentro(centroD);
				aux2.retainAll(aux1);
				if (aux2.size() > 0)
					return false;

			}

		}
		return true;
	}

	@Override
	public Iterator<Entry<String, TreeMap<String, ArrayList<Double>>>> iterator() {
		TreeMap<String, TreeMap<String, ArrayList<Double>>> mapa = new TreeMap<>();
		for (Entry<String, TreeMap<String, TreeMap<String, ArrayList<Double>>>> it : this.datos.entrySet()) {
			TreeMap<String, ArrayList<Double>> aux = new TreeMap<>();
			mapa.put(it.getKey(), aux);
			for (Entry<String, TreeMap<String, ArrayList<Double>>> it2 : it.getValue().entrySet()) {
				ArrayList<Double> aux2 = new ArrayList<>();
				aux.put(it2.getKey(), aux2);
				for (ArrayList<Double> it3 : it2.getValue().values()) {
					aux2.addAll(it3);
				}
			}

		}
		return mapa.entrySet().iterator();
	}
}