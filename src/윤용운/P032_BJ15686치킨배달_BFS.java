package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P032_BJ15686치킨배달_BFS {

    static class Pos {

        int i, j, dist;

        public Pos(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    static List<Pos> store = new ArrayList<>();
    static int[][] map;
    static boolean[][] isVisited;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N, M;
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int max = Integer.MAX_VALUE;
        map = new int[N][N];

        // 맵 입력
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 2) {
                    store.add(new Pos(i, j, 0));
                }
            }
        }

        // 부분집합 체크 후 BFS
        for (int i = 1; i < (1 << store.size()); i++) {
            Queue<Pos> que = new LinkedList<>();
            isVisited = new boolean[N][N];
            for (int j = 0; j < store.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    que.add(store.get(j));
                    isVisited[store.get(j).i][store.get(j).j] = true;
                }
            }
            if (que.size() != M) {
                continue;
            }
            int totalDist = 0;
            while (!que.isEmpty()) {
                Pos thisPos = que.poll();
                if (map[thisPos.i][thisPos.j] == 1) {
                    totalDist += thisPos.dist;
                }

                for (int k = 0; k < 4; k++) {
                    if (thisPos.i + di[k] < 0 || thisPos.i + di[k] >= N || thisPos.j + dj[k] < 0
                        || thisPos.j + dj[k] >= N
                        || isVisited[thisPos.i + di[k]][thisPos.j + dj[k]]) {
                        continue;
                    }

                    que.add(new Pos(thisPos.i + di[k], thisPos.j + dj[k], thisPos.dist + 1));
                    isVisited[thisPos.i + di[k]][thisPos.j + dj[k]] = true;
                }
            }
            if (totalDist < max) {
                max = totalDist;
            }
        }
        System.out.println(max);
    }
}
