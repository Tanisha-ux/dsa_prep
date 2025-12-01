import java.util.*;

public class Bipartite {
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

    public static boolean isBipartite(ArrayList<Edge> []graph,int col[]){
        Arrays.fill(col,-1);
        Queue<Integer> q=new LinkedList<>();
    

        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=0;

                while(!q.isEmpty()){
                    int curr= q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e=graph[curr].get(j);
                        if(col[e.dest]==-1){
                            int nextCol=col[curr]==0?1:0;
                            col[e.dest]=nextCol;

                            q.add(e.dest);
                            
                        }

                        else if(col[e.dest]==col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    int V = 6; // number of vertices
    ArrayList<Edge>[] graph = new ArrayList[V];
    int col[]=new int[V];

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
    System.out.println(isBipartite(graph,col));
    
    }
}
