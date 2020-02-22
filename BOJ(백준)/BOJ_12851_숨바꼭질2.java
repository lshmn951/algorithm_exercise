package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질2 {
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
		int count = 0;
		int num=0;
		boolean b = false;
		while(!que.isEmpty()) {
			Point temp = que.poll();
			if(b && temp.y>count) {
				continue;
			}
			if(temp.x == m) {
				count = temp.y;
				num++;
				b = true;
			}
			visit[temp.x] = true;
			if(temp.x-1>=0 && !visit[temp.x-1]) {
				que.add(new Point(temp.x-1,temp.y+1));
			}
			if(temp.x+1<=100000 && !visit[temp.x+1]) {
				que.add(new Point(temp.x+1,temp.y+1));
			}
			if(temp.x*2<=100000 && !visit[temp.x*2]) {
				que.add(new Point(temp.x*2,temp.y+1));
			}
		}
		System.out.println(count);
		System.out.println(num);
	}
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
