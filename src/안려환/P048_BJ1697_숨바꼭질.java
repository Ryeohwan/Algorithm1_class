package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P048_BJ1697_숨바꼭질 {
	static int N,K;
	static int answer = 0;
	
	static class Pos {
		int value;
		int depth;
		public Pos(int value, int depth) {
			this.value = value;
			this.depth = depth;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		K = Integer.parseInt(arr[1]);
		
		solve();
		System.out.println(answer);
		
	}
	
	static void solve() {
		Queue<Pos> que = new LinkedList<>();
		int [] map = new int [100001];  // 방문체크
		que.add(new Pos(N,0));
		map[N] = 1;
		while(!que.isEmpty()) {
			Pos temp = que.poll();
			if(temp.value == K) {
				answer = temp.depth;
				break;
			}else {
				if(temp.value+1<=100000 && map[temp.value+1]!= 1) {
					Pos tmp = new Pos(temp.value+1,temp.depth+1);
					que.add(tmp);
					map[temp.value+1] = 1;
				}
				if (temp.value-1 >= 0 && map[temp.value-1]!= 1) {
					Pos tmp = new Pos(temp.value-1,temp.depth+1);
					que.add(tmp);
					map[temp.value-1] = 1;

				}
				if (temp.value*2<=100000 && map[temp.value*2]!= 1) {
					Pos tmp = new Pos(temp.value*2,temp.depth+1);
					que.add(tmp);
					map[temp.value*2] = 1;
				}
				
			}
		}
		
	}
}
