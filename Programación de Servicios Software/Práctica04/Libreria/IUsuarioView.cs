﻿namespace PSS.jgb347.Practica_05
{
    /// <summary>
    /// Interface IUsuarioView describe el contrato que debe cumplir las clase Usuario.
    /// </summary>
    public interface IUsuarioView
    {
        string Id { get; set; } // Clave primaria única para cada usuario
        string Nombre { get; set; } // Nombre del Usuario
        string PalabraPaso { get; set; } // Palabra de paso para comprobar la autentificación del usuario.
        string Categoria { get; set; } // Categoría del Usuario
        bool EsValido { get; set; } // Indica si un usuario es válido
    }
}