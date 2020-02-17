package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {
	static int n,k,l;
	static int [][] arr;
	static int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Point> move = new ArrayList<>();
		List<Point> snake = new ArrayList<>();
		n = Integer.parseInt(bf.readLine());
		arr = new int [n+1][n+1];
		k = Integer.parseInt(bf.readLine());
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(bf.readLine());
			int in1 = Integer.parseInt(st.nextToken());
			int in2 = Integer.parseInt(st.nextToken());
			arr[in1][in2] = 2;
		}
		l = Integer.parseInt(bf.readLine());
		for(int i=0;i<l;i++) {
			st = new StringTokenizer(bf.readLine());
			int in1 = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			if(str.charAt(0)=='D') {
				move.add(new Point(in1,1));
			}
			else {
				move.add(new Point(in1,-1));
			}
		}
		int cnt = 0;
		int idx=0;
		int r = 1;
		int c = 1;
		snake.add(new Point(1,1));
		arr[1][1] = 1;
		while(true) {
			r += dirs[idx][0];
			c += dirs[idx][1];
			cnt++;
			if(!isin(r,c) || arr[r][c]==1) {
				break;
			}
			if(!move.isEmpty() && cnt==move.get(0).x) {
				idx += move.get(0).y;
				if(idx==4) {
					idx = 0;
				}
				if(idx == -1) {
					idx = 3;
				}
				move.remove(0);
			}
			
			if(arr[r][c]==2) {
				snake.add(new Point(r,c));
				arr[r][c] =1;
			}
			if(arr[r][c]==0) {
				snake.add(new Point(r,c));
				arr[r][c] = 1;
				arr[snake.get(0).x][snake.get(0).y] = 0;
				snake.remove(0);
			}
		}
		System.out.println(cnt);
	}
	public static boolean isin(int x,int y) {
		return x>0 && y>0 && x<=n && y<=n;
	}
	static class Point{
		int x,y;

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
