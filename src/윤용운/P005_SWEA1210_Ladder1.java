package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P005_SWEA1210_Ladder1 {

	public static void main(String[] args) throws Exception {
		int[][] map = new int[100][100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int startPos = 0;

		// input은 총 10개
		for (int c = 0; c < 10; c++) {
			// 테스트케이스 번호 입력
			int tc = Integer.parseInt(br.readLine());
			
			// 사다리 입력
			for (int i = 0; i < 100; i++) {
				//한줄씩 받으면서
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					// 하나씩 입력
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						// 출발점이 나오면 저장
						startPos = j;
					}
				}
			}

			// 위에서 아래로 가는것이 보통이지만, 정답을 찾기 위해 아래에서 위로 검색
//			endPos = findStart(map, startPos);// 2가 입력된 x좌표
			int x = startPos;
			// 가장 아래에서 시작
			int y = 99;
			// true : 위로 올라감 / false : 좌우로 움직임
			boolean isUp = true;
			// true : 왼쪽으로 이동 / false : 오른쪽으로 이동
			boolean isLeft = true;

			// y좌표가 제일 위로 갈떄까지
			while (y != 0) {

				// 올라가는 상황
				if (isUp) {
					if (x + 1 < 100 && map[y][x + 1] == 1) { // 오른쪽 길이 있으면
						isLeft = false;
						isUp = false;
					} else if (x - 1 >= 0 && map[y][x - 1] == 1) { // 왼쪽 길이 있으면
						isLeft = true;
						isUp = false;
					} else { // 둘다 없으면 그냥 위로 올라간다.
						y--;
					}
				} else {
					if (isLeft) {	// 왼쪽으로 가는 경우
						if (x - 1 >= 0 && map[y][x - 1] == 1) {
							x--;
						} else {	// 끝이면 한칸 올려준다.
							isUp = true;
							y--;
						}
					} else {	// 오른쪽으로 가는 경우
						if (x + 1 < 100 && map[y][x + 1] == 1) {
							x++;
						} else {	// 끝이면 한칸 올려준다.
							isUp = true;
							y--;
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(x).append("\n");
		}
		System.out.println(sb);
	}
}
