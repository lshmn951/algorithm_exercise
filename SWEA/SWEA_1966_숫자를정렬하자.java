package algo_exercise.SWEA;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PrmyKAWEDFAUq&categoryId=AV5PrmyKAWEDFAUq&categoryType=CODE
 * @mem
 * @time
 * @caution
 */

public class SWEA_1966_숫자를정렬하자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Scanner sc= new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int N = sc.nextInt();
			int [] arr= new int [N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			sb.append("#").append(t).append(" ");
			for(int i=0;i<N;i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
