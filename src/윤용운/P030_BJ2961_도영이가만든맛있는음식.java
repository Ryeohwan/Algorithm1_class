package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P030_BJ2961_도영이가만든맛있는음식 {
	static int N;
	static int[] sour;
	static int[] bitter;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			sour[i] = Integer.parseInt(input[0]);
			bitter[i] = Integer.parseInt(input[1]);
		}
		
		
	}
	
	static void subset(int count) {
		
	}

}
