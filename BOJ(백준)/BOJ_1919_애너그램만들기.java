package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_1919_애너그램만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[26];
		int arr2[] = new int[26];
		String str1 = sc.next();
		String str2 = sc.next();
		int sum = 0;
		for(int i=0;i<str1.length();i++) {
			arr[str1.charAt(i)-'a']++;
		}
		for(int i=0;i<str2.length();i++) {
			arr2[str2.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++) {
			sum+=Math.abs(arr[i]-arr2[i]);
		}
		System.out.println(sum);
	}

}
