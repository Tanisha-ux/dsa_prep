import java.util.*;

public class ConnectingCities {
    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }

    public static void minimumCost(int cities[][], int src, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[n];  // visited cities
        pq.add(new Edge(src, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                finalCost += curr.cost;

                // add all neighbours
                for (int i = 0; i < cities[curr.node].length; i++) {
                    if (!vis[i] && cities[curr.node][i] != 0) { // only add valid edges
                        pq.add(new Edge(i, cities[curr.node][i]));
                    }
                }
            }
        }

        System.out.println("Minimum cost to connect all cities = " + finalCost);
    }

    public static void main(String[] args) {
        int cities[][] = {
            {0, 1, 2, 3, 4},
            {1, 0, 5, 0, 7},
            {2, 5, 0, 6, 0},
            {3, 0, 6, 0, 0},
            {4, 7, 0, 0, 0}
        };
        int n = cities.length;
        int src = 0;

        minimumCost(cities, src, n);
    }
}
