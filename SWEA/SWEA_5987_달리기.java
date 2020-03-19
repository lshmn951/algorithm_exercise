package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5987_달리기 {
	static int n,m;
	static List<Integer> []lists; 
	static long [] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			lists = new List[n];
			dp = new long[1<<n];
			Arrays.fill(dp, -1);
			for(int i=0;i<n;i++) {
				lists[i] = new ArrayList<Integer>();
			}
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				lists[y].add(x);
			}
			System.out.print("#"+tc+" ");
			System.out.println(run(0));
		}
	}
	public static long run(int list) {
		if(list == (1<<n)-1) {
			return 1;
		}
		if(dp[list]!=-1) {
			return dp[list];
		}
		dp[list] = 0;
		out:for(int i=0;i<n;i++) {
			if((list & (1<<i)) == 0 ) {
				for(int j=0;j<lists[i].size();j++) {
					if((list & 1<<lists[i].get(j)) ==0) {
						continue out;
					}
				}
				dp[list] += run((list | 1<<i));
			}
		}
		
		return dp[list];
	}
}
