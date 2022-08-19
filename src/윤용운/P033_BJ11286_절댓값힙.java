package 윤용운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class P033_BJ11286_절댓값힙{
    static class Node implements Comparable<Node>{
        int realNum;
        int absNum;
        public Node(int i){
            realNum = i;
            absNum = Math.abs(i);
        }

        @Override
        public int compareTo(Node o) {
            if(absNum > o.absNum)
                return 1;
            else if (absNum < o.absNum)
                return -1;
            else{
                return Integer.compare(realNum, o.realNum);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        int count;
        PriorityQueue<Node> pq = new PriorityQueue<>(100001);
        StringBuilder sb =  new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());

        for(int i=0;i<count;i++){
            int next = Integer.parseInt(bf.readLine());
            if(next == 0){
                if(pq.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(pq.poll().realNum).append("\n");
            }
            else
                pq.add(new Node(next));
        }

        System.out.println(sb);
    }
}
