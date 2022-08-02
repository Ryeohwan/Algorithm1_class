package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P007_SWEA1954_달팽이숫자 {
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 테스트케이스 수 입력
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			// 전체 맵 크기 선언
			// default로 0으로 초기화되어 있다.
			int map[][] = new int[N][N];

			// 입력// 가장 왼쪽 위칸부터 시작
			int i = 0;
			int j = 0;
			int dir = 0;
			// 방향
			// 0 : 오른쪽
			// 1 : 아래쪽
			// 2 : 왼쪽
			// 3 : 위쪽 이동

			// 입력 가능한 숫자는 1부터 N^2까지
			for (int count = 1; count <= N * N; count++) {
				// overflow 방지
				dir = dir % 4;
				map[i][j] = count;

				// 배열의 끝이거나 값이 채워져 있으면 방향 전환
				if (dir == 0) {			// 오른쪽 이동
					if (j + 1 == N || map[i][j + 1] != 0) {
						dir++;
						i++;
					} else {
						j++;
					}
				} else if (dir == 1) {	// 아래로 이동
					if (i + 1 == N || map[i + 1][j] != 0) {
						dir++;
						j--;
					} else {
						i++;
					}
				} else if (dir == 2) {	// 왼쪽 이동
					if (j - 1 == -1 || map[i][j - 1] != 0) {
						dir++;
						i--;
					} else {
						j--;
					}
				} else {				// 위로 이동
					if (i - 1 == -1 || map[i - 1][j] != 0) {
						dir++;
						j++;
					} else {
						i--;
					}
				}
			}
			// 출력
			// 배열 순으로 출력
			sb.append("#").append(test_case).append("\n");
			for (int row[] : map) {
				for (int idx = 0; idx < N; idx++) {
					sb.append(row[idx]);
					if (idx < N - 1) {
						sb.append(" ");
					}
				}
				sb.append("\n");
			}
		}	
		System.out.println(sb);
	}
}
