package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P049_SWEA1238_Contact {

    static boolean[][] map;
    static boolean[] isVisited;
    static class Info {
        int data, depth;

        public Info(int data, int depth) {
            this.data = data;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";
        int tc = 1;
        while ((input = br.readLine()) != null) {
            map = new boolean[101][101];
            isVisited = new boolean[101];
            int answer = 0;
            int depth = 0;
            String[] inputArr = input.split(" ");

            int dataLength = Integer.parseInt(inputArr[0]) / 2;
            int start = Integer.parseInt(inputArr[1]);
            inputArr = br.readLine().split(" ");
            for (int i = 0; i < dataLength; i++) {
                map[Integer.parseInt(inputArr[2 * i])][Integer.parseInt(inputArr[2 * i + 1])] = true;
            }

            Queue<Info> que = new LinkedList<>();
            que.add(new Info(start, 1));
            isVisited[start] = true;

            while (!que.isEmpty()) {
                Info thisInfo = que.poll();
                if (thisInfo.depth > depth) {
                    depth = thisInfo.depth;
                    answer = thisInfo.data;
                } else if (thisInfo.depth == depth && thisInfo.data > answer) {
                    answer = thisInfo.data;
                }

                for (int i = 1; i <= 100; i++) {
                    if (!isVisited[i] && map[thisInfo.data][i]) {
                        isVisited[i] = true;
                        que.add(new Info(i, thisInfo.depth + 1));
                    }
                }
            }

            sb.append("#").append(tc++).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
