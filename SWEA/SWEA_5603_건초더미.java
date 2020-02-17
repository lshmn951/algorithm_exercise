package algo_exercise.SWEA;

import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGEbd6cjMDFAUo&categoryId=AWXGEbd6cjMDFAUo&categoryType=CODE
 * @mem
 * @time
 * @caution
 */

public class SWEA_5603_건초더미 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int N = sc.nextInt();
			int [] arr= new int[N];
			int avg=0;
			int result=0;
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
				avg += arr[i];
			}
			avg /= N;
			for(int i=0;i<N;i++) {
				if(arr[i]>avg) {
					result+= arr[i] - avg;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}

}
