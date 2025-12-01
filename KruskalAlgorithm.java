import java.util.*;


public class KruskalAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest,int wt) {
            this.src = src;
            this.dest = dest;
            this.wt=wt;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }
    static int V=4;
    static int par[]=new int[V];
    static int rank[]=new int[V];

    public static void init(){
        for(int i=0;i<par.length;i++){
            par[i]=i;
            rank[i]=0;
        }
    }

    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        else return par[x]=find(par[x]);
    }

    public static void union(int A,int B){
        int parA=find(A);
        int parB=find(B);

        if(rank[parA]==rank[parB]){
            par[parA]=parB;
            rank[parB]++;
        }

        else if(rank[parA]>rank[parB]){
            par[parB]=parA;
        }

        else{
            par[parA]=parB;
        }
    }


    public static void kruskals(ArrayList<Edge>edge){
        init();
        Collections.sort(edge);
        int cost=0;
        int count=0;

        for(int i=0;count<V-1;i++){
            Edge e=edge.get(i);

            int u=find(e.src);
            int v=find(e.dest);
            int w=e.wt;

            if(u!=v){
                union(e.src,e.dest);
                cost+=w;
                count++;
            }

            
        }
        System.out.println(cost);

    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();

        // Example graph
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        kruskals(edges); // run Kruskal's algorithm
    }

}
