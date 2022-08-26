package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S004_시험대비2_헌터 {

    static class Info {

        int i, j, number;
        boolean isMonster;

        public Info(int i, int j, int number) {
            this.i = i;
            this.j = j;
            this.number = number > 0 ? number - 1 : -(number + 1);
            this.isMonster = number > 0;
        }

        public int calc(Info next) {
            return Math.abs(this.i - next.i) + Math.abs(this.j - next.j);
        }
    }

    static List<Info> list;
    static boolean[] isKill;
    static boolean[] isReport;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            answer = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    if (!input[j].equals("0")) {
                        list.add(new Info(i, j, Integer.parseInt(input[j])));
                    }
                }
            }
            isKill = new boolean[list.size() / 2];
            isReport = new boolean[list.size() / 2];

            findRoute(0, 0, new Info(0, 0, 0));
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void findRoute(int step, int length, Info pos) {
        if (step == list.size()) {
            if (answer > length) {
                answer = length;
            }
            return;
        }

        for (Info info : list) {
            if (info.isMonster && !isKill[info.number]) {
                isKill[info.number] = true;
                findRoute(step + 1, length + info.calc(pos), info);
                isKill[info.number] = false;

            } else if (!info.isMonster && isKill[info.number] && !isReport[info.number]) {
                isReport[info.number] = true;
                findRoute(step + 1, length + info.calc(pos), info);
                isReport[info.number] = false;
            }
        }
    }
}
