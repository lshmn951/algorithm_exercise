package algo_exercise.BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2194_유닛이동시키기 {
	static int n,m,a,b,k;
	static boolean [][]arr;
	static Point start;
	static Point end;
	static int des = -1;
	static boolean [][] visit;
	static int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		k = sc.nextInt();
		arr = new boolean[n][m];
		visit = new boolean[n][m];
		for(int i=0;i<k;i++) {
			arr[sc.nextInt()-1][sc.nextInt()-1] = true;
		}
		start = new Point(sc.nextInt()-1,sc.nextInt()-1,0);
		visit[start.x][start.y]= true;
		end = new Point(sc.nextInt()-1,sc.nextInt()-1,0);
		bfs(start);
		System.out.println(des);
	}
	public static void bfs(Point st) {
		Queue<Point > que = new LinkedList<>();
		que.add(st);
		boolean [] bq;
		while(!que.isEmpty()) {
			Point temp = que.poll();
			if(temp.x==end.x && temp.y==end.y) {
				des = temp.cnt;
				break;
			}
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(ischeck(r,c) && !visit[r][c]) {
					visit[r][c] = true;
					que.add(new Point(r,c,temp.cnt+1));
				}
			}
		}
	}
	public static boolean ischeck(int x,int y) {
		if(x<0||x+a-1>=n || y<0 || y+b-1>=m) {
			return false;
		}
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				if(arr[x+i][y+j]) {
					return false;
				}
			}
		}
		return true;
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
