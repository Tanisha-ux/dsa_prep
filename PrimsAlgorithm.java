
import java.util.*;

public class PrimsAlgorithm {
    static class Edge{
        int src,dest,wt;

        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    public static void createGraph(ArrayList<Edge> []graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));

        // 0 --4-- 2
        graph[0].add(new Edge(0, 2, 4));
        graph[2].add(new Edge(2, 0, 4));

        // 1 --2-- 2
        graph[1].add(new Edge(1, 2, 2));
        graph[2].add(new Edge(2, 1, 2));

        // 1 --7-- 3
        graph[1].add(new Edge(1, 3, 7));
        graph[3].add(new Edge(3, 1, 7));

        // 2 --3-- 4
        graph[2].add(new Edge(2, 4, 3));
        graph[4].add(new Edge(4, 2, 3));

        // 3 --1-- 5
        graph[3].add(new Edge(3, 5, 1));
        graph[5].add(new Edge(5, 3, 1));

        // 4 --5-- 5
        graph[4].add(new Edge(4, 5, 5));
        graph[5].add(new Edge(5, 4, 5));

        // 4 --2-- 3
        graph[4].add(new Edge(4, 3, 2));
        graph[3].add(new Edge(3, 4, 2));

    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n,int path){
            this.n=n;
            this.path=path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }

    public static void Prims(ArrayList<Edge>[]graph,int src){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        boolean vis[]=new boolean[graph.length];
        pq.add(new Pair(src,0));

        int finalcost=0;
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            
            if(!vis[curr.n]){
                vis[curr.n]=true;
                finalcost+=curr.path;

                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e=graph[curr.n].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }

        System.out.println(finalcost);
        
        
        
    }
    
    public static void main(String[] args) {
        ArrayList<Edge>[]graph=new ArrayList[6];

        createGraph(graph);
        Prims(graph,0);


    }




}
