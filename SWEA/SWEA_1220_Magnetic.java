package algo_exercise.SWEA;

import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14hwZqABsCFAYD&categoryId=AV14hwZqABsCFAYD&categoryType=CODE
 * @mem
 * @time
 * @caution
 */

public class SWEA_1220_Magnetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int size = sc.nextInt();
			int [][]arr = new int[size][size];
			for(int r=0;r<size;r++) {
				for(int c=0;c<size;c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			int count=0;
			for(int r=0;r<size;r++) {
				for(int c=0;c<size;c++) {
					if(arr[r][c]==1) {
						int i = r+1;
						for(;i<size;i++) {
							if(arr[i][c]==1) {
								break;
							}
							else if(arr[i][c]==2) {
								count++;
								break;
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+count);
		}	
	}
}
