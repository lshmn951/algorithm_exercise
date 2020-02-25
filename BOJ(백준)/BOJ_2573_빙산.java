package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {
	static int n,m;
	static int [][] arr;
	static int [][] arr2;
	static boolean [][] visit;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int [n][m];
		arr2 = new int [n][m];
		visit = new boolean [n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int i;
		boolean b = true;
		for(i=0;b;i++) {
			int num=0;
			visit = new boolean[n][m];
			arr2 = new int [n][m];
			for(int q=0;q<n;q++) {
				for(int w=0;w<m;w++) {
					if(arr[q][w]!=0 && !visit[q][w]) {
						num++;
						melt(q,w);
					}
				}
			}
			/*
			 * for(int j=0;j<n;j++) { System.out.println(Arrays.toString(arr[j])); }
			 * System.out.println(num);
			 */
			if(num>1) {
				break;
			}
			for(int q=0;q<n;q++) {
				for(int j=0;j<m;j++) {
					arr[q][j] -= arr2[q][j];
					if(arr[q][j]<0) {
						arr[q][j] = 0;
					}
				}
			}
			b = false;
			for(int q=0;q<n;q++) {
				for(int j=0;j<m;j++) {
					if(arr[q][j]!=0) {
						b = true;
					}
				}
			}
		}
		if(!b) {
			System.out.println(0);
		}
		else {
			System.out.println(i);
		}
	}
	public static void melt(int x,int y) {
		Queue<Point > que = new LinkedList<>();
		que.add(new Point(x,y));
		visit[x][y] = true;
		while(!que.isEmpty()) {
			Point temp = que.poll();
			int num =0;
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(!isin(r,c)) {
					num++;
				}
				if(arr[r][c]!=0 && !visit[r][c]) {
					visit[r][c] = true;
					que.add(new Point(r,c));
				}
			}
			arr2[temp.x][temp.y] = num;
		}
	}
	public static boolean isin(int x,int y) {
		return arr[x][y]!=0;
	}
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
