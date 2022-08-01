package 안려환;

import java.util.Scanner;

public class P001_SWEA1289_원재의메모리복구하기 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int j = 0;j<n;j++) {
			char [] arr_1 = new char[51];
			int cnt = 0;
			String line = sc.next();
			char check = '0';
			for(int i = 0; i< line.length()-1;i++) {
				if(line.charAt(i) != check) {
					cnt ++;
					check = line.charAt(i);
					
				}
				
			}
			System.out.println("#"+(j+1)+" "+cnt);
		}
		
	}
}
