package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P005_SWEA1210_Ladder1 {

	public static void main(String[] args) throws Exception {
		int[][] map = new int[100][100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input = "";
		int startPos = 0, endPos = 0;

		while ((input = br.readLine()) != null) {
			int tc = Integer.parseInt(input);
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						startPos = j;
					}
				}
			}

			endPos = findStart(map, startPos);

			System.out.println("#" + tc + " " + endPos);
		}
	}

	static int findStart(int[][] map, int startPos) {
		int x = startPos;
		int y = 99;
		boolean isUp = true;
		boolean isLeft = true;

		while (y != 0) {

			if (isUp) {
				if (x + 1 < 100 && map[y][x + 1] == 1) {
					isLeft = false;
					isUp = false;
				} else if (x - 1 >= 0 && map[y][x - 1] == 1) {
					isLeft = true;
					isUp = false;
				} else {
					y--;
				}
			} else {
				if (isLeft) {
					if (x - 1 >= 0 && map[y][x - 1] == 1) {
						x--;
					} else {
						isUp = true;
						y--;
					}
				} else {
					if (x + 1 < 100 && map[y][x + 1] == 1) {
						x++;
					} else {
						isUp = true;
						y--;
					}
				}
			}
		}
		return x;
	}
}
