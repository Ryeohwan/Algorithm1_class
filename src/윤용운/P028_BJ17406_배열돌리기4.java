package 윤용운;

import com.sun.org.apache.xpath.internal.operations.Or;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P028_BJ17406_배열돌리기4 {
    static int N, M, K;
    static int[][] map;
    static Order[] orders;
    static boolean[] done;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new int[N][M];
        orders = new Order[K];
        done = new boolean[K];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int k = 0; k < K; k++) {
            input = br.readLine().split(" ");
            orders[k] = new Order(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1, Integer.parseInt(input[2]));
        }

        doOrder(0);
        System.out.println(answer);
    }

    static void doOrder(int step) {
        if (step == K) {
            for (int i = 0; i < N; i++) {
                int tmp = 0;
                for (int j = 0; j < M; j++) {
                    tmp += map[i][j];
                }
                if (tmp < answer) {
                    answer = tmp;
                }
            }
            return;
        }

        for (int o = 0; o < K; o++) {
            if (!done[o]) {
                done[o] = true;
                rotate(orders[o]);
                doOrder(step + 1);
                reverse(orders[o]);
                done[o] = false;
            }
        }
    }

    static void rotate(Order order) {
        for (int step = order.s; step > 0; step--) {
            int tmp = map[order.r - step][order.c - step];
            int di = 0;
            int dj = 0;
            for (; di < step * 2; di++) {
                map[order.r - step + di][order.c - step + dj] = map[order.r - step + di + 1][order.c - step + dj];
            }
            for (; dj < step * 2; dj++) {
                map[order.r - step + di][order.c - step + dj] = map[order.r - step + di][order.c - step + dj + 1];
            }
            for (; di > 0; di--) {
                map[order.r - step + di][order.c - step + dj] = map[order.r - step + di - 1][order.c - step + dj];
            }
            for (; dj > 0; dj--) {
                map[order.r - step + di][order.c - step + dj] = map[order.r - step + di][order.c - step + dj - 1];
            }
            map[order.r - step][order.c - step + 1] = tmp;
        }
    }

    static void reverse(Order order) {
        for (int step = order.s; step > 0; step--) {
            int tmp = map[order.r - step][order.c - step];
            int di = 0;
            int dj = 0;
            for (; dj < step * 2; dj++) {
                map[order.r - step + di][order.c - step + dj] = map[order.r - step + di][order.c - step + dj + 1];
            }
            for (; di < step * 2; di++) {
                map[order.r - step + di][order.c - step + dj] = map[order.r - step + di + 1][order.c - step + dj];
            }
            for (; dj > 0; dj--) {
                map[order.r - step + di][order.c - step + dj] = map[order.r - step + di][order.c - step + dj - 1];
            }
            for (; di > 0; di--) {
                map[order.r - step + di][order.c - step + dj] = map[order.r - step + di - 1][order.c - step + dj];
            }
            map[order.r - step + 1][order.c - step] = tmp;
        }
    }

    static class Order{
        int r, c, s;

        public Order(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}
