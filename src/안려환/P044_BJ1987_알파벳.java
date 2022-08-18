package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P044_BJ1987_알파벳 {
    static int n, m;
    static int result = 0;
    static char[][] arr;
    static int[] di = { 1, -1, 0, 0 };
    static int[] dj = { 0, 0, 1, -1 };
    static boolean[] isVisited = new boolean[26];

    static void solution(int i, int j, int count) {
        for (int k = 0; k < 4; k++) {
            if (i + di[k] < 0 || i + di[k] >= n || j + dj[k] < 0 || j + dj[k] >= m
                || isVisited[arr[i + di[k]][j + dj[k]]-65]) {
                if (result < count){
                    result = count;
                }
            } else {
                isVisited[arr[i + di[k]][j + dj[k]] - 65] = true;
                solution(i + di[k], j + dj[k], count + 1);
                isVisited[arr[i + di[k]][j + dj[k]] - 65] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        isVisited[arr[0][0] - 65] = true;

        solution(0, 0, 1);

        System.out.println(result);
    }
}
