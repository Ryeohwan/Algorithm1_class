package 윤용운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S001_SWEA6485_삼성시의버스노선 {
    static class Range {
        int start, end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isUsed(int busStop) {
            return busStop >= this.start && busStop <= this.end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            Range[] rangeArr = new Range[N];
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                rangeArr[i] = new Range(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }

            int P = Integer.parseInt(br.readLine());
            int[] result = new int[P];
            for(int i = 0; i < P; i++) {
                int thisBusStop = Integer.parseInt(br.readLine());
                for (Range range : rangeArr) {
                    if (range.isUsed(thisBusStop)) {
                        result[i]++;
                    }
                }
            }

            sb.append("#").append(tc);
            for(int count : result) {
                sb.append(" ").append(count);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
