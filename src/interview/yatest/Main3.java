package interview.yatest;

import java.math.BigInteger;
import java.util.*;

import java.util.*;

public class Main3 {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> -e.weight));
        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            parent[v]=u;
            pq.offer(new Edge(u, v, w));
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int pu = find(e.u);
            int pv = find(e.v);
            if (pu != pv) {
                parent[pu] = pv;
                ans += e.weight;
            }
        }
        System.out.println(ans);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static class Edge {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
}

