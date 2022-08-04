package 안려환;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P013_SWEA1225_암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test = 1; test<11; test++) {
			StringBuilder sb = new StringBuilder();
			Queue<Integer> arr = new LinkedList<>();
			int n = sc.nextInt();
			
			for(int i = 0; i< 8;i++) {
				int a = sc.nextInt();
				arr.add(a);
			}
			
			int value = 1;
			while(value!=0) {
				for(int i = 1; i< 6 ; i++) {  //1 ~ 5 의 값들만을 이용하기 위함이다.
					value = arr.poll();  // 앞에서 값을 꺼내와서
					value -= i;  // i만큼 뺴는데
					if(value <= 0 ) {
						value = 0;
					}
					arr.offer(value);
					if(value == 0) break;
				}
			}
			
			sb.append("#").append(test).append(" ");
			System.out.print(sb);
			for(int i = 0; i< 8 ; i++) {
				int a = arr.poll();
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}
