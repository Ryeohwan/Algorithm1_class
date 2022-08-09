package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P024_BJ2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int [][] arr = new int [100][100];  // 빈 2차원 배열을 만들어줍니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int cnt = 0;
		for(int test = 0; test < T; test++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n < 91 && m<91) {  // 10x10 인 색종이를 붙여야 하니 최대한 붙일 수 있는 자리까지만 연산하도록 설정하였습니다.
				for(int i = n; i<10+n;i++) {
					for(int j = m; j<10+m;j++) {
							if(arr[i][j] != 1) {  // 이미 색종이가 붙어있다면 cnt 를 더해주지 않습니다.
								arr[i][j] = 1;
								cnt ++;
						}
					}
				}
			}
			
		}
		System.out.println(cnt);

	}

}
