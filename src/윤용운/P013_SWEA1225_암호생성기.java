package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P013_SWEA1225_암호생성기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 선입선출을 위한 큐 생성
		Queue<Integer> que = new LinkedList<>();
		String input = "";
		
		// 테케 제한이 없으므로, 입력이 끝날때까지 계속 연산
		while((input = br.readLine()) != null) {
			int tc = Integer.parseInt(input);
			String[] pw = br.readLine().split(" ");
			int step = 1;
			
			// 큐에 값 입력
			for (int i = 0; i < pw.length; i++) {
				que.add(Integer.parseInt(pw[i]));
			}
			
			// 하나가 0될떄까지 반복
			while(true) {
				// 첫번째꺼 뽑아서
				int tmp = que.poll();
				
				// 뺐을때 0보다 작거나 같으면 끝
				if (tmp - step <= 0) {
					que.add(0);
					break;
				} else { // 아니면 반복
					que.add(tmp - step);
				}
				// 1 2 3 4 5 순으로 계속 반복
				step = step++ % 5 + 1;
			}
			
			// 출력값 StringBuilder에 입력
			sb.append("#").append(tc);
			while (!que.isEmpty()) {
				sb.append(" ").append(que.poll());
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
