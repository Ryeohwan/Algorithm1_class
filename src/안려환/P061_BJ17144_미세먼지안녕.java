package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P061_BJ17144_미세먼지안녕 {

	static int R, C, T;
	static int[][] map;
	static int [] dx = {0,-1,0,1};
	static int [] dy = {1,0,-1,0};
	static int puri = -1;
	static Queue<Dust> dusts;
	
	static class Dust{
		int x, y, w;

		public Dust(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		R= Integer.parseInt(arr[0]);
		C= Integer.parseInt(arr[1]);
		T= Integer.parseInt(arr[2]);
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			arr = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
				
				
				// 공기청정기 위치를 저장한다.
				if(puri == -1 && map[i][j] == -1) {
					puri = i;
				}
			}
		} // 입력부 완
		
		for (int time = 0; time < T; time++) {
			
			// 미세먼지가 있나 확인한다.
			checkDust();
			spread(); // 미세먼지 확산
			operate(); // 공기청정기 작동
		}
		
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == -1 ) continue; // 공기 청정기는 체크 ㄴㄴ
				result += map[i][j]; // 먼지의 양을 구하는 것이 문제이니까
			}
		}
		System.out.println(result);
	}
	
	private static void checkDust() {
		dusts = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == -1 || map[i][j] == 0) continue; // 미세먼지가 없거나 공기청정기이면
				dusts.add(new Dust(i,j,map[i][j]));
			}
		}
	}
	
	private static void spread() {
		while(!dusts.isEmpty()) {
			Dust now = dusts.poll();
			
			// 확산될 먼지가 5보다 작으면 소수점은 버리니까  확산될 양이 없다.
			if(now.w < 5) continue;
			
			int amount = now.w / 5; // 확산될 먼지의 양
			
			int cnt = 0;
			
			for (int i = 0; i < 4; i++) {
				int ax = now.x + dx[i];
				int ay = now.y + dy[i];  // 확산
				
				if(ax < 0 || ax >= R || ay < 0 || ay >= C) continue; // 맵 밖으로 건너뛰면 x
				if(map[ax][ay] == -1) continue; // 공기 청정기면 건너뛰기
				map[ax][ay] += amount; // 먼지 더해주자. 확산해서 이미 있는 것과 합해짐
				++cnt;
			}
			
			//이제 먼지 남은거 계산
			map[now.x][now.y] -= amount * cnt; // 확산된 방향만큼 곱해서 빼준다. 
			
		}
	}
	
	// 바람부는 것 처리
	private static void operate() {
		int top = puri;
		int down = puri +1 ;
		
		// 위쪽은 바람의 반시계방향 
		// 아래로
		for (int i = top -1 ; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		// 왼쪽으로
		for (int i = 0 ; i < C -1 ; i++) {
			map[0][i] = map[0][i+1];
		}
		// 위로
		for (int i = 0 ; i < top; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		// 오른쪽으로
		for (int i = C-1 ; i > 1; i--) {
			map[top][i] = map[top][i-1];
		}
		map[top][1] = 0;
		
		// 위쪽으로
		for (int i = down + 1 ; i < R -1; i++) {
			map[i][0] = map[i+1][0];
		}
		// 왼쪽으로
		for (int i = 0 ; i < C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		// 아래로
		for (int i = R-1 ; i > down; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		// 오른쪽으로
		for (int i = C-1 ; i > 1; i--) {
			map[down][i] = map[down][i-1];
		}
		map[down][1] = 0;
	}
}
