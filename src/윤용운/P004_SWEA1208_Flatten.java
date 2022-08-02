package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P004_SWEA1208_Flatten {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int dumpCount = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			while (dumpCount-- > 0) {
				// 평탄화 완료
				if (arr[99] == arr[0]) {
					break;
				}		
				arr[99]--;
				arr[0]++;
				int start = 0;
				int end = 99;
				while (start < 99 && arr[start] > arr[start + 1]) {
					int temp = arr[start];
					arr[start] = arr[start + 1];
					arr[start + 1] = temp;
					start++;
				}
				while (end > 0 && arr[end] < arr[end - 1]) {
					int temp = arr[end];
					arr[end] = arr[end - 1];
					arr[end - 1] = temp;
					end--;
				}
			}
			int answer = arr[99] - arr[0];
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
