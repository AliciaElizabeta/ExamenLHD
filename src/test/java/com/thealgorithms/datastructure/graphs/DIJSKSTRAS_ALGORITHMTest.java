package com.thealgorithms.datastructure.graphs;

import com.thealgorithms.datastructures.graphs.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DIJSKSTRAS_ALGORITHMTest {

    @Test
    void testFor1(){
        DIJSKSTRAS_ALGORITHM a = new DIJSKSTRAS_ALGORITHM();
        assertTrue(a.aleatorySelectionRCL(10)<11);}

    @Test
    void testFor2(){
        DIJSKSTRAS_ALGORITHM a = new DIJSKSTRAS_ALGORITHM();
        assertTrue(a.getK() == 9);
    }

    @Test
    void testFor3(){
        DIJSKSTRAS_ALGORITHM a = new DIJSKSTRAS_ALGORITHM();
        int dist[] = new int[2];
        dist[0] = 10 ; dist[1] = 20;
        String aux = "Vertex \t\t Distance";
        assertTrue(a.print(dist) == aux);

    }
}
