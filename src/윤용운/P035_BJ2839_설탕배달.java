package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P035_BJ2839_설탕배달 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                count += N / 5;
                N = 0;
            } else {
                N -= 3;
                count++;
            }
        }

        if (N < 0) {
            count = -1;
        }
        System.out.println(count);
    }
}
