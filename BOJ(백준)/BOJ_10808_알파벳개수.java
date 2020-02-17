package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_10808_알파벳개수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int [26];
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for(int i=0;i<str.length();i++) {
			a[str.charAt(i)-'a']++;
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
