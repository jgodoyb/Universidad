namespace PSS.jgb347.Practica_03
{
    [TestClass]
    public class TestJuego
    {
        [TestCleanup]
        public void TestCleanup()
        {
            Jugador.NumeroJugadores = 0;
        }


        [TestMethod]
        public void Constructor_SinParametros_NoNulo()
        {
            Juego juego = new Juego(); 
            Assert.IsNotNull(juego);
        }


        [TestMethod]
        public void AnadirJugador_NombreJugador_NumeroJugadoresCorrecto()
        {
            Juego juego = new Juego();
            Jugador jugador = new Jugador("A");
            juego.AnadirJugador(jugador);
            bool resultado = juego.NumeroJugadores == 1;

            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void ObtenerJugador_NombreJugador_EsElMismo()
        {
            Juego juego = new Juego();
            Jugador jugador1 = new Jugador("A");
            juego.AnadirJugador(jugador1);
            Jugador jugadorDiccionario = juego.ObtenerJugador("A");
            bool resultado = jugadorDiccionario == jugador1;

            Assert.IsTrue(resultado);
        }


        [TestMethod]
        [ExpectedException(typeof(NombreJugadorDuplicadoException))]
        public void AnadirJugador_NombreJugadorExiste_SaltaException()
        {
            Juego juego = new Juego();
            Jugador jugador1 = new Jugador("A");
            juego.AnadirJugador(jugador1);
            Jugador jugador2 = new Jugador("A");
            juego.AnadirJugador(jugador2);

            Assert.Fail("No se ha lanzado la excepcion correspondiente");
        }


        [TestMethod]
        public void ObtenerJugador_IdJugador_EsElMismo()
        {
            
        Juego juegoID = new Juego();
            Jugador jugador = new Jugador("A");
            juegoID.AnadirJugador(jugador);
            Jugador jugadorObtenido = juegoID.ObtenerJugador(1);
            bool resultado = jugadorObtenido.Id == 1;

            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void ObtenerGanador_Horizontal_Jugador1()
        {
            Juego juego = new Juego();
            Jugador jugador = new Jugador("A");
            jugador.Ficha = new Ficha(ColorEnum.Blanco);
            juego.AnadirJugador(jugador);
            jugador.ColocarFichaColumna(juego.Tablero, 0);
            jugador.ColocarFichaColumna(juego.Tablero, 1);
            jugador.ColocarFichaColumna(juego.Tablero, 2);
            jugador.ColocarFichaColumna(juego.Tablero, 3);
            bool resultado = juego.ObtenerGanador(jugador);

            Assert.IsTrue(resultado);
        }
        

        [TestMethod]
        public void ObtenerGanador_DiagonalIzq_Jugador1()
        {
            Juego juego = new Juego();
            Jugador jugador = new Jugador("A");
            jugador.Ficha = new Ficha(ColorEnum.Blanco);
            juego.AnadirJugador(jugador);
            juego.Tablero[5, 3] = jugador.Ficha;
            juego.Tablero[6, 2] = jugador.Ficha;
            juego.Tablero[7, 1] = jugador.Ficha;
            juego.Tablero[8, 0] = jugador.Ficha;
            bool resultado = juego.ObtenerGanador(jugador);

            Assert.IsTrue(resultado);
        }
        
    }
}