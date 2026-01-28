package practicas.practica02.parte01;

import practicas.auxiliar.AVLTree;

public class Usuario implements Comparable<Usuario> {
	private String nick; // atributo clave
	private AVLTree<Dispositivo> dispositivos;

	public Usuario(String nick) {
		if (nick == null || nick.trim().isEmpty())
			throw new RuntimeException("El nick es nulo o está vacío");
		this.nick = nick;
		this.dispositivos = new AVLTree<>();

	}

	public String getNick() {
		return this.nick;
	}

	public void clear() {
		for (Dispositivo d : this.dispositivos) {
			d.clear();
		}
		this.dispositivos.clear();

	}

	public void addDispositivos(Dispositivo... dispositivos) {
		if (dispositivos == null) return;
		for (Dispositivo d : dispositivos) {
			if (d == null) continue;
			this.dispositivos.add(new Dispositivo(d));
		}

	}

	

	public int getNumDispositivos() {
		return this.dispositivos.size();
	}

	public boolean enviarMensaje(String nombreDispositivo, String mensaje) {
		Dispositivo d = this.dispositivos.find(new Dispositivo(nombreDispositivo));
		if ( d == null ) return false;
		d.enviarMensaje(mensaje);
		return true;
	}

	public int getNumPalabras(String nombreDispositivo) {
		Dispositivo d = this.dispositivos.find(new Dispositivo(nombreDispositivo));
		if ( d == null) return -1;
		int cont = 0;
		for ( PalabraFrecuencia pf : d){
			cont += pf.getFrecuencia();
		}

		return cont;
	}

	public AVLTree<PalabraFrecuencia> getPalabras() {
		AVLTree<PalabraFrecuencia> result = new AVLTree<>();
		for (Dispositivo d : dispositivos){
			for (PalabraFrecuencia pf : d){
				PalabraFrecuencia aux = result.find(pf);
				if (aux == null){
					result.add(new PalabraFrecuencia(pf));
				}else{
					aux.setFrecuencia(aux.getFrecuencia() + pf.getFrecuencia());
				}
			}
		}
		return result;
	}

	@Override
	public String toString() {
		String result = this.nick + ": \n";
		for (Dispositivo d : dispositivos){
			result += "\t" + d + "\n";
		}
		return result;
	}

	@Override
	public boolean equals(Object otro) {
		if (otro == null) return false;
		if (this == otro) return true;
		if (!(otro instanceof Usuario)) return false;
		return this.compareTo((Usuario)otro) == 0;
	}

	@Override
	public int compareTo(Usuario otro) {
		return this.nick.compareTo(otro.nick);
	}
}
