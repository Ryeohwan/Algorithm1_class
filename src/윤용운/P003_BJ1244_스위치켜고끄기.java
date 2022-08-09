package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P003_BJ1244_스위치켜고끄기 {

	public static void main(String[] args) throws Exception {
		int switchs, N;
		boolean[] lights;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switchs = Integer.parseInt(br.readLine());
		lights = new boolean[switchs];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < switchs; i++) {
			if (st.nextToken().equals("0")) {
				lights[i] = false;
			} else {
				lights[i] = true;
			}
		}
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1")) {
				change1(lights, Integer.parseInt(st.nextToken()));
			} else {
				change2(lights, Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i < lights.length; i++) {
			if (lights[i]) {
				System.out.print("1");
			} else {
				System.out.print("0");
			}
			
			if (i % 20 == 19) {
				System.out.println();
			} else {
				System.out.print(" ");
			}
		}
	}
	
	static void change1(boolean[] lights, int num) {
		for (int i = 1; i * num - 1 < lights.length; i++) {
			lights[i * num - 1] = !lights[i * num - 1];
		}
	}
	
	static void change2(boolean[] lights, int num) {
		lights[num - 1] = !lights[num - 1];
		for (int i = 1; num - i - 1 >= 0 && num + i - 1 < lights.length; i++) {
			if (lights[num - i - 1] != lights[num + i - 1]) {
				break;
			}
			lights[num - i - 1] = !lights[num - i - 1];
			lights[num + i - 1] = !lights[num + i - 1];
		}
	}
}
