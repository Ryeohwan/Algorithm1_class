package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P010_BJ11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String a = br.readLine();
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(a," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		 // x1,y1  다음부터 x2,y2 까지의 합을 구하라
		
		int [][] arr = new int [n][n];
		int check = 0;
		int sum = 0;
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			sum = sum + arr[i][0];
			for(int j = 1; j<n;j++) {
				check = Integer.parseInt(st.nextToken());
				arr[i][j] = check + sum;
				sum = arr[i][j];
			}
			sum = 0;
		} // 2차원 배열에 누적합 입력 완료
		
		
		 for(int tc = 0; tc<m ; tc++) {
			 	int num = 0;
		        st = new StringTokenizer(br.readLine()," ");
		        int si = Integer.parseInt(st.nextToken()) -1;
		        int sj = Integer.parseInt(st.nextToken()) -1;
		        int ei = Integer.parseInt(st.nextToken()) -1;
		        int ej = Integer.parseInt(st.nextToken()) -1;
		        
		        for(int i = si;i<=ei;i++) {  // 사각형을 그렸을 때 좌측 끝에서 우측 끝까지 반복
		        	if(sj == 0) {
		        		num = num + arr[i][ej];
		        	}else {
		        		num = num + arr[i][ej] - arr[i][sj-1];  // sj-1 을 해야 sj부터의 값을 더해줄 수 있다.
		        	}
		        }
		        
		        sb.append(num).append("\n");  // StringBuilder 를 사용해서 해야 시간초과가 나지 않는다.
		        
		    }
		System.out.println(sb);
	}

}
