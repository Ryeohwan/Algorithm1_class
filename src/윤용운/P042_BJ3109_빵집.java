package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P042_BJ3109_빵집 {
    static int[] di = {-1, 0, 1};
    static int[] dj = {1, 1, 1};
    static int answer = 0;
    static char[][] map;
    static int R;
    static int C;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new char[R][];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < R; i++) {
            if(solve(i, 0)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean solve(int i, int j) {
        map[i][j] = '/';
        if (j == C - 1) {
            return true;
        }

        for (int dir = 0; dir < 3; dir++) {
            if (i + di[dir] >= 0 && i + di[dir] < R && map[i + di[dir]][j + dj[dir]] == '.'){
                if (solve(i + di[dir], j + dj[dir])) {
                    return true;
                }
            }
        }
        return false;
    }
}
