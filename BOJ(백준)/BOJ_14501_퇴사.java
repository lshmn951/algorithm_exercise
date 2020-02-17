package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_14501_퇴사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr1 = new int [n];
		int [] arr2 = new int [n];
		int [] dp = new int [n];
		for(int i=0;i<n;i++) {
			arr1[i] = sc.nextInt();
			arr2[i] = sc.nextInt();
		}
		for(int i=n-1;i>=0;i--) {
			if(i+arr1[i]<=n) {
				int max=0;
				for(int j=i+arr1[i];j<n;j++) {
					if(dp[j]>max) {
						max = dp[j];
					}
				}
				dp[i] = arr2[i]+max;
			}
			else {
				dp[i]=0;
			}
		}
		int max =0;
		for(int i=0;i<n;i++) {
			if(dp[i]>max) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}

}
