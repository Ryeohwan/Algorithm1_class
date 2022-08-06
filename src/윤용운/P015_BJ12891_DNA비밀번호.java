package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P015_BJ12891_DNA비밀번호 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Character> que = new LinkedList<>();
        int S, P, answer = 0;
        // S, P 입력
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // 문자열 입력
        char[] charArr = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        // 비밀번호 조건 입력
        int[] conditionArr = new int[4];
        for (int i = 0; i < 4; i++) {
            conditionArr[i] = Integer.parseInt(st.nextToken());
        }
        int[] countArr = new int[4];
        int i = 0;
        while (i < S) {
            // P보다 작으면 큐에 넣으면서 값 체크
            if (que.size() < P) {
                que.add(charArr[i]);
                // 알파벳 개수 카운트
                switch (charArr[i]) {
                    case 'A':
                        countArr[0]++;
                        break;
                    case 'C':
                        countArr[1]++;
                        break;
                    case 'G':
                        countArr[2]++;
                        break;
                    case 'T':
                        countArr[3]++;
                        break;
                    default:
                        break;
                }
                i++;
            } else { // 크기가 P가 되면 조건이랑 검사
                if (isCorrect(conditionArr, countArr)) {
                    answer++;
                }
                // 검사 후, 제일 앞에꺼를 빼면서 카운트 빼주기
                char tmp = que.poll();
                switch (tmp) {
                    case 'A':
                        countArr[0]--;
                        break;
                    case 'C':
                        countArr[1]--;
                        break;
                    case 'G':
                        countArr[2]--;
                        break;
                    case 'T':
                        countArr[3]--;
                        break;
                    default:
                        break;
                }
            }
        }
        // 마지막 인덱스에서는 검사가 안되므로 반복문 밖에서 검사
        if (isCorrect(conditionArr, countArr)) {
            answer++;
        }
        System.out.println(answer);
    }

    static boolean isCorrect(int[] condition, int[] count) {
        for (int i = 0; i < 4; i++) {
            if (condition[i] > count[i]) {
                return false;
            }
        }
        return true;
    }
}
