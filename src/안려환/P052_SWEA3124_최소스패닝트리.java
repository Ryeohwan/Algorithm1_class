package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P052_SWEA3124_최소스패닝트리 {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int[] parent;
    static Edge[] edges;
    static int V, E;

    static void make() {
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        parent[aRoot] = bRoot;
        return true;
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            String[] input = br.readLine().split(" ");
            V = Integer.parseInt(input[0]);
            E = Integer.parseInt(input[1]);
            long answer = 0;
            int count = 0;

            parent = new int[V + 1];
            edges = new Edge[E];
            make();

            for (int i = 0; i < E; i++) {
                input = br.readLine().split(" ");
                edges[i] = new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[1]),Integer.parseInt(input[2]));
            }
            Arrays.sort(edges);

            while (count != V - 1) {
                for (Edge edge : edges) {
                    if (union(edge.from, edge.to)) {
                        answer += edge.weight;
                        count++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
