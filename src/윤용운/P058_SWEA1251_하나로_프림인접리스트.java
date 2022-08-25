package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P058_SWEA1251_하나로_프림인접리스트 {
    static class Edge {
        int to;
        long weight;
        Edge next;

        public Edge(int to, long weight, Edge next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
    }
    static int N;
    static double E;
    static int[][] nodes;
    static Edge[] list;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            nodes = new int[2][N];
            list = new Edge[N];
            isVisited = new boolean[N];

            for (int i = 0; i < 2; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    nodes[1 - i][j] = Integer.parseInt(input[j]);
                }
            }

            E = Double.parseDouble(br.readLine());

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    long dist = (long)Math.pow(nodes[0][i] - nodes[0][j], 2) + (long)Math.pow(nodes[1][i] - nodes[1][j], 2);
                    list[i] = new Edge(j, dist, list[i]);
                    list[j] = new Edge(i, dist, list[j]);
                }
            }

            int cnt = 0;
            long totalWeight = 0;
            long[] weights = new long[N];
            Arrays.fill(weights, Long.MAX_VALUE);
            weights[0] = 0;
            PriorityQueue<Edge> que = new PriorityQueue<>((e1, e2) -> Double.compare(e1.weight, e2.weight));
            que.offer(new Edge(0, weights[0], list[0]));

            while (!que.isEmpty()) {
                Edge smallEdge = que.poll();

                if (isVisited[smallEdge.to]) {
                    continue;
                }
                isVisited[smallEdge.to] = true;
                totalWeight += smallEdge.weight;
                if (++cnt == N) {
                    break;
                }

                for (Edge nextEdge = list[smallEdge.to]; nextEdge != null; nextEdge = nextEdge.next) {
                    if (!isVisited[nextEdge.to] && nextEdge.weight < weights[nextEdge.to]) {
                        weights[nextEdge.to] = nextEdge.weight;
                        que.offer(nextEdge);
                    }
                }
            }
            sb.append(String.format("#%d %.0f\n", tc, totalWeight * E));
        }
        System.out.println(sb);
    }
}
