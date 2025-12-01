import java.util.*;

public class CheapestFlightsWithinKstops {
    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Info {
        int n;      // current node
        int cost;   // cost till now
        int stops;  // stops till now

        public Info(int n, int cost, int stops) {
            this.n = n;
            this.cost = cost;
            this.stops = stops;
        }
    }

    // Create graph using flights array (with a loop)
    public static ArrayList<Edge>[] createGraph(int n) {
        // Flights input array declared here
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 4, 100},
            {0, 3, 500},
            {3, 4, 100}
        };

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges using loop
        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            graph[u].add(new Edge(u, v, w));
        }

        return graph;
    }

    public static void cheapestflight(ArrayList<Edge>[] graph, int src, int dest, int K) {
        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr.stops > K) {
                continue;
            }

            for (Edge e : graph[curr.n]) {
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v] && curr.stops <= K) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        System.out.println("Minimum cost to reach " + dest + " within " + K + " stops:");
        if (dist[dest] == Integer.MAX_VALUE) {
            System.out.println("Not Possible");
        } else {
            System.out.println(dist[dest]);
        }
    }

    public static void main(String[] args) {
        int n = 5;  // number of cities
        ArrayList<Edge>[] graph = createGraph(n);

        int src = 0, dest = 4, K = 2;
        cheapestflight(graph, src, dest, K);
    }
}
