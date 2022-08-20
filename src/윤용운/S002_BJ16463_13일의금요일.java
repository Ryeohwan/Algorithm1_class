package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S002_BJ16463_13일의금요일 {

    static int[] limit = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int year = 2019;
        int month = 0;
        int friday = 4;

        while (year <= target) {
            friday += 7;

            if (friday == 13) {
                answer++;
            }

            if (friday > limit[month]) {
                friday -= limit[month++];
                if (month > 11) {
                    month %= 12;
                    year++;

                    if (year % 4 == 0) {
                        limit[1] = 29;
                    } else {
                        limit[1] = 28;
                    }

                    if (year % 100 == 0) {
                        limit[1] = 28;
                    }

                    if (year % 400 == 0) {
                        limit[1] = 29;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
