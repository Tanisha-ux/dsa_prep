import java.util.*;

public class SourceToTarget {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void allpaths(ArrayList<Edge> []graph,int src,int dest,String path){
        
        if(src==dest){
            System.out.println(path+dest);
            return;
        }

        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            allpaths(graph,e.dest,dest,path+src);
        }
    }

    public static void main(String[] args) {
        int V = 6; // number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph (directed)
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 5));

        int src = 0, dest = 5;
        System.out.println("All paths from " + src + " to " + dest + ":");
        allpaths(graph, src, dest, "");
    }
}
