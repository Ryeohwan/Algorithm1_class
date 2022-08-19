package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P047_BJ17135_캐슬디펜스 {

    static int N, M, D;
    static int[][] map;
    static boolean[][] isDied;
    static int[] np;
    static int answer = Integer.MIN_VALUE;

    static int[] di = {0, -1, 0};
    static int[] dj = {-1, 0, 1};
    static List<Pos> dieList;

    static class Pos {

        int i, j, dist;

        public Pos(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        D = Integer.parseInt(input[2]);

        map = new int[N][M];
        np = new int[M];

        np[M - 1] = 1;
        np[M - 2] = 1;
        np[M - 3] = 1;

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        solve();
        while (nextPermutation()) {
            solve();
        }

        System.out.println(answer);
    }

    static void checkEnemy(int pos, int step) {
        boolean[][] isVisited = new boolean[N][M];
        Queue<Pos> que = new LinkedList<>();

        isVisited[step][pos] = true;
        que.add(new Pos(step, pos, 1));

        while (!que.isEmpty()) {
            Pos thisPos = que.poll();
            if (map[thisPos.i][thisPos.j] == 1 && !isDied[thisPos.i][thisPos.j]) {
                dieList.add(thisPos);
                return;
            }

            for (int k = 0; k < 3; k++) {
                if (thisPos.j + dj[k] >= 0 && thisPos.j + dj[k] < M
                    && thisPos.i + di[k] >= 0 && !isVisited[thisPos.i + di[k]][thisPos.j + dj[k]]
                    && thisPos.dist < D) {
                    que.add(new Pos(thisPos.i + di[k], thisPos.j + dj[k], thisPos.dist + 1));
                    isVisited[thisPos.i + di[k]][thisPos.j + dj[k]] = true;
                }
            }
        }
    }

    static void solve() {
        int step = N;
        int count = 0;
        isDied = new boolean[N][M];
        while (step-- > 0) {
            dieList = new ArrayList<>();
            for (int pos = 0; pos < M; pos++) {
                if (np[pos] == 1) {
                    checkEnemy(pos, step);
                }
            }

            for (Pos diePos : dieList) {
                if (!isDied[diePos.i][diePos.j]) {
                    isDied[diePos.i][diePos.j] = true;
                    count++;
                }
            }
        }

        if (count > answer) {
            answer = count;
        }
    }

    static boolean nextPermutation() {
        int i = M - 1;

        while (i > 0 && np[i - 1] >= np[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = M - 1;
        while (np[i - 1] >= np[j]) {
            j--;
        }

        swap(np, i - 1, j);

        int k = M - 1;
        while (i < k) {
            swap(np, i++, k--);
        }
        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}