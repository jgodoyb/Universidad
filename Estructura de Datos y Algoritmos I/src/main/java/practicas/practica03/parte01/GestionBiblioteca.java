package practicas.practica03.parte01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import practicas.auxiliar.AVLTree;

public class GestionBiblioteca implements Iterable<Entry<String, TreeMap<String, Integer>>> {
	private final String bibliotecaId;
	protected final AVLTree<Libro> libros;
	protected final AVLTree<Usuario> usuarios;
	protected final TreeMap<Libro, Usuario> prestamos;
	protected final TreeMap<Usuario, ArrayList<Libro>> historicoPrestamos;

	public GestionBiblioteca(String bibliotecaId) {
		this.bibliotecaId = bibliotecaId;
		this.libros = new AVLTree<>();
		this.usuarios = new AVLTree<>();
		this.prestamos = new TreeMap<>();
		this.historicoPrestamos = new TreeMap<>();
	}

	public void addLibro(String autorId, String libroId) {
		this.libros.add(new Libro(autorId, libroId));
	}

	public void addLibro(Libro libro) {
		this.libros.add(libro);
	}

	public void addUsuario(String usuarioId) {
		this.usuarios.add(new Usuario(usuarioId));
	}

	public void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public void clear() {
		this.libros.clear();
		this.usuarios.clear();
		this.prestamos.clear();
		this.historicoPrestamos.clear();
	}

	public boolean prestarLibro(String usuarioId, String autorId, String libroId) {
		Usuario u = this.usuarios.find(new Usuario(usuarioId));
		Libro l = this.libros.find(new Libro(autorId, libroId));
		if (u == null || l == null)
			return false;
		return prestarLibro(u, l);
	}

	private boolean prestarLibro(Usuario usuarioCurr, Libro libroCurr) {
		if (this.prestamos.containsKey(libroCurr))
			return false;
		this.prestamos.put(libroCurr, usuarioCurr);
		guardarHistorico(libroCurr, usuarioCurr);
		return true;
	}

	private void guardarHistorico(Libro libroCurr, Usuario usuarioCurr) {
		ArrayList<Libro> aux = this.historicoPrestamos.get(usuarioCurr);
		if (aux == null) {
			this.historicoPrestamos.put(usuarioCurr, aux = new ArrayList<>());
		}
		aux.add(libroCurr);
	}

	public boolean devolverLibro(String usuarioId, String autorId, String libroId) {
		Usuario u = this.usuarios.find(new Usuario(usuarioId));
		Libro l = this.libros.find(new Libro(autorId, libroId));
		if (u == null || l == null)
			return false;
		return devolverLibro(u, l);
	}

	private boolean devolverLibro(Usuario usuarioCurr, Libro libroCurr) {
		Usuario aux = prestamos.get(libroCurr);
		if (aux == null || !aux.equals(usuarioCurr))
			return false;
		prestamos.remove(libroCurr);
		return true;
	}

	public String getPrestamosActuales() {
		TreeMap<String, ArrayList<String>> result = new TreeMap<>();
		for (Entry<Libro, Usuario> par : prestamos.entrySet()) {
			ArrayList<String> aux = result.get(par.getValue().getUsuarioId());
			if (aux == null) {
				result.put(par.getValue().getUsuarioId(), aux = new ArrayList<>());
			}
			aux.add(par.getKey().getAutorIdLibroId());
		}
		return result.toString();
	}

	public TreeMap<String, Integer> getUsuariosLibro(String autorId, String libroId) {
		Libro libroCurr = libros.find(new Libro(autorId, libroId));
		return libroCurr == null ? null : getUsuariosLibro(new Libro(autorId, libroId));
	}

	private TreeMap<String, Integer> getUsuariosLibro(Libro libroCurr) {
		TreeMap<String, Integer> result = new TreeMap<>();
		for (Entry<Usuario, ArrayList<Libro>> par : historicoPrestamos.entrySet()) {
			int i = 0;
			for (Libro l : par.getValue()) {
				if (l.equals(libroCurr))
					i++;
			}
			if (i > 0) {
				result.put(par.getKey().getUsuarioId(), i);
			}
		}
		return result;

	}

	public TreeSet<String> getLibrosUsuario(String usuarioId) {
		Usuario u = usuarios.find(new Usuario(usuarioId));
		return u == null ? null : getLibrosUsuario(u);
	}

	private TreeSet<String> getLibrosUsuario(Usuario usuarioCurr) {
		TreeSet<String> result = new TreeSet<>();
		ArrayList<Libro> aux = historicoPrestamos.get(usuarioCurr);
		if (aux == null)
			return null;
		for (Libro l : aux) {
			result.add(l.getAutorIdLibroId());
		}
		return result;

	}

	@Override
	public String toString() {
		return this.bibliotecaId + " (" + this.libros.size() + " libros y " + this.usuarios.size() + " usuarios" + ")";
	}

	@Override
	public Iterator<Entry<String, TreeMap<String, Integer>>> iterator() {
		TreeMap<String, TreeMap<String, Integer>> result = new TreeMap<>();
		TreeMap<String, Integer> aux;
		for (Usuario u : usuarios) {
			result.put(u.getUsuarioId(), aux = new TreeMap<>());
			for (Libro l : libros) {
				aux.put(l.getAutorIdLibroId(), 0);
			}
		}
		for (Entry<Usuario, ArrayList<Libro>> par : historicoPrestamos.entrySet()) {
			aux = result.get(par.getKey().getUsuarioId());
			for (Libro l : par.getValue()) {
				Integer i = aux.get(l.getAutorIdLibroId());
				aux.put(l.getAutorIdLibroId(), i + 1);
			}
		}
		return result.entrySet().iterator();
	}
}