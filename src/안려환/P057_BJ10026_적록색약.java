package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P057_BJ10026_적록색약 {
	
	static int N;
	// dfs 써보자
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static char [][] map;
	static boolean visit[][];
	static int color = 0;
	static int wcolor = 0;
	
	public static void main(String[] args)throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 입력부 완
		
		for(int i=0; i<N; i++) {  // 색약이 아닌 사람 color
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					dfs(i, j);
					color ++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {  // 색약인 사람들 map 처리
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'G') map[i][j] = 'R';
			}
		}
				
		visit = new boolean[N][N];	// 방문체크 처음부터 하기 위해	
		
		
		for(int i=0; i<N; i++) { // 색약인 사람 wcolor
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {						
					dfs(i, j);
					wcolor ++;
				}
			}
		}
		
		sb.append(color).append(" ").append(wcolor);
		System.out.println(sb);
		br.close();
	}
	
	// dfs 구현부
	public static void dfs(int x, int y) {
		visit[x][y] = true;	
		char color = map[x][y];
	
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(map[nx][ny] == color && !visit[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
}
