package algo_exercise.BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576_토마토 {
	static int [][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
	static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Point> que = new LinkedList<>();
		n = sc.nextInt();
		m = sc.nextInt();
		int result=0;
		boolean b = true;
		int [][] arr = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==1) {
					que.add(new Point(i,j,0));
				}
			}
		}
		while(!que.isEmpty()) {
			Point temp = que.poll();
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(isin(r,c) && arr[r][c]==0) {
					arr[r][c] = 1;
					que.add(new Point(r,c,temp.cnt+1));
				}
			}
			if(que.isEmpty()) {
				result = temp.cnt;
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==0) {
					b = false;
				}
			}
		}
		if(b) {
			System.out.println(result);
		}
		else {
			System.out.println(-1);
		}
	}
	public static boolean isin(int x,int y) {
		return x>=0 && y>=0 && x<m && y<n;
	}
	static class Point{
		int x,y;
		int cnt;
		public Point(int x, int y,int cnt) {
			this.cnt = cnt;
			this.x = x;
			this.y = y;
		}
		
	}
}
