package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583_영역구하기 {
	static int m,n,k;
	static boolean [][] arr;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer > list = new ArrayList<Integer>();
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new boolean [m][n];
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			for(int j=x1;j<x2;j++) {
				for(int q=y1;q<y2;q++) {
					arr[j][q] = true;
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(!arr[i][j]) {
					list.add(bfs(i,j));
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	public static int bfs(int x,int y) {
		Queue<Point> que = new LinkedList<>();
		int num=0;
		arr[x][y] = true;
		que.add(new Point(x,y));
		while(!que.isEmpty()) {
			Point temp = que.poll();
			num++;
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(!isin(r,c)) {
					continue;
				}
				if(!arr[r][c]) {
					arr[r][c] = true;
					que.add(new Point(r,c));
				}
			}
		}
		return num;
	}
	public static boolean isin(int x, int y) {
		return x >= 0 && y >= 0 && x < m && y < n;
	}
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
