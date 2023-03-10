package 안려환;

import java.util.Scanner;

public class P007_SWEA1954_달팽이숫자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int t = 1; t <= test; t++) {  // test case 만큼 반복하게 한다.
			int n = sc.nextInt();
			int[][] arr = new int[n][n];  // 입력받기 위한 2차원 배열
			int turn = 1;  // 그냥 1을 쓰는 것보다는 turn 이라는 변수를 사용하여 가독성을 높였읍니다.
			int x = 0, y = -1; // y에 1을 더해가야하기에 -1로 두어야 0값부터 접근 가능합니다.
			int cnt = 1; // 화면에 보여질 cnt 입니다.
			
			while(true) {
				for(int i = 0; i < n; i++) {
					y = y + turn; // 세로로 움직히는 방향
					arr[x][y] = cnt;  // cnt 값 입력해주는데 아래의 ++ 덕에 하나씩 증가차며 출력할 수 있다.
					cnt++;
				}
				n--; // 회전하면서 길이가 줄어들기 떄문에 -- 를 처리해줍니다.
				for(int i = 0; i < n; i++) {
					x = x + turn; // 가로로 움직이는 방향
					arr[x][y] = cnt;  
					cnt++;
				}
				turn *= -1;  // 외냐면 아래에서 위로 올라가는 방향으로 진행되기 때문이다.
				if(n == 0)
					break;
			}
			System.out.println("#" + t);
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr.length; j++) {  // 출력의 모양을 맞춰주기 위함이다.
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
