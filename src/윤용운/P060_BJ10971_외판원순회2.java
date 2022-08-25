package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P060_BJ10971_외판원순회2 {
    static int N;
    static int[][] map;
    static boolean[] isVisited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        isVisited[0] = true;
        dfs(0, 1, 0);
        System.out.println(answer);
    }

    static void dfs(int start, int step, int dist) {
        if (step == N) {
            if (map[start][0] != 0 && dist + map[start][0] < answer) {
                answer = dist + map[start][0];
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i] && map[start][i] != 0) {
                isVisited[i] = true;
                dfs(i, step + 1, dist + map[start][i]);
                isVisited[i] = false;
            }
        }
    }
}
