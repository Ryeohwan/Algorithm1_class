package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P059_SWEA1251_하나로_프림인접행렬 {
    static class Edge {
        int to;
        long weight;

        public Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static int N;
    static double E;
    static int[][] nodes;
    static long[][] map;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            nodes = new int[2][N];
            map = new long[N][N];
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
                    map[i][j] = dist;
                    map[j][i] = dist;
                }
            }

            int cnt = 0;
            long totalWeight = 0;
            long[] weights = new long[N];
            Arrays.fill(weights, Long.MAX_VALUE);
            weights[0] = 0;
            PriorityQueue<Edge> que = new PriorityQueue<>((e1, e2) -> Double.compare(e1.weight, e2.weight));
            que.offer(new Edge(0, weights[0]));

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

                for (int i = 0; i < N; i++) {
                    if (!isVisited[i] && map[smallEdge.to][i] < weights[i]) {
                        weights[i] = map[smallEdge.to][i];
                        que.offer(new Edge(i, weights[i]));
                    }
                }
            }
            sb.append(String.format("#%d %.0f\n", tc, totalWeight * E));
        }
        System.out.println(sb);
    }
}
