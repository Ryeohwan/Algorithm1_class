package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P049_SWEA1238_Contact {
	 	static int N;
	 	static int[][] graph;
	 	static int[] visited;
	 
	 	public static void main(String[] args) throws Exception {
	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st;
	      StringBuilder sb = new StringBuilder();
	 
	      for(int tc=1;tc<=10;tc++){
	         st = new StringTokenizer(in.readLine());
	         N = Integer.parseInt(st.nextToken());
	         int V = Integer.parseInt(st.nextToken());
	 
	         graph = new int[101][101];  // 인원은 최대 100명이니 그 수에 맞게 선언을 해준다.
	         visited = new int[101];
	 
	         st = new StringTokenizer(in.readLine());
	 
	         for(int i=0;i<N/2;i++){
	            int from = Integer.parseInt(st.nextToken());
	            int to = Integer.parseInt(st.nextToken());
	 
	            graph[from][to] = 1;
	         }    // 입력부 완
	 
	         sb.append("#").append(tc).append(" ").append(bfs(V)).append("\n");
	 
	      }
	 
	      System.out.print(sb);
	   }
	 
	   private static int bfs(int v) {
	      Queue<Integer> queue = new LinkedList<>();  // bfs는 큐로 구현한다.
	      queue.offer(v);  // 가장 첫 노드를 큐에 저장
	  
	      int depth = 1;  
	      visited[v] = depth;
	 
	      while(!queue.isEmpty()){
	         v = queue.poll();
	 
	         for(int i=0;i<=100;i++){
	            if(graph[v][i]==1 && visited[i]==0){ // 연결되어 있고 방문한 적이 없다면
	               queue.offer(i);
	               visited[i] = visited[v]+1;   
	            }
	         }
	 
	         depth = Math.max(depth,visited[v]);  // 큰 값을 넣어준다.
	      }
	 
	      for(int i=100;i>=0;i--){
	         if(visited[i]==depth){
	            return i;  // 마지막에 도달했다면
	         }
	      }
	 
	      return -1;
	   }
}
