package algo_exercise.SWEA;

import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB&categoryId=AV7GLXqKAWYDFAXB&categoryType=CODE
 * @mem
 * @time
 * @caution
 */

public class SWEA_2805_농작물수확하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int N = sc.nextInt();
			int [][]arr = new int [N][N];
			int sum1=0;
			for(int i=0;i<N;i++) {
				String str = sc.next();
				for(int j=0;j<N;j++) {
					arr[i][j] = str.charAt(j)-'0';
					sum1+=arr[i][j];
				}
			}
			int sum2 = 0;
			for(int i=0;i<N;i++) {
				if(i<N/2) {
					for(int c1=0;c1<N/2-i;c1++) {
						sum2+=arr[i][c1];
					}
					for(int c2=N/2+1+i;c2<N;c2++) {
						sum2+=arr[i][c2];
					}
				}
				else if(i>N/2) {
					for(int c1=0;c1<i-N/2;c1++) {
						sum2+=arr[i][c1];
					}
					for(int c2=N-i+N/2;c2<N;c2++) {
						sum2+=arr[i][c2];
					}
				}
			}
			System.out.println("#"+t+" "+(sum1-sum2));
		}
	}
}
