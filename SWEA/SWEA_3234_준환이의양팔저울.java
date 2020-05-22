package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {
	static int n;
	static int [] weight;
	static int [][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			weight = new int [n];
			for(int i=0;i<n;i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			dp = new int [1<<n][1<<n];
			System.out.println("#"+tc+" "+permutation(0, 0, 0, 0, 0));
		}
	}

	public static int permutation(int k,int left,int right,int leftbit,int rightbit) {
		if(k==n) {
			return 1;
		}
		if(dp[leftbit][rightbit]>0) {
			return dp[leftbit][rightbit];
		}
		
		for(int i=0;i<n;i++) {
			if((leftbit&(1<<i))==0 && (rightbit&(1<<i))==0) {
				dp[leftbit][rightbit] += permutation(k+1, left+weight[i], right, leftbit|(1<<i), rightbit);
				if(left>=right+weight[i]) {
					dp[leftbit][rightbit] +=permutation(k+1, left, right+weight[i], leftbit, rightbit|(1<<i));
				}
				
			}
		}
		return dp[leftbit][rightbit];
	}
	
}
