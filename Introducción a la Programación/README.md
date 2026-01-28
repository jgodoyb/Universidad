# ☕ Introducción a la Programación (IP)

Este repositorio contiene la colección completa de laboratorios y ejercicios prácticos de la asignatura **Introducción a la Programación**. El código documenta la evolución desde el pensamiento imperativo básico hasta el diseño de sistemas orientados a objetos, implementado en **Java**.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Learning Curve](https://img.shields.io/badge/Learning_Curve-Steep-red?style=for-the-badge)

## 📚 Mapa del Contenido

El código fuente se encuentra bajo `src/main/java/ual/ip` y está organizado meticulosamente por sesiones de laboratorio, cubriendo los siguientes tópicos:

### 🔹 Bloque 1: Programación Estructurada

* **Sesión 01 - Tipos de Datos y E/S Básica**
    * Manejo de la clase `Math` y entrada por consola.
    * *Ejercicios clave:* `CalculoIntereses` (aritmética financiera), `ConversorEurosPesetas` (casting y tipos), `EnteroAleatorio`.

* **Sesión 02 - Estructuras de Selección**
    * Lógica condicional compleja (`if-else`, `switch`, operador ternario).
    * *Ejercicios clave:*
        * `FechaCorrecta`: Algoritmo de validación de días/meses/años.
        * `EcuacionSegundoGrado`: Manejo de discriminantes y raíces.
        * `TarifaTaxi`: Lógica de negocio con múltiples condiciones.

* **Sesión 03 - Estructuras de Iteración**
    * Bucles `for`, `while`, `do-while` y bucles anidados.
    * *Ejercicios clave:*
        * `Fibonacci` & `Primo`: Algoritmos matemáticos clásicos.
        * `Euclides`: Cálculo del Máximo Común Divisor (MCD).
        * `CuadradoAsteriscos` / `TrianguloRectangulo`: Lógica de dibujo en consola.

* **Sesión 04 - Modularidad y Métodos**
    * Descomposición de problemas en subrutinas estáticas (`static methods`).
    * *Ejercicios clave:*
        * `PrintCalendario`: Algoritmo complejo modularizado para imprimir cualquier mes/año.
        * `SumaSerie` y `Sumatoria`: Abstracción de operaciones matemáticas.
        * `ValidarFecha`: Reutilización de lógica de validación.

### 🔹 Bloque 2: Estructuras de Datos Estáticas

* **Sesión 05 - Arrays y Matrices**
    * Manipulación de vectores y matrices multidimensionales.
    * *Ejercicios clave:*
        * `EstadisticasArrays`: Algoritmos de recorrido (Min, Max, Media).
        * `MatrizMagica`: Verificación de propiedades matemáticas en matrices cuadradas.
        * `MatricesBinarias`: Manipulación de bits y lógica booleana en grids.

### 🔹 Bloque 3: Programación Orientada a Objetos (POO)

* **Sesión 06 - Conceptos de Clase y Objeto**
    * Transición del paradigma imperativo al orientado a objetos. Encapsulamiento básico.
    * *Clases:* `Reloj` (manejo de tiempo), `Fraccion` (aritmética de objetos), `Circulo`.
    * *Testing:* Introducción a clases de prueba (`TestReloj`, `TestFraccion`).

* **Sesión 07 - Diseño de Objetos Avanzado**
    * Constructores, sobrecarga, métodos `toString`, inmutabilidad y privacidad.
    * *Clases:*
        * `HoraExacta` vs `Hora12`: Diferentes representaciones internas de un mismo concepto.
        * `Multimedia` / `Pelicula`: Modelado de entidades del mundo real.

* **Sesión 08 - Colecciones de Objetos**
    * Gestión de Arrays que contienen referencias a objetos.
    * *Sistema:* `AsignaturaNota` y `Alumno`. Permite gestionar calificaciones, calcular medias y filtrar alumnos aprobados mediante manipulación de objetos dentro de estructuras estáticas.

## 🛠️ Compilación y Ejecución

El proyecto sigue la estructura de directorios estándar de Java. Puedes compilar cualquier archivo individualmente.

**Ejemplo: Ejecutar el generador de calendarios**
```bash
cd src/main/java
javac ual/ip/sesion04/PrintCalendario.java
java ual.ip.sesion04.PrintCalendario