package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P018_SWEA1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		for(int test = 1; test<11;test++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			int check = 0;
			while (check < n) {
				
			}
		}

	}

}
