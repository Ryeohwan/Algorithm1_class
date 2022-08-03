package 윤용운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P009_BJ11659_구간합구하기4 {
	
    public static void main(String[] args) throws IOException {
        int N, testCase;
        int[] addArr;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = bf.readLine().split(" ");

        //입력 갯수 입력
        N = Integer.parseInt(input[0]);
        testCase = Integer.parseInt(input[1]);
        
        addArr = new int[N];

        // 입력
        input = bf.readLine().split(" ");
        
        // 누적합 입력 시작
        addArr[0] = Integer.parseInt(input[0]);

        for(int i=1;i<N;i++){
        	// 배열의 이전값 + 현재 입력값
            addArr[i] = Integer.parseInt(input[i]) + addArr[i-1];
        }

        for(int i=0;i<testCase;i++){
            int start, end;
            input = bf.readLine().split(" ");
            start = Integer.parseInt(input[0]) - 1;
            end = Integer.parseInt(input[1]) - 1;

            if (start == 0) {
            	// 시작 인덱스가 0이면 이전값이 0이므로 끝값만 입력
                sb.append(addArr[end]).append("\n");         	
            } else {
            	// 시작 인덱스가 0이 아니면, 구간 값 전의 합들은 빼준다.
                sb.append(addArr[end] - addArr[start - 1]).append("\n");          	
            }
        }
        // 출력
        System.out.println(sb);
    }
}
