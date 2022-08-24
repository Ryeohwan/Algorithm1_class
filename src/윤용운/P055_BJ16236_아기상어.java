package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P055_BJ16236_아기상어 {

    static class Pos {

        int i, j, time;

        public Pos(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    static int[][] map;
    static boolean[][] isVisited;
    static Queue<Pos> que = new LinkedList<>();
    static int sharkSize = 2;
    static int eatCount = 0;
    static int timer = 0;
    static int[] di = {-1, 0, 0, 1};
    static int[] dj = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 9) {
                    isVisited[i][j] = true;
                    map[i][j] = 0;
                    que.add(new Pos(i, j, 0));
                }
            }
        }

        while (!que.isEmpty()) {
            if (map[que.peek().i][que.peek().j] > 0
                && map[que.peek().i][que.peek().j] < sharkSize) {
                List<Pos> sharkList = new ArrayList<>();
                while (!que.isEmpty()) {
                    Pos tmp = que.poll();
                    if (map[tmp.i][tmp.j] > 0 && map[tmp.i][tmp.j] < sharkSize) {
                        sharkList.add(tmp);
                    }
                }
                Pos shark = sharkList.get(0);
                for (int i = 1; i < sharkList.size(); i++) {
                    if (shark.time != sharkList.get(i).time) {
                        break;
                    }

                    if (shark.i > sharkList.get(i).i) {
                        shark = sharkList.get(i);
                    } else if (shark.i == sharkList.get(i).i) {
                        if (shark.j > sharkList.get(i).j) {
                            shark = sharkList.get(i);
                        }
                    }
                }
                map[shark.i][shark.j] = 0;
                eatCount++;
                timer += shark.time;
                isVisited = new boolean[N][N];
                que.add(new Pos(shark.i, shark.j, 0));
                isVisited[shark.i][shark.j] = true;
                if (eatCount >= sharkSize) {
                    sharkSize++;
                    eatCount = 0;
                }
                continue;
            }

            Pos shark = que.poll();

            for (int k = 0; k < 4; k++) {
                if (shark.i + di[k] >= 0 && shark.i + di[k] < N && shark.j + dj[k] >= 0
                    && shark.j + dj[k] < N
                    && !isVisited[shark.i + di[k]][shark.j + dj[k]]
                    && map[shark.i + di[k]][shark.j + dj[k]] <= sharkSize) {

                    que.add(new Pos(shark.i + di[k], shark.j + dj[k], shark.time + 1));
                    isVisited[shark.i + di[k]][shark.j + dj[k]] = true;
                }
            }
        }

        System.out.println(timer);
    }
}
