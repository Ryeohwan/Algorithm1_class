package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A002_BJ1780_종이의_개수 {
	static int map[][];
	static int starti,startj,N;
	static int one = 0,zero = 0, minus = 0;
	static StringBuilder sb  = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			String [] arr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}
		// 입력 부 
		
		conquer(0,0,N);
		System.out.println(one);
		System.out.println(zero);
		System.out.println(minus);
	}
	static boolean check(int starti, int startj,int N){
		int temp = map[starti][startj];
		for (int i = starti; i < N + starti; i++) {
			for (int j = startj; j < N + startj; j++) {
				if(temp != map[starti][startj]) return true;
				else {
					if(map[starti][startj] == 1) {
						one++;
						return false;
					}else if (map[starti][startj] == 0) {
						zero++;
						return false;
					}else if (map[starti][startj] == -1) {
						minus++;
						return false;
					}
				}
			}
		}
		return false;
	}
	
	static void conquer(int starti, int startj,int N){
		if(check(starti,startj,N)) {
			conquer(starti,startj,N/3);
			conquer(starti,startj+N/3,N/3);
			conquer(starti,startj+2*N/3,N/3);
			conquer(starti+N/3,startj,N/3);
			conquer(starti+2*N/3,startj,N/3);
			conquer(starti+N/3,startj+N/3,N/3);
			conquer(starti+2*N/3,startj+2*N/3,N/3);
		}else {
			
		}
		
	}
}
