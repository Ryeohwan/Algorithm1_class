package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P026_BJ16935_배열돌리기3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] a = br.readLine().split(" ");
		int N = Integer.parseInt(a[0]);
		int M = Integer.parseInt(a[1]);
		int R = Integer.parseInt(a[2]);
		
		
		Stack<Integer> stack = new Stack<>();
		int [][] arr = new int [N][M];
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
		
		// 1 번 기능
		int [] temp = new int [M];
		
		temp = arr[0];
		arr[0] = arr[N-1];
		arr[N-1] = temp;
	}

}
