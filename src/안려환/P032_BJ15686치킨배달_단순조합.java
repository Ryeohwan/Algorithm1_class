package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P032_BJ15686치킨배달_단순조합 {

    static class Pos {

        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static List<Pos> store = new ArrayList<>();
    static List<Pos> house = new ArrayList<>();
    static int N, M, answer = Integer.MAX_VALUE;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // 맵 입력
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(s[j]) == 1) {
                    house.add(new Pos(i, j));
                } else if (Integer.parseInt(s[j]) == 2) {
                    store.add(new Pos(i, j));
                }
            }
        }
        isUsed = new boolean[store.size()];

        comb(0, 0);
        System.out.println(answer);
    }

    static void comb(int start, int depth) {
        if (depth == M) {
            int temp = 0;
            for (Pos pos : house) {
                int smallLength = Integer.MAX_VALUE;
                for (int j = 0; j < store.size(); j++) {
                    if (isUsed[j]) {
                        int thisLength = Math.abs(pos.i - store.get(j).i) + Math.abs(pos.j - store.get(j).j);
                        if (smallLength > thisLength) {
                            smallLength = thisLength;
                        }
                    }
                }
                temp += smallLength;
            }

            if (answer > temp) {
                answer = temp;
            }
            return;
        }

        for (int i = start; i < store.size(); i++) {
            isUsed[i] = true;
            comb(i + 1, depth + 1);
            isUsed[i] = false;
        }
    }
}

