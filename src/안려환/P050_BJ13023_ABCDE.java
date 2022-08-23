package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P050_BJ13023_ABCDE {
    static int N, M;
    static boolean[] isVisited;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);

            map.get(from).add(to);
            map.get(to).add(from);
        }

        // dfs
        for (int i = 0; i < N; i++) {
            isVisited[i] = true;
            if (dfs(i, 1)) {
                System.out.println(1);
                return;
            }
            isVisited[i] = false;
        }
        System.out.println(0);
    }

    static boolean dfs(int n, int step) {
        if (step == 5) {
            return true;
        }
        ArrayList<Integer> thisFriend = map.get(n);
        for (Integer integer : thisFriend) {
            if (!isVisited[integer]) {
                isVisited[integer] = true;
                if (dfs(integer, step + 1)) {
                    return true;
                }
                isVisited[integer] = false;
            }
        }
        return false;
    }
}
