package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P053_SWEA7465_창용마을무리의개수 {
    static int[] parent;
    static boolean[] isParent;
    static int V,E;

    static void make() {
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            parent[aRoot] = bRoot;
        }
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            String[] input = br.readLine().split(" ");

            V = Integer.parseInt(input[0]);
            E = Integer.parseInt(input[1]);
            parent = new int[V + 1];
            isParent = new boolean[V + 1];
            int answer = 0;
            make();

            for (int i = 0; i < E; i++) {
                input = br.readLine().split(" ");
                union(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
            }

            for (int i = 1; i <= V; i++) {
                int p = find(i);
                if (!isParent[p]) {
                    isParent[p] = true;
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
