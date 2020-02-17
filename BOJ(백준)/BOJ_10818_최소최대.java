package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_10818_최소최대 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			int input = sc.nextInt();
			if(min>input) {
				min = input;
			}
			if(max<input) {
				max = input;
			}
		}
		System.out.println(min+" "+max);
	}

}
