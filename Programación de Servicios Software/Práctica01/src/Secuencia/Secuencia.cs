using ComparadorPropiedad;
using System;

namespace Secuencia
{
    public class Secuencia<T> : List<T>, IEnumerable<T>, ISecuencia<T> where T : IComparable<T> 
    {
        public Secuencia() : base()
        {
        }

        public T this[int i]//Primero es necesari orevisar si el valor no es correcto, por ello se realizar un par de excepciones
        {
            get
            {
                if (i < 0 || i >= this.Count)
                {
                    throw new ArgumentOutOfRangeException("Posición no encontrada");
                }
                return this[i];

            }
            set
            {
                if (i < 0 || i >= this.Count)
                {
                    throw new ArgumentOutOfRangeException("Posición no encontrada");
                }

                this[i] = value;
            }
        }

        //Antiormetne se ha creado una intefaz con un a serie de clases, ahora en la clase Secuencia es necesario declararlas 
        public int Cuenta
        {
            get { return this.Count; }
        }

        public void Añadir(T item)
        {
            this.Add(item);
        }

        public bool Contiene(T item)
        {
            return this.Contains(item);
        }

        public bool Eliminar(T item)
        {
            return this.Remove(item);
        }

        public void Limpiar()
        {
            this.Clear();
        }

        public void Ordenar(IComparer<T> comparador)//Este método es ordenar una colección de elementos utilizando un comparador personalizado proporcionado por el usuario.
        {
            if (comparador is null) return;
            this.Sort(comparador);
        }



        public IEnumerable<T> RecorridoAscendente(ComparadorPropiedad<T> numero)
        {//devuelve una secuencia de elementos ordenados de manera ascendente
            Secuencia<T> nuevoElemento = new Secuencia<T>();

            foreach (T tiempo1 in this) {
                nuevoElemento.Añadir(tiempo1);
            }

            nuevoElemento.Ordenar(numero);
            foreach (T tiempo2 in nuevoElemento)
            {
                yield return tiempo2;//El uso de yield en un método indica que este método es un generador de secuencias
            }
        }


        public IEnumerable<T> RecorridoDescendente(ComparadorPropiedad<T> numero) // el cual es similar al método RecorridoAscendente explicado anteriormente, pero en este caso, devuelve una secuencia de elementos ordenados de manera descendente en lugar de ascendente.
            {
                Secuencia<T> nuevoElemento = new Secuencia<T>();

                foreach (T tiempo1 in this)
                {
                    nuevoElemento.Añadir(tiempo1);
                }

                nuevoElemento.Ordenar(numero);
                nuevoElemento.Reverse();

                foreach (T ttiempo2 in nuevoElemento)
                {
                    yield return ttiempo2;
                }
            }


        public IEnumerable<T> RecorridoAdelante()
            {
                foreach (T x in this)
                {
                    yield return x;
                }
            }


            public IEnumerable<T> RecorridoAtras()//invierte el orden de la colección actual y luego devuelve los elementos uno por uno en ese nuevo orden.
            {
                List<T> listaDesordenada = new List<T>(this);
                listaDesordenada.Reverse();

                foreach (T t in listaDesordenada)
                {
                    yield return t;
                }
            }
    }
    }
