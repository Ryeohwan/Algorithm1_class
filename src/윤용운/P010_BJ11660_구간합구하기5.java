package 윤용운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P010_BJ11660_구간합구하기5 {
	public static void main(String[] args) throws IOException {
        int N,M;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 입력값 입력
        String[] input = bf.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        // 2차원배열 생성
        int[][] map = new int[N][N];

        // 구간합 구하기
        for(int i=0;i<N;i++){
        	input = bf.readLine().split(" ");
        	// 각 행의 구간값을 우선 정한다.
            map[i][0] = Integer.parseInt(input[0]);
            for(int j=1;j<N;j++){
                map[i][j] = map[i][j-1] + Integer.parseInt(input[j]);
            }
        }

        for(int k=0;k<M;k++){
        	input = bf.readLine().split(" ");
        	// 시작좌표, 끝 좌표 입력
            int startI = Integer.parseInt(input[0]) - 1;
            int startJ = Integer.parseInt(input[1]) - 1;
            int endI = Integer.parseInt(input[2]) - 1;
            int endJ = Integer.parseInt(input[3]) - 1;
            int answer = 0;

            // 행별로 구한 구간값들을 열별로 다시 더해준다.
            for(int i = startI; i<=endI;i++){
                if(startJ == 0){
                    answer += map[i][endJ];
                } else {
                    answer += map[i][endJ] - map[i][startJ-1];
                }
            }

            sb.append(answer).append("\n");
        }
        // 출력
        System.out.println(sb);       
    }
}
