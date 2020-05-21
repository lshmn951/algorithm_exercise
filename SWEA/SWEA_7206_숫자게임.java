package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7206_숫자게임 {
	static int [] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String str = br.readLine();
			

			dp = new int [100000];
			System.out.println("#"+tc+" "+dfs(str));
		}

	}
	public static int dfs(String str) {
		int num = Integer.parseInt(str);
		if(str.length()==1) {
			return 0;
		}
		if(dp[num]!=0) {
			return dp[num];
		}
		int len = str.length()-1;
		for(int bit=1;bit<(1<<len);bit++) {
			String temp = "";
			int mul = 1;
			
			for(int i=0;i<len;i++) {
				if(((1<<i)&bit)>0) {
					temp+=str.charAt(i);
					mul *= Integer.parseInt(temp);
					temp = "";
				}else {
					temp+=str.charAt(i);
				}
			}
			temp+=str.charAt(len);
			temp = Integer.toString(mul*Integer.parseInt(temp));
			dp[num] = Math.max(dfs(temp)+1, dp[num]);
		}
		return dp[num];
	}
	
}
