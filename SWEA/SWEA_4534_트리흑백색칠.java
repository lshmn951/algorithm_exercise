package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_4534_트리흑백색칠 {
	static int n;
	static long res;
	final static int mod = 1000000007;
	static List<Integer> []list; 
	static long dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			n =  Integer.parseInt(br.readLine());
			list = new List[n+1];
			dp = new long[n+1][2];
			for(int i=1;i<=n;i++) {
				list[i] = new ArrayList<Integer>();
			}
			for(int i=0;i<n-1;i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				list[v1].add(v2);
				list[v2].add(v1);
			}
			res = (dfs(-1,1,0)%mod+dfs(-1,1,1)%mod)%mod;
			System.out.println("#"+tc+" "+res);
		}
	}
	public static long dfs(int pre,int cur,int color) {
		if(list[cur].size()==1) {
			if(list[cur].get(0)==pre) {
				return 1;
			}
		}
		
		if(dp[cur][color]!=0) {
			return dp[cur][color]%mod;
		}
		long temp = 1;
		if(color==0) {
			for(int i=0;i<list[cur].size();i++) {
				int des = list[cur].get(i);
				if(des!=pre) {
					temp *= (dfs(cur,des,1)%mod);
					temp %= mod;
				}
			}
		}
		if(color==1) {
			for(int i=0;i<list[cur].size();i++) {
				int des = list[cur].get(i);
				if(des!=pre) {
					temp *= ((dfs(cur,des,1)%mod)+(dfs(cur,des,0)%mod))%mod;
					temp %= mod;
				}
			}
		}
		dp[cur][color] = temp;
		return dp[cur][color];
	}

}
