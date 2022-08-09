package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P022_SWEA6808_규영이와인영이의카드게임 {

    // 규영이의 카드
    static int[] card;
    // 사용 된 카드인가?
    static boolean[] isUsed;
    static int win;
    static int lose;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            win = 0;
            lose = 0;
            card = new int[9];
            // 카드 계산을 위해 사이즈 + 1로 할당
            isUsed = new boolean[19];
            String[] input = br.readLine().split(" ");

            for (int i = 0; i < card.length; i++) {
                // 규영이 카드 순서대로 입력
                card[i] = Integer.parseInt(input[i]);
                // 규영이 카드는 사용처리
                isUsed[card[i]] = true;
            }

            // 총 9라운드까지, 0 : 0부터 시작
            gameStart(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);
    }

    static void gameStart(int step, int gy, int iy) {
        // 게임 끝났을떄
        if (step == 9) {
            // 규영이가 이겼으면
            if (gy > iy) {
                win++;
            } else if (gy < iy) { // 규영이가 졌으면
                lose++;
            }
            return;
        }

        for (int i = 1; i <= 18; i++) {
            // 규영이가 낼 카드는 사용처리되었고, 인영이가 쓸 카드만 선택
            if (!isUsed[i]) {
                isUsed[i] = true;
                if (card[step] > i) {
                    // 규영 승
                    gameStart(step + 1, gy + card[step] + i, iy);
                } else {
                    // 인영 승
                    gameStart(step + 1, gy, iy + card[step] + i);
                }
                isUsed[i] = false;
            }
        }
    }
}
