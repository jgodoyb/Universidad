using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PSS.jgb347_GodoyBeltranJorge.Practica_02
{

    public class UsuarioView : IUsuarioView, IEquatable<UsuarioView>, IEqualityComparer<UsuarioView>, IComparable<UsuarioView>/*Ya estan implementadas todas as interfaces que son 
                                                                                                                               necesarias para la práctica entera, incluyendo todas la partes*/
    {

        //Declaro las variables ocn sus correspondientes getters y setters.
        public string Id { get; set; }
        public string Nombre { get; set; }
        public string PalabraPaso { get; set; }
        public string Categoria { get; set; }
        public bool EsValido { get; set; }

        //constructor sobre-cargado.
        public UsuarioView(int id, string nombre, string palabraPaso, string categoria, bool esValido)
        {

            this.Id = Convert.ToString(id);
            this.Nombre = nombre;
            this.PalabraPaso = palabraPaso;
            this.Categoria = categoria;
            this.EsValido = esValido;
        }

        //Constructro vacío
        public UsuarioView(){}

        //Método para comparar objetos de tipo de UsuarioView.
        public bool Equals(UsuarioView? usuario2)
        {

            if (object.ReferenceEquals(this, usuario2))
            {
                return true;
            }

            if (object.ReferenceEquals(usuario2, null))
            {
                return false;
            }

            return this.Id.Equals(usuario2.Id);
        }

        //Método para comparar dos objetos de tipo de UsuarioView.

        public bool Equals(UsuarioView? usuario1, UsuarioView? usuario2)
        { //La '?' sirve para indicar que puede entrar un objeto tipo null 

            if (object.ReferenceEquals(usuario1, usuario2))
            {
                return true;
            }

            if (object.ReferenceEquals(usuario1, null) || object.ReferenceEquals(usuario2, null))
            {
                return false;
            }

            return usuario1.Id.Equals(usuario2.Id);

        }

        //Método para cumplir con el requisito de crear los CompareTo
        public int CompareTo(UsuarioView? other)
        {
            if (object.ReferenceEquals(this, other))
            {
                return 0;
            }
            if (object.ReferenceEquals(other, null))
            {
                return 1;
            }
            if (!this.GetType().Name.Equals(other.GetType().Name))
            {
                throw new ArgumentException("No se pueden comparar objetos de diferente tipo");
            }
            return this.Id.CompareTo(other.Id);
        }


        //A continuación de están expuestos los 4 métodos relacionos con las operaciones <,> >=



        public static bool operator <= (UsuarioView? usuario1, UsuarioView? usuario2)
        {

            return !(usuario1 > usuario2);
        }


        public static bool operator > (UsuarioView usuario1, UsuarioView? usuario2)
        {
            return !(usuario1 < usuario2 || usuario1 == usuario2);
        }


        public static bool operator >= (UsuarioView? usuario1, UsuarioView? usuario2)
        {
            return !(usuario1 < usuario2);
        }


        public static bool operator < (UsuarioView usuario1, UsuarioView? usuario2)
        {
            int entero = 0;

            if (object.ReferenceEquals(usuario1, usuario2))
            {
                entero = 0;
            }

            else if (object.ReferenceEquals(usuario2, null))
            {
                entero = 1;
            }

            else if (object.ReferenceEquals(usuario1, null))
            {
                entero = -1;
            }

            else
            {
                entero = usuario1.CompareTo(usuario2);
            }
            return entero < 0;
        }

        //Los dos sigueinte smetodos siven para cuando hay que trabajar con el "==" y el "!="

        public static bool operator ==(UsuarioView use1, UsuarioView use2)
        {
            if (object.ReferenceEquals(use1, use2))
            {
                return true;
            }

            if (object.ReferenceEquals(use1, null))
            {
                return false;
            }

            if (object.ReferenceEquals(use2, null))
            {
                return false;
            }
            return use1.Equals(use2);
        }


        public static bool operator !=(UsuarioView usuario1, UsuarioView usuario2)
        {
            return !(usuario1 == usuario2);
        }

        //Y para terminar esta primera parte, es necesario hacer el gethascode


        public override bool Equals(object? objeto)
        {
            return (objeto == null) ? false : Equals(objeto as UsuarioView); //Esta es una forma de hacer condicionales, como se ha visto en las clases doecentes
        }


        public override int GetHashCode()
        {
            if (string.IsNullOrEmpty(this.Id))//esta linea para saber si la id es nula o vacía
            {
                return "".GetHashCode();//se devuelve un codigo hash de una cadena vacía
            }

            return this.Id.GetHashCode();//si n oes vacio devuelve el id 
        }


        public int GetHashCode([DisallowNull] UsuarioView obj)//Lo de DisallowNull es para que se pueda admitir un valor null
        {
            return (obj == null) ? "".GetHashCode() : (obj as object).GetHashCode();
        }







    }
}
