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
 * @since 2020. 2. 13.
 * @see https://www.acmicpc.net/problem/18224
 * @mem
 * @time
 * @caution 4중배열은 좀 심했다...
 */

public class BOJ_18224_미로에갇힌건우 {
	static int n,m;
	static int [][]alfh;
	static boolean [][][][]visit;
	static int [][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		alfh = new int [n][n];
		visit = new boolean [n][n][m+1][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				alfh[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Rjsdn> que = new LinkedList<>();
		visit[0][0][1][0] = true;
		que.add(new Rjsdn(0,0,1,1,false));
		while(!que.isEmpty()) {
			Rjsdn temp = que.poll();
			if(temp.x==n-1 && temp.y==n-1) {
				if(temp.on) {
					System.out.println(temp.day+" moon");
				}
				else {
					System.out.println(temp.day+" sun");
				}
				return;
			}
			
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				int ncnt = (temp.cnt+1)%m;
				int d;
				if(temp.cnt%(2*m)==0) {
					d = 0;
				}
				else if(temp.cnt%m==0) {
					d = 1;
				}
				else {
					if(temp.on) {
						d = 1;
					}
					else {
						d = 0;
					}
				}
				if(!isin(r,c) || visit[r][c][ncnt][d]) {
					continue;
				}
				if(alfh[r][c]==0) {
					visit[r][c][ncnt][d] = true;
					if(temp.cnt%(2*m)==0) {
						que.add(new Rjsdn(r,c,temp.day+1,temp.cnt+1,false));
					}
					else if(temp.cnt%m==0) {
						que.add(new Rjsdn(r,c,temp.day,temp.cnt+1,true));
					}
					else {
						que.add(new Rjsdn(r,c,temp.day,temp.cnt+1,temp.on));
					}
				}
				else if(alfh[r][c]==1) {
					if(!temp.on) {
						continue;
					}
					while(isin(r,c) && alfh[r][c]==1) {
						r+=dirs[i][0];
						c+=dirs[i][1];
					}
					if(isin(r,c) && alfh[r][c]==0 && !visit[r][c][ncnt][d]) {
						visit[r][c][ncnt][d] = true;
						if(temp.cnt%(2*m)==0) {
							que.add(new Rjsdn(r,c,temp.day+1,temp.cnt+1,false));
						}
						else if(temp.cnt%m==0) {
							que.add(new Rjsdn(r,c,temp.day,temp.cnt+1,true));
						}
						else {
							que.add(new Rjsdn(r,c,temp.day,temp.cnt+1,temp.on));
						}
					}
				}
			}
			
		}
		System.out.println(-1);
	}
	public static boolean isin(int r,int c) {
		return r>=0 && c>=0 && r<n && c<n;
	}
	static class Rjsdn{
		int x,y;
		int day;
		int cnt;
		boolean on;
		public Rjsdn(int x, int y, int day, int cnt, boolean on) {
			this.x = x;
			this.y = y;
			this.day = day;
			this.cnt = cnt;
			this.on = on;
		}
		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + ", day=" + day + ", cnt=" + cnt + ", on=" + on + "]";
		}
		
	}
}
