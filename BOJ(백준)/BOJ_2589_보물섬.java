package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {
	static int n,m;
	static int [][] arr;
	static int max=0;
	static boolean [][] copy;
	static int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int [n+2][m+2];
		copy = new boolean [n+2][m+2];
		for(int i=1;i<=n;i++) {
			String str = br.readLine();
			for(int j=1;j<=m;j++) {
				if(str.charAt(j-1)=='L') {
					arr[i][j] = 1;
				}
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(arr[i][j]==1) {
					bfs(i,j);
				}
			}
		}
		System.out.println(max);
	}
	public static void bfs(int x,int y) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(x,y,0));
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(arr[i][j]==1) {
					copy[i][j] = true;
				}
			}
		}
		copy[x][y] = false;
		while(!que.isEmpty()) {
			Point temp = que.poll();
			if(check(temp.x,temp.y)) {
				max = Math.max(max, temp.cnt);
			}
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(!isin(r,c)) {
					continue;
				}
				copy[r][c] = false;
				que.add(new Point(r,c,temp.cnt+1));
			}
		}
	}
	public static boolean check(int x,int y) {
		return !copy[x-1][y] &&!copy[x+1][y]&&!copy[x][y+1]&&!copy[x][y-1];
	}
	public static boolean isin(int x,int y) {
		return copy[x][y];
	}
	static class Point{
		int x,y;
		int cnt;
		public Point(int x, int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
