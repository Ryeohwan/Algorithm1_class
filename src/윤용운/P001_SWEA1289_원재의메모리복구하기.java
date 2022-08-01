package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P001_SWEA1289_원재의메모리복구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			char base = '0';
			char[] input = br.readLine().toCharArray();
			
			for (int i = 0; i < input.length; i++) {
				if (input[i] != base) {
					answer++;
					base = input[i];
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
