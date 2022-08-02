package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P006_SWEA2805_농작물수확하기 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 테스트케이스 입력
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 농작지의 전체 크기 입력
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
//			// 위에서 아래로, 중간에서부터 좌우로 1칸씩 늘려가면서 값을 구해준다.
//			// 첫번쨰줄 ~ 중간 줄까지
//			for (int i = 0; i < n / 2 + 1; i++) {
//				//입력
//				String arr[] = br.readLine().split("");
//				//중간 - i칸부터 중간 + i칸까지의 입력값을 더한다.
//				for (int j = n / 2 - i; j < n / 2 + i + 1; j++) {
//					answer += Integer.parseInt(arr[j]);
//				}
//			}
//
//			// 중간 다음 줄 ~ 마지막줄
//			for (int i = n / 2 - 1; i >= 0; i--) {
//				//입력
//				String arr[] = br.readLine().split("");
//				//중간 - i칸부터 중간 + i칸까지의 입력값을 더한다.		
//				for (int j = n / 2 - i; j < n / 2 + i + 1; j++) {
//					answer += Integer.parseInt(arr[j]);
//				}
//			}
			
			for (int i = 0; i < n; i++) {
				String arr[] = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					if (Math.abs(i - n / 2) + Math.abs(j - n / 2) <= n / 2) {
						answer += Integer.parseInt(arr[j]);
					}
				}
			}

			// 출력
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
