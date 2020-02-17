package algo_exercise.SWEA;

import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5P0-h6Ak4DFAUq&categoryId=AV5P0-h6Ak4DFAUq&categoryType=CODE
 * @mem
 * @time
 * @caution
 */

public class SWEA_2005_파스칼의삼각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			System.out.println("#"+t);
			int N = sc.nextInt();
			int[] before = new int [10];
			int[] after = new int [10];
			for(int i=0;i<N;i++) {
				for(int j=0;j<=i;j++) {
					if(j==0 || j==i) {
						System.out.print(1+" ");
						after[j] = 1;
					}
					else {
						after[j] = before[j-1]+before[j];
						System.out.print(after[j]+" ");
					}
				}
				for(int j=0;j<=i;j++) {
					before[j] = after[j];
				}
				System.out.println();
			}
		}
	}

}
