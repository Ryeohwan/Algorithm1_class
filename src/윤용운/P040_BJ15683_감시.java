package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P040_BJ15683_감시 {
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<Pos> cctvs = new ArrayList<>();

    static class Pos {
        int i, j, type;

        public Pos(int i, int j, int type) {
            this.i = i;
            this.j = j;
            this.type = type;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvs.add(new Pos(i,j,map[i][j]));
                }
            }
        }

        solve(0);
        System.out.println(answer);
    }

    static void solve(int step) {
        if (step == cctvs.size()) {
            int tmp = 0;
            for (int[] row : map) {
                for (int col : row) {
                    if (col == 0) {
                        tmp++;
                    }
                }
            }

            if (tmp < answer) {
                answer = tmp;
            }
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            changeMap(cctvs.get(step), dir, true);
            solve(step + 1);
            changeMap(cctvs.get(step), dir, false);
            if (cctvs.get(step).type == 2 && dir > 1 || cctvs.get(step).type == 5 && dir > 0) {
                break;
            }
        }
    }

    static void changeMap(Pos pos, int dir, boolean isChange) {
        switch (pos.type) {
            case 1:
                switch (dir) {
                    case 0:
                        changeUp(pos, isChange);
                        break;
                    case 1:
                        changeRight(pos, isChange);
                        break;
                    case 2:
                        changeLeft(pos, isChange);
                        break;
                    case 3:
                        changeDown(pos, isChange);
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (dir) {
                    case 0:
                        changeUp(pos, isChange);
                        changeDown(pos, isChange);
                        break;
                    case 1:
                        changeLeft(pos, isChange);
                        changeRight(pos, isChange);
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                switch (dir) {
                    case 0:
                        changeUp(pos, isChange);
                        changeRight(pos, isChange);
                        break;
                    case 1:
                        changeDown(pos, isChange);
                        changeRight(pos, isChange);
                        break;
                    case 2:
                        changeDown(pos, isChange);
                        changeLeft(pos, isChange);
                        break;
                    case 3:
                        changeUp(pos, isChange);
                        changeLeft(pos, isChange);
                        break;
                    default:
                        break;
                }
                break;
            case 4:
                switch (dir) {
                    case 0:
                        changeUp(pos, isChange);
                        changeRight(pos, isChange);
                        changeLeft(pos, isChange);
                        break;
                    case 1:
                        changeUp(pos, isChange);
                        changeRight(pos, isChange);
                        changeDown(pos, isChange);
                        break;
                    case 2:
                        changeDown(pos, isChange);
                        changeRight(pos, isChange);
                        changeLeft(pos, isChange);
                        break;
                    case 3:
                        changeUp(pos, isChange);
                        changeDown(pos, isChange);
                        changeLeft(pos, isChange);
                        break;
                    default:
                        break;
                }
                break;
            case 5:
                changeUp(pos, isChange);
                changeDown(pos, isChange);
                changeLeft(pos, isChange);
                changeRight(pos, isChange);
                break;
            default:
                break;
        }
    }

    static void changeUp(Pos pos, boolean isChange) {
        int thisI = pos.i;
        int thisJ = pos.j;

        while (--thisI >= 0) {

            if (map[thisI][thisJ] == 6) {
                break;
            } else if (map[thisI][thisJ] <= 0) {
                if (isChange) {
                    map[thisI][thisJ]--;
                } else {
                    map[thisI][thisJ]++;
                }
            }
        }
    }

    static void changeRight(Pos pos, boolean isChange) {
        int thisI = pos.i;
        int thisJ = pos.j;

        while (++thisJ < M) {

            if (map[thisI][thisJ] == 6) {
                break;
            } else if (map[thisI][thisJ] <= 0) {
                if (isChange) {
                    map[thisI][thisJ]--;
                } else {
                    map[thisI][thisJ]++;
                }
            }
        }
    }

    static void changeLeft(Pos pos, boolean isChange) {
        int thisI = pos.i;
        int thisJ = pos.j;

        while (--thisJ >= 0) {

            if (map[thisI][thisJ] == 6) {
                break;
            } else if (map[thisI][thisJ] <= 0) {
                if (isChange) {
                    map[thisI][thisJ]--;
                } else {
                    map[thisI][thisJ]++;
                }
            }
        }
    }

    static void changeDown(Pos pos, boolean isChange) {
        int thisI = pos.i;
        int thisJ = pos.j;

        while (++thisI < N) {

            if (map[thisI][thisJ] == 6) {
                break;
            } else if (map[thisI][thisJ] <= 0) {
                if (isChange) {
                    map[thisI][thisJ]--;
                } else {
                    map[thisI][thisJ]++;
                }
            }
        }
    }
}
