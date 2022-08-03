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
			}
			int num = 0;
			int max = 0;
			for(int i = 0; i<n-m+1;i++ ) {
				for(int j = 0; j<n-m+1;j++) {
					for(int k = i; k<i+m;k++) {
						for(int l = j; l < j+m;l++) {
							num += arr[k][l];
						}
					}
					if(num>max) {
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
