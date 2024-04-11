package Graphs;

import java.util.*;

public class AdjacencyList {
    private LinkedList<Integer> [] adj;
    private int V;  //number of vertices
    private int E; // number of edges

    @SuppressWarnings("unchecked")
    public AdjacencyList(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    ///BREADTH FIRST SEARCH (BFS)Traversal

    public void bfs(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        while(!q.isEmpty()) {
            int u = q.poll(); //enque
            System.out.print(u + " ");

            for(int v: adj[u]) {
                if(!visited[v]) {
                    visited[v] = true;
                    q.offer(v); // dequeue
                }
            }
        }
    }

    // DEPTH FIRST SEARCH
    public void dfs(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while(!stack.isEmpty()) {
            int u = stack.pop();
            if(!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");

                for (int v : adj[u]) {
                    if(!visited[v]){
                        stack.push(v);
                    }
                    
                }
            }
        }
    }

    // Recursive approach for DFS
    public void dfs() {
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; v++) {
            if(!visited[v]) {
                dfs(v, visited);
            }
        }
    }

    public void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for(int w : adj[v]){
            if(!visited[w]) {
                dfs(w, visited);
            }
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w :  adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
            
        }
        return sb.toString();
         
    }

    public static void main(String[] args) {
        AdjacencyList ad = new AdjacencyList(5);
        ad.addEdge(0, 1);
        ad.addEdge(1, 2);
        ad.addEdge(2, 3);
        ad.addEdge(3, 0);
        ad.addEdge(2, 4);
        System.out.println(ad);
        System.out.println();
        ad.bfs(0);
        System.out.println();
        // ad.dfs(0);
        System.out.println();
        ad.dfs();

    }


    
}


// package Graphs;

// import java.util.*;

// class Pair {
//     int vertex;
//     int weight;

//     Pair(int vertex, int weight) {
//         this.vertex = vertex;
//         this.weight = weight;
//     }

//     @Override
//     public String toString() {
//         return "(" + vertex + ", " + weight + ")";
//     }
// }

// public class AdjacencyList {
//     private List<Pair>[] adj;
//     private int V;  //number of vertices
//     private int E; // number of edges

//     public AdjacencyList(int nodes) {
//         this.V = nodes;
//         this.E = 0;
//         this.adj = new ArrayList[nodes];
//         for (int v = 0; v < V; v++) {
//             adj[v] = new ArrayList<>();
//         }
//     }

//     public void addEdge(int u, int v, int weight) {
//         adj[u].add(new Pair(v, weight));
//         adj[v].add(new Pair(u, weight));
//         E++;
//     }

//     public String toString() {
//         StringBuilder sb = new StringBuilder();
//         sb.append(V + " vertices, " + E + " edges " + "\n");
//         for (int v = 0; v < V; v++) {
//             sb.append(v + ": ");
//             for (Pair w :  adj[v]) {
//                 sb.append(w + " ");
//             }
//             sb.append("\n");
//         }
//         return sb.toString();
//     }

//     public static void main(String[] args) {
//         AdjacencyList ad = new AdjacencyList(5);
//         ad.addEdge(0, 1, 1);
//         ad.addEdge(0, 2, 4);
//         ad.addEdge(1, 2, 2);
//         ad.addEdge(1, 3, 5);
//         ad.addEdge(2, 4, 3);
//         ad.addEdge(3, 4, 2);
//         System.out.println(ad);
//     }
// }