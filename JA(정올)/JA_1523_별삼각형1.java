package algo_exercise.JA;

import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=795&sca=2020
 * @mem
 * @time
 * @caution
 */

public class JA_1523_별삼각형1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n =sc.nextInt();
		int m =sc.nextInt();
		if(n>0 &&n<=100 && m>0&&m<4) {
			if(m==1) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<=i;j++) {
						sb.append("*");
					}
					sb.append("\n");
				}
			}
			else if(m==2) {
				for(int i=0;i<n;i++) {
					for(int j=n;j>i;j--) {
						sb.append("*");
					}
					sb.append("\n");
				}
			}
			else if(m==3) {
				for(int i=0;i<n;i++) {
					for(int j=1;j<n-i;j++) {
						sb.append(" ");
					}
					for(int j=0;j<(1+i*2);j++) {
						sb.append("*");
					}
					sb.append("\n");
				}
			}
			System.out.println(sb);
		}
		else {
			System.out.println("INPUT ERROR!");
		}
	}

}
