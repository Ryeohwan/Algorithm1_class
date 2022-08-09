package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

//public class P021_SWEA1233_사칙연산유효성검사 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		
//		for (int test = 1; test < 11; test++) {
//			StringBuilder sb = new StringBuilder();
//			int check = 0;
//			LinkedList<String> num_list = new LinkedList<>();
//			int n = Integer.parseInt(br.readLine());
//			char [] list = new char[n+1];
//			int answer = 1;
//			for (int i = 0; i < n; i++) {
//				st = new StringTokenizer(br.readLine()," ");
//				num_list.add(st.nextToken());
//				check = Integer.parseInt(num_list.get(0));
//				num_list.add(st.nextToken());
//				list[check] = num_list.get(1).charAt(0);
//				if(list[check] != '+' && list[check] != '/'&& list[check] != '-'&& list[check] != '*') {
//					if(check % 2 == 0 && check / 2 > 0) {
//						if(list[check/2]!='+' && list[check/2]!='-' && list[check/2]!='*' &&  list[check/2]!='/') {
//							answer=0;
//						}
//					}
//				}
//			}
//			sb.append("#").append(test).append(" ").append(answer);
//			System.out.println(sb);
//			
//		}
//	}
//}

public class P021_SWEA1233_사칙연산유효성검사 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		for (int test = 1; test <11; test++) {
			StringBuilder sb = new StringBuilder();
			int n=sc.nextInt();
			sc.nextLine();
			char[] list=new char[n+1];
			int answer=1;
			for (int i = 0; i < n; i++) {
				String[] s=sc.nextLine().split(" ");
				int check=Integer.parseInt(s[0]);  
				list[check]=s[1].charAt(0);  // 연산자를 입력받습니다.
	
				if(list[check]!='+' && list[check]!='-' && list[check]!='*' &&  list[check]!='/') {  // 연산자가 있는지 판단해줍니다.
					if(check%2==0 && check/2>0) {
						if(list[check/2]!='+' && list[check/2]!='-' && list[check/2]!='*' &&  list[check/2]!='/') {
							answer=0;  // 그리고 부모노드에서 연산자가 있는지 판단해봅니다.
						}
					}
				}
			}
			
			sb.append("#").append(test).append(" ").append(answer);
			System.out.println(sb);
		}
	}
}
