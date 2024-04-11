package Graphs;

import java.util.LinkedList;

class Edge {
    int vertex;
    int weight;

    public Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class GraphAdjList {
    LinkedList<Edge>[] adj;
    
    public GraphAdjList(int nodes) {
        this.adj = new LinkedList[nodes];
        for(int i = 0; i < nodes; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int u, int v, int weight) {
        this.adj[u].add(new Edge(v, weight));
        this.adj[v].add(new Edge(u, weight));
    }

    

    public static void main(String[] args) {
        GraphAdjList g = new GraphAdjList(5);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 4, 3);
        g.addEdge(3, 4, 2);
    }
}
