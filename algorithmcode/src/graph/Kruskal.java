package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        if(this.cost < o.cost)
            return -1;
        else if(this.cost == o.cost)
            return 0;
        else
            return 1;
    }
}

class Main {
    public static int[] parent;
    static int V, E;
    public static List<Edge> list;

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y)
            parent[y] = x;
    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] VE = br.readLine().split(" ");
        V = Integer.parseInt(VE[0]);
        E = Integer.parseInt(VE[1]);

        list = new ArrayList<>();
        for(int i=0;i<E;i++){
            String[] inputs = br.readLine().split(" ");
            list.add(new Edge(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]),Integer.parseInt(inputs[2])));
        }

        parent = new int[V+1];

        for(int i=1;i<=V;i++){
            parent[i]=i;
        }

        list.sort(Comparator.naturalOrder());

        int sum = 0;

        for(int i=0;i<E;i++){
            Edge edge = list.get(i);
            if(!isSameParent(edge.v1,edge.v2)){
                union(edge.v1,edge.v2);
                sum+=edge.cost;
            }
        }

        System.out.println(sum);

        br.close();
    }

}