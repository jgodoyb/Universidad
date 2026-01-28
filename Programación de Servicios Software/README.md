# 🔷 Programación de Servicios Software (PSS)

Desarrollo de aplicaciones modulares en el ecosistema .NET (C#), enfocándose en patrones de diseño, arquitectura de software y gestión de datos.

![C#](https://img.shields.io/badge/C%23-239120?style=for-the-badge&logo=c-sharp&logoColor=white)
![.NET](https://img.shields.io/badge/.NET-512BD4?style=for-the-badge&logo=dotnet&logoColor=white)

## 🏗️ Proyectos y Prácticas

El repositorio está dividido en 4 prácticas incrementales, cada una con su propia solución (`.sln`) y pruebas unitarias:

### 1. Fundamentos del Lenguaje (`Práctica01`)
Exploración de las capacidades de C#:
* **Interfaces y Genéricos:** Implementación de `ISecuencia` y clases genéricas.
* **Delegados y Eventos:** Manejo de eventos y comparadores personalizados (`ComparadorPropiedad`).
* **Vistas:** Separación básica de lógica y presentación (`UsuarioView`).

### 2. Lógica de Dominio y POO (`Práctica02`)
Desarrollo del núcleo de un juego de mesa:
* **Modelado:** Clases `Tablero`, `Ficha`, `Jugador` y `Juego`.
* **Algoritmos:** Lógica de movimiento y estado del juego.
* **Testing:** Pruebas unitarias exhaustivas para validar las reglas del juego.

### 3. Arquitectura MVVM y Datos (`Práctica03`)
Introducción al patrón **Model-View-ViewModel** y acceso a datos:
* **MVVM:** ViewModels como `vmCategoriaNombre` y `vmNombreCantidad` para desacoplar la interfaz de los datos.
* **Capas:** Separación en carpetas `Usuario`, `Personal`, `Categoria`.
* **Conexión:** Clases de infraestructura (`Conexion`, `Consultas`) para interactuar con orígenes de datos.

### 4. Persistencia y Seguridad (`Práctica04`)
Implementación de patrones de diseño para autenticación y almacenamiento flexible:
* **Abstracción:** Interfaz `IAutentificacion` para definir el contrato de seguridad.
* **Estrategias de Persistencia:** Implementaciones concretas para guardar datos en:
    * XML (`AutentificacionXml`).
    * Archivos de texto (`AutentificacionTextFile`).
    * Base de datos SQL Server (`AutentificacionSqlServerFile`).
* **Aplicación de Consola:** `ConsoleAppXML` para demostrar el uso de las librerías.

## 🚀 Ejecución
Requiere **Visual Studio 2022** o **.NET SDK 6.0+**.

Para ejecutar los tests de una práctica específica:
```powershell
cd "Práctica02/tests"
dotnet test