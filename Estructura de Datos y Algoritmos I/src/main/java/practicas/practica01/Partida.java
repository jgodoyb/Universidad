package practicas.practica01;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import practicas.practica01.Configuracion.TIPO_BARAJA;

public class Partida implements Iterable<Jugador> {
	private TIPO_BARAJA tipo;
	private LinkedList<Jugador> jugadores;
	private Baraja baraja;

	public Partida(String tipo, Jugador... jugadores) {
		try {
			this.tipo = TIPO_BARAJA.valueOf(tipo);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("Tipo no válido");
		}

		this.jugadores = new LinkedList<>();
		for (Jugador j : jugadores) {
			if (j.getOcupado()) {
				throw new RuntimeException("El jugador " + j.getId() + " ya pertenece a una partida");
			}
			j.setOcupado(true);
			this.jugadores.add(j);
		}
		this.baraja = new Baraja(tipo);

	}

	public int size() {
		return this.jugadores.size();
	}

	public void clear() {
		this.baraja.clear();
		this.jugadores.clear();
	}

	public boolean init(int numCartas) {
		if (this.baraja.size() == 0 || numCartas <= 0 || numCartas * jugadores.size() > this.baraja.size())
			return false;

		for (Jugador j : jugadores) {
			if (j.size() > 0) {
				return false;
			}
		}

		Random rnd = new Random();
		for (int i = 0, n = rnd.nextInt(1, 11); i < n; i++) {
			this.baraja.barajar();
			this.baraja.cortarBaraja(rnd.nextInt(1, this.baraja.size()));
		}

		Carta cartaRandom;
		for (Jugador j : this.jugadores) {
			for (int i = 0; i < numCartas; i++) {
				do {
					cartaRandom = baraja.getCarta(rnd.nextInt(baraja.size()));
				} while (cartaRandom.getRepartida());
				j.cogerCarta(cartaRandom);
			}
		}
		return true;
	}

	public int getNumCartas() {
		return this.baraja.size();
	}

	public int getNumCartasRepartidas() {
		int result = 0;
		for (Carta carta : this.baraja) {
			if (carta.getRepartida()) {
				result += 1;
			}
		}
		return result;
	}

	public Jugador getManoGanadora() {
		Carta cartaMayor = new Carta(this.tipo.toString(), this.tipo.getValores().get(0), this.tipo.getPalos().get(0));
		Jugador result = null;
		for (Jugador jugador : this.jugadores) {
			for (Carta carta : jugador) {
				if (carta.compareTo(cartaMayor) > 0) {
					cartaMayor = carta;
					result = jugador;
				}
			}
		}
		return result;
	}

	public void end() {
		for (Jugador jugador : this.jugadores) {
			for (Carta carta : jugador) {
				carta.setRepartida(false);
			}
			jugador.clear();
		}
	}

	@Override
	public String toString() {
		return "Partida con baraja " + this.tipo.toString() + ": " + this.jugadores.toString();
	}

	@Override
	public Iterator<Jugador> iterator() {
		return this.jugadores.iterator();
	}
}