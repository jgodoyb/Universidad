package ual.eda2.practica02;

import java.util.Iterator;
import java.util.HashMap;
import java.util.HashSet;

public class Network<V> implements Iterable<Vertice> {

	private boolean directed; // directed = false (unDirected), directed = true (DiGraph)

	protected HashMap<Vertice, HashMap<Vertice, Double>> adjacencyMap;

	public Network() {
		this.directed = false;
		this.adjacencyMap = new HashMap<Vertice, HashMap<Vertice, Double>>();
	}

	public void setDirected(boolean uD_Or_D) {
		this.directed = uD_Or_D;
	}

	public boolean getDirected() {
		return this.directed;
	}

	public boolean isEmpty() {
		return this.adjacencyMap.isEmpty();
	}

	public void clear() {
		this.adjacencyMap.clear();
	}

	public int numberOfVertices() {
		return this.adjacencyMap.size();
	}

	public int numberOfEdges() {
		int count = 0;
		for (HashMap<Vertice, Double> itMap : this.adjacencyMap.values())
			count += itMap.size();
		return count;
	}

	public boolean containsVertice(Vertice vertice) {
		return this.adjacencyMap.containsKey(vertice);
	}

	public boolean containsEdge(Vertice v1, Vertice v2) {
		HashMap<Vertice, Double> neighbors = this.adjacencyMap.get(v1);
		if (neighbors == null)
			return false;
		return neighbors.containsKey(v2);
	}

	public double getWeight(Vertice v1, Vertice v2) {
		HashMap<Vertice, Double> neighbors = this.adjacencyMap.get(v1);
		if (neighbors == null)
			return -1;
		Double weight = neighbors.get(v2);
		return weight == null ? -1 : weight;
	}

	public boolean isAdjacent(Vertice v1, Vertice v2) {
		HashMap<Vertice, Double> neighbors = this.adjacencyMap.get(v1);
		return neighbors == null ? false : neighbors.containsKey(v2);
	}

	public boolean addVertice(Vertice vertice) {
		if (this.adjacencyMap.containsKey(vertice))
			return false;
		this.adjacencyMap.put(vertice, new HashMap<Vertice, Double>());
		return true;
	}

	public boolean addEdge(Vertice v1, Vertice v2, double w) {
		if (!containsVertice(v1) || !containsVertice(v2))
			return false;
		this.adjacencyMap.get(v1).put(v2, w);
		if (!this.directed) {
			this.adjacencyMap.get(v2).put(v1, w);
		}
		return true;
	}

	public void addEdge(String v1, String v2, double w) {
		Vertice vertice1 = null;
		Vertice vertice2 = null;
		for (Vertice v : this.adjacencyMap.keySet()) {
			if (v.toString().equals(v1))
				vertice1 = v;
			if (v.toString().equals(v2))
				vertice2 = v;
		}
		addEdge(vertice1, vertice2, w);
	}

	public boolean removeVertice(Vertice vertice) {
		if (!containsVertice(vertice))
			return false;
		for (HashMap<Vertice, Double> itMap : this.adjacencyMap.values()) {
			itMap.remove(vertice);
		}
		this.adjacencyMap.remove(vertice);
		return true;
	}

	public boolean removeEdge(Vertice v1, Vertice v2) {
		if (!containsEdge(v1, v2))
			return false;
		this.adjacencyMap.get(v1).remove(v2);
		if (!this.directed) {
			this.adjacencyMap.get(v2).remove(v1);
		}
		return true;
	}

	public int size() {
		int count = 0;
		for (HashMap<Vertice, Double> itMap : this.adjacencyMap.values())
			count += itMap.size();
		return count;
	}

	public HashSet<Vertice> verticeSet() {
		return new HashSet<Vertice>(this.adjacencyMap.keySet());
	}

	public HashSet<Vertice> getNeighbors(Vertice v) {
		HashMap<Vertice, Double> neighbors = this.adjacencyMap.get(v);
		return (neighbors == null) ? new HashSet<>() : new HashSet<>(neighbors.keySet());
	}

	@Override
	public String toString() {
		return this.adjacencyMap.toString();
	}

	@Override
	public Iterator<Vertice> iterator() {
		return this.adjacencyMap.keySet().iterator();
	}

}