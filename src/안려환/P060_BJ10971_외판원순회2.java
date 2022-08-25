package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P060_BJ10971_외판원순회2 {
	static int cost;
	static int N;
	static int [][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		visited = new boolean[N];
		cost = Integer.MAX_VALUE;  // 최소값 찾기 위해서 max 넣어준다.
		
		for (int i = 0; i < N; i++) {
			String [] arr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		} // 입력부 끝
		
		//호출부
		for (int i = 0; i < N; i++) {
			visited[i] = true;  // 방문처리 해주면서 i별로  dfs 돌려준다.
			dfs(i,i,0,0);
		}
		sb.append(cost);
		System.out.println(sb);
	}
	
	private static void dfs(int start, int current, int depth, int sum) {
		if(depth == N-1) {  // 끝까지 갔으면 cost 에 최소값 넣어준다.
			if(map[current][start] != 0) {
				sum+= map[current][start];
				cost= Math.min(cost, sum);
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!visited[i] && map[current][i] >0) {  // 방문한적 없으면서 map 의 0이 아닌 경우에는 
				visited[i] = true;
				dfs(start,i,depth+1,sum+map[current][i]);  // 깊이 한 번 더 들어가고 sum 누적 덧셈해준다.
				visited[i] = false;
			}
		}
	}

}
