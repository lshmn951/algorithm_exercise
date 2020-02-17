package algo_exercise.SWEA;

import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PnnU6AOsDFAUq&categoryId=AV5PnnU6AOsDFAUq&categoryType=CODE
 * @mem
 * @time
 * @caution
 */

public class SWEA_1948_날짜계산기 {
	static int[] mon = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t= 1;t<=tc;t++) {
			int sum =0;
			int month1 = sc.nextInt();
			int day1 = sc.nextInt();
			int month2 = sc.nextInt();
			int day2 = sc.nextInt();
			
			
			for(int i= month1-1;i<month2-1;i++) {
				sum+=mon[i];
			}
			sum = sum + (day2-day1)+1;
			
			System.out.println("#"+t+" "+sum);
		}
	}
}
