package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_9625_BABBA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []a = new int [46];
		int []b = new int [46];
		a[0] = 1;
		b[0] = 0;
		a[1] = 0;
		b[1] = 1;
		a[2] = 1;
		b[2] = 1;
		a[3] = 1;
		b[3] = 2;
		for(int i=4;i<=45;i++) {
			a[i] = a[i-1]+a[i-2];
			b[i] = b[i-1]+b[i-2];
		}
		System.out.println(a[n]+" "+b[n]);
	}

}
