# ☕ Estructura de Datos y Algoritmos II

Continuación avanzada de la ingeniería algorítmica. Este repositorio contiene la implementación de diversos paradigmas de diseño de algoritmos para resolver problemas complejos de optimización.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Algorithms](https://img.shields.io/badge/Algorithms-Complexity-red?style=for-the-badge)

## 🧠 Paradigmas de Diseño

Las prácticas están organizadas por el esquema algorítmico utilizado:

| Práctica | Paradigma | Problema / Caso de Estudio |
| :--- | :--- | :--- |
| **01** | **Divide y Vencerás** | *Control del espacio aéreo*: Problema de los pares de puntos más cercanos (Closest Pair of Points). |
| **02** | **Algoritmos Voraces (Greedy)** | Optimización de rutas en grafos sobre mapas personalizados (`EDA Land`). |
| **03** | **Greedy & Prog. Dinámica** | El problema del viajante de comercio (**TSP** - Travelling Salesman Problem). Comparativa de eficiencia. |
| **04** | **Backtracking & Branch-Bound** | Búsqueda exacta en espacios de estados para rutas óptimas. |

## 📂 Estructura de Archivos
* `src/`: Código fuente Java.
* `docs/`: Memorias y documentación de las prácticas (PDF/DOCX).
* `datasets/`: Archivos de texto con datos de prueba (grafos, coordenadas, mapas).

## 🚀 Cómo Ejecutar

Cada práctica cuenta con su propia clase `Main.java` o clases de prueba específicas.

**Ejemplo (Línea de comandos):**
```bash
cd "src/main/java/ual/eda2/practica01 - Divide y Vencerás"
javac Main.java
java Main