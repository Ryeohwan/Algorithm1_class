package 안려환;

import java.util.Scanner;

public class P030_BJ2961_도영이가만든맛있는음식 {
	// n개의 수를 입력받고 가능한 모든 부분 집합을 생성
	static int N, min = Integer.MAX_VALUE;
	static int[] sour;
	static int[] bitter;
	static boolean[] isSelected;
	
 	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
 		N = sc.nextInt();
 		sour = new int[N];
 		bitter = new int[N];
 		isSelected = new boolean[N];
 		
 		for(int i = 0;i<N;i++) {
 			sour[i] = sc.nextInt();
 			bitter[i] = sc.nextInt();
 		}
 		
 		subset(0);
 		System.out.println(min);
	}
 	
 	private static void subset(int index) {
 		boolean isUsed = false;
 		if(index == N) {  // 더이상 고려할 원소가 없다면 부분집합의 구성이 완성
 			int s = 1, b = 0;
 			for(int i = 0; i<N;i++) {
 				if (isSelected[i]) {
 					isUsed = true;
 					s *= sour[i];
 					b += bitter[i];
 				}
 			}
 			
 			if (min >= Math.abs(s - b) && isUsed) {
 				min = Math.abs(s - b);
 			}
 			return;
 		}
 		
 		//원소 선택
 		isSelected[index] = true;
 		subset(index+1);
 		// 원소 미선택
 		isSelected[index] = false;
 		subset(index +1);
 	}
}