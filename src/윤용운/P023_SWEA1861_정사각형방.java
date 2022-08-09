package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P023_SWEA1861_정사각형방 {

    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            boolean[][] isVisited = new boolean[N][N];
            int[][] map = new int[N][N];
            int[][] saved = new int[N][N];
            int pos = 0;
            int length = 0;

            // input
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            // find
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int thisI = i;
                    int thisJ = j;
                    int count = 0;
                    while (!isVisited[thisI][thisJ]) {
                        count++;
                        isVisited[thisI][thisJ] = true;
                        for (int k = 0; k < 4; k++) {
                            if (thisI + di[k] >= 0 && thisI + di[k] < N && thisJ + dj[k] >= 0
                                && thisJ + dj[k] < N
                                && map[thisI + di[k]][thisJ + dj[k]] - map[thisI][thisJ] == 1){
                                thisI = thisI + di[k];
                                thisJ = thisJ + dj[k];
                                break;
                            }
                        }
                    }

                    // 저장
                    if (count + saved[thisI][thisJ] > length || (count + saved[thisI][thisJ] == length && pos > map[i][j])) {
                        length = count + saved[thisI][thisJ];
                        pos = map[i][j];
                    }
                    saved[i][j] = count + saved[thisI][thisJ];
                }
            }
            sb.append("#").append(tc).append(" ").append(pos).append(" ").append(length).append("\n");
        }
        System.out.println(sb);
    }
}
