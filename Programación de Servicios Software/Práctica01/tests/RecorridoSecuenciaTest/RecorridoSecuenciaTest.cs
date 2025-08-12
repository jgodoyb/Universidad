using Secuencia;
using PSS.jgb347_GodoyBeltranJorge.Practica_02;
using ComparadorPropiedad;
namespace RecorridoSecuenciaTest
{
    [TestClass]
    public class RecorridoSecuenciaTest
    {
        [TestMethod]
        public void RecorridoAdelante_ObjectosNoNull_OrdenDeEntrada()//Devuelve los elementos en el mismo orden que otra secuencia llamada SecuenciaModificada
        {
            //Primero creamos usuarios para crear para que más adelante odamos ahcer secuencias
            UsuarioView user1 = new UsuarioView(9536954, "María", "Palabra", "Enfermero", true);
            UsuarioView user2 = new UsuarioView(9876543, "Juanjo", "Palabra", "Enfermero", true);
            UsuarioView user3 = new UsuarioView(6666666, "Jorge", "Palabra", "Enfermero", true); 

            //Hacemos un par de secuncias, una funcionando como la original mientras que la otra es la que se piensa modificar
            Secuencia<UsuarioView> SecuenciaOriginal = new Secuencia<UsuarioView>() {
                user2,
                user3,
                user1
            };

            Secuencia<UsuarioView> SecuenciaModificada = new Secuencia<UsuarioView>() {
                user2,
                user3,
                user1
            };

            //Creamos una tercera secuencia
            Secuencia<UsuarioView> secuenciaFinal = new Secuencia<UsuarioView>();
            foreach (UsuarioView user in SecuenciaOriginal.RecorridoAdelante())
            {
                secuenciaFinal.Añadir(user);
            }
            CollectionAssert.AreEqual(SecuenciaModificada, secuenciaFinal);//El collection sirve para poder comparar dos colecciones
        }


        [TestMethod]
        public void RecorridoAscendente_ObjectosNoNull_OrdenAscendente()
        {
            UsuarioView user1 = new UsuarioView(8, "Maria", "Palabra", "Enfermero", true);
            UsuarioView user2 = new UsuarioView(6, "Juanjo", "Palabra", "Enfermero", true);
            UsuarioView user3 = new UsuarioView(50, "Jorge", "Palabra", "Enfermero", true);
            UsuarioView user4 = new UsuarioView(7, "Lucía", "Palabra", "Enfermero", true);

            Secuencia<UsuarioView> SecuenciaOriginal = new Secuencia<UsuarioView>() {
                user4,
                user2,
                user3,
                user1
            };

            Secuencia<UsuarioView> SecuenciaModificada = new Secuencia<UsuarioView>() {
                user3,
                user2,
                user4,
                user1
            };

            Secuencia<UsuarioView> secuenciaFinal = new Secuencia<UsuarioView>();
            ComparadorPropiedad<UsuarioView> comparador = new ComparadorPropiedad<UsuarioView>("Id");
            foreach (UsuarioView user in SecuenciaOriginal.RecorridoAscendente(comparador))
            {
                secuenciaFinal.Añadir(user);
            }
            CollectionAssert.AreEqual(SecuenciaModificada, secuenciaFinal);
        }


        [TestMethod]
        public void RecorridoAtras_ObjectosNoNull_ReverseOrder()
        {
            UsuarioView user1 = new UsuarioView(12, "Maria", "Palabra", "Enfermero", true);
            UsuarioView user2 = new UsuarioView(1, "Juanjo", "Palabra", "Enfermero", true);
            UsuarioView user3 = new UsuarioView(25, "Jorge", "Palabra", "Enfermero", true);
            UsuarioView user4 = new UsuarioView(5, "Lucía", "Palabra", "Enfermero", true);
            
            Secuencia<UsuarioView> SecuenciaOriginal = new Secuencia<UsuarioView>() {
                user1,
                user3,
                user2,
                user4
            };

            Secuencia<UsuarioView> SecuenciaModificada = new Secuencia<UsuarioView>() {
                user4,
                user2,
                user3,
                user1
            };

            Secuencia<UsuarioView> secuenciaFinal = new Secuencia<UsuarioView>();
            foreach (UsuarioView user in SecuenciaOriginal.RecorridoAtras())
            {
                secuenciaFinal.Añadir(user);
            }
            CollectionAssert.AreEqual(SecuenciaModificada, secuenciaFinal);
        }


        [TestMethod]
        public void RecorridoDescendente_ObjectosNoNull_OrdenDescendente()
        {
            UsuarioView user1 = new UsuarioView(8, "Maria", "Palabra", "Enfermero", true);
            UsuarioView user2 = new UsuarioView(6, "Juanjo", "Palabra", "Enfermero", true);
            UsuarioView user3 = new UsuarioView(50, "Jorge", "Palabra", "Enfermero", true);
            UsuarioView user4 = new UsuarioView(7, "Lucía", "Palabra", "Enfermero", true);

            Secuencia<UsuarioView> SecuenciaOriginal = new Secuencia<UsuarioView>() {
                user3,
                user1,
                user4,
                user2
                };

            Secuencia<UsuarioView> SecuenciaModificada= new Secuencia<UsuarioView>() {
                user1,
                user4,
                user2,
                user3
            };

            Secuencia<UsuarioView> secuenciaFinal = new Secuencia<UsuarioView>();
            ComparadorPropiedad<UsuarioView> comparador = new ComparadorPropiedad<UsuarioView>("Id");

            foreach (UsuarioView user in SecuenciaOriginal.RecorridoDescendente(comparador))
            {
                secuenciaFinal.Añadir(user);
            }
            CollectionAssert.AreEqual(SecuenciaModificada, secuenciaFinal);
        }


        [TestMethod]
        public void RecorridoAscendente_ObjectosNullyOtros_OrdenAscendente()
        {
         
            UsuarioView user1 = new UsuarioView(8, "Maria", "Palabra", "Enfermero3", true);
            UsuarioView user2 = new UsuarioView(6, "Juanjo", "Palabra", "Enfermero2", true);
            UsuarioView user3 = new UsuarioView(50, "Jorge", "Palabra", "Enfermero1", true);
            UsuarioView user4 = null;

            Secuencia<UsuarioView> SecuenciaOriginal = new Secuencia<UsuarioView>() {
                user3,
                user1,
                user4,
                user2
            };

            Secuencia<UsuarioView> SecuenciaModificada = new Secuencia<UsuarioView>() {
                user4,
                user3,
                user2,
                user1
            };

            Secuencia<UsuarioView> secuenciaFinal = new Secuencia<UsuarioView>();
            ComparadorPropiedad<UsuarioView> comparador = new ComparadorPropiedad<UsuarioView>("Categoria");
            foreach (UsuarioView user in SecuenciaOriginal.RecorridoAscendente(comparador))
            {
                secuenciaFinal.Añadir(user);
            }
            CollectionAssert.AreEqual(SecuenciaModificada, secuenciaFinal);
        }


        [TestMethod]
        public void RecorridoDescendente_ObjectosNullyOtros_OrdenDescendente()
        {
            UsuarioView user1 = new UsuarioView(8, "Maria", "Palabra", "Enfermero", true);
            UsuarioView user2 = new UsuarioView(6, "Juanjo", "Palabra", "Enfermero", true);
            UsuarioView user3 = new UsuarioView(50, "Jorge", "Palabra", "Enfermero", true);
            UsuarioView user4 = null;

            Secuencia<UsuarioView> SecuenciaOriginal = new Secuencia<UsuarioView>() {

                user2,
                user4,
                user1,
                user3
            };

            Secuencia<UsuarioView> SecuenciaModificada = new Secuencia<UsuarioView>() {
                user1,
                user2,
                user3,
                user4
            };

            Secuencia<UsuarioView> secuenciaFinal = new Secuencia<UsuarioView>();
            ComparadorPropiedad<UsuarioView> comparador = new ComparadorPropiedad<UsuarioView>("Id");
            foreach (UsuarioView user in SecuenciaOriginal.RecorridoDescendente(comparador))
            {
                secuenciaFinal.Añadir(user);
            }
            CollectionAssert.AreEqual(SecuenciaModificada, secuenciaFinal);
        }


        [TestMethod]
        public void RecorridoAtras_ObjectosNullyOtros_ReverseOrder()
        {
            UsuarioView user1 = new UsuarioView(8, "Maria", "Palabra", "Enfermero3", true);
            UsuarioView user2 = new UsuarioView(6, "Juanjo", "Palabra", "Enfermero2", true);
            UsuarioView user3 = new UsuarioView(50, "Jorge", "Palabra", "Enfermero1", true);
            UsuarioView user4 = null;
            Secuencia<UsuarioView> SecuenciaOriginal = new Secuencia<UsuarioView>() {
                user1,
                user3,
                user4,
                user2
            };

            Secuencia<UsuarioView> SecuenciaModificada = new Secuencia<UsuarioView>() {
                user2,
                user4,
                user3,
                user1
            };

            Secuencia<UsuarioView> secuenciaFinal = new Secuencia<UsuarioView>();
            foreach (UsuarioView user in SecuenciaOriginal.RecorridoAtras())
            {
                secuenciaFinal.Añadir(user);
            }
            CollectionAssert.AreEqual(SecuenciaModificada, secuenciaFinal);
        }


        [TestMethod]
        public void RecorridoAdelante_ObjectosNullyOtros_OrdenDeEntrada()
        {
            UsuarioView user1 = new UsuarioView(8, "Maria", "Palabra", "Enfermero3", true);
            UsuarioView user2 = new UsuarioView(6, "Juanjo", "Palabra", "Enfermero2", true);
            UsuarioView user3 = new UsuarioView(50, "Jorge", "Palabra", "Enfermero1", true);
            UsuarioView user4 = null;

            Secuencia<UsuarioView> SecuenciaOriginal = new Secuencia<UsuarioView>() {
                user4,
                user2,
                user1,
                user3
            };
            Secuencia<UsuarioView> SecuenciaModificada = new Secuencia<UsuarioView>() {
                user4,
                user2,
                user1,
                user3
            };

            Secuencia<UsuarioView> secuenciaFinal = new Secuencia<UsuarioView>();
            foreach (UsuarioView user in SecuenciaOriginal.RecorridoAdelante())
            {
                secuenciaFinal.Añadir(user);
            }
            CollectionAssert.AreEqual(SecuenciaModificada, secuenciaFinal);
        }
    }
}
