package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 19.
 * @see https://www.acmicpc.net/problem/1697
 * @mem
 * @time
 * @caution bfs 조건 확인
 */
public class BOJ_1697_숨바꼭질 {
	static int n,m;
	static boolean []visit = new boolean [100001];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(n,0));
		while(!que.isEmpty()) {
			Point temp = que.poll();
			if(temp.x == m) {
				System.out.println(temp.y);
				return;
			}
			if(temp.x-1>=0 && !visit[temp.x-1]) {
				visit[temp.x-1]= true;
				que.add(new Point(temp.x-1,temp.y+1));
			}
			if(temp.x+1<=100000 && !visit[temp.x+1]) {
				visit[temp.x+1]= true;
				que.add(new Point(temp.x+1,temp.y+1));
			}
			if(temp.x*2<=100000 && !visit[temp.x*2]) {
				visit[temp.x*2]= true;
				que.add(new Point(temp.x*2,temp.y+1));
			}
		}
	}
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
