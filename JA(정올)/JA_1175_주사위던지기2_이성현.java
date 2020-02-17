package algo_exercise.JA;

import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see 
 * @mem
 * @time
 * @caution 
 */


public class JA_1175_주사위던지기2_이성현 {
	static int[] dices;
	static int n;
	static int m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		dices = new int [n];
		m = sc.nextInt();
		gamesum(0);
	}
	
	public static void gamesum(int idx) {
		if(idx==n) {
			int sum=0;
			for(int i=0;i<n;i++) {
				sum += dices[i];
			}
			if(sum==m) {
				for(int dice:dices) {
					System.out.print(dice+ " ");
				}
				System.out.println();
			}
			return;
		}
		for(int i=1;i<=6;i++) {
			dices[idx]=i;
			gamesum(idx+1);
		}
	}

}
