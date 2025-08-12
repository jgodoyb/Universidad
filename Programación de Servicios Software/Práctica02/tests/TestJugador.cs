namespace PSS.jgb347.Practica_03
{
    [TestClass]
    public class TestJugador
    {
        [TestMethod]
        public void Constructor_SinParametros_NoNulo()
        {
            Jugador jugador = new Jugador();
            Assert.IsNotNull(jugador);
        }


        [TestMethod]
        public void Constructor_Nombre_EsIgual()
        {
            Jugador jugador = new Jugador("Nombre");
            bool resultado = jugador.Nombre == "Nombre";

            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void Constructor_SinParametros_NombreNumerado()
        {
            Jugador jugador = new Jugador();
            bool resultado = jugador.Nombre == "Jugador" + Jugador.NumeroJugadores.ToString();

            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void Ficha_ColorBlanco_ColorEsIgual()
        {
            Jugador jugador = new Jugador();
            jugador.Ficha = new Ficha(ColorEnum.Blanco);
            bool resultado = jugador.Ficha.Color == ColorEnum.Blanco;

            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void ColocarFichaPosicion_Valida_EsTrue()
        {
            Jugador jugador = new Jugador();
            jugador.Ficha = new Ficha(ColorEnum.Blanco);
            Tablero tablero = new Tablero();
            bool resultado = jugador.ColocarFichaColumna(tablero, 0);

            Assert.IsTrue(resultado);
        }



        [TestMethod]
        public void ColocarFichaPosicion_Fuera_EsFalse()
        {
            Jugador jugador = new Jugador();
            jugador.Ficha = new Ficha(ColorEnum.Blanco);
            Tablero tablero = new Tablero();
            bool resultado = jugador.ColocarFichaColumna(tablero, 40);

            Assert.IsFalse(resultado);
        }


        [TestMethod]
        [ExpectedException(typeof(Jugador.JugadorSinFichaException))]
        public void Ficha_NoAsignada_Excepcion()
        {
            Jugador jugador = new Jugador();
            bool resultado = jugador.Ficha.Color == ColorEnum.Blanco;

            Assert.Fail("Se esperaba una excepcion de jugador sin ficha");
        }

    }
}