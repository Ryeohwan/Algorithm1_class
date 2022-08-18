package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A002_BJ1780_종이의_개수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] map = new int [N][N];
		for (int i = 0; i < N; i++) {
			String [] arr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}
		// 입력 부 
		
		
	}
	static class conquer{
		
	}
}
