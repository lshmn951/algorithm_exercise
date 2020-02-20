package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 19.
 * @see https://www.acmicpc.net/problem/16234
 * @mem
 * @time
 * @caution	bfs와 list를 이용
 */
public class BOJ_16234_인구이동 {
	static int N,L,R;
	static boolean b;
	static int [][] arr;
	static boolean [][] visit;
	static List<Point> list;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0;
		while(true) {
			b=false;
			visit = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visit[i][j]) {
						bfs(i,j);
					}
				}
			}
			if(!b) {
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	public static void bfs(int x,int y) {
		int sum=0;
		Queue<Point> que = new LinkedList<>();
		list = new ArrayList<>();
		que.add(new Point(x,y));
		while(!que.isEmpty()) {
			Point temp = que.poll();
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(!isin(r,c)) {
					continue;
				}
				if(!visit[r][c] && Math.abs(arr[r][c]-arr[temp.x][temp.y])>=L &&
						Math.abs(arr[r][c]-arr[temp.x][temp.y])<=R) {
					visit[r][c] = true;
					list.add(new Point(r,c));
					sum+=arr[r][c];
					que.add(new Point(r,c));
				}
			}
		}
		if(list.size()>0) {
			b= true;
			int avg = sum/list.size();
			for(int i=0;i<list.size();i++) {
				arr[list.get(i).x][list.get(i).y] = avg;
			}
		}
	}
	public static boolean isin(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}

	}
}
