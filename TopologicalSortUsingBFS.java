import java.util.*;

public class TopologicalSortUsingBFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Calculate indegree of all vertices
    public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    // Topological sort using BFS (Kahn's Algorithm)
    public static void topSort(ArrayList<Edge>[] graph) {
        int deg[] = new int[graph.length];
        calcIndeg(graph, deg);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < deg.length; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                deg[e.dest]--;
                if (deg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    // -------- MAIN FUNCTION --------
    public static void main(String[] args) {
        int V = 6; // number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph (DAG)
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        // Perform Topological Sort
        System.out.println("Topological Sort (BFS / Kahn's Algorithm):");
        topSort(graph);
    }
}
