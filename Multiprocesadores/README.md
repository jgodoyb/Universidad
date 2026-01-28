# ⚡ Multiprocesadores y Programación Paralela

Desarrollo de aplicaciones de alto rendimiento (HPC) utilizando lenguaje C en entornos Linux. Se exploran diferentes modelos de programación paralela para acelerar cálculos intensivos.

![C](https://img.shields.io/badge/C-00599C?style=for-the-badge&logo=c&logoColor=white)
![MPI](https://img.shields.io/badge/OpenMPI-High_Performance-blue?style=for-the-badge)
![Bash](https://img.shields.io/badge/Bash-Scripting-4EAA25?style=for-the-badge&logo=gnu-bash&logoColor=white)

## ⚙️ Modelos de Programación

El repositorio cubre tres enfoques para los mismos problemas computacionales:

| Práctica | Modelo | Tecnologías | Descripción |
| :--- | :--- | :--- | :--- |
| **Practica 01** | **Secuencial** | C estándar | Línea base para comparativas de rendimiento (`gmon.out`). |
| **Practica 02** | **Memoria Compartida** | **Pthreads** (POSIX Threads) | Paralelización mediante hilos ligeros en un solo nodo. |
| **Practica 03** | **Memoria Distribuida** | **MPI** (Message Passing Interface) | Paralelización mediante procesos comunicados por mensajes. |

## 🧪 Problemas Resueltos
1.  **Simulación Wa-tor:** Dinámica de poblaciones depredador-presa en un toroide.
2.  **Conjunto de Mandelbrot:** Generación de fractales matemáticos.
3.  **Bandera:** Algoritmos de ordenación y procesamiento de matrices.

## 🚀 Compilación y Ejecución

Cada subcarpeta contiene un `makefile` y un script `Run.sh` para automatizar el proceso.

**Requisitos:** GCC, OpenMPI (`mpicc`, `mpirun`), Pthreads.

**Ejemplo de ejecución (MPI):**
```bash
cd Multiprocesadores/Practica03/Mandel-MPI
make clean
make
./Run.sh  # Ejecuta mpirun con los parámetros configurados