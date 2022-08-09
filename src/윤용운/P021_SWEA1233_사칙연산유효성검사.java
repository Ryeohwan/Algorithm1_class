package 윤용운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P021_SWEA1233_사칙연산유효성검사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int input = Integer.parseInt(br.readLine());
            int answer = 1;
            for (int i = 0; i < input; i++) {
                String[] str = br.readLine().split(" ");

                if (str.length == 2) {
                    if (str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
                        answer = 0;
                    }
                }

                if (str.length == 4) {
                    if (!str[1].equals("+") && !str[1].equals("-") && !str[1].equals("*") && !str[1].equals("/")) {
                        answer = 0;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
