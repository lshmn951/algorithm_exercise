package algo_exercise.SWEA;

import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq&categoryId=AV5PzOCKAigDFAUq&categoryType=CODE
 * @mem
 * @time
 * @caution
 */

public class SWEA_2001_파리퇴치 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int N = sc.nextInt();
			int [][] arr = new int [N][N];
			int M = sc.nextInt();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max = Integer.MIN_VALUE;
			int sum = 0;
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					sum = 0;
					
					for(int r=i;r<i+M;r++) {
						for(int c=j;c<j+M;c++) {
							sum += arr[r][c];
						}
					}
					
					if(sum>max) {
						max = sum;
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
}
