package ual.eda2.practica01;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Punto otro = (Punto) obj;
        return (this.x == otro.x && this.y == otro.y);
    }

    @Override
    public String toString() {
        return "(" + "x=" + x + ", y=" + y + ')';
    }

}