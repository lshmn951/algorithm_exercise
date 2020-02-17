package algo_exercise.BOJ;

import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 7.
 * @see https://www.acmicpc.net/problem/1120
 * @mem
 * @time
 * @caution 당연한 방법으로 돌리면 그냥 됨
 */

public class BOJ_1120_문자열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int min = Integer.MAX_VALUE;
		for(int i=0;i<=str2.length()-str1.length();i++) {
			int sum=0;
			for(int j=0;j<str1.length();j++) {
				if(str1.charAt(j)!=str2.charAt(i+j)) {
					sum++;
				}
			}
			if(sum<min) {
				min = sum;
			}
		}
		System.out.println(min);
	}

}
