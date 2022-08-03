package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class P011_SWEA2001_파리퇴치 {
	public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 전체 테스트케이스 입력
		int T;
		T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N, M, answer = 0;
			int[][] map;
			String[] input = bf.readLine().split(" ");

			// 입력값 입력 후 맵 생성
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			map = new int[N][N];

			// 각 행별로 입력값 입력
			for (int i = 0; i < N; i++) {
				input = bf.readLine().split(" "); 
				// 구간합을 더하면서 배열에 입력
				map[i][0] = Integer.parseInt(input[0]);
				for (int j = 1; j < N; j++) {
					map[i][j] = map[i][j - 1] + Integer.parseInt(input[j]);
				}
			}

			// 가로세로 M만큼의 합을 구해야 하므로, (M-1, M-1)부터 M개행의 구간값을 더한다.
			for (int i = M - 1; i < N; i++) {
				for (int j = M - 1; j < N; j++) {
					int tmp = 0;
					// 합 구하기
					for (int k = 0; k < M; k++) {
						int left;
						if (j - M < 0) {
							left = 0;
						} else {
							left = map[i - k][j - M];
						}

						tmp += map[i - k][j] - left;
					}

					// 현재 잡은 파리 수랑 최대로 잡은 파리수를 비교
					if (tmp > answer) {
						answer = tmp;
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}