package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P009_BJ11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb ;
		StringTokenizer st;
		String a = br.readLine();
		st = new StringTokenizer(a," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int [] arr = new int [N];
		int check = 0;
		String b = br.readLine();
		st = new StringTokenizer(b," ");
		arr[0] = Integer.parseInt(st.nextToken());
		for(int i = 1;i<N;i++) {
			check = Integer.parseInt(st.nextToken());
			arr[i] = arr[i-1] +check;
		}
		
		
		for(int i = 0; i<M;i++) {
			sb = new StringBuffer();
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int num = 0;
			if(x == 1) {
				num = arr[y-1];
			}else {
				num = arr[y-1] - arr[x-2];
			}
			
			
			
			System.out.println(num);
		}
		
	}

}
