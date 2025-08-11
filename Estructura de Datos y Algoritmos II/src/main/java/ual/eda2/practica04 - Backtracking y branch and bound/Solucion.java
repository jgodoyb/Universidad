package ual.eda2.practica04;

import java.util.Arrays;

public class Solucion {

    private int[] soa;
    private double voa;

    public Solucion(int n) {
        this.soa = new int[n];
        Arrays.fill(soa, -1);
        this.voa = 0;
    }

    public double getVoA() {
        return voa;
    }

    public void setVoA(double voa) {
        this.voa = voa;
    }

    public int[] getSoa() {
        return soa;
    }

    public void setSoa(int[] soa) {
        this.soa = soa.clone();
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < soa.length; i++) {
            s += "Director " + (i + 1) + " -> Tarea " + (soa[i] + 1) + "\n";
        }
        s += "Valor optimo: " + voa;
        return s;
    }
}
