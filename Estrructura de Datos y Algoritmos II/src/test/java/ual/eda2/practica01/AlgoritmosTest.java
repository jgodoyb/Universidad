package ual.eda2.practica01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AlgoritmosTest {

    @Test
    public void testFuerzaBrutaSimple() {
        Punto[] puntos = { new Punto(0, 0), new Punto(1, 1), new Punto(2, 2) };
        Par resultado = Algoritmos.fuerzaBrutaSimple(puntos);
        assertEquals(1.414, resultado.getDistancia(), 0.001);
    }

    @Test
    public void testFuerzaBrutaMejorado() {
        Punto[] puntos = { new Punto(0, 0), new Punto(1, 1), new Punto(2, 2) };
        Par resultado = Algoritmos.fuerzaBrutaMejorado(puntos);
        assertEquals(1.414, resultado.getDistancia(), 0.001);
    }

    @Test
    public void testDivideVencerasSimple() {
        Punto[] puntos = { new Punto(0, 0), new Punto(1, 1), new Punto(2, 2) };
        Par resultado = Algoritmos.divideVencerasSimple(puntos);
        assertEquals(1.414, resultado.getDistancia(), 0.001);
    }

    @Test
    public void testDivideVencerasMejorado() {
        Punto[] puntos = { new Punto(0, 0), new Punto(1, 1), new Punto(2, 2) };
        Par resultado = Algoritmos.divideVencerasMejorado(puntos);
        assertEquals(1.414, resultado.getDistancia(), 0.001);
    }

    @Test
    public void testDivideVencerasPro() {
        Punto[] puntos = { new Punto(0, 0), new Punto(1, 1), new Punto(2, 2) };
        Par resultado = Algoritmos.divideVencerasPro(puntos);
        assertEquals(1.414, resultado.getDistancia(), 0.001);
    }

    @Test
    public void testDivideVencerasUltra() {
        Punto[] puntos = { new Punto(0, 0), new Punto(1, 1), new Punto(2, 2) };
        Par resultado = Algoritmos.divideVencerasUltra(puntos);
        assertEquals(1.414, resultado.getDistancia(), 0.001);
    }

    @Test
    public void testFuerzaBrutaSimpleWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            Algoritmos.fuerzaBrutaSimple(null);
        });
    }

    @Test
    public void testFuerzaBrutaMejoradoWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            Algoritmos.fuerzaBrutaMejorado(null);
        });
    }

    @Test
    public void testDivideVencerasSimpleWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            Algoritmos.divideVencerasSimple(null);
        });
    }

    @Test
    public void testDivideVencerasMejoradoWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            Algoritmos.divideVencerasMejorado(null);
        });
    }

    @Test
    public void testDivideVencerasProWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            Algoritmos.divideVencerasPro(null);
        });
    }

    @Test
    public void testDivideVencerasUltraWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            Algoritmos.divideVencerasUltra(null);
        });
    }

    @Test
    public void testFuerzaBrutaSimpleWithLessThanTwoPoints() {
        Punto[] puntos = { new Punto(0, 0) };
        assertThrows(IllegalArgumentException.class, () -> {
            Algoritmos.fuerzaBrutaSimple(puntos);
        });
    }

    @Test
    public void testFuerzaBrutaMejoradoWithLessThanTwoPoints() {
        Punto[] puntos = { new Punto(0, 0) };
        assertThrows(IllegalArgumentException.class, () -> {
            Algoritmos.fuerzaBrutaMejorado(puntos);
        });
    }

    @Test
    public void testDivideVencerasSimpleWithLessThanTwoPoints() {
        Punto[] puntos = { new Punto(0, 0) };
        assertThrows(IllegalArgumentException.class, () -> {
            Algoritmos.divideVencerasSimple(puntos);
        });
    }

    @Test
    public void testDivideVencerasMejoradoWithLessThanTwoPoints() {
        Punto[] puntos = { new Punto(0, 0) };
        assertThrows(IllegalArgumentException.class, () -> {
            Algoritmos.divideVencerasMejorado(puntos);
        });
    }

    @Test
    public void testDivideVencerasProWithLessThanTwoPoints() {
        Punto[] puntos = { new Punto(0, 0) };
        assertThrows(IllegalArgumentException.class, () -> {
            Algoritmos.divideVencerasPro(puntos);
        });
    }

    @Test
    public void testDivideVencerasUltraWithLessThanTwoPoints() {
        Punto[] puntos = { new Punto(0, 0) };
        assertThrows(IllegalArgumentException.class, () -> {
            Algoritmos.divideVencerasUltra(puntos);
        });
    }
}