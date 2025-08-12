namespace PSS.jgb347.Practica_03
{
    public class Tablero
    {
        //Primero se debe declaran las variables que se emplearán en la clase, cabe destacar que por defecto la dimensión asignada será 9
        //Pero si fuera otro número el código está preparado para cualqueir tipo de dimensión
        private int dimension = 9;
        private int numeroCasillasOcupadas;


        //Ahora se crean los contructores, el cual primero se encuentra el de por defecto, el cual crea un tablero cuando no se le asigna ninguna dimensión siendo la de por defecto 9
        public Tablero() : this(9) { }//Aqui es donde hay que cambiar si se quiere un tablero más grande

        public Tablero(int dimension)
        {
            if (dimension >= 5) // Validar la dimensión mínima al crear el tablero
            {
                casillas = new Ficha[dimension, dimension];
                this.dimension = dimension;
            }
            else
            {
                throw new ArgumentException("La dimensión debe ser igual o mayor que 5 para jugar 4 en raya.");
            }
        }


        //Despues es necesario crear los métodos getters y setter para las dos variables de la clase, y donde los setter deberan verificar que que el número indica es un número válido
        public int Dimension
        {
            get { return dimension; }
            set
            {
                if (value >= 5) 
                {
                    dimension = value;
                }
                else
                {
                    throw new ArgumentException("La dimensión debe ser igual o mayor que 5 para jugar 4 en raya.");
                }
            }
        }

        public int NumeroCasillasOcupadas
        {
            get { return numeroCasillasOcupadas; }
            set
            {
                if (value >= 0)
                {
                    numeroCasillasOcupadas = value;
                }
                else
                {
                    throw new ArgumentOutOfRangeException("NumeroCasillasOcupadas", "El número de casillas ocupadas no puede ser negativo.");
                }
            }
        }


        public bool TableroLleno
        {
            get
            {
                return NumeroCasillasOcupadas >= dimension * dimension;
            }
        }


        //La siguiente sección del código permite acceder y manipular las fichas en el tablero
        private Ficha[,] casillas;

        public Ficha this[int fila, int columna]
        {
            get { return casillas[fila, columna]; }
            set { casillas[fila, columna] = value; }
        }



        /// <summary>
        /// Método que permite que el jugador pueda poner una ficha en el tablero existente
        /// </summary>
        /// <param name="ficha"></param>
        /// <param name="columna"></param>
        /// <returns></returns>

        public bool PonerFichaColumna(Ficha ficha, int columna)
        {
            if (columna < 0 || columna >= dimension)
            {
                return false; 
            }

            for (int fila = Dimension - 1; fila >= 0; fila--)
            {
                if (this[fila, columna] == null)
                {
                    this[fila, columna] = ficha;
                    NumeroCasillasOcupadas++;
                    return true;
                }
            }

            return false; 
        }


        //Este método es muy util para clonar directaemente tableros, incluyendo hasta las fichas que hay en él
        public Tablero Clonar()
        {
            Tablero clon = new Tablero(this.Dimension);
            for (int i = 0; i < clon.Dimension; i++)
            {
                for (int j = 0; j < clon.Dimension; j++)
                {
                    clon[i, j] = this[i, j];
                }
            }
            return clon;
        }
    }
}

