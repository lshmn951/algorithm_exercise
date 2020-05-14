package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_2468_안전영역 {
	static int n;
	static int [][] arr;
	static int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int [][] copy;
	static int max = Integer.MIN_VALUE;
	static boolean [][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		n = Integer.parseInt(br.readLine());
		arr = new int [n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<=100;i++) {
			copy = new int [n][n];
			visit = new boolean [n][n];
			int sum=0;
			for(int j=0;j<n;j++) {
				copy[j] = arr[j].clone();
			}
			for(int j=0;j<n;j++) {
				for(int q=0;q<n;q++) {
					copy[j][q] -= i;
					if(copy[j][q]<0) {
						copy[j][q] = 0;
					}
				}
			}
			for(int j=0;j<n;j++) {
				for(int q=0;q<n;q++) {
					if(!visit[j][q] && copy[j][q]!=0) {
						sum++;
						dfs(j,q);
						
					}
				}
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);

	}
	public static void dfs(int x,int y) {
		visit[x][y] = true;
		for(int i=0;i<4;i++) {
			int r = x+dir[i][0];
			int c = y+dir[i][1];
			if(!isin(r,c)) {
				continue;
			}
			if(!visit[r][c] && copy[r][c]!=0) {
				dfs(r,c);
			}
		}
	}
	public static boolean isin(int x,int y) {
		return x>=0 && y>=0 && x<n && y<n;
	}
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
