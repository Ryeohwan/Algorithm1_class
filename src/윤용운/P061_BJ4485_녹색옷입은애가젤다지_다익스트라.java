package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P061_BJ4485_녹색옷입은애가젤다지_다익스트라 {

    static class Pos {
        int i, j, dist;

        public Pos(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    static int[][] map;
    static int[][] dist;
    static boolean[][] isVisited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;

        while ((N = Integer.parseInt(br.readLine())) != 0) {
            map = new int[N][N];
            dist = new int[N][N];
            isVisited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Pos> que = new PriorityQueue<>((e1, e2) -> e1.dist - e2.dist);
            que.add(new Pos(0, 0, map[0][0]));
            dist[0][0] = map[0][0];
            while (!que.isEmpty()) {
                Pos thisPos = que.poll();

                if (thisPos.i == N - 1 && thisPos.j == N - 1) {
                    sb.append("Problem ").append(tc++).append(": ").append(dist[N - 1][N - 1]).append("\n");
                    break;
                }
                
                isVisited[thisPos.i][thisPos.j] = true;
                for (int k = 0; k < 4; k++) {
                    if (thisPos.i + di[k] >= 0 && thisPos.i + di[k] < N && thisPos.j + dj[k] >= 0 && thisPos.j + dj[k] < N
                    && dist[thisPos.i + di[k]][thisPos.j + dj[k]] > dist[thisPos.i][thisPos.j] + map[thisPos.i + di[k]][thisPos.j + dj[k]]) {
                        dist[thisPos.i + di[k]][thisPos.j + dj[k]] = dist[thisPos.i][thisPos.j] + map[thisPos.i + di[k]][thisPos.j + dj[k]];
                        if (!isVisited[thisPos.i + di[k]][thisPos.j + dj[k]])
                            que.add(new Pos(thisPos.i + di[k], thisPos.j + dj[k], dist[thisPos.i + di[k]][thisPos.j + dj[k]]));
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
