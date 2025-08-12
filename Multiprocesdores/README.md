# 🖥️ Multiprocesadores

Este repositorio contiene el trabajo desarrollado en la asignatura **Multiprocesadores**, donde se estudian y aplican diferentes técnicas de programación paralela y concurrente.  
El objetivo es resolver un mismo conjunto de problemas con distintas tecnologías, evaluando rendimiento, escalabilidad y complejidad de implementación.

---

## 📚 Contenido del repositorio

El repositorio se organiza en tres prácticas principales.  
En todas ellas se resuelven los mismos problemas, pero con enfoques de programación diferentes:

### 1️⃣ Práctica 01 — **Versión Secuencial**
Implementación clásica sin paralelismo.  
Sirve como punto de referencia para medir las mejoras obtenidas con técnicas paralelas.

- **Ejercicios incluidos:**
  - `Bandera` → Generación de un patrón tipo bandera.
  - `Mandel` → Cálculo y representación del conjunto de Mandelbrot.
  - `Wa-Tor` → Simulación de un ecosistema marino con depredadores y presas.

---

### 2️⃣ Práctica 02 — **Programación con pthreads**
Uso de hilos POSIX para paralelizar el trabajo, distribuyendo las tareas entre múltiples hilos.  
Se abordan aspectos como la sincronización, comunicación y partición de datos.

- **Ejercicios incluidos:**
  - `Bandera-PTh`
  - `Mandel-PTh`
  - `Wa-Tor-PTh`

---

### 3️⃣ Práctica 03 — **Programación con MPI**
Implementación distribuida usando **Message Passing Interface (MPI)**.  
Permite la ejecución en sistemas con múltiples nodos, aprovechando memoria distribuida y comunicación por paso de mensajes.

- **Ejercicios incluidos:**
  - `Bandera-MPI`
  - `Mandel-MPI`

---

## ⚙️ Tecnologías utilizadas

- **Lenguaje:** C
- **Paralelismo con hilos:** `pthreads`
- **Paralelismo distribuido:** `MPI`
- **Herramientas de compilación:** `make`, `gcc`
- **Scripts de ejecución:** `Run.sh`

---

## 📂 Estructura del repositorio
Multiprocesdores/
│
├── Practica01/ # Versión secuencial
│ ├── Bandera/
│ ├── Mandel/
│ └── Wa-tor/
│
├── Practica02/ # Versión con pthreads
│ ├── Bandera-PTh/
│ ├── Mandel-PTh/
│ └── Wa-tor-PTh/
│
├── Practica03/ # Versión con MPI
│ ├── Bandera-MPI/
│ └── Mandel-MPI/

---

## 🏆 Objetivo de la asignatura

- Comprender la diferencia entre **programación secuencial, paralela y distribuida**.
- Aprender a utilizar **pthreads** y **MPI** en C.
- Evaluar el **rendimiento y escalabilidad** de diferentes enfoques.
- Desarrollar habilidades en **depuración y optimización** de programas paralelos.

---

## 📌 Notas

Cada carpeta de práctica incluye su propio `makefile` y un script `Run.sh` para ejecutar los programas con parámetros predefinidos.
