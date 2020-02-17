package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_13300_방배정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int man[] = new int [6];
		int woman[] = new int [6];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		for(int i=0;i<N;i++) {
			int tjdquf = sc.nextInt();
			int grade = sc.nextInt();
			if(tjdquf==0) {
				woman[grade-1]++;
			}
			else {
				man[grade-1]++;
			}
		}
		int sum=0;
		for(int i=0;i<6;i++) {
			sum+=(man[i]+(k-1))/k;
			sum+=(woman[i]+(k-1))/k;
		}
		System.out.println(sum);
	}

}
