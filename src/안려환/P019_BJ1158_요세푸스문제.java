package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P019_BJ1158_요세푸스문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i<n+1; i++) {
			list.add(i);
		}
		System.out.print("<");
		StringBuilder sb = new StringBuilder();
		while(list.size() != 0) {
			for(int i = 0;i<k;i++) { // 매 k번 마다 삭제해주기 위해 마지막을 k로 해준다.
				if(i == k-1) { // 마지막에 도달하면
					if(list.size() == 1) {  // 1로 해야 sb에 들어갈 마지막 값에는 ,를 안넣을 수 있다.
						sb.append(list.remove());
					}else {
						sb.append(list.remove()).append(", "); // 답 형식이 띄어쓰기이다.
					}
				}else {
					list.add(list.remove());  // 다시 리스트에 k번이 아닌 경우 넣는다.
				}
			}
		}System.out.print(sb);
		System.out.print(">");
	}

}
