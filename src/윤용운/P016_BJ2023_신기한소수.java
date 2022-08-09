package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P016_BJ2023_신기한소수 {

    static int N;
    static int prime = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        makePrime(0);
        System.out.println(sb);
    }

    static void makePrime(int stack) {
        if (stack == N) {
            if (isPrime(prime)) {
                sb.append(prime).append("\n");
            }
        }
        for (int i = 0; i < 10; i++) {
            prime = prime * 10 + i;
            if (isPrime(prime)) {
                makePrime(stack + 1);
            }
            prime /= 10;
        }
    }

    static boolean isPrime(int prime) {
        if (prime == 0 || prime == 1) {
            return false;
        }

        int tmp = (int) Math.sqrt(prime);

        for (int i = 2; i <= tmp; i++) {
            if (prime % i == 0) {
                return false;
            }
        }
        return true;
    }
}
