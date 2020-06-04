package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_불 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char [][] map = new char[M+2][N+2];
			int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
			Queue<Point> sg = new LinkedList<>();
			Queue<Point> fire = new LinkedList<>();
			int ans=0;
			for(int i=0;i<M+2;i++) {
				map[i][0] = '.';
				map[i][N+1] = '.';
			}
			for(int i=0;i<N+2;i++) {
				map[0][i] = '.';
				map[M+1][i] = '.';
			}
			for(int i=1;i<=M;i++) {
				String str = br.readLine();
				for(int j=1;j<=N;j++) {
					map[i][j] = str.charAt(j-1);
					if(map[i][j]=='@') {
						sg.add(new Point(i,j,0));
					}
					if(map[i][j]=='*') {
						fire.add(new Point(i,j,0));
					}
				}
			}
			out:while(!sg.isEmpty()) {
				int fsize = fire.size();
				while(fsize-->0) {
					Point fp = fire.poll();
					for(int i=0;i<4;i++) {
						int r = fp.x+dirs[i][0];
						int c = fp.y+dirs[i][1];
						if(r<1||c<1||r>M||c>N) {
							continue;
						}
						if(map[r][c]=='.'||map[r][c]=='@') {
							map[r][c]='*';
							fire.add(new Point(r,c,0));
						}
					}
				}
				int ssize = sg.size();
				while(ssize-->0) {
					Point sp = sg.poll();
					if(sp.x<1||sp.y<1||sp.x>M||sp.y>N) {
						ans = sp.cnt;
						break out;
					}
					for(int i=0;i<4;i++) {
						int r = sp.x+dirs[i][0];
						int c = sp.y+dirs[i][1];
						if(map[r][c]=='.') {
							map[r][c]='@';
							sg.add(new Point(r,c,sp.cnt+1));
						}
					}
				}
			}
			if(ans==0) {
				System.out.println("IMPOSSIBLE");
			}else {
				System.out.println(ans);
			}
		}
	}
	public static class Point{
		int x,y;
		int cnt;
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
