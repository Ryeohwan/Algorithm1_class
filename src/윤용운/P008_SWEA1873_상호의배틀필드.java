package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P008_SWEA1873_상호의배틀필드 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		int H, W, count, posI = 0, posJ = 0;
		// 맵
		char[][] map;
		// 명령
		char[] orders;
		String[] input;

		for (int tc = 1; tc <= TC; tc++) {
			// 맵 크기 입력
			input = br.readLine().split(" ");
			H = Integer.parseInt(input[0]);
			W = Integer.parseInt(input[1]);
			map = new char[H][W];

			// 맵 입력
			for (int i = 0; i < H; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = tmp.charAt(j);
					// 현재 탱크위치 저장
					if (map[i][j] == '^' || map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v') {
						posI = i;
						posJ = j;
					}
				}
			}

			// 명령 입력
			count = Integer.parseInt(br.readLine());
			orders = br.readLine().toCharArray();

			// 명령 수행
			for (int idx = 0; idx < count; idx++) {
				switch (orders[idx]) {
				// UDLR : 방향 전환 후 이동
				case 'U':
					map[posI][posJ] = '^';
					if (posI - 1 >= 0 && map[posI - 1][posJ] == '.') {
						map[posI][posJ] = '.';
						map[--posI][posJ] = '^';				
					}
					break;
				case 'D':
					map[posI][posJ] = 'v';
					if (posI + 1 < H && map[posI + 1][posJ] == '.') {
						map[posI][posJ] = '.';
						map[++posI][posJ] = 'v';				
					}
					break;
				case 'L':
					map[posI][posJ] = '<';
					if (posJ - 1 >= 0 && map[posI][posJ - 1] == '.') {
						map[posI][posJ] = '.';
						map[posI][--posJ] = '<';				
					}
					break;
				case 'R':
					map[posI][posJ] = '>';
					if (posJ + 1 < W && map[posI][posJ + 1] == '.') {
						map[posI][posJ] = '.';
						map[posI][++posJ] = '>';				
					}
					break;
				// S : 발사
				case 'S':
					switch (map[posI][posJ]) {
					// 상하좌우 방향에 따라 위/아래/좌/우 벽 체크하면서 진생
					case '^':
						for (int tmp = posI - 1; tmp >= 0; tmp--) {
							if (map[tmp][posJ] == '#') {// 강철이면 변화없음
								break;
							} else if (map[tmp][posJ] == '*') {// 벽돌이면 평지화
								map[tmp][posJ] = '.';
								break;
							}
						}
						break;
					case '<':
						for (int tmp = posJ - 1; tmp >= 0; tmp--) {
							if (map[posI][tmp] == '#') {// 강철이면 변화없음
								break;
							} else if (map[posI][tmp] == '*') {// 벽돌이면 평지화
								map[posI][tmp] = '.';
								break;
							}
						}		
						break;
					case '>':
						for (int tmp = posJ + 1; tmp < W; tmp++) {
							if (map[posI][tmp] == '#') {// 강철이면 변화없음
								break;
							} else if (map[posI][tmp] == '*') {// 벽돌이면 평지화
								map[posI][tmp] = '.';
								break;
							}
						}				
						break;
					case 'v':
						for (int tmp = posI + 1; tmp < H; tmp++) {
							if (map[tmp][posJ] == '#') {// 강철이면 변화없음
								break;
							} else if (map[tmp][posJ] == '*') {// 벽돌이면 평지화
								map[tmp][posJ] = '.';
								break;
							}
						}				
						break;
					default:
						break;
					}
					break;
				default :
					break;
				}
			}
			
			// 출력
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
