package 안려환;

import java.util.Scanner;

public class P006_SWEA2805_농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();  // 전체 테스트 케이스이다.
		
		for(int i = 0; i<T;i++) {
			int sum = 0;   // 출력해줄 농작물 가치의 합입니다.
			int N = sc.nextInt();  // N을 입력받습니다.
			int [][] arr = new int[N][N];
			
			for(int j = 0; j<N;j++) {
				String str = sc.next();
				for(int k = 0; k<str.length();k++) {
					arr[j][k] = str.charAt(k)-'0';  // 한 char씩 입력받아 정수형으로 저장합니다.
				}
			} // 농장 배열 입력 완료
			
			int avg = N/2;
			int a1,b1;
			for(int j = 0; j<N;j++) {
				for(int k = 0; k<N;k++) {
					a1 = Math.abs(avg - j);  // 차이를 절대값으로 저장합니다.
					b1 = Math.abs(avg - k);
					if(a1+b1<=avg) {  // 거리를 비교해서 같거나 작은 값만 선택합니다.
						sum += arr[j][k];
						
					}
				}
			}
			System.out.println("#"+(i+1)+" "+sum);
			sum = 0;
		
		}
	}

}
