using System.ComponentModel;
namespace ComparadorPropiedad
{

    public class ComparadorPropiedad<T> : IComparer<T> where T : IComparable<T>
    {

        private PropertyDescriptor propiedad;//Hay que crear un obejto con esta clase para poder emplear métodos interesantes como el GetValue(), usado en el CompareTo

        private PropertyDescriptor GetProperty(string name)/* Este primer método está proporcionado por el docuemento de la parte 3, es copiar y pegar, pero tiene 
                                                              como objetivo el bsucar y devolver un descriptor de propiedad para una propiedad específica dentro de 
                                                              una clase genérica T */
        { 
            T item = (T)Activator.CreateInstance(typeof(T));
            PropertyDescriptor propName = null;
            foreach (PropertyDescriptor propDesc in TypeDescriptor.GetProperties(item))
            {
                if (propDesc.Name.Contains(name)) propName = propDesc;
            }
            return propName;
        }

        public ComparadorPropiedad(string nombre)
            {
                propiedad = GetProperty(nombre);
                if (propiedad is null)//Primero se verifica si hay alguna propiedad y para ello se emplea un exceptión.
                {
                    throw new ArgumentException("No existe ninguna propiedad");
                }

                Type propertyType = Nullable.GetUnderlyingType(propiedad.PropertyType) ?? propiedad.PropertyType;//Una vez que se sabe que hay propiedad, es verifica que la propiedad es un tipo nullable
                bool assert = typeof(IComparable).IsAssignableFrom(propertyType);
                if (!assert)
                { 
                    throw new ArgumentException("La propiedad " + nombre + " no es puede comparar");
                }
            }


            public int Compare(T? x, T? y)//Finalemente es necesario hacer un CompareTo básico, y el ? sirve para indicar que puede ser Null
            {

                if (x is null)
                {
                    return -1;
                }

                if (x is null && y is null)
                {
                    return 0;
                }


                if (y is null)
                {
                    return 1;
                }

                var valueX = propiedad.GetValue(x) as IComparable;
                var valueY = propiedad.GetValue(y) as IComparable;

                return valueX.CompareTo(valueY);
            }
           
        }
    }



