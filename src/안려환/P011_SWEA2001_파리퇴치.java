package 안려환;

import java.util.Scanner;

public class P011_SWEA2001_파리퇴치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test = 0;test<T;test++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int [][] arr = new int [n][n];
			for(int i = 0; i<n;i++) {
				for(int j =0; j<n;j++) {
					arr[i][j] = sc.nextInt();
				}
			}  // 여기까지 입력을 받아준다.
			int num = 0;
			int max = 0;
			for(int i = 0; i<n-m+1;i++ ) {  // 파리채의 크기만큼만 들어갈 수 있게 n-m +1 까지만 받아준다.
				for(int j = 0; j<n-m+1;j++) {
					for(int k = i; k<i+m;k++) {
						for(int l = j; l < j+m;l++) {
							num += arr[k][l];
						}
					}
					if(num>max) {  // 최대 값들만 비교해서 num 에 넣어준다.
						max = num;
						num = 0;
					}else {
						num = 0;
					}
					
				}
				
			}
			
			System.out.println("#"+test+" "+max);
		}
		
		
	}

}
