package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {
	static int [][] arr;
	static int [][] visit;
	static int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	static int N;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc=1;;tc++) {
			N = Integer.parseInt(bf.readLine());
			if(N==0) {
				break;
			}
			arr = new int [N][N];
			visit = new int [N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					visit[i][j] = 125*125*9 +1;
				}
			}
			zelda();
			System.out.println("Problem "+tc+": "+visit[N-1][N-1]);
		}
	}
	
	public static void zelda() {
		visit[0][0] = arr[0][0];
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(0,0));
		while(!que.isEmpty()) {
			Point temp = que.poll();
			
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(isin(r,c) && visit[r][c]>visit[temp.x][temp.y]+arr[r][c]) {
					visit[r][c] = visit[temp.x][temp.y]+arr[r][c];
					que.add(new Point(r,c));
				}
			}
		}
		
	}
	
	public static boolean isin(int r,int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
