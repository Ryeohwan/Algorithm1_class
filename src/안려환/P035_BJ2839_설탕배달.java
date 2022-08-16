package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P035_BJ2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
//		if(N % 5 == 0) cnt += N/5;
//		else if ((N - 3) % 5 == 0) {
//			cnt++;
//			cnt += (N - 3) / 5;
//		}else if ((N-5)% 3 == 0)  {
//			cnt++;
//			cnt += (N - 5) / 3;
//		}else if (N%3 == 0){
//			cnt += N/3;
//		}else cnt = -1;

		
		while(N > 0) {
			if(N % 5 == 0) {
				cnt += N/5;
				N = 0;
			}else {
				cnt ++;
				N -= 3;
			}
		}
		
		if(N < 0) {
			cnt = -1;
		}
		
		System.out.println(cnt);
	}

}
