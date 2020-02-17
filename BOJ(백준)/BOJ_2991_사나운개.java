package algo_exercise.BOJ;

import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 7.
 * @see https://www.acmicpc.net/problem/2991
 * @mem
 * @time
 * @caution 개가 물 수 있는 시간을 저장한 배열을 만들고 각 사람들이 그 시간에 물리는지 안물리는지 판단
 */


public class BOJ_2991_사나운개 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int p = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int [] dog1 = new int [1000];
		int [] dog2 = new int [1000];
		for(int i=1;i<1000;i+=(a+b)) {
			for(int j=i;j<i+a && j<1000;j++) {
				dog1[j]= 1;
			}
		}
		for(int i=1;i<1000;i+=(c+d)) {
			for(int j=i;j<i+c && j<1000;j++) {
				dog2[j]= 1;
			}
		}
		System.out.println(dog1[p]+dog2[p]);
		System.out.println(dog1[m]+dog2[m]);
		System.out.println(dog1[n]+dog2[n]);
	}
}
