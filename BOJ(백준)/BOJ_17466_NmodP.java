package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_17466_NmodP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mod = sc.nextInt();
		long result = 1;
		while(n>0) {
			result = result * n;
			result = result%mod;
			n--;
		}
		System.out.println(result);
	}

}
