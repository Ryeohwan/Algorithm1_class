package 안려환;

import java.util.Scanner;

public class P002_BJ17478_재귀함수가뭔가요 {
	
	static int cnt = 0;
	static void recur(int n , int cnt) {
		String [] qarr = {"\"재귀함수가 뭔가요?\"","\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.","마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.","그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};
		String aa = "____";
		String [] aarr = {"\"재귀함수가 뭔가요?\"","\"재귀함수는 자기 자신을 호출하는 함수라네\"","라고 답변하였지."};
		String fin = "";
		if(cnt == 0) {
			for(int i =0; i<4;i++) {
				System.out.println(qarr[i]);
			}
			cnt += 1;
			recur(n,cnt);
		}else if (cnt < n) {
			for(int i =0; i<4;i++) {
				qarr[i] = aa + qarr[i];
				System.out.println(qarr[i]);
			}
			cnt += 1;
			recur(n,cnt);
		}else if (cnt == n) {
			for(int j = 1; j<n;j++) {
				aa += aa;
			}
			for(int i = 0 ; i<3;i++) {
				aarr[i] = aa + aarr[i];
				System.out.println(aarr[i]);
			}
			cnt += 1;
			recur(n,cnt);
		}else {
			for(int j = 1; j<n;j++) {
				aa -= aa;
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recur(N,cnt);

	}

}
