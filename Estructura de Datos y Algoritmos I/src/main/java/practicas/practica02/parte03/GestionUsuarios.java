package practicas.practica02.parte03;

import java.util.ArrayList;
import practicas.auxiliar.AVLTree;
import practicas.auxiliar.Par;


public class GestionUsuarios {
	private AVLTree<Par<String, AVLTree<Par<String, ArrayList<String>>>>> usuarios;

	public GestionUsuarios() {
		this.usuarios = new AVLTree<>();
	}

	public void addDispositivos(String usuario, String... dispositivos) {
		Par<String, AVLTree<Par<String, ArrayList<String>>>> usuarioCurr = this.usuarios.find(new Par<>(usuario, null));
		if(usuarioCurr == null) {
			usuarioCurr = new Par<>(usuario, new AVLTree<>());
			this.usuarios.add(usuarioCurr);
		}
		for(String dispositivo : dispositivos) {
			usuarioCurr.getValue().add(new Par<>(dispositivo, new ArrayList<>()));
		}
	}

	public boolean enviarMensaje(String usuario, String dispositivo, String mensaje) {
		Par<String, AVLTree<Par<String, ArrayList<String>>>> usuarioCurr = this.usuarios.find(new Par<>(usuario, null));
		
		if(usuarioCurr == null) return false;
		Par<String, ArrayList<String>> dispositivoCurr = usuarioCurr.getValue().find(new Par<>(dispositivo, null));
		
		if(dispositivoCurr == null) return false;
		
		for(String p : mensaje.split("[,. ]+")){
			dispositivoCurr.getValue().add(p);
		}
		return true;
	}

	public ArrayList<Par<String, Integer>> getPalabras(String usuario) {
		ArrayList<Par<String, Integer>> result = new ArrayList<>();
		Par<String, AVLTree<Par<String, ArrayList<String>>>> usuarioCurr = this.usuarios.find(new Par<>(usuario, null));
		
		if(usuarioCurr == null) return null;
		
		for(Par<String, ArrayList<String>> d : usuarioCurr.getValue()) {
			for(String palabra : d.getValue()) {
				Par<String, Integer> palabraCurr = new Par<>(palabra, null);
				int pos = result.indexOf(palabraCurr);
				if(pos == -1) {
					result.add(new Par<>(palabra, 1));
				} else {
					result.get(pos).setValue(result.get(pos).getValue() + 1);
				}
			}
		}		
		return result;
	}

	public AVLTree<Par<String, ArrayList<String>>> getDispositivos(String usuario) {
		Par<String, AVLTree<Par<String, ArrayList<String>>>> usuarioCurr = this.usuarios.find(new Par<>(usuario, null));
		return usuarioCurr == null ? null : usuarioCurr.getValue();
	}
	
	public void clear() {
		
		this.usuarios.clear();
	}
	
	@Override
	public String toString() {
		String result = "";
		
		
		for(Par<String, AVLTree<Par<String, ArrayList<String>>>> u : this.usuarios) {
			result += u.getKey() + ":\n";
			for(Par<String, ArrayList<String>> d : u.getValue()) {
				result += "\t" + d.getKey() + " -> " + d.getValue().toString() + "\n";
			}
		}
		return result;
	}
}