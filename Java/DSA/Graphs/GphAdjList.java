// package Graphs;

// import java.util.*;

// // CLASS 
// class Pair {
//     String vertex;
//     int weight;

//     Pair(String vertex, int weight) {
//         this.vertex = vertex;
//         this.weight = weight;
//     }

//     @Override
//     public String toString() {
//         return "(" + vertex + ", " + weight + ")";
//     }
// }

// public class GphAdjList {
//     private Map<String, List<Pair>> adjList;

//     public GphAdjList() {
//         this.adjList = new HashMap<>();
//     }

//     public void addVertex(String v) {
//         adjList.putIfAbsent(v, new ArrayList<>());
//     }

//     public void addEdge(String u, String v, int weight) {
//         adjList.get(u).add(new Pair(v, weight));
//         adjList.get(v).add(new Pair(u, weight));
//     }

//     public void printGraph() {
//         for (String v : adjList.keySet()) {
//             System.out.println(v + " -> " + adjList.get(v));
//         }
//     }

//     public static void main(String[] args) {
//         GphAdjList g = new GphAdjList();
//         for (String v : new String[]{"A", "B", "C", "D", "E"}) {
//             g.addVertex(v);
//         }
//         g.addEdge("A", "B", 1);
//         g.addEdge("A", "C", 4);
//         g.addEdge("B", "C", 2);
//         g.addEdge("B", "D", 5);
//         g.addEdge("C", "E", 3);
//         g.addEdge("D", "E", 2);
//         g.printGraph();
//     }
// }