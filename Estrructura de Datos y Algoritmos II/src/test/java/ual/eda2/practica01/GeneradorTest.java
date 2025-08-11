package ual.eda2.practica01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GeneradorTest {

    @Test
    public void testEjecutarGaussiana() {
        String input = "1\n10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Generador generador = new Generador();
        Punto[] puntos = generador.ejecutar();

        assertNotNull(puntos);
        assertEquals(10, puntos.length);
    }

    @Test
    public void testEjecutarUniforme() {
        String input = "2\n10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Generador generador = new Generador();
        Punto[] puntos = generador.ejecutar();

        assertNotNull(puntos);
        assertEquals(10, puntos.length);
    }

    @Test
    public void testEjecutarExponencial() {
        String input = "3\n10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Generador generador = new Generador();
        Punto[] puntos = generador.ejecutar();

        assertNotNull(puntos);
        assertEquals(10, puntos.length);
    }

    @Test
    public void testEjecutarCantidadInvalida() {
        String input = "1\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Generador generador = new Generador();
        Punto[] puntos = generador.ejecutar();

        assertNull(puntos);
    }

    @Test
    public void testEjecutarOpcionInvalida() {
        String input = "4\n10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Generador generador = new Generador();
        Punto[] puntos = generador.ejecutar();

        assertNotNull(puntos);
        assertEquals(10, puntos.length);
    }
}