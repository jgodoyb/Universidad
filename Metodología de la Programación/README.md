# ☕ Metodología de la Programación (MP)

En este módulo se profundiza en la Ingeniería de Software, aplicando principios avanzados de Programación Orientada a Objetos (POO), diseño e implementación manual de estructuras de datos lineales y patrones de persistencia.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![UML](https://img.shields.io/badge/UML-Design-blue?style=for-the-badge)
![Patterns](https://img.shields.io/badge/Design_Patterns-DAO_Strategy-green?style=for-the-badge)

## 📚 Contenido por Sesiones

El código fuente se encuentra estructurado en el paquete `src/org/mp`, mostrando una evolución clara en la complejidad del software sesión a sesión:

### 🔹 Bloque 1: POO Avanzada y Genericidad
* **Sesión 01 - Conceptos Base:** Repaso de clases, objetos y modularidad (`Baraja`, `Carta`, `Fraccion`).
* **Sesión 02 - Abstracción y Polimorfismo:**
    * **Jerarquía de Herencia:** Clase abstracta `Persona` extendida por `Estudiante`, `Profesor` y `Empleado`.
    * **Genericidad:** Implementación de `MatrizGenerica<T>` para operar indistintamente con diferentes tipos de datos numéricos y objetos (`MatrizFraccion`, `MatrizInteger`).
    * **Interfaces:** Uso de contratos mediante interfaces como `ObjetoGeometrico`.

### 🔹 Bloque 2: Estructuras de Datos (Implementación Propia)
A diferencia de usar las colecciones estándar de Java, aquí se implementan "desde cero" para comprender su gestión interna de memoria y punteros:
* **Sesión 03 - Listas:**
    * Jerarquía: `List` (Interfaz) → `AbstractList` → `ArrayList` y `LinkedList`.
    * Manejo de nodos doblemente enlazados y arrays dinámicos.
* **Sesión 04 - Pilas, Colas y Aplicaciones:**
    * Implementación de `GenericStack` (Pila) y `GenericQueue` (Cola).
    * **Evaluador:** Algoritmo para evaluar expresiones matemáticas en notación postfija usando pilas.
    * **Problema de Josephus:** Resolución algorítmica (`GenericJosephus`) utilizando colas circulares.
    * **Listas Ordenadas:** Implementación de `SortedLinkedList`.

### 🔹 Bloque 3: Algoritmia y Comparadores
* **Sesión 05 - Ordenación y Búsqueda:**
    * **Algoritmos de Ordenación:** Implementación manual de `Mergesort` y `Quicksort` en la clase `Ordenacion`.
    * **Comparadores (Strategy Pattern):** Flexibilidad en criterios de ordenación implementando `Comparator<T>` (ej. `NumeroPaloComparator`, `VolumenComparator`).
    * **Búsqueda:** Búsqueda binaria y manejo de excepciones propias (`ElementoNoEncontradoException`).

### 🔹 Bloque 4: Persistencia y Patrones de Diseño
* **Sesión 06 - Ficheros de Texto:**
    * Lectura, escritura y parsing de datos estructurados (`ConjuntoDatos`, `Estadistica`) apoyado en `UtilidadArchivos`.
* **Sesión 07 - Ficheros Binarios y DAO:**
    * **Serialización:** Almacenamiento persistente de objetos complejos como `Imagen` y `Banda` en formato binario (`.dat`).
    * **Patrón DAO (Data Access Object):** La clase `ImagenDAO` abstrae la lógica de acceso a datos, separando completamente el almacenamiento en disco de la lógica de negocio.

## 📐 Diseño UML
La carpeta `/uml` contiene los diagramas de clases (`.cld`) generados durante la fase de diseño, que sirven como plano arquitectónico para la implementación (ej. `LinkedList.cld`, `MatrizGenerica.cld`, `Evaluador.cld`).

## 🛠️ Ejecución
El proyecto sigue la estructura de paquetes estándar de Java.

**Ejemplo de compilación y ejecución:**
```bash
# Desde la carpeta src
javac org/mp/sesion04/Evaluador.java
java org.mp.sesion04.Evaluador