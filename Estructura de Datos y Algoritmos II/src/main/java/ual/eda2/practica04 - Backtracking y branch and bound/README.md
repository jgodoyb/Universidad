# Práctica 4 – Organizando la concesión de proyectos

---

## 📌 Objetivo  
Implementar y analizar algoritmos de **búsqueda exhaustiva optimizada** para resolver problemas combinatorios, utilizando los esquemas **Backtracking** y **Branch and Bound**.  
El objetivo es comparar el rendimiento de ambos enfoques y estudiar cómo las podas y heurísticas influyen en la reducción del espacio de búsqueda.

---

## 📄 Descripción del problema  
La empresa ficticia **EDAOptimiza** necesita resolver un problema de asignación y planificación que puede representarse como una búsqueda de soluciones en un espacio de combinaciones.  
En este caso, se utiliza un problema modelo que permite evaluar y comparar la eficacia de **Backtracking** y **Branch and Bound** para encontrar soluciones óptimas o factibles.

---

## ⚙️ Algoritmos implementados  

1. **Backtracking básico**  
   - Genera el árbol de soluciones explorando todas las posibilidades.  
   - Aplica poda cuando una solución parcial no puede conducir a una solución válida.  

2. **Backtracking con poda adicional**  
   - Usa criterios adicionales para reducir el espacio de búsqueda.  
   - Puede incluir ordenación previa de elementos o selección inteligente de candidatos.  

3. **Branch and Bound (B&B)**  
   - Construye un árbol de búsqueda ordenando los nodos según una función de coste/beneficio.  
   - Usa una cota superior/inferior para descartar ramas completas sin explorarlas.  

4. **Branch and Bound con heurísticas**  
   - Aplica estimaciones más ajustadas para mejorar la poda.  
   - Permite encontrar soluciones óptimas más rápido en la práctica.  

---

## 📑 Documentos asociados  

https://github.com/jgodoyb/Universidad/tree/main/Estructura%20de%20Datos%20y%20Algoritmos%20II/docs/practica04

---