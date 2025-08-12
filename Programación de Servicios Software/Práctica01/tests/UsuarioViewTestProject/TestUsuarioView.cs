
using PSS.jgb347_GodoyBeltranJorge.Practica_02;


namespace TestUsuarioView
{
    [TestClass]
    public class TestUsuarioView
    {
        //Para empezar con los tests, se va acomprobar el comportamiento de los equals en diferentes situaciones

        //Comparar Objetos con id diferente x
        [TestMethod]
        public void EqualsIEquality_ObjetosConIdDistinto_False()
        {
            UsuarioView usuario1 = new UsuarioView(7, "Juanjo", "xao", "Enfermero", true);
            UsuarioView usuario2 = new UsuarioView(1, "María", "pasapalabra", "Médica", false);
            bool resulto = Equals(usuario1, usuario2);//Es mejor de esta forma, cambiar esto en todo
            Assert.IsFalse(resulto);

        }

        //Comparar objetos con id igual pero los demás es diferente x
        [TestMethod]
        public void EqualsIEquality_diferentesAtributosIdIgual_True()
        {
            UsuarioView user1 = new UsuarioView(4, "Juanjo", "xao", "Enfermero", true);
            UsuarioView user2 = new UsuarioView(4, "María", "pasapalabra", "Médica", false);
            bool resuelto = Equals(user1, user2);
            Assert.IsTrue(resuelto);
        }


        //Método qpara comparar dos objetos iguales x
        [TestMethod]
        public void EqualsIEquality_ReferenciasIguales_True()
        {
            UsuarioView user1 = new UsuarioView(4, "Juanjo", "xao", "enfermero", true);
            UsuarioView user2 = user1;
            bool resultado = Equals(user1, user2);
            Assert.IsTrue(resultado);

        }


        //Método para comparar un obejto con otro null x
        [TestMethod]
        public void EqualsIEquality_objetoConNull_False()
        {
            UsuarioView user1 = new UsuarioView(4, "María", "pasapalabra", "Médica", true);
            UsuarioView user2 = null;
            bool resultado = Equals(user1, user2);
            Assert.IsFalse(resultado);
        }


        //Dos objetos null 
        [TestMethod]
        public void EqualsIEquality_TodoNull_True()
        {
            UsuarioView user1 = null;
            UsuarioView user2 = null;
            bool resultado = Equals(user1, user2);
            Assert.IsTrue(resultado);
        }




        //Ahora se van a comprobar otros comportamientos del equals con objects
        //Metodo que sirve para comparar dos objetos con id diferentes
        [TestMethod]
        public void EqualsObject_ObjectsDifferentId_False()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(3, "Juanjo", "xao", "Enfermero", true);
            Assert.IsFalse(user1.Equals(user2 as object));

        }


        //Metodo que sirve para comparar dos objetos con a misma id
        [TestMethod]
        public void EqualsObject_DiferenteObjetosMismaId_True()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(1, "Juanjo", "xao", "Enfermero", true);
            Assert.AreEqual(true, user1.Equals(user2 as object));
        }


        //Método para comparar dos objetos que son los mismos, esperando un true
        [TestMethod]
        public void EqualsObject_MismoObjeto_True()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = user1;
            Assert.AreEqual(true, user1.Equals(user2 as object));
        }


        //Método para comparar un objeto con un null
        [TestMethod]
        public void EqualsObject_ParametrosNullYOtro_False()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = null;
            Assert.IsFalse(user1.Equals(user2 as object));
        }



        /*En el siguietne apartado se comprueba el comportamineto del método equals pero ahora con el la interfaz IEquatable<T>,
        por lo tanto los tests serán muy similares a los del apartado anterior, pero cambiando ciertos matices
        Para seguir con un orden, van en el mism oorden, comprobando lo mismo pero con otra interfaz*/



        [TestMethod]
        public void EqualsObject_ObjetosDiferentestId_False2()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(3, "Juanjo", "xao", "Enfermero", true);
            bool resultado = Equals(user1, user2);
            Assert.IsFalse(resultado);
        }


        [TestMethod]
        public void EqualsObject_DiferenteObjetosMismaId_True2()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(1, "Juanjo", "xao", "Enfermero", true);
            bool resultado = Equals(user1, user2);
            Assert.IsTrue(resultado);
        }


        [TestMethod]
        public void EqualsObject_MismoObjeto_True2()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = user1;
            bool resultado = Equals(user1, user2);
            Assert.IsTrue(resultado);

        }


        [TestMethod]
        public void EqualsObject_ParametrosNullYOtro_False2()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = null;
            bool resultado = Equals(user1, user2);
            Assert.IsFalse(resultado);

        }



        /*Los test del equals ya estan comporbados todos en los diferentes casos, ahora es hora de verificar el funcionamineto
        de los operadores "==" y el de "!=", en cual habra 5 métodos para cada uno y que serán muy similares, entre el bloque de 
        "==" y el los de "!="
        
        Empezaré con los de "!=" y siguiendo u norden similar a los anteriores tests para buscar una homogeneidad*/

        [TestMethod]
        public void OperadorDistintoDe_ObjetosDiferentesId_True()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(3, "Juanjo", "xao", "Enfermero", true);
            Assert.AreEqual(true, user1 != user2);
        }

        //Ambos objetos son nulos por lo que son iguales, saliendo una salida false
        [TestMethod]
        public void OperadorDistintoDe_ObjetosNull_False()
        {
            UsuarioView user1 = null;
            UsuarioView user2 = null;
            Assert.AreEqual(false, user1 != user2);
        }


        //Un test para un obejto que tiene id pero si parámetros y otro null
        [TestMethod]
        public void OperadorDistintoDe_parametrosNullyNull_True()
        {
            UsuarioView user1 = new UsuarioView(1, "", "", "", false);
            UsuarioView user2 = null;
            Assert.AreEqual(true, user1 != user2);
        }

        //Un test para dos objetos que tienen la misma id, y parametros null, considerandose iguales pero al igualarse debe salir false
        [TestMethod]
        public void OperadorDistintoDe_ObjetosDiferentesIdMisma_False()
        {
            UsuarioView user1 = new UsuarioView(1, "", "", "", false);
            UsuarioView user2 = new UsuarioView(1, "", "", "", false);
            Assert.AreEqual(false, user1 != user2);
        }

        //Un tests parecido al enterior pero directamente el segundo objeto se crea a partir del primero y debe salir tambien false
        [TestMethod]
        public void OperadorDistintoDe_MismoObjeto_False()
        {
            UsuarioView user1 = new UsuarioView(9, "", "", "", false);
            UsuarioView user2 = user1;
            Assert.AreEqual(false, user1 != user2);
        }




        /* Como se ha mencionado anteriormente, ahroa tocan los tests del operador == que serán practicamente iguales pero teniendo ciertas
        nociones en cuenta*/

        [TestMethod]
        public void OperadorIgualQue_ObjetosDiferentesId_False()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(3, "Juanjo", "xao", "Enfermero", true);
            Assert.AreEqual(false, user1 == user2);
        }


        [TestMethod]
        public void OperadorIgualQue_ObjetosNull_True()
        {
            UsuarioView user1 = null;
            UsuarioView user2 = null;
            Assert.AreEqual(true, user1 == user2);
        }


        [TestMethod]
        public void OperadorIgualQue_ObjetoConUnNull_False()
        {
            UsuarioView user1 = new UsuarioView(1, "Javi", "paso", "Informatica", false);
            UsuarioView user2 = null;
            Assert.AreEqual(false, user2 == user1);
        }


        [TestMethod]
        public void OperadorIgualQue_ObjetosDiferentesIdIgual_True()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(1, "Juanjo", "xao", "Enfermero", true);
            Assert.AreEqual(true, user1 == user2);
        }


        [TestMethod]
        public void OperadorIgualQue_MismoObjeto_True()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = user1;
            Assert.AreEqual(true, user1 == user2);
        }


        /*Los test de la parte de los operadores ya estan hecho, ahroa falta los del hasCode que son los 2 siguientes y son un poco mas complejos que los anteriores*/

        [TestMethod]
        public void GetHashCode_ObjetosConParametros_true()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(1, "Juanjo", "xao", "Enfermero", true);
            Assert.AreEqual(user1.GetHashCode(), user1.GetHashCode(user2));
        }

        [TestMethod]
        public void GetHashCode_ObjetosConParametros_False()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(1, "Juanjo", "xao", "Enfermero", true);
            UsuarioView user3 = new UsuarioView(5, "Alex", "camara", "Derecho", false);
            UsuarioView user4 = new UsuarioView(5, "Elena", "telefono", "informatica", true);
            Assert.AreNotEqual(user1.GetHashCode(), user1.GetHashCode(user3));
            Assert.AreNotEqual(user2.GetHashCode(), user2.GetHashCode(user3));
        }



        /*Hasta aqui son los test de la primera parte, ahora es necesrio hacer la parte de los tests de la segunda parte que trata 
        de la Interfaz IComparable<T> */

        //Se seguirá un patrón al igual que la parte anterior y asi seguir un orden

        [TestMethod]
        public void CompareTo_DifferentObjectsSameId_Iguales()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(1, "Juanjo", "xao", "Enfermero", true);
            int resultado = user1.CompareTo(user2);//Empleado el modo del profesor, de esta manera es más practica porque se puede ir comprobando el relultado de esta comparación y saber posibles fallos
            Assert.AreEqual(0, resultado);
        }

        [TestMethod]
        public void CompareTo_MismaReferencia_Iguales()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = user1;
            int resultado = user1.CompareTo(user2);
            Assert.AreEqual(0, resultado);
        }


        [TestMethod]
        public void CompareTo_ParametrosNullyOtro_EsMenor_True()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = null;
            int resutlado = user1.CompareTo(user2);
            Assert.IsTrue(resutlado > 0);
        }

        public void CompareTo_ObjectsDiferenteId_EsMenor_True()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(3, "Juanjo", "xao", "Enfermero", true);
            int resutlado = user1.CompareTo(user2);
            Assert.IsTrue(resutlado < 0);
        }


        //A continuación hay que hacer una serie de test para ver en los diferntes casos de <, menor o igual, > o mayor o igual, en el cual serán muy parcidos los tests.
        //Primero están escritos los de mayor ">"

        [TestMethod]
        public void OperadorMayorQue_ParametrosNullYOtro_EsMayor_True()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = null;
            Assert.IsTrue(user1 > user2);
        }


        [TestMethod]
        public void OperadorMayorQue_ObjectosDiferentesId_EsMayor_True()
        {
            UsuarioView user1 = new UsuarioView(13, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(4, "Junjo", "pasapalabra", "Médica", false);
            Assert.IsTrue(user2 > user1);
        }


        [TestMethod]
        public void OperadorMayorQue_ParametrosNull_False()
        {
            UsuarioView user1 = null;
            UsuarioView user2 = null;
            Assert.IsFalse(user2 > user1);
        }

        [TestMethod]
        public void OperadorMayorQue_MismaReferencia_False()
        {
            UsuarioView user1 = new UsuarioView(12, "Juanjo", "xao", "Enfermero", false);
            UsuarioView user2 = user1;
            Assert.IsFalse(user2 > user1);
        }


        [TestMethod]
        public void OperadorMayorQue_DiferenteObjetoMismaId_False()
        {
            UsuarioView user1 = new UsuarioView(12, "Juanjo", "xao", "Enfermero", false);
            UsuarioView user2 = new UsuarioView(12, "Juanjo", "xao", "Enfermero", false);
            Assert.IsFalse(user2 > user1);
        }


        //Una vez que estan hechos los test de mayor que, se harán los de menor que "<" , que como se verá a continuación, tendrán una estructura muy similar 


        [TestMethod]
        public void OperadorMenorQue_ParametrosNullYOtro_EsMenor_True()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = null;
            Assert.IsTrue(user2 < user1);
        }


        [TestMethod]
        public void OperadorMenorQue_ObjetosDiferentesId_EsMenor_True()
        {
            UsuarioView user1 = new UsuarioView(4, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = new UsuarioView(13, "Junjo", "pasapalabra", "Médica", true);
            Assert.IsTrue(user2 < user1);
        }


        [TestMethod]
        public void OperadorMenorQue_ParametrosNull_False()
        {
            UsuarioView user1 = null;
            UsuarioView user2 = null;
            Assert.IsFalse(user2 < user1);
        }


        [TestMethod]
        public void OperadorMenorQue_MismaReferencia_False()
        {
            UsuarioView user1 = new UsuarioView(12, "Juanjo", "xao", "Enfermero", false);
            UsuarioView user2 = user1;
            Assert.IsFalse(user2 < user1);
        }

        [TestMethod]
        public void OperadorMenorQue_DiferentesObjectosSameId_False()
        {
            UsuarioView user1 = new UsuarioView(12, "Juanjo", "xao", "Enfermero", false);
            UsuarioView user2 = new UsuarioView(12, "Juanjo", "xao", "Enfermero", false);
            Assert.IsFalse(user1 < user2);
        }

        //Ya estan hechos los test que comprueban los operador "<" y ">", ahora es necesario hacer algo muy similar ya que hay que hacerlo con el ">=" y el "<="
        //Primero se hara el de ">="


        [TestMethod]
        public void OperadorMayorIgualQue_ParametrosNullYOtro_EsMayor_True()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = null;
            Assert.IsTrue(user1 >= user2);
        }


        [TestMethod]
        public void OperadorMayorIgualQue_ObjetosDiferentesId_EsMayor_True()
        {
            UsuarioView user1 = new UsuarioView(13, "Maria", "pasapalabra", "Médica", true);
            UsuarioView user2 = new UsuarioView(4, "Junjo", "pasapalabra", "Médica", false);
            Assert.IsTrue(user2 >= user1);
        }


        [TestMethod]
        public void OperadorMayorIgualQue_ParametrosNull_EsIgual_True()
        {
            UsuarioView user1 = null;
            UsuarioView user2 = null;
            Assert.IsTrue(user1 >= user2);
        }


        [TestMethod]
        public void OperadorMayorIgualQue_MismaReferencia_EsIgual_False()
        {
            UsuarioView user1 = new UsuarioView(12, "Juanjo", "xao", "Enfermero", true);
            UsuarioView user2 = user1;
            Assert.IsTrue(user2 >= user1);

        }


        [TestMethod]
        public void OperadorMayorIgualQue_DiferenteObjectosSameId_EsIgual_True()
        {
            UsuarioView user1 = new UsuarioView(12, "Juanjo", "xao", "Enfermero", true);
            UsuarioView user2 = new UsuarioView(12, "Juanjo", "xao", "Enfermero", false);
            Assert.IsTrue(user2 >= user1);
        }


        //Por última parte, es necesario hacer el operador de "<=", que al igual que el caso anterior, pero con el operador que toca.

        [TestMethod]
        public void OperadorMenorIgualQue_ParametrosNullYOtro_EsMenor_True()
        {
            UsuarioView user1 = new UsuarioView(1, "Maria", "pasapalabra", "Médica", false);
            UsuarioView user2 = null;
            Assert.IsTrue(user2 <= user1);
        }


        [TestMethod]
        public void OperadorMenorIgualQue_DiferenteObjectoSameId_EsIgual_True()
        {
            UsuarioView user1 = new UsuarioView(12, "Juanjo", "xao", "Enfermero", false);
            UsuarioView user2 = new UsuarioView(12, "Juanjo", "xao", "Enfermero", false);
            Assert.IsTrue(user1 <= user2);
        }


        [TestMethod]
        public void OperadorMenorIgualQue_MismaReferencia_EsIgual_True()
        {
            UsuarioView user1 = new UsuarioView(12, "Juanjo", "xao", "Enfermero", true);
            UsuarioView user2 = user1;
            Assert.IsTrue(user1 <= user2);
        }


        [TestMethod]
        public void OperadorMenorIgualQue_ParametrosNull_EsIgual_True()
        {
            UsuarioView user1 = null;
            UsuarioView user2 = null;
            Assert.IsTrue(user1 <= user2);
        }


        [TestMethod]
        public void OperadorMenorIgualQue_ObjectsDifferentId_EsMenor_True()
        {
            UsuarioView user1 = new UsuarioView(13, "Maria", "pasapalabra", "Médica", true);
            UsuarioView user2 = new UsuarioView(4, "Junjo", "pasapalabra", "Médica", false);
            Assert.IsTrue(user1 <= user2);

        }







    }
}