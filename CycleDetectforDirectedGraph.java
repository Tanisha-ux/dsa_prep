import java.util.ArrayList;

public class CycleDetectforDirectedGraph {
    static class Edge {
        int src;
        int dest;
        

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
            
        }
    }

    public static boolean isCycleUtil(ArrayList<Edge>[]graph, boolean vis[],boolean stack[],int curr){
        vis[curr]=true;
        stack[curr]=true;

        for(int i=0;i<graph[curr].size();i++){ 
            Edge e=graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph,vis,stack,e.dest)){
                return true;
            }
        }

        stack[curr]=false;
        return false;
    }

    public static boolean isCycle(ArrayList<Edge>[]graph){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph,vis,stack,i)){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4; // number of vertices
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Initialize graph
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges (directed graph)
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1)); // back edge creates a cycle

        if (isCycle(graph)) {
            System.out.println("Cycle detected in the graph");
        } else {
            System.out.println("No cycle in the graph");
        }
    }

}
