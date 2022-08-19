package 윤용운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P045_BJ1260_DFS와BFS {
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] isVisited;
    public static int[][] graph;
    public static int n,m,v;

    static void dfs(int d){
        isVisited[d] = true;
        sb.append(d);

        for(int i = 1;i<=n;i++){
            if(graph[d][i] != 0 && !isVisited[i]){
                sb.append(" ");
                dfs(i);
            }
        }
    }

    static void bfs(int b){
        Queue<Integer> que = new LinkedList<>();
        que.add(b);
        isVisited[b] = true;

        while(que.peek() != null){
            int next = que.poll();
            sb.append(next);

            for(int i=1;i<=n;i++){
                if(graph[next][i] != 0 && !isVisited[i]){
                    que.add(i);
                    isVisited[i] = true;
                }
            }
            sb.append(" ");
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        // n,m,v 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];

        // Node 생성
        for(int i=0;i<m;i++){
            String k = bf.readLine();
            StringTokenizer kst = new StringTokenizer(k);
            int x = Integer.parseInt(kst.nextToken());
            int y = Integer.parseInt(kst.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        isVisited = new boolean[n + 1];
        dfs(v);
        sb.append("\n");
        isVisited = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }
}
