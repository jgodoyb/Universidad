namespace PSS.jgb347.Practica_03
{

    //Para poder hacer esta parte ha sido necesario hacer uso de los videos que el profesor proporciona, ya que el algoritmo humano es sencillo
    //pero al hacer un propio algoritmoListo, es necesario ver como lo ha hecho el profesor
    public delegate bool Calculo(Juego juego, Jugador jugador, out int columna);
    public static class Algoritmos
    {

        //En este algoritmo directamente es el humano quien escoge la casilla, por lo tanto, es únicamente una escritura por consola
        public static bool AlgoritmoHumano(Juego juego, Jugador jugador, out int columna)
        {
            string consola = Console.ReadLine();
            columna = int.Parse(consola);
            return true;
        }

        //Tmabién está implementado el algoritmoRandom, que como su nombre especifica, únicamente coloca la ficha sin "pensar", de manera aleatoria, considerándose un algoritmo tonto
        public static bool AlgoritmoRandom(Juego juego, Jugador jugador, out int columna)
        {
            Random random = new Random();
            columna = random.Next(0, juego.Tablero.Dimension); // Genera una columna aleatoria

            // Devuelve la columna seleccionada, la verificación de validez se realizará en el bucle principal
            return true;
        }







    }
}