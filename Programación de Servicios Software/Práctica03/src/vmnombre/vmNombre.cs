namespace PSS.jgb347.Práctica_04
{
    public class vmNombre
    {
        public string Nombre { get; set; }
        public override bool Equals(Object obj)
        {
            vmNombre vm = obj as vmNombre;
            if (ReferenceEquals(vm, null))
                return false;
            else
                return Nombre.Equals(vm.Nombre);
        }

        public override int GetHashCode()
        {
            return Nombre.GetHashCode();
        }


    }
}
