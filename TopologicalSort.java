import java.util.*;


public class TopologicalSort {
    static class Edge {
        int src;
        int dest;
        

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
            
        }
    }

    public static void topSortUtil(ArrayList<Edge>[]graph, boolean vis[],Stack<Integer> s,int curr){
        vis[curr]=true;
        

        for(int i=0;i<graph[curr].size();i++){ 
            Edge e=graph[curr].get(i);
            
            if(!vis[e.dest] ){
                topSortUtil(graph,vis,s,e.dest);
            }
        }

        s.push(curr);
        
    }

    public static void topSort(ArrayList<Edge>[]graph){
        boolean vis[]=new boolean[graph.length];
        Stack<Integer> s=new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topSortUtil(graph,vis,s,i);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
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

        topSort(graph);
    }



}
