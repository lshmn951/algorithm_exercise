package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class BOJ_2750_수정렬하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
	}

}
