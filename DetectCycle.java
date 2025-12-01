import java.util.ArrayList;

public class DetectCycle {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static boolean detectCycleUtil(ArrayList<Edge> []graph,boolean vis[],int curr,int par){
        vis[curr]=true;

        for(int i=0;i<graph[curr].size() ;i++){
            Edge e=graph[curr].get(i);

            if(!vis[e.dest] ){
                if(detectCycleUtil(graph,vis,e.dest,curr)){
                    return true;
                }
            }

            else if(vis[e.dest] && e.dest!=par){
                return true;
            }
        }

        return false;

    }

    public static boolean detectCycle(ArrayList<Edge> []graph){
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
            if(detectCycleUtil(graph,visited,i,-1)){
                return true;
            }
            }
        }
        return false;
        
    }




    public static void main(String[] args) {
    int V = 6; // number of vertices
    ArrayList<Edge>[] graph = new ArrayList[V];

    // Initialize adjacency list
    for (int i = 0; i < V; i++) {
        graph[i] = new ArrayList<>();
    }

    // Example with a cycle: 0-1-2-0
    graph[0].add(new Edge(0, 1, 1));
    graph[1].add(new Edge(1, 0, 1));
    graph[1].add(new Edge(1, 2, 1));
    graph[2].add(new Edge(2, 1, 1));
    graph[2].add(new Edge(2, 0, 1));
    graph[0].add(new Edge(0, 2, 1));

    // Another component: 3-4
    graph[3].add(new Edge(3, 4, 1));
    graph[4].add(new Edge(4, 3, 1));

    // Isolated node 5

    boolean hasCycle = detectCycle(graph);
    System.out.println("Cycle present? " + hasCycle);
    }

}
