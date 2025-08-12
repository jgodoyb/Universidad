namespace PSS.jgb347.Practica_03
{
    [TestClass]
    public class TestTablero
    {
        [TestMethod]
        public void Constructor_SinParametros_NoNulo()
        {
            Tablero tablero = new Tablero();
            Assert.IsNotNull(tablero);
        }


        [TestMethod]
        public void Dimension_SinParametros_Es9()
        {
            Tablero tablero = new Tablero();
            bool resultado = tablero.Dimension == 9;

            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void Constructor_Dimension_EsIgual()
        {
            Tablero tablero = new Tablero(5);
            bool resultado = tablero.Dimension == 5;

            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void Indexador_FilaColumna_EsIgual()
        {
            Tablero tablero = new Tablero(9);
            Ficha ficha = new Ficha(ColorEnum.Blanco);
            tablero[1, 1] = ficha;
            bool resultado = tablero[1, 1].Color == ColorEnum.Blanco;

            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void PonerFichaPosicion_PongoFicha_EsIgualColor()
        {
            Tablero tablero = new Tablero(9);
            Ficha ficha = new Ficha(ColorEnum.Blanco);
            tablero.PonerFichaColumna(ficha, 0);
            bool resultado = tablero[8, 0].Color == ColorEnum.Blanco;

            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void Tablero_PonerFichaPosicionVacia_EsTrue()
        {
            Tablero tablero = new Tablero(9);
            Ficha ficha = new Ficha(ColorEnum.Blanco);
            bool resultado = tablero.PonerFichaColumna(ficha, 0);
            
            Assert.IsTrue(resultado);
        }
        

        [TestMethod]
        public void Tablero_PonerFichaPosicionFuera_EsFalse()
        {
            Tablero tablero = new Tablero(9);
            Ficha ficha = new Ficha(ColorEnum.Blanco);
            bool resultado = tablero.PonerFichaColumna(ficha, 40);

            Assert.IsFalse(resultado);
        }
        [TestMethod]
        public void NumeroCasillasOcupadas_TableroNuevo_Es0()
        {
            Tablero tablero = new Tablero(9);
            bool resultado = tablero.NumeroCasillasOcupadas == 0;

            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void NumeroCasillasOcupadas_Tablero1Ficha_Es1()
        {
            Tablero tablero = new Tablero(9);
            Ficha ficha = new Ficha(ColorEnum.Blanco);
            tablero.PonerFichaColumna(ficha, 0);
            bool resultado = tablero.NumeroCasillasOcupadas == 1;

            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void EsFinDeJuego_TableroVacio_False()
        {
            Tablero tablero = new Tablero(9);
            Assert.IsFalse(tablero.TableroLleno);
        }
        
    }
}