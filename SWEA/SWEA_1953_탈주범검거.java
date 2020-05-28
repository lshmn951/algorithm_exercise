package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {
	static int N,M;
	static int [][] map;
	static boolean [][] visit;
	static int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=  Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int [N][M];
			visit = new boolean [N][M];
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<Loc> que = new LinkedList<>();
			que.add(new Loc(r,c,0));
			visit[r][c]=true;
			while(!que.isEmpty()) {
				Loc t = que.poll();
				if(t.cnt==l-1) {
					continue;
				}
				int [] shape =new int [4];
				if(map[t.x][t.y]==1) {shape[0]=shape[1]=shape[2]=shape[3]=1;}
				else if(map[t.x][t.y]==2) {shape[0]=shape[1]=1;}
				else if(map[t.x][t.y]==3) {shape[2]=shape[3]=1;}
				else if(map[t.x][t.y]==4) {shape[0]=shape[3]=1;}
				else if(map[t.x][t.y]==5) {shape[1]=shape[3]=1;}
				else if(map[t.x][t.y]==6) {shape[1]=shape[2]=1;}
				else if(map[t.x][t.y]==7) {shape[0]=shape[2]=1;}
				for(int i=0;i<4;i++) {
					if(shape[i]==1) {
						int x = t.x+dirs[i][0];
						int y = t.y+dirs[i][1];
						if(x<0||y<0||x>=N||y>=M) {
							continue;
						}
						if(visit[x][y]) {
							continue;
						}
						if(i==0&&(map[x][y]==3||map[x][y]==4||map[x][y]==7)) {continue;}
						else if(i==1&&(map[x][y]==3||map[x][y]==5||map[x][y]==6)) {continue;}
						else if(i==2&&(map[x][y]==2||map[x][y]==6||map[x][y]==7)) {continue;}
						else if(i==3&&(map[x][y]==2||map[x][y]==4||map[x][y]==5)) {continue;}
						else if(map[x][y]==0) {continue;}
						que.add(new Loc(x,y,t.cnt+1));
						visit[x][y]=true;
						
					}
				}
			}
			int ans = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visit[i][j]) {
						ans++;
					}
				}				
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	
	public static class Loc{
		int x,y;
		int cnt;
		public Loc(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
}
