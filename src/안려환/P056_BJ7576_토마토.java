package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class P056_BJ7576_토마토 {
	
	static int m;
	static int n;
	static int[][] tomatoes;
	static int maxVal;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class pos{
		int i ,j;
		public pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		m = Integer.parseInt(arr[0]);
		n = Integer.parseInt(arr[1]);
		tomatoes = new int[n][m];
		for(int i=0; i<n; i++) {
			String [] arr2 = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				tomatoes[i][j] = Integer.parseInt(arr2[j]);
			}
		}
		
		Queue<pos> que = new LinkedList<>();  
		// 익은 토마토 1이면 넣는다. 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(tomatoes[i][j] == 1) {
					que.add(new pos(i,j));
				}
			}
		}
		
		while(!que.isEmpty()) {
			pos now = que.poll();
			int nowX = now.i;
			int nowY = now.j;
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				// 범위 체크
				if(nextX < 0 || nextY < 0 || nextX > n-1 || nextY > m-1)
					continue;
				
				// 토마토가 없거나, 익은 토마토라면 continue
				if(tomatoes[nextX][nextY] != 0)
					continue;
				
				// 이렇게 체크하는 방법 다음에도 써봐야겠다...
				
				// 조건 맞으면 이동 후 que 에 삽입
				tomatoes[nextX][nextY] = tomatoes[nowX][nowY] + 1;
				que.add(new pos(nextX,nextY));
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(tomatoes[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				maxVal = Math.max(maxVal, tomatoes[i][j]);
			}
		}
		System.out.println(maxVal-1);
	}
	
}