package Graphs;

import java.util.LinkedList;

public class GraphAdjList {
    LinkedList<Integer>[] adj;
    
    public GraphAdjList(int nodes) {
        this.adj = new LinkedList[nodes];
        for(int i = 0; i < nodes; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
    }

    public static void main(String[] args) {
        GraphAdjList g = new GraphAdjList(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
    }
}
