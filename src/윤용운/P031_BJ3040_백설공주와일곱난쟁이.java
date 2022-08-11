package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P031_BJ3040_백설공주와일곱난쟁이 {
    static int[] dwarves;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        dwarves = new int[9];
        for (int i = 0; i < 9; i++) {
            dwarves[i] = Integer.parseInt(br.readLine());
            total += dwarves[i];
        }
        total -= 100;

        int i = 0;
        int j = 0;

        for (;i < 8; i++) {
            for (j = i + 1; j < 9; j++) {
                if (dwarves[i] + dwarves[j] == total) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            System.out.println(dwarves[k]);
                        }
                    }
                }
            }
        }
    }
}
