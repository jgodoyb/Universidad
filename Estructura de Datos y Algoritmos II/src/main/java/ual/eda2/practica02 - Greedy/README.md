# Práctica 2 – Servicio web para la generación de rutas óptimas en redes
---

## 📌 Objetivo  
Implementar y analizar diferentes algoritmos para resolver el problema de **encontrar rutas óptimas en redes** utilizando el enfoque **greedy** y variantes más avanzadas (Dijkstra, A*, Widest Path).  
El objetivo principal es comparar su **eficiencia teórica y experimental**, utilizando tanto redes de carreteras reales como redes generadas aleatoriamente.

---

## 📄 Descripción del problema  
La empresa ficticia **EDAOptimalRoute** necesita un servicio web que proporcione la **ruta más corta** (menor distancia) entre dos núcleos de población de EDAland.  
Además, se exploran variantes como encontrar rutas con restricciones (paso por un punto concreto) y el **Widest Path Problem** (camino de máxima capacidad).

El problema se formula así:  
> *Dado un grafo ponderado positivamente (dirigido o no dirigido), encontrar el camino mínimo o máximo entre dos vértices, según el criterio definido.*

---

## ⚙️ Algoritmos implementados  

1. **Dijkstra Greedy (O(V²))**  
   Implementación vista en clase para obtener la ruta más corta desde un vértice origen hasta todos los demás.

2. **DijkstraNaive**  
   Versión intuitiva que busca el vértice con distancia mínima iterando sobre los no visitados.

3. **DijkstraPQ**  
   Versión optimizada con cola de prioridad (`PriorityQueue`), complejidad O(E log V).

4. **DijkstraBestFirst**  
   Variante Best-First Search sin lista de visitados, priorizando siempre el siguiente vértice con menor distancia.

5. **A***  
   Algoritmo de búsqueda informada que combina Dijkstra y heurísticas (en este caso, distancia Euclídea).

6. **DijkstraAStar**  
   Versión híbrida que integra Best-First y heurística sin listas abiertas/cerradas.

7. **DijkstraBestFirstWPP**  
   Implementación del **Widest Path Problem** (camino más ancho) para maximizar la arista mínima del recorrido.

8. **Ruta con paso obligatorio**  
   Adaptación de los algoritmos anteriores para calcular la ruta más corta que pase por un vértice intermedio obligatorio.

---

## 📑 Documentos asociados  

https://github.com/jgodoyb/Universidad/tree/main/Estructura%20de%20Datos%20y%20Algoritmos%20II/docs/practica02

---
