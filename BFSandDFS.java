import java.util.*;

public class BFSandDFS {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void DFS(ArrayList<Edge> graph[],boolean isVisited[], int curr){
        System.out.print(curr+" ");
        isVisited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!isVisited[e.dest]){
                DFS(graph,isVisited,e.dest);
            }
        }
    }

    

    

    public static void BFS(ArrayList<Edge> []list){
        Queue<Integer> q=new LinkedList<>();
        boolean isVisited[]=new boolean[list.length];

        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!isVisited[curr]){
                isVisited[curr]=true;
                System.out.print(curr+" ");

                for(int i=0;i<list[curr].size();i++){
                Edge e=list[curr].get(i);
                q.add(e.dest);
            }
            }
            
        }


    }

    public static void createGraph(ArrayList<Edge> graph[],int V){
        

        
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,5));

        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        graph[4].add(new Edge(4,2,2));

        for(int i=0;i<graph[2].size();i++){
            Edge e=graph[2].get(i);
            System.out.println(e.dest);
        }

    }

    public static void main(String[] args) {
    
        
    int V=5;
    int curr=0;
    ArrayList<Edge>graph[]=new ArrayList[V];
    boolean isVisited[]=new boolean[graph.length];
    createGraph(graph,V);
    
    BFS(graph);
    System.out.println();
    DFS(graph,isVisited,curr);
    
    }
}
