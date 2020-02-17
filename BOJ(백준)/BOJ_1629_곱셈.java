package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_1629_곱셈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		long mul = A%C;
		long result = 1;
		while(B>0) {
			if(B%2==1) {
				result *= mul;
				result %=C;
			}
			mul = ((mul%C)*(mul%C))%C;
			B/=2;
		}
		System.out.println(result);
		
	}
	
}
