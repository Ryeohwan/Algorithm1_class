package 안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P027_BJ1010_다리놓기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        // n!/(r! * (n - r)!)
        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            System.out.println(fac(n).divide(fac(r).multiply(fac(n - r))));
        }
        BigInteger.TEN.add(BigInteger.ONE);
    }

    static BigInteger fac(int i) {
        if (i == 0) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(i).multiply(fac(i - 1));
    }
}
