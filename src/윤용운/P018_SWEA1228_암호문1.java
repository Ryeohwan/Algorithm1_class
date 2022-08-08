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
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            List<String> list = new LinkedList<>(Arrays.asList(input));

            int M = Integer.parseInt(br.readLine());
            input = br.readLine().split("I");
            for (int order = 1; order <= M; order++) {
                String[] command = input[order].trim().split(" ");
                int insertPos = Integer.parseInt(command[0]);
                int count = Integer.parseInt(command[1]);

                List<String> addList = new LinkedList<>(Arrays.asList(command).subList(2, 2 + count));
                list.addAll(insertPos, addList);
            }

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
