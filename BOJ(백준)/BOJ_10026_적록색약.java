package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10026_적록색약 {
	static int n;
	static char [][] arr;
	static char [][] arr2;
	static int num1=0;
	static int num2=0;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		arr2 = new char[n][n];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<n;j++) {
				if(str.charAt(j)=='R') {
					arr[i][j] = 'R';
					arr2[i][j] = 'R';
				}
				if(str.charAt(j)=='G') {
					arr[i][j] = 'G';
					arr2[i][j] = 'R';
				}
				if(str.charAt(j)=='B') {
					arr[i][j] = 'B';
					arr2[i][j] = 'B';
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]!='A') {
					num1++;
					bfs(i,j,arr[i][j]);
				}
				if(arr2[i][j]!='A') {
					num2++;
					bfs2(i,j,arr2[i][j]);
				}
			}
		}
		System.out.println(num1+" "+num2);
	}
	public static void bfs(int x,int y,char t) {
		Queue<Point >que = new LinkedList<>();
		que.add(new Point(x,y));
		arr[x][y] = 'A';
		while(!que.isEmpty()) {
			Point temp = que.poll();
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(!isin(r,c)) {
					continue;
				}
				if(arr[r][c]==t) {
					arr[r][c] = 'A';
					que.add(new Point(r,c));
				}
			}
		}
		
	}
	public static void bfs2(int x,int y,char t) {
		Queue<Point >que = new LinkedList<>();
		que.add(new Point(x,y));
		arr2[x][y] = 'A';
		while(!que.isEmpty()) {
			Point temp = que.poll();
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(!isin(r,c)) {
					continue;
				}
				if(arr2[r][c]==t) {
					arr2[r][c] = 'A';
					que.add(new Point(r,c));
				}
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
