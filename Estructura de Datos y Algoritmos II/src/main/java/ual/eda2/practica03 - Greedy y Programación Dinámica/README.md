# Práctica 3 – Un sistema eficiente de recogida de residuos ♻️
---

## 📌 Objetivo  
Implementar y comparar diferentes algoritmos para resolver el **Problema del Viajante de Comercio (TSP)**, utilizando enfoques **Greedy** y **Programación Dinámica (DP)**.  
El objetivo principal es estudiar el comportamiento y la eficiencia de cada enfoque en función del tamaño del problema, así como validar que las soluciones cumplen con las restricciones del TSP.

---

## 📄 Descripción del problema  
La empresa ficticia **EDAExpress** desea optimizar las rutas de reparto de sus vehículos para minimizar el coste total de viaje, visitando todas las ciudades exactamente una vez y regresando al punto de origen.

El problema se formula así:  
> *Dado un grafo completo ponderado con distancias entre ciudades, encontrar el ciclo Hamiltoniano de coste mínimo.*

---

## ⚙️ Algoritmos implementados  

1. **Greedy TSP:**  
   Selecciona en cada paso la arista de menor coste que conecta un vértice no visitado, construyendo la ruta de manera voraz.

2. **Greedy TSP con elección aleatoria controlada:**  
   Introduce aleatoriedad para romper empates y explorar rutas alternativas.

3. **Greedy TSP con dos criterios:**  
   Combina distancia mínima y otro criterio adicional para seleccionar la siguiente ciudad.

4. **Programación Dinámica – Held-Karp:**  
   - Complejidad O(n²·2ⁿ)  
   - Calcula la solución óptima utilizando subproblemas que representan rutas parciales y conjuntos de ciudades visitadas.

5. **Greedy mejorado con 2-opt:**  
   Aplica optimización local para mejorar una solución inicial greedy, intercambiando aristas y reduciendo el coste total.

---

## 📑 Documentos asociados  

https://github.com/jgodoyb/Universidad/tree/main/Estructura%20de%20Datos%20y%20Algoritmos%20II/docs/practica03

---