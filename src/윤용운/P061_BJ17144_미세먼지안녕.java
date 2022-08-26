package 윤용운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P061_BJ17144_미세먼지안녕 {

    static int R, C, T;
    static int[][][] map;
    static int aircon1, aircon2;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C][2];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
                if (map[i][j][0] == -1) {
                    aircon2 = i;
                    aircon1 = aircon2 - 1;
                } else {
                    answer += map[i][j][0];
                }
            }
        }

        for (int t = 0; t < T; t++) {
            spreadDust();
            addDust();
            airconUpOn();
            airconDownOn();
        }
        System.out.println(answer);
    }

    static void spreadDust() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int count = 0;
                if (map[i][j][0] != -1) {
                    int dust = map[i][j][0] / 5;

                    if (i - 1 >= 0 && map[i - 1][j][0] != -1) {
                        map[i - 1][j][1] += dust;
                        count++;
                    }

                    if (i + 1 < R && map[i + 1][j][0] != -1) {
                        map[i + 1][j][1] += dust;
                        count++;
                    }

                    if (j - 1 >= 0 && map[i][j - 1][0] != -1) {
                        map[i][j - 1][1] += dust;
                        count++;
                    }

                    if (j + 1 < C) {
                        map[i][j + 1][1] += dust;
                        count++;
                    }

                    map[i][j][0] -= dust * count;
                }
            }
        }
    }

    static void addDust() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j][0] += map[i][j][1];
                map[i][j][1] = 0;
            }
        }
    }

    static void airconUpOn() {
        answer -= map[aircon1 - 1][0][0];
        int I = aircon1 - 1;
        int J = 0;
        while (I > 0) {
            map[I][J][0] = map[I - 1][J][0];
            I--;
        }
        while (J < C - 1) {
            map[I][J][0] = map[I][J + 1][0];
            J++;
        }
        while (I <= aircon1 - 1) {
            map[I][J][0] = map[I + 1][J][0];
            I++;
        }
        while (J > 0) {
            map[I][J][0] = map[I][J - 1][0];
            J--;
        }
        map[aircon1][1][0] = 0;
    }

    static void airconDownOn() {
        answer -= map[aircon2 + 1][0][0];
        int I = aircon2 + 1;
        int J = 0;
        while (I < R - 1) {
            map[I][J][0] = map[I + 1][J][0];
            I++;
        }
        while (J < C - 1) {
            map[I][J][0] = map[I][J + 1][0];
            J++;
        }
        while (I >= aircon2 + 1) {
            map[I][J][0] = map[I - 1][J][0];
            I--;
        }
        while (J > 0) {
            map[I][J][0] = map[I][J - 1][0];
            J--;
        }
        map[aircon2][1][0] = 0;
    }
}
