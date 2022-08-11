package 안려환;


import java.util.Scanner;

public class P031_BJ3040_백설공주와일곱난쟁이 {
	static int[] hat_num = new int[9];
	static boolean[] real_nan = new boolean[9];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			hat_num[i] = scan.nextInt();
		}
		find_nan(0, 0, 0);
	}
	public static void find_nan(int cnt, int check_cnt, int sum) {
		if(cnt == 9) {
			if(check_cnt == 7 && sum==100) {
				for(int i=0;i<9;i++) {
					if(real_nan[i]) {
						System.out.println(hat_num[i]);
					}
				}
				System.exit(0);
			}
			return;
		}
		real_nan[cnt] = true;  // 부분집합을 이용한다.
		find_nan(cnt+1, check_cnt+1, sum+hat_num[cnt]);
		real_nan[cnt] = false;
		find_nan(cnt+1,check_cnt, sum);
	}

}