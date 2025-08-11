package ual.eda2.practica02;

public class Par<K, V extends Comparable<V>> implements Comparable<Par<K, V>> {

    private final K clave;
    private V valor;
    //La k que pone clave es el Vertices, y la v que pone valor es el peso de la arista en double
    public Par(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return this.clave;
    }

    public V getValor() {
        return this.valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Par<K, V> other) {
        return this.valor.compareTo(other.valor);
    }
}
