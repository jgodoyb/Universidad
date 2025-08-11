# Práctica 1 – Esquema Divide-and-Conquer  
**Asignatura:** EDA II – 2º Grado en Ingeniería Informática  
**Autor(es):** Jorge Godoy Beltrán

---

## 📌 Objetivo  
Implementar y analizar diferentes versiones de algoritmos para resolver el **problema del par de puntos más cercano** en un conjunto bidimensional, utilizando tanto enfoques **iterativos** como **divide-and-conquer**.  
El objetivo principal es comparar su **eficiencia teórica y experimental**, justificando las diferencias encontradas y verificando su correcto funcionamiento con datos reales y sintéticos.

---

## 📄 Descripción del problema  
La empresa ficticia **EDAsoft**, perteneciente a *theBestSoft*, recibe el encargo de **EDAena** para analizar posiciones de aeronaves en un instante concreto y determinar el par de aviones más cercanos.  
En caso de que la distancia mínima sea inferior a un **umbral de seguridad**, se generará una señal de alerta para evitar posibles colisiones.

El problema se formula así:  
> *Dado un array P de n puntos (x, y) en un plano 2D, encontrar el par de puntos cuya distancia euclídea sea mínima.*

---

## ⚙️ Algoritmos implementados  

Se han desarrollado e implementado **seis algoritmos**:

1. **Iterativo – Fuerza bruta:**  
   Calcula la distancia entre todos los pares posibles de puntos (O(n²)).

2. **Iterativo mejorado:**  
   Reduce el número de comparaciones a n(n-1)/2.

3. **Divide-and-Conquer básico:**  
   - Ordena los puntos por coordenada x.  
   - Divide el conjunto en dos mitades.  
   - Combina resultados evaluando posibles pares cercanos entre mitades.

4. **Divide-and-Conquer con optimización de franja central:**  
   Considera solo los puntos cercanos a la línea divisoria en una franja de ancho `2d`.

5. **Divide-and-Conquer con ordenación por Y y regla de los 7:**  
   Ordena la franja central por coordenada y y compara un punto con un máximo de 7 vecinos.

6. **Divide-and-Conquer optimizado (versión final):**  
   - Mantiene dos arrays ordenados por X e Y.  
   - Genera subarrays en tiempo lineal.  
   - Aplica regla de los 7 en la fase de combinación.

---

## 📑 Documentos asociados  

https://github.com/jgodoyb/Universidad/tree/main/Estrructura%20de%20Datos%20y%20Algoritmos%20II/docs/practica01

