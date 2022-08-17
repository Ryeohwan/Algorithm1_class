package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P041_BJ1992_쿼드트리 {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        int N;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] strings = bf.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }
        solution(0, 0, N);

        System.out.println(sb);
    }

    static void solution(int i, int j, int N) {
        if(check(i, j, N)){
            sb.append(arr[i][j]);
        } else {
            sb.append("(");
            solution(i, j, N/2);
            solution(i, j + N/2, N/2);
            solution(i + N/2, j, N/2);
            solution(i + N/2, j + N/2, N/2);
            sb.append(")");
        }
    }

    static boolean check(int i, int j, int N) {
        int checker = arr[i][j];
        for (int ii = i; ii < i + N; ii++) {
            for (int jj = j; jj < j + N; jj++) {
                if(checker != arr[ii][jj]){
                    return false;
                }
            }
        }
        return true;
    }
}
