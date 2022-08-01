package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P006_SWEA2805_농작물수확하기 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			for (int i = 0; i < n / 2 + 1; i++) {
				String arr[] = br.readLine().split("");
				for (int j = n / 2 - i; j < n / 2 + i + 1; j++) {
					answer += Integer.parseInt(arr[j]);
				}
			}

			for (int i = n / 2 - 1; i >= 0; i--) {
				String arr[] = br.readLine().split("");
				for (int j = n / 2 - i; j < n / 2 + i + 1; j++) {
					answer += Integer.parseInt(arr[j]);
				}
			}

			System.out.println("#" + test_case + " " + answer);
		}
	}
}
