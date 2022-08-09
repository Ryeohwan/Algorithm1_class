package 안려환;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P003_BJ1244_스위치켜고끄기 {

	public static void main(String[] args) throws IOException{
		// buffered reader 써보자.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기 위함이다.
		StringBuilder sb = new StringBuilder();  // 문자열을 받기 위함이다.
		StringTokenizer st;  // 문자열을 쪼개서 저장하기 위함
		
		int N = Integer.parseInt(br.readLine()); // 입력받아온 것들을 정수형으로
		int [] switches = new int[N+1];
		st = new StringTokenizer(br.readLine()); // 쪼개서 받아둔다.
		for(int i =0; i<N;i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = Integer.parseInt(br.readLine());
		for(int i = 0; i<5;i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {  // 남성일 때
				for (int j = 0;j <= N;j++) {
					int mult = j * num; // 배수인지 확인하는 것.
					if(mult > N) { // 이게 스위치가 들은 길이보다 길어지면 안된다.
						break;
					}
					switches[mult] = Math.abs(switches[mult] - 1);
				}
			}else {
				switches[num] = Math.abs(switches[num] - 1);
				int r = 1;
				while(true) {
					if(num - r >= 1 && num + r <= N && switches[num-r] == switches[num + r]) {
						switches[num -r] = Math.abs(switches[num - r] - 1);
						switches[num+r] = Math.abs(switches[num+r] - 1);
					}else break;
					
				}
			}
		}
		for(int i =1; i <= N; i++) {
			sb.append(switches[i]); // string buffered 라 append 로 값을 넣어줘야 한다.
			if(i%20 == 0) {
				sb.append("\n");
			}else {
				sb.append(" ");
			}
			System.out.println(sb);
		}

	}

}
