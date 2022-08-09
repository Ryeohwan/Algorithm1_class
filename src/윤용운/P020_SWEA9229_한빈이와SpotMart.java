package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P020_SWEA9229_한빈이와SpotMart {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int N, M, answer = -1;
            sb.append("#").append(tc).append(" ");
            String[] input = br.readLine().split(" ");
            int[] arr;
            // 봉지 수
            N = Integer.parseInt(input[0]);
            // 무게 제한
            M = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // 범위가 작으므로 완전탐색
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (arr[i] + arr[j] > answer && arr[i] + arr[j] <= M) {
                        answer = arr[i] + arr[j];
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
