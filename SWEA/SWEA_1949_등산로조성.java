package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1949_등산로조성 {
	static int n,k;
	static int [][] map;
	static boolean [][] visit;
	static int maxlen;
	static int [][] dirs= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int [n][n];
			visit = new boolean [n][n];
			maxlen = Integer.MIN_VALUE;
			int maxh=0;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxh = Math.max(maxh, map[i][j]);
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==maxh&&!visit[i][j]) {
						visit[i][j]=true;
						dfs(i,j,1,false);
						visit[i][j] = false;
					}
				}
			}
			System.out.println("#"+tc+" "+maxlen);
		}
	}
	public static void dfs(int x,int y, int cnt,boolean cut) {
		maxlen = Math.max(maxlen, cnt);
		for(int d=0;d<4;d++) {
			int r = x+dirs[d][0];
			int c = y+dirs[d][1];
			if(r<0||c<0||r>=n||c>=n) {
				continue;
			}
			if(visit[r][c]) {
				continue;
			}
			if(map[x][y]<=map[r][c] && !cut) {
				
					for(int i=1;i<=k;i++) {
						int temp = map[r][c];
						int low = map[r][c] - i;
						if(map[x][y]>low) {
							visit[r][c] = true;
							map[r][c] = low;
							dfs(r,c,cnt+1,true);
							visit[r][c] = false;
							map[r][c] = temp;
						}
					}
				
			}
			else if(map[x][y]>map[r][c]) {
				visit[r][c] = true;
				dfs(r,c,cnt+1,cut);
				visit[r][c] = false;
			}
		}
	}
}
