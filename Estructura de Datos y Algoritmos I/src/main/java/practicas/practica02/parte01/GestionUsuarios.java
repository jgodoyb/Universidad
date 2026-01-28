package practicas.practica02.parte01;

import java.util.Iterator;

import practicas.auxiliar.AVLTree;
import practicas.auxiliar.Format;

public class GestionUsuarios implements Iterable<Usuario> {
	private AVLTree<Usuario> usuarios;
	 
	public GestionUsuarios() {
		this.usuarios = new AVLTree<>();
	}
	
	public void addDispositivos(Usuario usuario, Dispositivo... dispositivos) {
		Usuario u = this.usuarios.find(usuario);
		if(u == null) {
			this.usuarios.add(u = usuario);
		}
		u.addDispositivos(dispositivos);
	}

	public boolean enviarMensaje(String nombreUsuario, String nombreDispositivo, String mensaje) {
		Usuario u = this.usuarios.find(new Usuario(nombreUsuario));
		if(u == null) return false;
		return u.enviarMensaje(nombreDispositivo, mensaje);
	}
	
	public void clear() {
		for (Usuario u : usuarios) {
			u.clear();
		}
		this.usuarios.clear();
	}
	
	public String getGradoSimilitud(AVLTree<PalabraFrecuencia> conjunto01, AVLTree<PalabraFrecuencia> conjunto02) {
		
		double suma = .0;
		boolean disjunto = true;
		for (PalabraFrecuencia palFreq01: conjunto01) {
			PalabraFrecuencia palFreq02 = conjunto02.find(palFreq01);
			if(palFreq02 == null) continue;
			disjunto = false;
			suma += Math.pow(palFreq01.getFrecuencia() - palFreq02.getFrecuencia(), 2);
		}
		return disjunto ? "-1.00" : Format.formatDouble(1.0 / (1 + Math.sqrt(suma))); 
	}
	
	public String getGradoSimilitud(String nombreUsuario) {
		String result = "";
		Usuario usuarioCurr = this.usuarios.find(new Usuario(nombreUsuario));
		if (usuarioCurr == null) return null;
		result = usuarioCurr.getNick() + " vs...\n";
		for (Usuario u : usuarios) {
			if(u.equals(usuarioCurr)) continue;
			result += "\t" + u.getNick() + ": " + getGradoSimilitud(u.getPalabras(), usuarioCurr.getPalabras()) + "\n";
		}
		return result;
	}
		
	@Override
	public String toString() {
		return this.usuarios.toString();
	}

	@Override
	public Iterator<Usuario> iterator() {
		return this.usuarios.iterator();
	}
}