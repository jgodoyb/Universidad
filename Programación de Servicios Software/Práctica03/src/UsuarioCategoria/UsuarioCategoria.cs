namespace PSS.jgb347.Práctica_04
{
    public class UsuarioCategoria
    {
        private int _id;
        private int _categoriaId;
        private int _usuarioId;

        public int Id
        {
            get { return _id; }
            set { _id = value; }
        }

        public int CategoriaId
        {
            get { return _categoriaId; }
            set { _categoriaId = value; }
        }

        public int UsuarioId
        {
            get { return _usuarioId; }
            set { _usuarioId = value; }
        }
    }

}
