package algo_exercise.SWEA;

import java.util.Scanner;

public class SWEA_2050_D1_알파벳을숫자로변환 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//scanner = new Scanner(src);
		String str = scanner.next();
		for(int i=0;i<str.length();i++) {
			System.out.printf("%d ",str.charAt(i)-'A'+1);
		}
	}
	private static String src = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
}
