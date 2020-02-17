package algo_exercise.JA;

import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=992&sca=2020
 * @mem
 * @time
 * @caution
 */

public class JA_1719_별삼각형2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(n>0 && n<=100 && n%2==1 && m>0 && m<5) {
			if(m==1) {
				int j=0;
				for(int i=0;i<n;i++) {
					for(int temp=0;temp<=j;temp++) {
						sb.append("*");
					}
					if(i<n/2) {
						j++;
					}
					else {
						j--;
					}
					sb.append("\n");
				}
			}
			else if(m==2) {
				int j=0;
				for(int i=0;i<n;i++) {
					for(int temp=j;temp<n/2;temp++) {
						sb.append(" ");
					}
					for(int temp=0;temp<=j;temp++) {
						sb.append("*");
					}
					if(i<n/2) {
						j++;
					}
					else {
						j--;
					}
					sb.append("\n");
				}
			}
			else if(m==3) {
				int j=n;
				int q=0;
				for(int i=0;i<n;i++) {
					for(int temp=0;temp<q;temp++) {
						sb.append(" ");
					}
					for(int temp=0;temp<j;temp++) {
						sb.append("*");
					}
					
					if(i<n/2) {
						j-=2;
						q++;
					}
					else {
						j+=2;
						q--;
					}
					sb.append("\n");
				}
			}
			else if(m==4) {
				int j=n/2+1;
				int q=0;
				for(int i=0;i<n;i++) {
					for(int temp=0;temp<q;temp++) {
						sb.append(" ");
					}
					for(int temp=0;temp<j;temp++) {
						sb.append("*");
					}
					
					if(i<n/2) {
						j-=1;
						q++;
					}
					else {
						j+=1;
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
