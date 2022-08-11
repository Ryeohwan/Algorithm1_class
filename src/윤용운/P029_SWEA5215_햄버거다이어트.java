package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P029_SWEA5215_햄버거다이어트 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int L = Integer.parseInt(input[1]);
			int max = 0;

			int[] score = new int[N + 1];
			int[] kal = new int[N + 1];
			int[][] dp = new int[N + 1][L + 1];
			
			for (int i = 1; i <= N; i++) {
				input = br.readLine().split(" ");
				score[i] = Integer.parseInt(input[0]);
				kal[i] = Integer.parseInt(input[1]);
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j < L; j++) {
					if (kal[i] <= j) {
						dp[i][j] = Math.max(score[i] + dp[i - 1][j - kal[i]], dp[i - 1][j]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
					max = Math.max(max, dp[i][j]);
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
