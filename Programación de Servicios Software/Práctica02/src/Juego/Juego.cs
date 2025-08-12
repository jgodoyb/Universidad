namespace PSS.jgb347.Practica_03
{
    //Se ha creado la clase excepción porque mas adelante se empelará, y aunque se peuden crear muchos maás tipos de constructores, 
    //actualmente solo hace falta el que se encuentra escrito
    public class NombreJugadorDuplicadoException : Exception
    {
        public NombreJugadorDuplicadoException(string? message) : base(message)
        {
        }
       
    }


    public class Juego
    {
        public int NumeroJugadores { get { return Jugadores.Count; } } //Lo primero de todo es crear un vriable que almacene el numero de jugadores, que para ello se llamara a la clase Jugadores
        //Para almacenar un numero ilimitado de jugadores hay dos posible sopciones, o un diccionario o un cola, en este caso se empela un diccionario ya que es lo que se ha empleado en practicas
        private Dictionary<string, Jugador> Jugadores = new Dictionary<string, Jugador>(); 
        public Tablero Tablero { get; set; }
       
       
        
        //Una vez declaradas las varibles es necesario crear lo construcctores de la clase juego
        public Juego()
        {
            Tablero = new Tablero();
        }
        public Juego(int dimension)
        {
            Tablero = new Tablero(dimension);
        }


        //Lo que s ehace en este métiodo es meter los jugadores en el diccionario que se ha creado antes, que para llevar un control de los jugadores
        //se ha creado una excepción, que saltará cuando se repita el nombre del jugador
        public void AnadirJugador(Jugador jugador)
        {
            try
            {
                Jugadores.Add(jugador.Nombre, jugador);
            }
            catch (Exception excepción )
            {
                throw new NombreJugadorDuplicadoException("El nombre del jugador" + jugador.Nombre + " ya existe");//Esta es la excepción que antes se ha creado 
            }
        }


        //Método para obtener el nombre d eun jugador a parti de su nombre, pero se obtiene del diccionario creado
        public Jugador ObtenerJugador(string nombre)
        {
            return Jugadores[nombre];
        }

        //Y este otro método para encontrarlo a partir de la id
        public Jugador ObtenerJugador(int idJugador)
        {
            foreach (Jugador jugador in Jugadores.Values)
            {
                if (jugador.Id == idJugador)
                    return Jugadores[jugador.Nombre];
            }
            throw new IndexOutOfRangeException("Id jugador no existe " + idJugador);// Excepción que actua cuando el id proporcionado no corresponde a ningún jugador existente en el diccionario
        }


        //Ahora se van a comprobar las disferentes opciones que hay para ganar
        //-->Hacer un diagonal Derecha
        //-->Hacer un diagonal Izquierda
        //-->Hacer una vertical
        //-->Hacer una horizontal
        //Para empezar, se comprobará la vertical


        private bool ComprobarVertical(Jugador jugador)//Es privada porquue posteriomente se va hacer otro método público que invocará los 4 metodos que se crearán a continuación
        {
            ColorEnum color = jugador.Ficha.Color;
            int dimension = Tablero.Dimension;

            //Ahora se crea un array con las posiciones, inializándolasr todas a false, haciéndolo con un bucle
            bool[] posiciones = new bool[4];
            for (int i = 0; i < posiciones.Length; i++)
            {
                posiciones[i] = false;
            }

            for (int i = 0; i < dimension - 3; i++)
            {
                for (int j = 0; j < dimension; j++)
                {
                    Ficha ficha = Tablero[i, j];
                    if (ficha == null) continue;
                    if (ficha.Color == color)
                    {
                        posiciones[0] = true;
                        posiciones[1] = (Tablero[i + 1, j] == null) ? false :(Tablero[i + 1, j].Color == color);
                        posiciones[2] = (Tablero[i + 2, j] == null) ? false :(Tablero[i + 2, j].Color == color);
                        posiciones[3] = (Tablero[i + 3, j] == null) ? false :(Tablero[i + 3, j].Color == color);
                    }
                    if (posiciones[0] && posiciones[1] && posiciones[2] && posiciones[3])//Si se cumple todo, es porque ya ha ganado
                        return true;
                }
            }
            return false;//sigue el juego
        }



        //Método para comprobar la horizontal, el cual es prácticamente igual que el anterior pero a la hora de comprobar las posiones, se trabajará las j en vez de con la i
        private bool ComprobarHorizontal(Jugador jugador)
        {
            ColorEnum color = jugador.Ficha.Color;
            int dimension = Tablero.Dimension;

            //Se vuelve a hacer el mismo proceso que el método anterior
            bool[] posiciones = new bool[4];
            for (int i = 0; i < posiciones.Length; i++)
            {
                posiciones[i] = false;
            }


            for (int i = 0; i < dimension; i++)
            {
                for (int j = 0; j < dimension - 3; j++)
                {
                    Ficha ficha = Tablero[i, j];
                    if (ficha == null) continue;
                    if (ficha.Color == color)
                    {
                        posiciones[0] = true;
                        posiciones[1] = (Tablero[i, j + 1] == null) ? false :(Tablero[i, j + 1].Color == color);
                        posiciones[2] = (Tablero[i, j + 2] == null) ? false :(Tablero[i, j + 2].Color == color);
                        posiciones[3] = (Tablero[i, j + 3] == null) ? false :(Tablero[i, j + 3].Color == color);
                    }
                    if (posiciones[0] && posiciones[1] && posiciones[2] && posiciones[3])//Si se cumple todo, es porque ya ha ganado
                        return true;
                }
            }
            return false;//sigue el juego
        }


        //Para los métodos para comprobar diagonales, tanto uno como el otro serán con la misma estructura que los dos anteriores pero se verificarán posiciones diferntes
        //Para la horizontales se estado jugnado con j, mientas que para las veritcales a sido con la i, en este caso se emplearán ambas.


        private bool ComprobarDiagonalDerecha(Jugador jugador)
        {
            ColorEnum color = jugador.Ficha.Color;
            int dimension = Tablero.Dimension;

            bool[] posiciones = new bool[4];
            for (int i = 0; i < posiciones.Length; i++)
            {
                posiciones[i] = false;
            }
            for (int i = 0; i < dimension - 3; i++)
            {
                for (int j = 0; j < dimension - 3; j++)
                {
                    Ficha ficha = Tablero[i, j];
                    if (ficha == null) continue;
                    if (ficha.Color == color)
                    {
                        posiciones[0] = true;
                        posiciones[1] = (Tablero[i + 1, j + 1] == null) ? false : (Tablero[i + 1, j + 1].Color == color);
                        posiciones[2] = (Tablero[i + 2, j + 2] == null) ? false : (Tablero[i + 2, j + 2].Color == color);
                        posiciones[3] = (Tablero[i + 3, j + 3] == null) ? false : (Tablero[i + 3, j + 3].Color == color);
                    }
                    if (posiciones[0] && posiciones[1] && posiciones[2] && posiciones[3])
                        return true;
                }
            }
            return false;
        }


        private bool ComprobarDiagonalIzquierda(Jugador jugador)
        {
            ColorEnum color = jugador.Ficha.Color;
            int dimension = Tablero.Dimension;

            bool[] posiciones = new bool[4];
            for (int i = 0; i < posiciones.Length; i++)
            {
                posiciones[i] = false;
            }
            for (int i = 0; i < dimension - 3; i++)
            {
                for (int j = 0; j < dimension - 3; j++)
                {
                    Ficha ficha = Tablero[i, j];
                    if (ficha == null) continue;
                    if (ficha.Color == color)
                    {
                        posiciones[0] = true;
                        posiciones[1] = (Tablero[i + 1, j - 1] == null) ? false : (Tablero[i + 1, j - 1].Color == color);
                        posiciones[2] = (Tablero[i + 2, j - 2] == null) ? false : (Tablero[i + 2, j - 2].Color == color);
                        posiciones[3] = (Tablero[i + 3, j - 3] == null) ? false : (Tablero[i + 3, j - 3].Color == color);
                    }
                    if (posiciones[0] && posiciones[1] && posiciones[2] && posiciones[3])
                        return true;
                }
            }
            return false;
        }

        //Una vez que están todos los métodos creados, al ser privados no pueden salir de la clase, pero para eso está este otro método el cual invoca a estos 4 métodos

        public bool ObtenerGanador(Jugador jugadaGanadora)
        {
            bool horizontal = ComprobarHorizontal(jugadaGanadora);
            bool vertical = ComprobarVertical(jugadaGanadora);
            bool diagonalIzquierda = ComprobarDiagonalIzquierda(jugadaGanadora);
            bool diagonalDerecha = ComprobarDiagonalDerecha(jugadaGanadora);
            
            if (horizontal || vertical || diagonalIzquierda || diagonalDerecha)
            {
                return true;
            }
            else return false;
        }

        //Metodo para dar por finalizado el juego en el caso de que el tablero este lleno
        public bool FinJuego()
        {
            return Tablero.TableroLleno;
        }
    }

}
