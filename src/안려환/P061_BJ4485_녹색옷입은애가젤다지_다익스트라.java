package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P061_BJ4485_녹색옷입은애가젤다지_다익스트라 {
	
	static int N;
	static int [][] map, distance;
	static int min;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	
	static class Point implements Comparable<Point>{
		int r , c , w;

		public Point(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {  // 값 비교해서 최소값 사용
			int diff = this.w - o.w;
			return diff;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			map = new int [N][N];
			distance = new int [N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);  // max로 채워준다. 최소값 찾기 위함
			}
			
			for (int i = 0; i < N; i++) {
				String [] arr = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
				}
			}
			
			sb.append("Problem ").append(cnt++).append(": ").append(dijkstra());
			sb.append("\n");
		}
		System.out.println(sb);

	}
	
	private static int dijkstra() {
		// 초기 값 설정을 해준다.
		distance[0][0] = map[0][0];
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>();  // Priorityqueue 사용한다. 삽입과 삭제가 일어날 때 순서가 조정된다.
		pq.add(new Point(0,0,map[0][0]));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();  // 순서 조정 됨
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr >= 0 && nr <N && nc >=0 && nc<N) {
					// 현재 가중치보다 작다면 그게 일단 최소비용이다.
					if(distance[nr][nc] > distance[cur.r][cur.c] + map[nr][nc]) {
						distance[nr][nc] = distance[cur.r][cur.c] + map[nr][nc];
						pq.add(new Point(nr,nc,distance[nr][nc]));
					}
				}
				
			}
			
		}
		return distance[N-1][N-1];
	}

}
