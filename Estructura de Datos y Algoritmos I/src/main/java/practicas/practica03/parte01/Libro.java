package practicas.practica03.parte01;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Libro implements Comparable<Libro>, Iterable<Entry<String, Integer>> {
	private String autorId;
	private String libroId;
	private final TreeMap<String, Integer> palFreq;

	public Libro(String fileName) {
		Scanner scan;
		try {
			scan = new Scanner(new File(fileName));
		} catch (IOException e) {
			throw new RuntimeException("Archivo no encontrado");
		}
		this.autorId = scan.nextLine().trim();
		this.libroId = scan.nextLine().trim();
		this.palFreq = new TreeMap<>();

		while (scan.hasNextLine()) {
			String linea = scan.nextLine().trim();
			if (linea.isEmpty())
				continue;
			add(linea.split("[.,:; ]+"));
		}
		scan.close();
	}

	public Libro(String autorId, String libroId) {
		this.autorId = autorId.trim();
		this.libroId = libroId.trim();
		this.palFreq = new TreeMap<>();
	}

	public void clear() {
		this.palFreq.clear();
	}

	public void add(String... palabras) {
		for (String palabra : palabras) {
			Integer v = this.palFreq.get(palabra.toLowerCase());
			this.palFreq.put(palabra.toLowerCase(), (v == null) ? 1 : v + 1);
		}
	}

	public String getAutorIdLibroId() {
		return this.autorId + " - " + this.libroId;
	}

	public String getAutorId() {
		return this.autorId;
	}

	public String getLibroId() {
		return this.libroId;
	}

	public int getNumPalabras() {
		int suma = 0;
		for (Integer freq : this.palFreq.values()) {
			suma += freq;
		}

		return suma;
	}

	public TreeSet<String> getPalabras() {
		return new TreeSet<>(this.palFreq.keySet());
	}

	@Override
	public String toString() {
		return this.libroId + " (" + this.autorId + ") -> [" + this.palFreq.size()
				+ (this.palFreq.size() == 1 ? " palabra distinta]" : " palabras distintas]");
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof Libro))
			return false;
		if (this == o)
			return true;
		return this.compareTo((Libro) o) == 0;
	}

	@Override
	public int compareTo(Libro o) {
		int cmp = this.autorId.compareTo(o.autorId);
		return (cmp != 0) ? cmp : this.libroId.compareTo(o.libroId);
	}

	@Override
	public Iterator<Entry<String, Integer>> iterator() {
		return this.palFreq.entrySet().iterator();
	}
}