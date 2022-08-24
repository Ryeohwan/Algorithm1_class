package 윤용운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P056_BJ7576_토마토 {
    static class Pair {
        int i, j, day;

        public Pair(int i, int j, int day) {
            this.i = i;
            this.j = j;
            this.day = day;
        }
    }
    static int N, M, count = 0;
    static int[][] graph;
    static Queue<Pair> que = new LinkedList<>();
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    static int bfs() {
        int answer = 0;
        while (!que.isEmpty()) {
            Pair thisPair = que.poll();
            if (thisPair.day > answer) {
                answer = thisPair.day;
            }
            for (int k = 0; k < 4; k++) {
                int nexti = thisPair.i + di[k];
                int nextj = thisPair.j + dj[k];

                if (nexti >= 0 && nextj >= 0 && nexti < N && nextj < M && graph[nexti][nextj] == 0) {
                    que.add(new Pair(nexti, nextj, thisPair.day + 1));
                    graph[nexti][nextj] = 1;
                    count++;
                }
            }
        }
        if (count < N * M) {
            return -1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    que.add(new Pair(i, j, 0));
                    count++;
                } else if (graph[i][j] == -1) {
                    count++;
                }
            }
        }
        System.out.println(bfs());
    }
}