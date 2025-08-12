namespace PSS.jgb347.Práctica_04
{
    public class Consultas
    {
        private UserData datos;

        public Consultas()
        {
            datos = new UserData();
            datos.CargarDatos();
        }

        /// <summary>
        /// Usuarios que se han conectado a una aplicación según la categoria cuyo codigo es categoriaId
        /// </summary>
        /// <param /name="categoriaId"> Id de la categoria</param>
        /// <returns> Lista ordenada alfabéticamente de los nombres de ls usuarios en mayúsculas</returns>
        public IEnumerable<vmNombre> UsuariosEnCategoria(int categoriaId)
        {
            var usuarios = from user in datos.Usuarios
                           join usercategory in datos.UsuariosCategorias on user.Id equals usercategory.CategoriaId
                           where usercategory.CategoriaId == categoriaId
                           orderby user.NombreUsuario
                           select new vmNombre//Como se tiene que devolver un objeto tipo vmNombre, es necesario hacer esto
                                {
                                    Nombre = user.NombreUsuario.ToUpper()//El ToUpper sirve para poner en mayúscula 
                                };
         return usuarios;
        }


        /// <summary>
        /// Usuarios que se han conectado a una aplicación según la categoria cuyo nombre es nombreCategoria
        /// </summary>
        /// <param //name="nombreCategoria"> Nombre de la categoria</param>
        /// <returns> Lista ordenada alfabéticamente de los nombres de ls usuarios en mayúsculas</returns>
        public IEnumerable<vmNombre> UsuariosEnCategoria(string nombreCategoria)
        {
            var usuarios = from user in datos.Usuarios
                           join usercategory in datos.UsuariosCategorias on user.Id equals usercategory.CategoriaId
                           join category in datos.Categorias on usercategory.CategoriaId equals category.Id
                           where category.NombreCategoria == nombreCategoria
                           select new vmNombre
                           {
                               Nombre = user.NombreUsuario.ToUpper()
                           };

        return usuarios;

        }

        /// <summary>
        /// Usuarios cuyo nombre comienza por cadenaComienzo 
        /// </summary>
        /// <param //name="cadenaComienzo">cadena de comienzo del nombre</param>
        /// <returns> Lista de los nombres de ls usuarios en mayúsculas</returns>
        public IEnumerable<vmNombre> UsuariosConNombreComienza(string cadenaComienzo)
        {
            var nombres = from user in datos.Usuarios
                          where user.NombreUsuario.StartsWith(cadenaComienzo)//Sirve para indicar que tiene que empezar por ahí
                          select new vmNombre
                          {
                              Nombre = user.NombreUsuario.ToUpper()
                          };
            return nombres;
        }

        /// <summary>
        /// Usuarios cuyo nombre comienza por cadenaComienzo que pertenecen a una categoria dada
        /// </summary>
        /// <param //name="categoria">nombre de la caegoria</param>
        /// <param //name="cadenaComienzo">cadnea de comienzo del nombre</param>
        /// <returns> Lista ordenada alfabéticamente de los nombres de ls usuarios en mayúsculas</returns>
        public IEnumerable<vmNombre> UsuariosConNombreComienzaEnCategoria(string cadenaComienzo, string categoria)
        {
            var usuarios = from user in datos.Usuarios
                           join usercategory in datos.UsuariosCategorias on user.Id equals usercategory.CategoriaId
                           join category in datos.Categorias on usercategory.Id equals category.Id
                           where user.NombreUsuario.StartsWith(cadenaComienzo) && category.NombreCategoria == categoria
                           orderby user.NombreUsuario
                           select new vmNombre
                           {
                               Nombre = user.NombreUsuario.ToUpper()
                           };
            return usuarios;

        }



        /// <summary>
        /// Usuarios conectados desde una IP  
        /// </summary>
        /// <param //name="ip">ip de la conexion</param>
        /// <returns> Lista de los nombres de los usuarios en mayúsculas</returns>
        public IEnumerable<vmNombre> UsuariosConectadosIP(string ip)
        {
            var nombres = from user in datos.Usuarios
                          join usercategory in datos.UsuariosCategorias on user.Id equals usercategory.UsuarioId
                          join conection in datos.Conexiones on usercategory.Id equals conection.UsuarioCategoriaId
                          where conection.IP == ip
                          select new vmNombre
                          {
                              Nombre = user.NombreUsuario.ToUpper()
                          };
            return nombres;
        }



        /// <summary>
        /// Encuentra el  nombre del usuario de una aplicación dada a través de su e-mail
        /// </summary>
        /// <param //name="Aplicacion"> cadena con el nombre de la aplicación</param>
        /// <param //name="email">cadena con el e-mail</param>
        /// <returns> Nombre del Usuario o null si no se encuentra</returns>
        public IEnumerable<vmNombre> EncontrarUsuarioAppEmail(string aplicacion, string email)
        {
            var nombres = from user in datos.Usuarios
                          join apli in datos.Aplicaciones on user.AplicacionId equals apli.Id
                          join pers in datos.Personales on user.Id equals pers.UsuarioId
                          where pers.Email == email && apli.NombreAplicacion == aplicacion
                          select new vmNombre
                          {
                              Nombre = user.NombreUsuario
                          };

            return nombres;
        }



        //Las consultas relacionadas con los usuarios ya están hechas toda hechas, ahora toca hacer las que están relacionadas con las categorias



        /// <summary>
        /// Lista de pares (Categoria,Usuario) para  una aplicación dada
        /// </summary>

        /// <param //name="aplicación">nombre de la aplicación</param>
        /// <returns>Lista de pares (nombre de categoria y nombre de Usuario)</returns>
        public IEnumerable<vmCategoriaNombre> ListaParCategoriaUsuarioParaApp(string aplicacion)
        {
            var usuarios = from user in datos.Usuarios
                           join apli in datos.Aplicaciones on user.AplicacionId equals apli.Id
                           join category in datos.Categorias on apli.Id equals category.AplicacionId
                           where apli.NombreAplicacion == aplicacion
                           select new vmCategoriaNombre
                           {
                               Nombre = user.NombreUsuario,
                               Categoria = category.NombreCategoria
                           };
            return usuarios;

        }

        /// <summary>
        /// Lista de Usuarios agrupados en lista de categorias  (un mismo usuario puede estar en dos categorias)
        /// </summary>
        /// <returns> Lista  de nombres de usuario agrupados para cada categoria (de otra lista)  </returns>
        public IEnumerable<IGrouping<string, vmCategoriaNombre>> AgrupacionUsuariosCategorias()
        {
            var usuarios = from user in datos.Usuarios
                           join usercategory in datos.UsuariosCategorias on user.Id equals usercategory.UsuarioId
                           join category in datos.Categorias on usercategory.CategoriaId equals category.Id
                           group new vmCategoriaNombre//Se tiene que emplear el group new para crear grupos de este tipo de objeto
                           {
                               Nombre = user.NombreUsuario,
                               Categoria = category.NombreCategoria
                           }
                           by category.NombreCategoria into grupo
                           select grupo;             
            return usuarios;
        }


        /// <summary>
        /// Relacion de Usuarios agrupados en categorias ordenadas éstas en orden descendente alfabéticamente 
        ///(un mismo puede aparecer  varias veces si esta en varias categorias)
        /// </summary>
        /// <returns> Lista agrupada de usuarios por categorias </returns>
        public IEnumerable<vmCategoriaNombre> AgrupacionUsuariosCategoriasOrdenadas()
        {
            var usuarios = from user in datos.Usuarios
                           join usercategory in datos.UsuariosCategorias on user.Id equals usercategory.UsuarioId
                           join category in datos.Categorias on usercategory.CategoriaId equals category.Id
                           orderby category.NombreCategoria descending//Esta cláusala indica el order descendente
                           select new vmCategoriaNombre
                           {
                               Nombre = user.NombreUsuario,
                               Categoria = category.NombreCategoria
                           };
                           
            return usuarios;
        }


        /// <summary>
        /// Categoria con mayor numero de usuarios y total 
        /// </summary>
        /// <returns>Devuelve nombre de la categoria con más usurios y el numero de usuarios</returns>
        public IEnumerable<vmCategoriaNombre> CategoriaMaximoNumeroUsuarios() //CategoriaConMayorNumeroUsuariosConectados()
        {
            var usuarios = (from category in datos.Categorias
                           join userCategory in datos.UsuariosCategorias on category.Id equals userCategory.CategoriaId
                           group userCategory.UsuarioId by category.NombreCategoria into grupo
                           orderby grupo.Count() descending //Esto sirve para ordenar los grupos de mayor a menor
                           select new vmCategoriaNombre
                           {
                               Nombre = grupo.Count().ToString(),
                               Categoria = grupo.Key

                           }).Take(1);//Como anterioremente se ha ordenado la lista, solo hace falta coger uno, para esa función se emplea la función take()

            return usuarios;
        }

        /// Todas las categorias de usuarios para una aplicación dada
        /// </summary>
        /// <param name="aplicacion"> nombre de la aplicación</param>
        /// <returns>Lista de los nombres de las categorias de usuarios</returns>
        public IEnumerable<vmCategoriaNombre> TodasCategoriasApp(string aplicacion)
        {
            var categorias = from user in datos.Usuarios
                             join apli in datos.Aplicaciones on user.AplicacionId equals apli.Id
                             join category in datos.Categorias on apli.Id equals category.AplicacionId
                             where apli.NombreAplicacion == aplicacion
                             select new vmCategoriaNombre
                             {
                                 Nombre = user.NombreUsuario,
                                 Categoria = category.NombreCategoria
                             };
            return categorias;
        }

        /// <summary>
        /// Lista de Categoria/Aplicación  para un usuario dado 
        /// </summary>
        /// <param name="usuario">nombre del usuario</param>
        /// <returns>Lista de pares (nombre de categoria y nombre de aplicación)</returns>
        public IEnumerable<vmCategoriaNombre> CategoriasAplicacionParaUsuario(string usuario)
        {
            var usuarios = from user in datos.Usuarios
                           join apli in datos.Aplicaciones on user.AplicacionId equals apli.Id
                           join category in datos.Categorias on apli.Id equals category.AplicacionId
                           where user.NombreUsuario == usuario
                           select new vmCategoriaNombre
                           //A continaución, como la salida tiene que ser un objeto de tipo "vmCategoriaNombre", se le asignará al nombre el nombre de la aplicación.
                           {
                               Nombre = apli.NombreAplicacion,
                               Categoria = category.NombreCategoria
                           };
            return usuarios;

        }




        //Ya estan hechas tanto las consultas de usuarios como las de categorias, como último apartado, ahce falta hacer las consultas de agrupaciones, que serán consultas que serán un mayor desafío



        /// <summary>
        /// ¿Desde que IP ha habido más conexiones y cuantas para una categoria dada? 
        /// </summary>
        /// <returns>Lista con la IP y el número de conexiones</returns>
        public IEnumerable<vmNombreCantidad> IPconMasConexionesSegunCategoria(string nombreCategoria)
        {
            var direcciones = (from category in datos.Categorias
                              join usercategory in datos.UsuariosCategorias on category.Id equals usercategory.CategoriaId
                              join con in datos.Conexiones on usercategory.Id equals con.UsuarioCategoriaId
                              where category.NombreCategoria == nombreCategoria
                              group con.Id by con.IP into grupo
                              orderby grupo.Count() descending
                              select new vmNombreCantidad
                              {
                                  Nombre = grupo.Key,
                                  Cantidad = grupo.Count()
                              }).Take(1);

            return direcciones;
        }

        /// <summary>
        /// Secuencia de pares (usuarios, suma total duración de conexion) ordenados de mayor a menor duración
        /// </summary>

        /// <returns>Lista de pares NombreUsuario, suma de la duración de las conexiones</returns>
        public IEnumerable<vmNombreCantidad> UsuarioSumaDuracionConexiones()
        {
            var tiempo = from user in datos.Usuarios
                         join usercategory in datos.UsuariosCategorias on user.Id equals usercategory.UsuarioId
                         join con in datos.Conexiones on usercategory.Id equals con.UsuarioCategoriaId
                         group con.Duracion by user.NombreUsuario into grupo
                         orderby grupo.Sum() descending //Sum() por lo que se puede deducir sirve para
                         select new vmNombreCantidad
                         {
                             Nombre = grupo.Key,
                             Cantidad = grupo.Sum()
                         };

            return tiempo;

        }


        /// <summary>
        /// LEFT OUTER JOIN
        /// Secuencia de pares (usuarios, suma total de duración de conexiones) ordenados de menor a mayor duración 
        /// Usuarios que no se hayan conectado nunca deberán aparecer con una cantidad de 0
        /// </summary>

        /// <returns>Lista de pares NombreUsuario, total suma de duración de conexiones</returns>
        public IEnumerable<vmNombreCantidad> UsuarioSumaDuracionConexionesNulos()
        {
            var suma = from user in datos.Usuarios
                       join usercategoty in datos.UsuariosCategorias on user.Id equals usercategory.UsuarioId
                       join con in datos.Conexiones on usercategoty.Id equals con.UsuarioCategoriaId
                       into resumen//Esto sirve para hacer un resumen de todos los joins que se han hecho
                       from grup1 in resul.DefaultIfEmpty()//Para dar un valor predeteminado nulo
                       group (grup1 == null ? 0 : grup1.Duracion) by u into grupo// esto es como un if, si el grupo es null se iguala 0 pero sino se da la duración
                       orderby grupo.Sum() descending
                       select new vmNombreCantidad
                       {
                           Nombre = grupo.Key.NombreUsuario,
                           Cantidad = grupo.Sum()
                       };
            return suma;

        }


        /// <summary>
        /// LEFT OUTER JOIN
        /// Relacion de usuarios cuya suma total de duración de conexión sea superior a la media. 
        /// </summary>
        /// <returns>Lista con el nombre de usuario y suma total de duracion de conexiones</returns>
        public IEnumerable<vmNombreCantidad> UsuariosSumaDuracionMayorMedia1()
        {
            

        }


        /// <summary>
        /// LEFT OUTER JOIN
        /// Relacion de usuarios cuya suma total de duración de conexión sea superior a la media. 
        /// </summary>
        /// <returns>Lista con el nombre de usuario y suma total de duracion de conexiones</returns>
        public IEnumerable<vmNombreCantidad> UsuariosSumaDuracionMayorMedia()
        {

        }


        /// <summary>
        /// Relacion de aplicaciones y su respectiva suma de tiempos de conexión de todos los usuarios 
        /// </summary>
        /// <returns>Lista con el nombre de aplicacion y  suma total de duracion de conexiones</returns>
        public IEnumerable<vmNombreCantidad> AplicacionesMasUsadas()
        {
            var tiempos = from apli in datos.Aplicaciones
                          join user in datos.Usuarios on apli.Id equals user.AplicacionId
                          join usercategory in datos.UsuariosCategorias on user.Id equals usercategory.UsuarioId
                          join con in datos.Conexiones on usercategory.Id equals con.UsuarioCategoriaId
                          group con.Duracion by apli.NombreAplicacion into grupo
                          select new vmNombreCantidad
                          {
                              Nombre = grupo.Key,
                              Cantidad = grupo.Sum()
                          };
            return tiempos;

        }



        /// <summary>
        /// Relacion de aplicaciones y su respectiva suma de tiempos de conexión de todos los usuarios (ordenas de mayor a menor) 
        /// </summary>
        /// <returns>Lista con el nombre de aplicacion y  suma total de duracion de conexiones</returns>
        public IEnumerable<vmNombreCantidad> AplicacionesMasUsadasOrdenadas() 
        {

            var tiempos = from apli in datos.Aplicaciones
                          join user in datos.Usuarios on apli.Id equals user.AplicacionId
                          join usercategory in datos.UsuariosCategorias on user.Id equals usercategory.UsuarioId
                          join con in datos.Conexiones on usercategory.Id equals con.UsuarioCategoriaId
                          group con.Duracion by apli.NombreAplicacion into grupo
                          orderby grupo.Sum() descending //La anterior consulta y esta son iguales excepto que esta está ordenada de forma descendente, y en la otra no se exije ningún orden específico
                          select new vmNombreCantidad
                          {
                              Nombre = grupo.Key,
                              Cantidad = grupo.Sum()
                          };
            return tiempos;

        }














    }
}
