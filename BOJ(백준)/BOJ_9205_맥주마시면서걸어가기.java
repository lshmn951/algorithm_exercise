package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {
	static boolean [][]arr;
	static boolean [] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			int n = Integer.parseInt(br.readLine());
			arr = new boolean [n+2][n+2];
			visit = new boolean [n+2];
			List<Point> list = new ArrayList<>();
			Queue<Integer >que = new LinkedList<Integer>();
			for(int i=0;i<n+2;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Point(x,y));
			}
			Point a1,a2;
			for(int i=0;i<n+2;i++) {
				for(int j=0;j<n+2;j++) {
					if(i!=j) {
						a1 = list.get(i);
						a2 = list.get(j);
						if(Math.abs(a1.x-a2.x)+Math.abs(a1.y-a2.y)<=1000) {
							arr[i][j] = true;
							arr[j][i] = true;
						}
					}
				}
			}
			
			que.add(0);
			while(!que.isEmpty()) {
				int temp = que.poll();
				if(visit[temp]) {
					continue;
				}
				visit[temp] = true;
				for(int i=0;i<n+2;i++) {
					if(arr[temp][i]) {
						que.add(i);
					}
				}
			}
			if(visit[n+1]) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
		}
		
	}
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
