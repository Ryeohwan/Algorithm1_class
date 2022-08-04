package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P012_SWEA1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			boolean trigger = true;
			for (int i = 0; i < input.length; i++) {
				switch (input[i]) {
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
				if (!trigger) {
					break;
				}
			}
			if (trigger) {
				sb.append("#").append(tc).append(" ").append("1").append("\n");
			} else {
				sb.append("#").append(tc).append(" ").append("0").append("\n");			
			}
		}
		System.out.println(sb);
	}
}
