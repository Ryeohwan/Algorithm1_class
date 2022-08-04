package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P014_BJ2164_카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> que = new LinkedList<>();
		
		// N 입력
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		// Queue에 모든 카드 값 입력
		for (int i = 1; i <= N; i++) {
			que.add(i);
		}
		
		// Queue가 빌때까지 반복. 마지막 카드를 answer에 계속 저장한다.
		while (!que.isEmpty()) {
			// 1. 카드 버리기
			answer = que.poll();
			if (que.isEmpty()) {
				// 큐가 비어있다면 전에 버린 카드가 정답
				// 남아있다면, 
				break;
			}
			// 2. 카드 뒤로 넘기기
			answer = que.poll();
			que.add(answer);
		}
		
		// 정답 출력
		System.out.println(answer);
	}
}
