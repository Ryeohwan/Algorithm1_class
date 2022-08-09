package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P018_SWEA1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		
		for(int test = 1; test<11;test++) {
			int cnt = 0;
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0; i<N;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}  // 기존 암호문 넣어둔 링크드 리스트 list
			
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < n; i++) { // 명령어 입력 받기
                char I = st.nextToken().charAt(0); // I
                int x = Integer.parseInt(st.nextToken()); 
                int y = Integer.parseInt(st.nextToken()); // x 와 y를 입력받는다.
                for (int j = 0; j < y; j++) { // 붙일 개수
                	list.add(x + j, Integer.parseInt(st.nextToken())); // x+j 로 한 칸씩 뒤로 밀어줍니다.
                }
           
                
            }
			sb = new StringBuilder();
            sb.append("#").append(test).append(" ");
            for (int i = 0; i < 10; i++) { // 아 10개만 출력하는 것
                sb.append(list.get(i) + " ");
            }
            System.out.println(sb);
		}

	}

}
