package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P043_SWEA1247_최적경로 {
    static int answer;
    static Pos[] client;
    static Pos[] tmpArr;
    static boolean[] isVisited;
    static int N;
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDist(Pos p) {
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            client = new Pos[N];
            tmpArr = new Pos[N + 2];
            isVisited = new boolean[N];

            answer = Integer.MAX_VALUE;
            String[] input = br.readLine().split(" ");
            tmpArr[0] = new Pos(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            tmpArr[N + 1] = new Pos(Integer.parseInt(input[2]), Integer.parseInt(input[3]));
            for (int i = 0; i < N; i++) {
                client[i] = new Pos(Integer.parseInt(input[i * 2 + 4]), Integer.parseInt(input[i * 2 + 5]));
            }

            track(1, 0);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void track(int depth, int dist) {
        if (dist > answer) {
            return ;
        }

        if (depth > N) {
            dist += tmpArr[depth - 1].getDist(tmpArr[depth]);
            if (answer > dist) {
                answer = dist;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) {
                continue;
            }
            tmpArr[depth] = client[i];
            isVisited[i] = true;
            track(depth + 1, dist + tmpArr[depth - 1].getDist(tmpArr[depth]));
            isVisited[i] = false;
        }
    }
}
