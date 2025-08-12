using System;

namespace PSS.jgb347.Practica_03
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Do you want the program in English or Spanish? (Type 'English' or 'Spanish')");
            string language = Console.ReadLine().ToLower();

            bool isEnglish = language == "english";

            // Display the initial message in the chosen language
            if (isEnglish)
            {
                Console.WriteLine("Welcome to the game!");
            }
            else
            {
                Console.WriteLine("¡Bienvenido al juego!");
            }

            //Primero se crean los jugadores como dijo el profesor
            Juego juego = new Juego();
            Jugador jugador1 = new Jugador(isEnglish ? "Player1" : "Jugador1");
            jugador1.Ficha = new Ficha(ColorEnum.Blanco);
            jugador1.AlgoritmoPosicion = Algoritmos.AlgoritmoHumano;
            juego.AnadirJugador(jugador1);

            Jugador jugador2 = new Jugador(isEnglish ? "Player2" : "Jugador2");
            jugador2.Ficha = new Ficha(ColorEnum.Negro);
            jugador2.AlgoritmoPosicion = Algoritmos.AlgoritmoRandom;
            juego.AnadirJugador(jugador2);

            bool hayGanador = false;
            Jugador jugadorGanador = null;
            var random = new Random(DateTime.Now.Millisecond);
            int id = random.Next(2) + 1; // Esto sirve para generar aleatoridad a la hora de quién empieza 

            do
            {
                bool posicionValida = false;

                do
                {
                    jugadorGanador = juego.ObtenerJugador(id);
                    Console.Clear(); // Limpiar la consola antes de mostrar el tablero
                    DibujarTablero(juego.Tablero); // Dibujar el tablero en la consola

                    //Thread.Sleep(1000); //Se emplea cuando ambos jugadores no son humanos, sirve para dar pausa entre jugada y jugada

                    Console.WriteLine(isEnglish ? $"{jugadorGanador.Nombre}, please enter a column:" : $"{jugadorGanador.Nombre}, por favor introduce una columna:");

                    if (jugadorGanador.ObtenerPosicion(juego, out int columna))
                        posicionValida = jugadorGanador.ColocarFichaColumna(juego.Tablero, columna);

                    if (!posicionValida)
                        Console.WriteLine(isEnglish ? "Invalid column!" : "¡Columna no válida!");

                } while (!posicionValida);

                id = (id % 2) + 1;
                hayGanador = juego.ObtenerGanador(jugadorGanador);

            } while (!juego.FinJuego() && !hayGanador);

            Console.Clear(); // Limpiar la consola antes de mostrar el resultado final
            DibujarTablero(juego.Tablero); // Mostrar el tablero final

            if (hayGanador)
            {
                Console.WriteLine(isEnglish ? $"Player {jugadorGanador.Nombre} has won!" : $"¡El jugador {jugadorGanador.Nombre} ha ganado!");
            }
            else
            {
                Console.WriteLine(isEnglish ? "It's a tie :(" : "Empate :(");
            }

            Console.ReadLine();
        }

        // Método para dibujar el tablero en la consola
        static void DibujarTablero(Tablero tablero)
        {
            int dimension = tablero.Dimension;

            for (int fila = 0; fila < dimension; fila++)
            {
                for (int columna = 0; columna < dimension; columna++) 
                {
                    Ficha ficha = tablero[fila, columna];
                    if (ficha == null)
                    {
                        Console.Write("|   ");
                    }
                    else
                    {
                        string simbolo = (ficha.Color == ColorEnum.Blanco) ? " O " : " X ";
                        Console.Write("|" + simbolo);
                    }
                }
                Console.WriteLine("|");
            }
            for (int i = 0; i < dimension * 4; i++)
            {
                Console.Write("-");
            }
            Console.WriteLine();
        }
    }
}
