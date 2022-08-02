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
			// 평탄화 횟수 입력
			int dumpCount = Integer.parseInt(br.readLine());
			// 평탄화 해야하는 지형 입력
			int[] arr = new int[100];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 지형의 높이순으로 정렬
			Arrays.sort(arr);
			
			// 평탄화 작업 시행
			while (dumpCount-- > 0) {
				// 평탄화 완료 체크
				if (arr[99] == arr[0]) {
					break;
				}
				// 최고점 1 빼기
				arr[99]--;
				// 최저점 1 더하기
				arr[0]++;
				
				// 작업 수행 후 다시 높이순으로 정렬
				int start = 0;
				int end = 99;
				
				// 최저점 재배치
				while (start < 99 && arr[start] > arr[start + 1]) {
					int temp = arr[start];
					arr[start] = arr[start + 1];
					arr[start + 1] = temp;
					start++;
				}
				
				//최고점 재배치
				while (end > 0 && arr[end] < arr[end - 1]) {
					int temp = arr[end];
					arr[end] = arr[end - 1];
					arr[end - 1] = temp;
					end--;
				}
			}
			// 완료 후 고저차 계산
			int answer = arr[99] - arr[0];
			// 출력
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
