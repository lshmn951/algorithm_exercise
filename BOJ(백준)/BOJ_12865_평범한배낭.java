package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
	static int N,K;
	static int [][] arr;
	static int [] dp = new int [100001];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][2];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] =  Integer.parseInt(st.nextToken());
			arr[i][1] =  Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=K;j>=1;j--) {
				if(arr[i][0]<=j) {
					dp[j] = Math.max(dp[j], dp[j-arr[i][0]]+arr[i][1]);
				}
			}
		}
		System.out.println(dp[K]);
	}
	
}
