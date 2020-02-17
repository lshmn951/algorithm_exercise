package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10867_중복빼고정렬하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int cur = arr[0];
		System.out.print(cur+" ");
		for(int i=1;i<n;i++) {
			if(cur!=arr[i]) {
				cur = arr[i];
				System.out.print(cur+" ");
			}
		}
	}

}
