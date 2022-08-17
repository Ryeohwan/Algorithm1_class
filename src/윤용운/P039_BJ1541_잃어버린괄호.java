package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P039_BJ1541_잃어버린괄호 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int answer = 0;

        for (int i = 0; i < input.length; i++) {
            String[] tmpArr = input[i].split("\\+");
            for (String s : tmpArr) {
                if (i == 0) {
                    answer += Integer.parseInt(s);
                } else {
                    answer -= Integer.parseInt(s);
                }
            }
        }
        System.out.println(answer);
    }
}
