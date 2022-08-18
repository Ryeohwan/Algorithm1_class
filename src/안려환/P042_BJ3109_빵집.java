package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P042_BJ3109_빵집 {
	static char [][] map;
	static int starti = 0, startj = 0, cnt = 0;
	static int C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		int R = Integer.parseInt(arr[0]);
		C = Integer.parseInt(arr[1]);
		map = new char [R][C];
		for (int i = 0; i < R; i++) {
			String arr1 = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i] = arr1.toCharArray();
			}
		} // 입력부
		
	}
	
	public static int isAvailable(int starti,int startj) { // 건물과 이미 지나간 파이프를 X로 표시해서 int 로 방향지정
		// 오른쪽, 오른쪽위 , 오른쪽 아래
		if(map[starti][startj] != 'X') {
			if(map[starti][startj+1] != 'X') return 1;
			else if (map[starti+1][startj+1] != 'X') return 2;
			else if (map[starti-1][startj+1] != 'X') return 3;
			else return 0;  // 0이 나오면 아래 줄로 이동해야 한다.
		}else {  // 0,0에  건물이 있는 경우
			 // 아래 칸으로 내려간다.
			return 0; // 0이 나오면 아래 줄로 이동해야 한다.
		}
		
	}
	
	public static void setLocation(int starti,int startj) {
		if (startj == C) {
			cnt ++;
			starti = 0;
			startj = 0;
		}
		switch(isAvailable(starti,startj)) {
		case 0:
			setLocation(starti+1,startj);
			break;
		case 1:
			setLocation(starti,startj+1);
		}
	}

}
