package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10819_차이를최대로 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr= new int[n];
		for(int i =0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int sum = 0;
		for(int i=0;i<n/2;i++) {
			sum += Math.abs(arr[i]-arr[n-i-1]);
		}
		System.out.println(sum);
	}

}
