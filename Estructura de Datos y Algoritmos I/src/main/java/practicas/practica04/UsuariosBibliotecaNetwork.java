package practicas.practica04;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.Scanner;

import practicas.auxiliar.Format;
import practicas.practica03.parte01.Usuario;

public class UsuariosBibliotecaNetwork extends Network<Usuario> {
	private TreeMap<Usuario, TreeMap<String, TreeSet<Usuario>>> datos = new TreeMap<>();

	@Override
	public String toString() {
		return this.datos.toString();
	}

	@Override
	public void clear() {
		super.clear();
		this.datos.clear();
	}

	public boolean load(String fileName) {
		Scanner scan = null;
		this.adjacencyList.clear();
		try {
			scan = new Scanner(new File(fileName));
		} catch (Exception e) {
			return false;
		}
		TreeMap<Usuario, ArrayList<Double>> fileLoaded = new TreeMap<>();
		while (scan.hasNextLine()) {
			String line = scan.nextLine().trim();
			if (line.isEmpty() || line.startsWith("%"))
				continue;

			String items[] = line.split(",");
			Usuario user = new Usuario(items[0]);
			ArrayList<Double> libros = new ArrayList<>(items.length - 1);

			for (int i = 1; i < items.length; i++) {
				libros.add(Double.valueOf(items[i]));
			}

			fileLoaded.put(user, libros);
		}
		scan.close();
		computeDistances(fileLoaded);
		fileLoaded.clear();
		return true;
	}

	public void computeDistances(TreeMap<Usuario, ArrayList<Double>> fileLoaded) {

		this.datos.clear();

		for (Entry<Usuario, ArrayList<Double>> par1 : fileLoaded.entrySet()) {
			for (Entry<Usuario, ArrayList<Double>> par2 : fileLoaded.entrySet()) {
				if (par1.getKey().compareTo(par2.getKey()) == 0)
					continue;
				double dist = MyMath.getCosineDistance(par1.getValue(), par2.getValue());
				if (dist < 0)
					continue;

				TreeMap<String, TreeSet<Usuario>> aux = this.datos.get(par1.getKey());
				if (aux == null)
					datos.put(par1.getKey(), aux = new TreeMap<>());

				TreeSet<Usuario> aux2 = aux.get(Format.formatDouble(dist));
				if (aux2 == null)
					aux.put(Format.formatDouble(dist), aux2 = new TreeSet<>());
				aux2.add(par2.getKey());

				aux = this.datos.get(par2.getKey());
				if (aux == null)
					datos.put(par2.getKey(), aux = new TreeMap<>());

				aux2 = aux.get(Format.formatDouble(dist));
				if (aux2 == null)
					aux.put(Format.formatDouble(dist), aux2 = new TreeSet<>());
				aux2.add(par1.getKey());

			}
		}
	}

	public void buildGraph(int k) {
		if (k <= 0 || k >= this.datos.size())
			throw new RuntimeException("k > 0 && k < " + this.datos.size());
		this.adjacencyList.clear();
		this.setDirected(true);
		for (Entry<Usuario, TreeMap<String, TreeSet<Usuario>>> par1 : this.datos.entrySet()) {
			this.addVertex(par1.getKey());
			HashMap<Usuario, Double> aux = this.adjacencyList.get(par1.getKey());
			for (Entry<String, TreeSet<Usuario>> par2 : par1.getValue().entrySet()) {
				for (Usuario u : par2.getValue()) {
					if (aux.size() == k)
						break;
					aux.put(u, Double.valueOf(par2.getKey()));
				}
				if (aux.size() == k)
					break;
			}
		}

	}
}