package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P023_SWEA1861_정사각형방 {

	static int[] dx = {-1, 1, 0, 0};  // dfs 를 사용하기 위한 배열
	static int[] dy = {0, 0, 1, -1};
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr;
		StringBuilder sb = new StringBuilder();  // 답을 담기 위한 sb
		int t = Integer.parseInt(br.readLine());
		
		for(int test = 1; test < t+1; test++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}   // 처음 입력부이다.
			
			int[] c = new int[n * n+1];
			int max = 0;
			int start_arr = n * n; //처음 출발지이다. 가장 큰 값으로 설정을 해준다.
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					cnt = 1;
					dfs(arr, i, j, n, arr[i][j]);  // 주변에 1큰 애가 있나 탐색을 해준다.
					c[arr[i][j]] = cnt;  // 탐색 값을 이 번호를 인덱스로 갖는 c 배열에 넣어준다.
					if(cnt>=max) {  // 최댓값을 찾아주기 위함이다.
						if (cnt>max) {
							start_arr = arr[i][j];
							max = cnt;
						}
						else {
							if(start_arr>arr[i][j]) {
								start_arr = arr[i][j];
							}
						}
						
					}
				}
			}
			sb.append("#").append(test).append(" ").append(start_arr).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	
	public static void dfs(int[][] r, int x, int y, int N, int now_n) {  // dfs 구현부이다.
		for(int i=0;i<4;i++) {  // dx,dy 를 사용하는 거라 4번
			int nowx = x+dx[i];  // x 와 y 만큼 상하좌우로 이동하며 값을 확인한다.
			int nowy = y+dy[i];
			if((0 <= nowx && nowx < N)&&(0 <= nowy && nowy < N)&&(r[nowx][nowy] == now_n + 1)) {  // 현재 위치가 배열을 벗어나지 않으면서 딱 하나 큰 자리를 찾는 로직이다. 
				cnt++;  // 찾았으므로 cnt 를 올려준다.
				dfs(r, nowx, nowy, N, now_n+1);
			}
		}
	}

}
