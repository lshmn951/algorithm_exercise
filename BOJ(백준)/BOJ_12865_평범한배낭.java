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
	static int [] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		dp = new int [N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] =  Integer.parseInt(st.nextToken());
			arr[i][1] =  Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			if(arr[i][0]>K) {
				dp[i] = 0;
			}
			else {
				for(int j=0;j<N;j++) {
					if(i!=j) {
						
					}
				}
			}
		}
		int max = 0;
		for(int i=0;i<N;i++) {
			if(dp[i]>max) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
	
}
