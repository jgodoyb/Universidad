namespace PSS.jgb347.Practica_03
{
    [TestClass]
    public class TestFicha
    {
        [TestMethod]
        public void Constructor_SinParametros_NoNulo()
        {
            Ficha ficha = new Ficha();
            Assert.IsNotNull(ficha);
        }

        [TestMethod]
        public void Constructor_SinParametros_ColorSinColor()
        {
            Ficha ficha = new Ficha();
            bool resultado = ficha.Color == ColorEnum.SinColor;
            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void Constructor_Color_EsCorrecto()
        {
            Ficha ficha = new Ficha(ColorEnum.Blanco);
            bool resultado = ficha.Color == ColorEnum.Blanco;
            Assert.IsTrue(resultado);
        }

    }
    
}