package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P051_SWEA3289_서로소집합 {

    static int[] parent;

    static void make() {
        for (int i = 0; i < parent.length; i++) {
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

    static boolean find(int a, int b) {
        return find(a) == find(b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            parent = new int[n + 1];
            make();

            for (int i = 0; i < m; i++) {
                input = br.readLine().split(" ");
                int order = Integer.parseInt(input[0]);
                int a = Integer.parseInt(input[1]);
                int b = Integer.parseInt(input[2]);

                switch (order) {
                    case 0:
                        union(a, b);
                        break;
                    case 1:
                        if (find(a, b)) {
                            sb.append(1);
                        } else {
                            sb.append(0);
                        }
                        break;
                    default:
                        break;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
