package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P037_JO1828_냉장고 {
    static class Material implements Comparable<Material>{
        int low, high;

        public Material(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public int compareTo(Material o) {
            if (this.low - o.low != 0) {
                return this.low - o.low;
            } else {
                return this.high - o.high;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Material[] arr = new Material[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = new Material(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        Arrays.sort(arr);

        // 로직
        int refrigerator = 1;
        int high = arr[0].high;
        for (int i = 1; i < N; i++) {
            if (arr[i].low <= high) {
                if (arr[i].high <= high) {
                    high = arr[i].high;
                }
            } else {
                refrigerator++;
                high = arr[i].high;
            }
        }

        System.out.println(refrigerator);
    }
}
