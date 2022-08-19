package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P046_SWEA3234_준환이의양팔저울 {
    static int[] arr;
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(arr);
            solve(0, 0, 0);
            while(nextPermutation()) {
                solve(0, 0, 0);
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void solve(int left, int right, int step) {
        if (step == N) {
            answer++;
            return;
        }

        if (left >= right + arr[step]) {
            solve(left, right + arr[step], step + 1);
        }
        solve(left + arr[step], right, step + 1);
    }

    static boolean nextPermutation() {
        int i = N - 1;

        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = N - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        swap(arr, i - 1, j);

        int k = N - 1;
        while (i < k) {
            swap(arr, i++, k--);
        }
        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}