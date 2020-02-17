package algo_exercise.SWEA;

import java.util.Scanner;

public class SWEA_2058_D1_자릿수더하기 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//입력의 방향을 바꾸자.
		//scanner = new Scanner(str);
		int n = scanner.nextInt();
		int sum=0;
		//입력 값을 확인하자.
		//System.out.println(n);
		
		while(n!=0) {
			sum += n%10;
			n /=10;
		}
		System.out.println(sum);
	}
	
	private static String str= "6789";
}
