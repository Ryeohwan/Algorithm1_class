package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P034_SWEA4012_요리사 {
    static int[][] map;
    static boolean[] isUsed;
    static int answer = Integer.MAX_VALUE;
    static int N;

    static ArrayList<Integer> A;
    static ArrayList<Integer> B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            isUsed = new boolean[N];
            answer = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] += Integer.parseInt(input[j]);
                }
            }

            comb(0, 0);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void comb(int start, int depth) {
        if (depth ==  N / 2) {
            A = new ArrayList<>();
            B = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (isUsed[i]) {
                    A.add(i);
                } else {
                    B.add(i);
                }
            }
            int small = calc();
            answer = Math.min(answer, small);
            return ;
        }

        for (int i = start; i < N; i++) {
            isUsed[i] = true;
            comb(i + 1, depth + 1);
            isUsed[i] = false;
        }
    }

    static int calc() {
        int Atotal = 0;
        int Btotal = 0;

        for (int i = 0; i < N/2; i++) {
            for (int j = i + 1; j < N/2; j++) {
                Atotal += map[A.get(i)][A.get(j)];
                Atotal += map[A.get(j)][A.get(i)];
                Btotal += map[B.get(i)][B.get(j)];
                Btotal += map[B.get(j)][B.get(i)];
            }
        }

        return Math.abs(Atotal - Btotal);
    }
}
