package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P017_BJ2493_탑 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Info> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int [] answer = new int[input.length];

        int i = input.length - 1;
        stack.push(new Info(i, Integer.parseInt(input[i])));
        i--;
        while (i >= 0) {
            while (!stack.empty() && Integer.parseInt(input[i]) > stack.peek().height){
                Info info = stack.pop();
                answer[info.pos] = i + 1;
            }
            stack.add(new Info(i, Integer.parseInt(input[i])));
            i--;
        }

        sb.append(answer[0]);
        for (i = 1; i < answer.length; i++) {
            sb.append(" ").append(answer[i]);
        }

        System.out.println(sb);
    }

    static class Info {
        int pos, height;

        public Info(int pos, int height) {
            this.pos = pos;
            this.height = height;
        }
    }
}
