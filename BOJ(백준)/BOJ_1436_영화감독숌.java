package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1436_영화감독숌 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tya = 665;
		for(int i=0;i<n;i++) {
			while(true) {
				tya++;
				String str = Integer.toString(tya);
				if(str.contains("666")) {
					break;
				}
			}
		}
		System.out.println(tya);
	}
}
