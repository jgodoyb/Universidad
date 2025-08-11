package ual.eda2.practica01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParTest {

    @Test
    public void testConstructorWithParameters() {
        Punto p1 = new Punto(1, 2);
        Punto p2 = new Punto(3, 4);
        double distancia = 5.0;
        Par par = new Par(p1, p2, distancia);

        assertEquals(p1, par.getP1());
        assertEquals(p2, par.getP2());
        assertEquals(distancia, par.getDistancia());
    }

    @Test
    public void testDefaultConstructor() {
        Par par = new Par();

        assertNull(par.getP1());
        assertNull(par.getP2());
        assertEquals(Double.MAX_VALUE, par.getDistancia());
    }

    @Test
    public void testToStringWithValues() {
        Punto p1 = new Punto(1, 2);
        Punto p2 = new Punto(3, 4);
        double distancia = 5.0;
        Par par = new Par(p1, p2, distancia);

        String expected = "Par { " + p1 + ", " + p2 + ", distancia=" + Utilidades.format(distancia) + '}';
        assertEquals(expected, par.toString());
    }

    @Test
    public void testToStringWithNullValues() {
        Par par = new Par();

        assertEquals("Par vacio", par.toString());
    }
}