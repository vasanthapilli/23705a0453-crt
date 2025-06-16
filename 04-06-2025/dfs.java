import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int vertices = 5; // Define the number of vertices
        Graph graph = new Graph(vertices, false);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);

        graph.printGraph();

        System.out.println("DFS traversal:");
        graph.dfs(0, new boolean[vertices]);
    }
}

class Graph {
    ArrayList<HashSet<Integer>> graph;
    int vertices;
    boolean isDirected;

    Graph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        this.graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new HashSet<>());
        }
    }

    public void addEdge(int src, int dest) {
        if (isValid(src, dest)) {
            this.graph.get(src).add(dest);
            if (!this.isDirected) {
                this.graph.get(dest).add(src);
            }
        } else {
            System.out.println("Invalid edge: " + src + " -> " + dest);
        }
    }

    private boolean isValid(int src, int dest) {
        return (src >= 0 && src < vertices) && (dest >= 0 && dest < vertices);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (Integer neighbor : graph.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (Integer neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }
}
