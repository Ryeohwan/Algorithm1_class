package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P036_BJ1074_Z {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int min = 0;

        for (int i = N; i >= 0; i--) {
            int range = (int) Math.pow(2, i);

            if (r < range / 2 && c < range / 2) {
                continue;
            } else if (r < range / 2 && c >= range / 2) {
                c -= range / 2;
                min += range * range / 4;
            } else if (r >= range / 2 && c < range / 2) {
                r -= range / 2;
                min += range * range / 2;
            } else {
                r -= range / 2;
                c -= range / 2;
                min += range * range / 4 * 3;
            }
        }
        System.out.println(min);
    }
}
