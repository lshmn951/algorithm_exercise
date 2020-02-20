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
 * @since 2020. 2. 19.
 * @see https://www.acmicpc.net/problem/2644
 * @mem
 * @time
 * @caution bfs 그래프
 */
public class BOJ_2644_촌수계산 {
	static int [][ ]arr;
	static int n;
	static boolean [] visit;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n  = Integer.parseInt(bf.readLine());
		arr = new int [n+1][n+1];
		visit = new boolean [n+1];
		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end= Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(bf.readLine());
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(start,0));
		while(!que.isEmpty()) {

			Point temp = que.poll();
			
			if(visit[temp.x]) {
				continue;
			}
			
			if(temp.x==end) {
				System.out.println(temp.y);
				return;
			}
			
			visit[temp.x]= true;
			
			for(int i=1;i<=n;i++) {
				if(arr[temp.x][i]==1) {
					que.add(new Point(i,temp.y+1));
				}
			}
		}
		System.out.println(-1);
	}
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
