import java.util.*;
import java.io.*;

class ShortestPaths {

    static int inf = 1000000;

    // class to store node value and distance
    /*
     * static class Node implements Comparator<Node> { Integer vertex; Integer len;
     * 
     * Node(int v, int l) { vertex = v; len = l; }
     * 
     * Node() { }
     * 
     * @Override public int compare(Node node1, Node node2) { if (node1.len <
     * node2.len) return -1; else if (node1.len > node2.len) return 1; return 0; } }
     */

    static class Node implements Comparable<Node> {
        Integer vertex;
        Integer len;

        Node(int v, int l) {
            vertex = v;
            len = l;
        }

        @Override
        public int compareTo(ShortestPaths.Node o) {
            if (this.len > o.len)
                return 1;
            if (this.len < o.len)
                return -1;
            return 0;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v, e;
        v = in.nextInt();
        e = in.nextInt();
        ArrayList<ArrayList<Node>> adj = new ArrayList<>(v);
        // setup adj list
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Node>());
        }
        // add edges
        for (int i = 0; i < e; i++) {
            int m, n, w;
            m = in.nextInt();
            n = in.nextInt();
            w = in.nextInt();
            adj.get(m).add(new Node(n, w));
        }

        System.out.println();
        int src = in.nextInt();
        int dist[] = Dijkstra(src, adj, v);
        for (int i : dist) {
            System.out.print(i + " ");
        }
        in.close();
    }

    // implementation of Dijkstra using Min Heap
    static int[] Dijkstra(int src, ArrayList<ArrayList<Node>> adj, int n) {
        int dist[] = new int[n];
        /**
         * for(int i=0;i<n;i++) { dist[i]=inf; }
         */
        Arrays.fill(dist, inf);

        PriorityQueue<Node> pq = new PriorityQueue<Node>(n);
        pq.add(new Node(src, 0));
        dist[src] = 0;
        while (pq.size() > 0) {
            Node node = pq.poll();
            for (Node it : adj.get(node.vertex)) {
                if (dist[node.vertex] + it.len < dist[it.vertex]) {
                    dist[it.vertex] = dist[node.vertex] + it.len;
                    pq.add(new Node(it.vertex, dist[it.vertex]));
                }
            }
        }
        return dist;
    }
}