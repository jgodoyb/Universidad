namespace PSS.jgb347.Practica_05
{
    public class AutentificacionExcepcion : Exception
    {
        public AutentificacionExcepcion(String mensaje, CodigoAutentificacion codigo) : base(mensaje)
        {
        }
    }
}