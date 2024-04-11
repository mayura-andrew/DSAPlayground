package Graphs;

import java.util.*;

public class GrapthString {
    private int E; // number of edges in Graph
    private Map<String, Integer> adjMatrix;

    public GrapthString() {
        this.E = 0;
        this.adjMatrix = new HashMap<>();
    }

    public void addEdge(String u, String v, int weight) {
        adjMatrix.put(u + "," + v, weight);
        adjMatrix.put(v + "," + u, weight);
        E++;
    }
    
    public void printGraph(Set<String> vertices) {
        // Print the vertices as the first row
        for (String v : vertices) {
            System.out.print("\t" + v);
        }
        System.out.println();

        // Print the adjacency matrix
        for (String v1 : vertices) {
            System.out.print(v1 + "\t"); // Print the vertex as the first column
            for (String v2 : vertices) {
                String edge = v1 + "," + v2;
                int weight = adjMatrix.getOrDefault(edge, 0);
                System.out.print(weight + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GrapthString g = new GrapthString();
        Set<String> vertices = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E"));
        g.addEdge("A", "B", 1);
        g.addEdge("A", "C", 4);
        g.addEdge("B", "C", 2);
        g.addEdge("B", "D", 5);
        g.addEdge("C", "E", 3);
        g.addEdge("D", "E", 2);
        g.printGraph(vertices);

    }
}
