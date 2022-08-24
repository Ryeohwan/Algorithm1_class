package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P054_BJ13055_탈출 {

    static class Pos {

        int i, j, time;

        public Pos(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    static int R, C;
    static char[][] map;
    static Queue<Pos> water = new LinkedList<>();
    static Queue<Pos> route = new LinkedList<>();

    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R][C];
        int time = 0;
        boolean isEnd = false;

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                switch (map[i][j]) {
                    case 'S':
                        route.add(new Pos(i, j, 0));
                        break;
                    case '*':
                        water.add(new Pos(i, j, 0));
                        break;
                    default:
                        break;
                }
            }
        }

        while (!route.isEmpty() && !isEnd) {
            // 물 퍼트리기
            while (!water.isEmpty() && water.peek().time == time) {
                Pos w = water.poll();

                for (int i = 0; i < 4; i++) {
                    if (w.i + di[i] >= 0 && w.i + di[i] < R && w.j + dj[i] >= 0 && w.j + dj[i] < C
                        && (map[w.i + di[i]][w.j + dj[i]] == '.' || map[w.i + di[i]][w.j + dj[i]] == 'S')) {

                        water.add(new Pos(w.i + di[i], w.j + dj[i], w.time + 1));
                        map[w.i + di[i]][w.j + dj[i]] = '*';
                    }
                }
            }

            while (!route.isEmpty() && route.peek().time == time) {
                Pos r = route.poll();

                if (map[r.i][r.j] == 'D') {
                    isEnd = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    if (r.i + di[i] >= 0 && r.i + di[i] < R && r.j + dj[i] >= 0 && r.j + dj[i] < C
                        && (map[r.i + di[i]][r.j + dj[i]] == '.' || map[r.i + di[i]][r.j + dj[i]] == 'D')) {

                        route.add(new Pos(r.i + di[i], r.j + dj[i], r.time + 1));
                        if (map[r.i + di[i]][r.j + dj[i]] == '.') {
                            map[r.i + di[i]][r.j + dj[i]] = 'S';
                        }
                    }
                }
            }
            time++;
        }

        if (isEnd) {
            System.out.println(time - 1);
        } else {
            System.out.println("KAKTUS");
        }
    }
}
