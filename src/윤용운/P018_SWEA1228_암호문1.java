package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P018_SWEA1228_암호문1 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            // 초기 리스트 입력 개수
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            // 초기에 리스트에 들어가는 값들 입력
            // 입력만 할것이기에 ArrayList 보다 LinkedList 가 빠를것이라 생각
            List<String> list = new LinkedList<>(Arrays.asList(input));

            int M = Integer.parseInt(br.readLine());
            input = br.readLine().split("I");
            // 1부터 시작하는 이유는 I로 자를 때 첫번째 인덱스가 ""가 생기게 된다.
            for (int order = 1; order <= M; order++) {
                // 배열로 만들고
                String[] command = input[order].trim().split(" ");

                // 첫번쨰, 두번째 값은 조건
                int insertPos = Integer.parseInt(command[0]);
                int count = Integer.parseInt(command[1]);

                // 세번째 값부터 마지막 값까지 리스트로 생성
                List<String> addList = new LinkedList<>(Arrays.asList(command).subList(2, 2 + count));
                // 생성 후 입력
                list.addAll(insertPos, addList);
            }

            // 출력
            sb.append("#").append(tc);
            for (int i = 0; i < 10; i++) {
                sb.append(" ").append(list.get(0));
                list.remove(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
