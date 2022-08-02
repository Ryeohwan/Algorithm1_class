package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P007_SWEA1954_달팽이숫자 {
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];

			solution(map, N);
			print(map, N, test_case);
		}
	}

	static void solution(int map[][], int N) {
		int i = 0;
		int j = 0;
		int dir = 0;

		for (int count = 1; count <= N * N; count++) {
			dir = dir % 4;
			map[i][j] = count;
			if (dir == 0) {
				if (j + 1 == N || map[i][j + 1] != 0) {
					dir++;
					i++;
				} else {
					j++;
				}
			} else if (dir == 1) {
				if (i + 1 == N || map[i + 1][j] != 0) {
					dir++;
					j--;
				} else {
					i++;
				}
			} else if (dir == 2) {
				if (j - 1 == -1 || map[i][j - 1] != 0) {
					dir++;
					i--;
				} else {
					j--;
				}
			} else {
				if (i - 1 == -1 || map[i - 1][j] != 0) {
					dir++;
					j++;
				} else {
					i--;
				}
			}
		}
	}

	static void print(int map[][], int N, int test_case) {
		System.out.println("#" + test_case);
		for (int row[] : map) {
			for (int i = 0; i < N; i++) {
				if (i < N - 1) {
					System.out.print(row[i] + " ");
				} else {
					System.out.println(row[i]);
				}
			}
		}
	}
}
