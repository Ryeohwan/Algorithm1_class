package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class P012_SWEA1218_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		for(int t = 1 ; t<11; t++) {
			Stack<String> stack1 = new <String>Stack();
			Stack<String> stack2 = new <String>Stack();  // 기호별 다른 스택을 사용한다.
			Stack<String> stack3 = new <String>Stack();
			Stack<String> stack4 = new <String>Stack();
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			String []str = br.readLine().split("");  // char 단위로 받아낼 때 사용하자.
			int check = 0;
			for(int test = 0; test<n;test++) {
				switch(str[test]) {  // 조건을 넣어준다.
				case "(":
					stack1.add(str[test]);  // 여는 괄호는 스택에 넣어둔다.
					break;
				case "{":
					stack2.add(str[test]);
					break;
				case "<":
					stack3.add(str[test]);
					break;
				case "[":
					stack4.add(str[test]);
					break;
				case ")":
					if(stack1.size()>0) {  // 닫는 괄호들은 스택 길이를 판별하여 꺼내준다. 없다면 check 에 1을 넣는다.
						stack1.pop();
						break;
					}else {
						check = 1;
						break;
					}
				case "}":
					if(stack2.size()>0) {
						stack2.pop();
						break;
					}else {
						check = 1;
						break;
					}
				case ">":
					if(stack3.size()>0) {
						stack3.pop();
					}else {
						check = 1;
					}break;
				case "]":
					if(stack4.size()>0) {
						stack4.pop();
						break;
					}else {
						check = 1;
						break;
					}
				}

				
			}
			
			if(stack1.isEmpty() == false || stack2.isEmpty() == false || stack3.isEmpty() == false || stack4.isEmpty() == false) {  // 각 스택들이 비어있어야만 0이다.
				check = 1;
			}
			if(check == 1) {  // 생각해보니 닫는 괄호부터 튀어나오는거라 거꾸로 생각했어서 답을 거꾸로 내줬다.
				check = 0;
			}else {
				check = 1;
			}
			sb.append("#").append(t).append(" ").append(check);
			System.out.println(sb);
			
			
		}
		

	}

}
