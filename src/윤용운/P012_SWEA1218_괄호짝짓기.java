package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P012_SWEA1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 마지막 넣은 것을 체크해야 되기 때문에 스택 선언
		Stack<Character> stack = new Stack<>();
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			// 캐릭터배열로 생성
			char[] input = br.readLine().toCharArray();
			boolean trigger = true;
			for (int i = 0; i < input.length; i++) {
				switch (input[i]) {
				// 괄호 시작 "(,[,{,<" 이면 입력
				case '(':
					stack.push(input[i]);
					break;
				case '[':
					stack.push(input[i]);
					break;
				case '{':
					stack.push(input[i]);
					break;
				case '<':
					stack.push(input[i]);
					break;
				// 괄호 끝이면 마지막 입력 값이랑 체크
				case ')':
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						trigger = false;
					}
					break;
				case ']':
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						trigger = false;
					}
					break;
				case '}':
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						trigger = false;
					}
					break;
				case '>':
					if (stack.peek() == '<') {
						stack.pop();
					} else {
						trigger = false;
					}
					break;
				default :
					break;
				}
				// 괄호가 서로 맞지 않다면 틀림
				if (!trigger) {
					break;
				}
			}
			
			// 출력값 저장
			if (trigger) {
				sb.append("#").append(tc).append(" ").append("1").append("\n");
			} else {
				sb.append("#").append(tc).append(" ").append("0").append("\n");			
			}
		}
		// 출력
		System.out.println(sb);
	}
}
