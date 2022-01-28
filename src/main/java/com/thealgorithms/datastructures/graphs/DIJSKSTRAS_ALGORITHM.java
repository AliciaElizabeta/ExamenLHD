/*
Refer https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
for better understanding 
 */
package com.thealgorithms.datastructures.graphs;
import java.util.Random;

/*! \brief Clase DIJSKSTRAS_ALGORITHM
 * Esta clase se encarga de realizar el algoritmo de dijkstra
 * dado un grafo
 */

public class DIJSKSTRAS_ALGORITHM {
    private static Random r;
    int k = 9;

    //! Metodo getK().
    /*!
      Retorna el valor de K que esta inicializado a 9
      pero esto cambia segun el grafo
    */
    public int getK(){ return k; }

    //! Metodo minDist().
    /*!
      A partir de un array de distancias y un conjunto de
      booleanos asociadas a las posiciones del array
      devuelve el indice del array con distancia minima
    */
    public int minDist(int dist[], Boolean Set[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int r = 0; r < k; r++) {
            if (Set[r] == false && dist[r] <= min) {
                min = dist[r];
                min_index = r;
            }
        }

        return min_index;
    }

    //! Metodo print().
    /*!
      Recibe un array de distancias y muestra
      una salida formateada, además retorna en
      este caso un String con dicha salida
    */
    public String print(int dist[]) {
        System.out.println("Vertex \t\t Distance");
        String toReturn = "Vertex \t\t Distance";
        for (int i = 0; i < k && i < dist.length; i++) {
            System.out.println(i + " \t " + dist[i]);
            toReturn.concat("\ni + \" \\t \" + dist[i]");
        }
        return toReturn;
    }

    //! Metodo aleatorySelectionRCL.
    /*!
      Se indica un valor maximo y se seleciona una posicion
      calculada aleatoriamente entre el maximo y 0
    */
    public int aleatorySelectionRCL(int maxTRCL) {
       r = new Random();
       int low = 0;
       int high = maxTRCL;
       int posSelected = r.nextInt(high-low) + low;
       return posSelected;
    }

    //! Metodo dijkstra.
    /*!
      A partir de un grafo realiza el algoritmo
      de dijkstra
    */
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[k];
        Boolean Set[] = new Boolean[k];

        for (int i = 0; i < k; i++) {
            dist[i] = Integer.MAX_VALUE;
            Set[i] = false;
        }

        dist[src] = 0;

        for (int c = 0; c < k - 1; c++) {

            int u = minDist(dist, Set);

            Set[u] = true;

            for (int v = 0; v < k; v++) {
                if (!Set[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        print(dist);
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
        {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0},
        {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},
        {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        DIJSKSTRAS_ALGORITHM t = new DIJSKSTRAS_ALGORITHM();
        t.dijkstra(graph, 0);
    }//main

}//djikstras

/*
OUTPUT :
Vertex   Distance 
0            0
1            4
2            12
3            19
4            21
5            11
6            9
7            8
8            14
 */
