package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P024_BJ2563_색종이 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] paper = new boolean[100][100];
        int count = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int tc = 0; tc < count; tc++) {
            String[] input = br.readLine().split(" ");

            int startI = Integer.parseInt(input[0]);
            int startJ = Integer.parseInt(input[1]);

            for (int i = startI; i < startI + 10; i++) {
                for (int j = startJ; j < startJ + 10; j++) {
                    if (!paper[i][j]) {
                        paper[i][j] = true;
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
