package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P038_SWEA5644_무선충전 {

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public void move(String dir) {
            switch (dir) {
                case "0" :
                    break;
                case "1" :
                    this.i -= 1;
                    break;
                case "2" :
                    this.j += 1;
                    break;
                case "3" :
                    this.i += 1;
                    break;
                case "4" :
                    this.j -= 1;
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            int[][] map = new int[10][10];
            int[][] chargeCount;
            String[] aMove, bMove;
            int[] charger;

            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int A = Integer.parseInt(input[1]);

            aMove = br.readLine().split(" ");
            bMove = br.readLine().split(" ");
            Pos aPos = new Pos(0,0);
            Pos bPos = new Pos(9,9);
            chargeCount = new int[2][M + 1];
            // 충전기 정보
            charger = new int[A + 1];
            for (int idx = 1; idx <= A; idx++) {
                input = br.readLine().split(" ");
                charger[idx] = Integer.parseInt(input[3]);
                int chargerI = Integer.parseInt(input[0]) - 1;
                int chargerJ = Integer.parseInt(input[1]) - 1;
                int range = Integer.parseInt(input[2]);

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (Math.abs(i - chargerI) + Math.abs(j - chargerJ) <= range) {
                            map[j][i] += 1 << idx;
                        }
                    }
                }
            }

            for (int step = 0; step <= M; step++) {
                if ((map[aPos.i][aPos.j] & map[bPos.i][bPos.j]) == 0) {
                    if (map[aPos.i][aPos.j] == 0) {
                        chargeCount[0][step] = 0;
                    } else {
                        for (int i = 0; i <= A; i++) {
                            if ((map[aPos.i][aPos.j] & 1 <<i) != 0) {
                                if (charger[i] > chargeCount[0][step]) {
                                    chargeCount[0][step] = charger[i];
                                }
                            }
                        }
                    }

                    if (map[bPos.i][bPos.j] == 0) {
                        chargeCount[1][step] = 0;
                    } else {
                        for (int i = 0; i <= A; i++) {
                            if ((map[bPos.i][bPos.j] & 1 << i) != 0) {
                                if (charger[i] > chargeCount[1][step]) {
                                    chargeCount[1][step] = charger[i];
                                }
                            }
                        }
                    }
                } else {
                    int aMax = 0;
                    int bMax = 0;
                    for (int i = 1; i <= A; i++) {
                        if ((map[aPos.i][aPos.j] & 1 << i) != 0) {
                            for (int j = 1; j <= A; j++) {
                                if ((map[bPos.i][bPos.j] & 1 << j) != 0) {
                                    if (i == j && aMax + bMax <= charger[i]) {
                                        chargeCount[0][step] = charger[i] / 2;
                                        chargeCount[1][step] = charger[i] / 2;
                                        aMax = charger[i] / 2;
                                        bMax = charger[i] / 2;
                                    } else if (i != j && aMax + bMax <= charger[i] + charger[j]) {
                                        chargeCount[0][step] = charger[i];
                                        chargeCount[1][step] = charger[j];
                                        aMax = charger[i];
                                        bMax = charger[j];
                                    }
                                }
                            }
                        }
                    }
                }
                if (step == M) {
                    break;
                }
                aPos.move(aMove[step]);
                bPos.move(bMove[step]);
            }

            int count = 0;
            for (int[] c : chargeCount) {
                for (int value : c) {
                    count += value;
                }
            }
            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
