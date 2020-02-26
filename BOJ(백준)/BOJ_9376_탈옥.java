package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_9376_탈옥 {
	static int h,w;
	static char [][] map;
	static Point [] start = new Point[3];
	static int min = Integer.MAX_VALUE;
	static int [][][] number;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int tc=0;tc<t;tc++) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2];
			number = new int[h+2][w+2][3];
			start[0] = new Point(0,0);
			int idx = 1;
			for(int i=1;i<=h;i++) {
				String str = br.readLine();
				for(int j=1;j<=w;j++) {
					map[i][j] = str.charAt(j-1);
					if(map[i][j]=='$') {
						map[i][j] = '.';
						start[idx++] = new Point(i,j);
					}
				}
			}
			for(int i=0;i<=h+1;i++) {
				map[i][0] = '.';
				map[i][w+1] = '.';
			}
			for(int i=0;i<=w+1;i++) {
				map[0][i] = '.';
				map[h+1][i] = '.';
			}
			bfs();
			System.out.println(min);
		}
	}
	public static void bfs() {
		for(int t=0;t<3;t++) {
			boolean [][] visit = new boolean[h+2][w+2];
			Point temp = start[t];
			visit[temp.x][temp.y]=true;
			Deque<Point> dq = new ArrayDeque<>();
			dq.add(new Point(temp.x,temp.y));
			while(!dq.isEmpty()) {
				Point tmp = dq.pop();
				for(int i=0;i<4;i++) {
					int r = tmp.x+dirs[i][0];
					int c = tmp.y+dirs[i][1];
					if(!isin(r,c)) {
						continue;
					}
					if(map[r][c]=='*') {
						continue;
					}
					if(map[r][c]=='.' && !visit[r][c]) {
						visit[r][c] = true;
						number[r][c][t] = number[tmp.x][tmp.y][t];
						dq.push(new Point(r,c));
					}
					if(map[r][c]=='#' && !visit[r][c]) {
						visit[r][c] = true;
						number[r][c][t] = number[tmp.x][tmp.y][t]+1;
						dq.add(new Point(r,c));
					}
				}
			}
		}
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=w;j++) {
				if(map[i][j]!='*') {
					int res = 0;
					for(int k=0;k<3;k++) {
						res += number[i][j][k];
					}
					if(map[i][j]=='#') {
						res-=2;
					}
					min = Math.min(min, res);
				}
			}
		}
	}
	public static boolean isin(int x, int y) {
		return (x >=0 && y >=0 && x <= h+1 && y <= w+1);
	}
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}
}
