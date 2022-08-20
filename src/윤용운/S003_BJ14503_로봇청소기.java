package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S003_BJ14503_로봇청소기 {

    static int N, M, posI, posJ, dir, answer = 0, total = 0;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];

        input = br.readLine().split(" ");
        posI = Integer.parseInt(input[0]);
        posJ = Integer.parseInt(input[1]);
        dir = Integer.parseInt(input[2]);

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 0) {
                    total++;
                }
            }
        }

        simulation();
        System.out.println(answer);
    }

    static void simulation() {
        int count = 0;
        while (true) {
            if (map[posI][posJ] == 0) {
                answer++;
                map[posI][posJ] = 2;
                count = 0;
            }

            if (!checkLeft()) {
                if (count++ < 4) {
                    dir = (3 + dir) % 4;
                } else {
                    if (moveBack()) {
                        count = 0;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    static boolean checkLeft() {
        switch (dir) {
            case 0:
                if (map[posI][posJ - 1] == 0) {
                    dir = 3;
                    posJ--;
                    return true;
                }
                break;
            case 1:
                if (map[posI - 1][posJ] == 0) {
                    dir = 0;
                    posI--;
                    return true;
                }
                break;
            case 2:
                if (map[posI][posJ + 1] == 0) {
                    dir = 1;
                    posJ++;
                    return true;
                }
                break;
            case 3:
                if (map[posI + 1][posJ] == 0) {
                    dir = 2;
                    posI++;
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    static boolean moveBack() {
        switch (dir) {
            case 0:
                if (map[posI + 1][posJ] != 1) {
                    posI++;
                    return true;
                }
                break;
            case 1:
                if (map[posI][posJ - 1] != 1) {
                    posJ--;
                    return true;
                }
                break;
            case 2:
                if (map[posI - 1][posJ] != 1) {
                    posI--;
                    return true;
                }
                break;
            case 3:
                if (map[posI][posJ + 1] != 1) {
                    posJ++;
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }
}
