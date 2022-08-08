package 윤용운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P019_BJ1158_요세푸스문제 {
    public static void main(String[] args) throws IOException{
        int N,K,count = 1;
        // 큐에 넣고, 반복 할 생각으로 큐 생성
        Queue<Integer> que = new LinkedList<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 갯수만큼 큐에 입력
        for(int i=1;i<=N;i++){
            que.add(i);
        }
        sb.append("<");
        while(!que.isEmpty()){
            // K 번째 수이면, 출력
            if(count == K){
                sb.append(que.poll());
                if(!que.isEmpty()){
                    sb.append(", ");
                }
                count = 1;
            } else {    // 아니면, 다시 뒤에 넣어주기
                int i = que.poll();
                que.add(i);
                count++;
            }
        }
        sb.append(">");

        // 출력
        System.out.println(sb);
    }
}
