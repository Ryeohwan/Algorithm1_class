package 안려환;

import java.util.Scanner;

public class P004_SWEA1208_Flatten {

	public static void main(String[] args) {
		int[] fini = new int[10];
		Scanner sc = new Scanner(System.in);

		for (int test = 0; test < 10; test++) {
			int N = sc.nextInt();

			int max = 0, min = 0, gap = 0;
			int[] arr = new int[100]; // 박스가 들어있을 인덱스
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();

			}

			for (int again = 0; again < N; again++) {
				for (int i = 0; i < 100; i++) { // 최대 값과 최소 값을 찾아주는 반복문이다.
					if (arr[i] >= arr[max]) {
						max = i;
					} else if (arr[i] <= arr[min]) {
						min = i;
					}
				}
				arr[max] -= 1; // 덤프가 일어난다.(N 값의 횟수만큼)
				arr[min] += 1;
			}
			for (int i = 0; i < 100; i++) { // 최대 값과 최소 값을 찾아주는 반복문이다.
				if (arr[i] >= arr[max]) {
					max = i;
				} else if (arr[i] <= arr[min]) {
					min = i;
				}
			}

			gap = arr[max] - arr[min];
			fini[test] = gap;

		}
		for(int i = 0; i<10;i++) {
			System.out.println("#"+(i+1)+" "+fini[i]);
		}
		

	}

}
