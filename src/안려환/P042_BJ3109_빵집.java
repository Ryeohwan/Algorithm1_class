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
		
		setLocation(0,0);
		
	}
	
	public static int isAvailable(int starti,int startj) { // 건물과 이미 지나간 파이프를 X로 표시해서 int 로 방향지정
		// 오른쪽, 오른쪽위 , 오른쪽 아래
		if(map[starti][startj] != 'X'||map[starti][startj] != 'z' && starti-1 > 0 && starti-1 < R && startj-1 >0 && startj-1 < R) {
			if(map[starti-1][startj+1] != 'X') return 1;  // 대각선 위
			else if (map[starti][startj+1] != 'X') return 2;  // 우측으로 이동
			else if (map[starti+1][startj+1] != 'X') return 3; // 대각선 아래
			else return 0;  // 0이 나오면 아래 줄로 이동해야 한다.
		}else if(map[starti][startj] == 'X'||map[starti][startj] == 'z'){  // 0,0에  건물이 있는 경우
			 // 아래 칸으로 내려간다.
			return 0; // 0이 나오면 아래 줄로 이동해야 한다.
		}else {
			return -1;
		}
		
	}
	
	
	public static void setLocation(int starti,int startj) {
		map[starti][startj] = 'z';
		if (startj == C) {
			cnt ++;
			startj = 0;
		}
		switch(isAvailable(starti,startj)) {
		case -1:
			break;
		case 0:
			setLocation(starti+1,startj);
			break;
		case 1:
			setLocation(starti-1,startj+1);
		case 2:
			setLocation(starti,startj+1);
			break;
		case 3:
			setLocation(starti+1,startj+1);
			break;
		default:
			break;
		}
	}

}
