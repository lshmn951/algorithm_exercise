package algo_exercise.SWEA;

import java.util.Scanner;

public class SWEA_5356_세로로말해요 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			System.out.print("#"+i+" ");
			StringBuilder sb = new StringBuilder();
			String[] str = new String[5];
			int max=0;
			for(int j=0;j<5;j++) {
				str[j] = sc.next();
				if(str[j].length()>max) {
					max = str[j].length();
				}
			}
			for(int j=0;j<max;j++) {
				for(int k=0;k<5;k++) {
					if(str[k].length()>j) {
						sb.append(str[k].charAt(j));
					}
				}
			}
			System.out.println(sb);
		}
	}

}
