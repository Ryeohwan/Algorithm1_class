package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P042_BJ3109_빵집 {
	static char [][] map;
	static int starti = 0, startj = 0, cnt = 0;
	static int R,C;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		R = Integer.parseInt(arr[0]);
		C = Integer.parseInt(arr[1]);
		map = new char [R][C];
		for (int i = 0; i < R; i++) {
			String arr1 = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i] = arr1.toCharArray();
			}
		} // 입력부
		for(int i=0; i<R; i++)  // 매 줄마다 호출해준다..... -> 이걸 못했었다.
			if(check(i, 0))
				cnt++;
		System.out.println(cnt);
	}
	
	public static boolean check(int starti, int startj) {
		map[starti][startj] = 'z';
		
		if(startj == C-1) // 오른쪽 끝에 도착했다면
			return true;
		
		if(starti > 0 && map[starti-1][startj+1] == '.') // 오른쪽 위로 가는 방법
			if(check(starti-1, startj+1))
				return true;
		if(map[starti][startj+1] == '.') // 오른쪽
			if(check(starti, startj+1))
				return true;
		if(starti+1 < R && map[starti+1][startj+1] == '.') // 오른쪽 아래
			if(check(starti+1, startj+1))
				return true;
		return false;
	}
	

}
