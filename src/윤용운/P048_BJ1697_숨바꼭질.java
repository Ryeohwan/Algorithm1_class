package 윤용운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P048_BJ1697_숨바꼭질 {
    static Queue<Node> q = new LinkedList<>();
    static boolean[] visited = new boolean[100001];

    static class Node{
        int n,depth;
        public Node(int n, int depth){
            this.n = n;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception{
        int N,K;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(new Node(N,0),K);
    }
    private static void bfs(Node node, int end) {
        q.add(node);
        visited[node.n] = true;
        while(true){
            Node thisNode = q.poll();
            int thisN = thisNode.n;
            int thisDepth = thisNode.depth;

            if(thisN == end){
                System.out.println(thisNode.depth);
                break;
            }


            if(thisN - 1 >= 0){
                if(!visited[thisN - 1]){
                    q.add(new Node(thisN - 1,thisDepth+1));
                    visited[thisN - 1] = true;
                }
            }
            if(thisN + 1 <= 100000){
                if(!visited[thisN + 1]){
                    q.add(new Node(thisN + 1,thisDepth+1));
                    visited[thisN + 1] = true;
                }
            }
            if(thisN * 2 <= 100000){
                if(!visited[thisN * 2]){
                    q.add(new Node(thisN * 2,thisDepth+1));
                    visited[thisN * 2] = true;
                }
            }
        }
    }

}
