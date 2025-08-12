
namespace PSS.jgb347.Practica_03
{
    [Serializable]
    public class Jugador
    {
        //Para las variables, se han escogio las variables de nombre, id, un bool para sabe si es humano o no, y posteriormente ficha puede o no estar asignado a un jugador
        public int Id { get; }
        public string Nombre { get; }
        public bool Humano = true;
        public Calculo AlgoritmoPosicion;
        private Ficha ficha;
        public static int NumeroJugadores = 0;



        //Se deben crear los psibles contructores que se emplearán mas adelante, pero se pueden crear más
        public Jugador(string nombre)
        {
            NumeroJugadores++;
            Id = NumeroJugadores;
            Nombre = nombre;
        }
        public Jugador(string nombre, bool humano)
        {
            NumeroJugadores++;
            Id = NumeroJugadores;
            Nombre = nombre;
            Humano = humano;
        }
        public Jugador()
        {
            NumeroJugadores++;
            Id = NumeroJugadores;
            Nombre = "Jugador" + NumeroJugadores.ToString();
        }


        //En caso de no asignar ninguna ficha al jugador, se avisará del suceso, ya que todo jugador debe tener una ficha asignada
        public Ficha Ficha
        {
            get
            {
                if (ficha == null) throw new JugadorSinFichaException("El jugador no tiene una ficha asignada.");
                else return ficha;
            }
            set
            {
                ficha = value;
            }
        }
        

        //Y finalmente todas las acciones que puede hacer un jugador, como por ejeemplo colar una ficha en una columna y otra muy interesantes el de obtener posicion
        public bool ColocarFichaColumna(Tablero tablero, int columna)
        {
            return tablero.PonerFichaColumna(this.Ficha, columna);
        }

        public bool ObtenerPosicion(Juego juego, out int columna)
        {
            return AlgoritmoPosicion(juego, this, out columna);
        }

        public class JugadorSinFichaException : Exception
        {
            public JugadorSinFichaException(string mensaje) : base(mensaje) { }
        }
    }
}