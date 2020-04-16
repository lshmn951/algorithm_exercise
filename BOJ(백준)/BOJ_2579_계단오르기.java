package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2579_계단오르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int [n+1];
		int [] dp = new int [n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 0;
		dp[1] = arr[1];
		dp[2] = arr[1]+arr[2];
		for(int i=3;i<=n;i++) {
			dp[i] = Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i]+arr[i-1]);
		}
		System.out.println(dp[n]);
	}

}
