package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 11.
 * @see https://www.acmicpc.net/problem/15686
 * @mem
 * @time
 * @caution arr배열에서 치킨집과 집과 거리를 잘 판단해서 큐에 넣어야 제대로 모든 케이스를 통과한다.
 */

public class BOJ_15686_치킨배달 {
	static int N,M;
	static int [][] arr;
	static int [][] copy;
	static int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	static List<Point> chi = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	static int sum1=0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][N];
		copy = new int [N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					arr[i][j]=0;
					chi.add(new Point(i,j,0));
				}
				else if(arr[i][j]==1) {
					sum1++;
				}
			}
		}
		per(0,new Point[M],0);
		System.out.println(min);
	}
	public static void per(int k,Point[] temp,int before) {
		if(k==M) {
			int cur = del(temp);
			min = Math.min(min, cur);
		}
		else {
			for(int i=before;i<chi.size();i++) {
				temp[k] = chi.get(i);
				per(k+1,temp,i+1);
			}
		}
	}
	public static int del(Point [] temp) {
		int sum_1 = 0;
		int sum2 = 0;
		Queue<Point> que = new LinkedList<>();
		boolean [][] vis = new boolean[N][N];
		for(int i=0;i<N;i++) {
			copy[i] = arr[i].clone();
		}
		for(int i=0;i<temp.length;i++) {
			que.add(temp[i]);
		}
		
		while(!que.isEmpty()) {
			Point t = que.poll();
			if(sum_1==sum1) {
				while(que.isEmpty()) {
					que.poll();
				}
				break;
			}
			if(vis[t.x][t.y]) {
				continue;
			}
			vis[t.x][t.y]= true;
			for(int i=0;i<dirs.length;i++) {
				int r = t.x + dirs[i][0];
				int c = t.y + dirs[i][1];
				if(isin(r,c)&& copy[r][c]==0 &&!vis[r][c]) {
					que.add(new Point(r,c,t.cnt+1));
				}
				if(isin(r,c)&& copy[r][c]==1) {
					sum_1++;
					sum2 += t.cnt+1;
					copy[r][c] = 0;
					que.add(new Point(r,c,t.cnt+1));
				}
			}
		}
		
		return sum2;
	}
	public static boolean isin(int r,int c) {
		return r>=0 && c >=0 && r<N && c<N;
	}

	static class Point{
		int x,y;
		int cnt;
		public Point(int x, int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
		
	}
}
