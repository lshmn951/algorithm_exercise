package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 
 * @author 이성현
 * @since 2020. 2. 18.
 * @see https://www.acmicpc.net/problem/2206
 * @mem
 * @time
 * @caution [][][]visit
 */
public class BOJ_2206_벽부수고이동하기 {
	static int N,M;
	static int [][] arr;
	static boolean [][][]visit;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		visit = new boolean[N][M][2];
		for(int i=0;i<N;i++) {
			String str = bf.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		bfs();
	}
	public static void bfs() {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(0,0,1,0));
		boolean b = false;
		int count= 0;
		while(!que.isEmpty()) {
			Point temp = que.poll();
			if(temp.x==N-1 && temp.y==M-1) {
				count = temp.cnt;
				b = true;
				que.clear();
				break;
			}
			
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(!isin(r,c)) {
					continue;
				}
				if(arr[r][c]==0 && !visit[r][c][temp.b] && temp.b<=1) {
					visit[r][c][temp.b] = true;
					que.add(new Point(r,c,temp.cnt+1,temp.b));
				}
				else if(arr[r][c]==1 && !visit[r][c][temp.b] && temp.b<1) {
					visit[r][c][temp.b]  = true;
					que.add(new Point(r,c,temp.cnt+1,temp.b+1));
				}
			}
			
		}
		
		if(b) {
			System.out.println(count);
		}
		else {
			System.out.println(-1);
		}
	}
	public static boolean isin(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
	static class Point {
		int x, y;
		int cnt;
		int b;
		public Point(int x, int y,int cnt,int b) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.b = b;
		}
		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + ", cnt=" + cnt + ", b=" + b + "]";
		}
		
	}
}
