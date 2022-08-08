package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P020_SWEA9229_한빈이와SpotMart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		
		for(int test = 0; test < T; test ++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			int [] arr = new int [N];
			for(int i = 0; i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Queue<Integer> que = new LinkedList<>();  // 그냥 추가만 하면 쓸 수 있도록 que 를 썼읍니다.
			for(int i = 0 ; i<N-1;i++) {
				for(int j = i+1; j<N;j++) {
					que.add(arr[i] + arr[j]);  // 조합을 사용하여 두 개의 합들을 모아두었습니다.
				}
			}
			int max = 0, temp = 0;
			for(int a:que) {
				if(a<=M) {
					temp = a;
					if(temp > max) {
						max = temp;   // 조건에 맞는 것 중에 가장 큰 값을 가져왔습니다.
					}
				}
			}
			
			if(max == 0) {
				sb.append("#").append(test+1).append(" ").append(-1);  // 만족하는 경우가 없을 시
				System.out.println(sb);
			}else {
				sb.append("#").append(test+1).append(" ").append(max);  // 만족하는 경우 찾았을 때
				System.out.println(sb);
			}
			
		}
	}

}
