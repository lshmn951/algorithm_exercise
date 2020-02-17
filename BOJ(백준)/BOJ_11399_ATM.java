package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 7.
 * @see https://www.acmicpc.net/problem/11399
 * @mem
 * @time
 * @caution 정렬하고 더해주자
 */

public class BOJ_11399_ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr= new int [n];
		int [] sum = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		sum[0] = arr[0];
		int summin = sum[0];
		for(int i=1;i<n;i++) {
			sum[i] = sum[i-1] + arr[i];
			summin+=sum[i];
		}
		
		System.out.println(summin);
		
	}

}