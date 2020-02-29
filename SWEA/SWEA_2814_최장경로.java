package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2814_최장경로 {
	static int n,m;
	static boolean arr[][];
	static boolean visit[];
	static int max = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			max = 1;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new boolean [n+1][n+1];
			visit = new boolean [n+1];
			m = Integer.parseInt(st.nextToken());
			while(m-->0) {
				st = new StringTokenizer(br.readLine());
				int in1 = Integer.parseInt(st.nextToken());
				int in2 = Integer.parseInt(st.nextToken());
				arr[in1][in2] = true;
				arr[in2][in1] = true;
			}
			for(int i=1;i<=n;i++) {
				visit[i] = true;
				dfs(i,1);
				visit[i] = false;
			}
			System.out.println("#"+tc+" "+max);
		}
	}
	public static void dfs(int v, int d) {
		max = Math.max(max, d);
		for(int i=1;i<=n;i++) {
			if(arr[v][i] && !visit[i]) {
				visit[i] = true;
				dfs(i,d+1);
				visit[i] = false;
			}
		}
	}

}
