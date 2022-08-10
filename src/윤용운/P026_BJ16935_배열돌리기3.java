package 윤용운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P026_BJ16935_배열돌리기3 {
	static int [][] arr;
	static int [][] rotateArr;
	static boolean isRotate = true;
	static int N;
	static int M;
	static int R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String [] a = br.readLine().split(" ");
		N = Integer.parseInt(a[0]);
		M = Integer.parseInt(a[1]);
		R = Integer.parseInt(a[2]);
		arr = new int [N][M];
		rotateArr = new int[M][N];
		int[][] map = arr;
		int[][] nextMap = rotateArr;
		
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			String [] b = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(b[j]);
			}
		}
		int [] R_arr = new int [R];
		String [] b = br.readLine().split(" ");
		for (int i = 0; i < R; i++) {
			R_arr[i] = Integer.parseInt(b[i]);
		}
		// 입력받기

		for (int order = 0; order < R; order++) {
			switch (R_arr[order]) {
				case 1:
					for (int i = 0; i < map.length / 2; i++) {
						int[] tmp = map[i];
						map[i] = map [map.length - 1 - i];
						map [map.length - 1 - i] = tmp;
					}
					break;
				case 2:
					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map[i].length / 2; j++) {
							int tmp = map[i][j];
							map[i][j] = map[i][map[i].length - 1 - j];
							map[i][map[i].length - 1 - j] = tmp;
						}
					}
					break;
				case 3:
					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map[i].length; j++) {
							nextMap[j][nextMap[j].length - 1 - i] = map[i][j];
						}
					}
					isRotate = !isRotate;
					int [][] tmp2 = nextMap;
					nextMap = map;
					map = tmp2;
					break;
				case 4:
					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map[i].length; j++) {
							nextMap[nextMap.length - 1 - j][i] = map[i][j];
						}
					}
					isRotate = !isRotate;
					tmp2 = nextMap;
					nextMap = map;
					map = tmp2;
					break;
				case 5:
					for (int i = 0; i < map.length / 2; i++) {
						for (int j = 0; j < map[i].length / 2; j++) {
							int tmp = map[i][j];
							map[i][j] = map[i + map.length / 2][j];
							map[i + map.length / 2][j] = map[i + map.length / 2][j + map[i].length/2];
							map[i + map.length / 2][j + map[i].length/2] = map[i][j + map[i].length/2];
							map[i][j + map[i].length/2] = tmp;
						}
					}
					break;
				case 6:
					for (int i = 0; i < map.length / 2; i++) {
						for (int j = 0; j < map[i].length / 2; j++) {
							int tmp = map[i][j];
							map[i][j] = map[i][j + map[i].length/2];
							map[i][j + map[i].length/2] = map[i + map.length / 2][j + map[i].length/2];
							map[i + map.length / 2][j + map[i].length/2] = map[i + map.length / 2][j];
							map[i + map.length / 2][j] = tmp;
						}
					}
					break;
				default:
					break;
			}
		}

		for (int[] line : map) {
			for (int idx : line) {
				sb.append(idx).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
