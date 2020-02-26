package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16985_Maaaaaaaaaze {
	static boolean [][][] maze = new boolean [5][5][5];
	static boolean [][] copy;
	static boolean [][][] copymaze = new boolean [5][5][5];
	static int min = Integer.MAX_VALUE;
	static int[][] dirs = { { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 }, {0,0,1}, {0,0,-1} };
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				st = new StringTokenizer(br.readLine());
				for(int q=0;q<5;q++) {
					int in1 = Integer.parseInt(st.nextToken());
					if(in1==1) {
						maze[i][j][q] = true;
					}
				}
			}
		}
		per(0,new boolean [5],new int[5]);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}
	public static void per(int k,boolean [] visit,int [] temp) {
		if(k==5) {
			bfs(temp);
		}
		for(int i=0;i<5;i++) {
			if(!visit[i]) {
				visit[i] = true;
				temp[k] = i;
				for(int j=0;j<4;j++) {
					revolve(i);
					per(k+1,visit,temp);
				}
				visit[i] = false;
			}
		}
	}
	public static void bfs(int [] temp) {
		for(int q=0;q<5;q++) {
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					copymaze[q][i][j] = maze[temp[q]][i][j];
				}
			}
		}
		Queue<Point> que = new LinkedList<>();
		if(copymaze[0][0][0]) {
			que.add(new Point(0,0,0,0));
			copymaze[0][0][0]=false;
			while(!que.isEmpty()) {
				Point tmp = que.poll();
				if(tmp.x==4 && tmp.y==4 &&tmp.z==4) {
					min = Math.min(min, tmp.cnt);
					while(!que.isEmpty()) {
						que.poll();
					}
					return;
				}
				
				for(int i=0;i<6;i++) {
					int r = tmp.x+dirs[i][0];
					int c = tmp.y+dirs[i][1];
					int h = tmp.z+dirs[i][2];
					if(!isin(r,c,h)) {
						continue;
					}
					if(copymaze[r][c][h]) {
						copymaze[r][c][h] = false;
						que.add(new Point(r,c,h,tmp.cnt+1));
					}
				}
			}
		}
	}
	public static void revolve(int idx) {
		copy = new boolean [5][5];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				copy[4-j][i] = maze[idx][i][j]; 
			}
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				maze[idx][i][j] = copy[i][j]; 
			}
		}
	}
	public static boolean isin(int x,int y,int z) {
		return x>=0 && x<5 && y>=0 && y<5 && z>=0 && z<5;
	}
	static class Point{
		int x,y,z;
		int cnt;
		public Point(int x, int y, int z,int cnt) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.cnt = cnt;
		}

	}
}
