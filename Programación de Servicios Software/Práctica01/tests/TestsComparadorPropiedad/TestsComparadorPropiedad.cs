using ComparadorPropiedad;
using PSS.jgb347_GodoyBeltranJorge.Practica_02;
namespace TestsComparadorPropiedad
{
    [TestClass]
    public class TestsComparadorPropiedad
    {
        [TestMethod]
        
        public void ComparadorPropiedadCategoria_DifferentObjectsSameCategoria_EsIgual()
        {
            UsuarioView user1 = new UsuarioView(2, "Juanjo", "xao", "Enfermero", true); //Se emplean los mismos ejemplos
            UsuarioView user2 = new UsuarioView(11, "Mar�a", "pasapalabra", "Enfermero", false);

            ComparadorPropiedad<UsuarioView> propiedad = new ComparadorPropiedad<UsuarioView>("Categoria");//Se creo una variable "propiedad" con la clase creada anteriormente
            int resultado = propiedad.Compare(user2, user1);//De esta manera esta hecha como ha explicado el profesor en pr�cticas
            Assert.IsTrue(resultado == 0);
        }


        [TestMethod]
        public void ComparadorPropiedadCategoria_ObjetosDiferentesCategoria_EsMayor_True()
        {

            UsuarioView user1 = new UsuarioView(6, "Juanjo", "xao", "Enfermero", true); 
            UsuarioView user2 = new UsuarioView(6, "Juanjo", "xao", "M�dico", false);

            ComparadorPropiedad<UsuarioView> propiedad = new ComparadorPropiedad<UsuarioView>("Categoria");
            int resultado = propiedad.Compare(user2, user1);
            Assert.IsTrue(resultado > 0);
            
        }


        [TestMethod]
        public void ComparadorPropiedadCategoria_ParametrosNullYOtro_EsMenor_True()
        {
            UsuarioView user1 = new UsuarioView(6, "Juanjo", "xao", "Enfermero", true);
            UsuarioView user2 = null;

            ComparadorPropiedad<UsuarioView> propiedad = new ComparadorPropiedad<UsuarioView>("Categoria");
            int resultado = propiedad.Compare(user2, user1);
            Assert.IsTrue(resultado < 0);

     
        }


        [TestMethod]
        public void ComparadorPropiedadCategoria_MismaReferencia_EsIgual_True()
        {
           
            UsuarioView user1 = new UsuarioView(6, "Juanjo", "xao", "Enfermero", true);
            UsuarioView user2 = user1;

            ComparadorPropiedad<UsuarioView> propiedad = new ComparadorPropiedad<UsuarioView>("Categoria");
            int resultado = propiedad.Compare(user2, user1);
            Assert.IsTrue(resultado == 0);
            
        }


    
        [TestMethod]
        public void ComparadorPropiedadEsValido_ObjectosDiferentesEsValido_EsMayor_True()
        {
            UsuarioView user1 = new UsuarioView(6, "Juanjo", "xao", "M�dico", true);
            UsuarioView user2 = new UsuarioView(6, "Juanjo", "xao", "Enfermero", false);

            ComparadorPropiedad<UsuarioView> propiedad = new ComparadorPropiedad<UsuarioView>("EsValido");
            int resultado = propiedad.Compare(user1, user2);
            Assert.IsTrue(resultado > 0);
            
        }


        [TestMethod]
        public void ComparadorPropiedadCategoria_ParametrosNull_EsIgual_True()
        {
            UsuarioView user1 = null;
            UsuarioView user2 = null;

            ComparadorPropiedad<UsuarioView> propiedad = new ComparadorPropiedad<UsuarioView>("Categoria");
            int resultado = propiedad.Compare(user2, user1);
            Assert.IsFalse(resultado == 0);

        }
        

        [TestMethod]
        [ExpectedException(typeof(System.ArgumentException))]//Esta l�nea de c�digo es par aindicar que se espera una excepci�n de tipo "ArgumentException"
        public void ComparadorPropiedadNoExistente_DifferentObjectsSameProperties_ArgumentException_Fail()
        {
          
            UsuarioView user1 = new UsuarioView(6, "Juanjo", "xao", "Enfermero", true);
            UsuarioView user2 = new UsuarioView(6, "Juanjo", "xao", "Enfermero", true);

            ComparadorPropiedad<UsuarioView> propiedad = new ComparadorPropiedad<UsuarioView>("botella");
            Assert.Fail("No se ha podido lanzar ninguna excepci�n");//Es nueva forma de finalizar un test  significa que no se ha lanzado la excepci�n esperada y, por lo tanto, el test debe fallar
        }



    }
}