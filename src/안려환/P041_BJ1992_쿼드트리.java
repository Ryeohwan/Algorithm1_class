package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P041_BJ1992_쿼드트리 {
	static char [][]map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
//			String a = br.readLine();
//			for (int j = 0; j < N; j++) {
//				map[i][j] = a.charAt(j);
//			}
			map[i] = br.readLine().toCharArray();
		}
		conquer(0,0,N);
		System.out.println(sb);
	}
	
	// 값이 하나라도 다르면 
	
	static boolean check (int starti, int startj, int n) {
		char check = map[starti][startj];
		for (int k = starti; k < n+starti; k++) {
			for (int k2 = startj; k2 < n+startj; k2++) {
				if(check != map[k][k2]) {
					return true;  // 나눠야 한다는 것
				}
			}
		}
		return false;
	}
	
	static void conquer(int starti, int startj, int n) {
		if(check(starti,startj,n)){
			sb.append("(");
			conquer(starti,startj,n/2);
			conquer(starti,startj+n/2,n/2);
			conquer(starti+n/2,startj,n/2);
			conquer(starti+n/2,startj+n/2,n/2);
			sb.append(")");
			}
		else {
			sb.append(map[starti][startj]);
		}

	}
}
