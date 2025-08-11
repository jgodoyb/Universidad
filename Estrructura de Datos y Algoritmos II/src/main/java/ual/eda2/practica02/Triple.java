package ual.eda2.practica02;

public class Triple<K, V extends Comparable<V>, T> implements Comparable<Triple<K, V, T>> {

    private K destino;
    private V peso;
    private T origen;

    public Triple(K destino, V peso, T origen) {
        this.destino = destino;
        this.peso = peso;
        this.origen = origen;
    }

    public K getDestino() {
        return this.destino;
    }

    public V getValor() {
        return this.peso;
    }

    public T getClave() {
        return origen;
    }

    public V setPeso(V peso) {
        V antiguo = this.peso;
        this.peso = peso;
        return antiguo;
    }

    @Override
    public int compareTo(Triple<K, V, T> other) {
        return this.peso.compareTo(other.peso);
    }
}
