package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P062_SWEA_4013_특이한자석 {
    static int[][] gears;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] input;
            gears = new int[4][8];
            int order = Integer.parseInt(br.readLine());
            for (int i = 0; i < 4; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < 8; j++) {
                    gears[i][j] = Integer.parseInt(input[j]);
                }
            }

            while (order-- > 0) {
                input = br.readLine().split(" ");
                int gear = Integer.parseInt(input[0]) - 1;
                int dir = Integer.parseInt(input[1]);

                if (gear < 3 && gears[gear][2] != gears[gear + 1][6]) {
                    checkUp(gear + 1, -dir);
                }
                if (gear > 0 && gears[gear - 1][2] != gears[gear][6]) {
                    checkDown(gear - 1, -dir);
                }
                turn(gears[gear], dir);
            }

            int answer = 0;
            for(int i = 0; i < 4; i++) {
                answer += gears[i][0] * (int)Math.pow(2, i);
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void checkUp(int gear, int dir) {
        if (gear >= 3) {
            turn(gears[gear], dir);
            return ;
        }

        if (gears[gear][2] != gears[gear + 1][6]) {
            checkUp(gear + 1, -dir);
        }
        turn(gears[gear], dir);
    }

    static void checkDown(int gear, int dir) {
        if (gear <= 0) {
            turn(gears[gear], dir);
            return ;
        }

        if (gears[gear - 1][2] != gears[gear][6]) {
            checkDown(gear - 1, -dir);
        }
        turn(gears[gear], dir);
    }

    static void turn(int[] gear, int dir) {
        int tmp = 0;
        switch (dir) {
            case 1:
                tmp = gear[7];
                System.arraycopy(gear, 0, gear, 1, 7);
                gear[0] = tmp;
                break;
            case -1:
                tmp = gear[0];
                System.arraycopy(gear, 1, gear, 0, 7);
                gear[7] = tmp;
                break;
            default:
                break;
        }
    }
}
