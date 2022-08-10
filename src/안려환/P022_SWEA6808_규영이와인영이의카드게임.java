package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P022_SWEA6808_규영이와인영이의카드게임 {
	public static boolean[] number;  // 재귀를 이용하기 위해서 static 으로 뺴주었습니다.
	public static int[] kCard = new int[9];
	public static int winCnt, loseCnt;
	
	// 순서 없이 n 개 중에서 r 개 뽑기이다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		// 이번 줄에 규영이가 내는 경우에 대해서 적게 된다.
		for (int tc = 1; tc <= T; ++tc) {			
			String [] arr = br.readLine().split(" ");
			number = new boolean[19];
			for (int i = 0; i < 9; ++i) {
				int input = Integer.parseInt(arr[i]);
				number[input] = true;
				kCard[i] = input;
			}
			
			winCnt = 0;
			loseCnt = 0;
			
			permutation(0, 0, 0); // 순열 처음 점수 0 점에서 시작한다.
			
			System.out.println("#" + tc + " " + winCnt + " " + (9*8*7*6*5*4*3*2 - winCnt));  // 팩토리얼에서 이긴 경우를 빼주면 나머지의 경우가 나옵니다.
		}
		
		br.close();  // 메모리를 위해서 종료를 시켜줍니다.
	}
	
	public static void permutation(int idx, int kScore, int iScore) {
		if (idx >= 9) {  // 9장을 뽑았을 때
			if (kScore > iScore) {  // 규영이의 점수가 높으면
				winCnt++;
			}
			
			return;
		}
		
		for (int i = 1; i < 19; ++i) {  // 카드가 1 ~ 18 이다.
			if (!number[i]) {  // false 일 때 그니까 뽑지 않은 카드일 때 하나하나 다 해보기 위함이니 이후에 false 로 다시 매꿔줍니다
				number[i] = true;
				
				int score = kCard[idx] + i;  // 승자는 규영이의 카드의 점수와 내가 뽑은 카드의 점수를 합한 값을 가져오게 됩니다.
				
				if (kCard[idx] >= i) {  // 규영이가 이긴 경우
					permutation(idx + 1, kScore + score, iScore);
				}
				else {  // 인영이가 이긴 경우
					permutation(idx + 1, kScore, iScore + score);
				}
				
				number[i] = false; // 다시 매꿔줍니다.
			}
		}
	}
}