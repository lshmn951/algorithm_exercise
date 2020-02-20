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
 * @since 2020. 2. 20.
 * @see https://www.acmicpc.net/problem/14503
 * @mem
 * @time
 * @caution 시뮬레이션 0,0부터 시작하는 좌표
 */
public class BOJ_14503_로봇청소기 {
	static int [][] arr;
	static int N,M;
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Cleaner va;
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int x =Integer.parseInt(st.nextToken());
		int y =Integer.parseInt(st.nextToken());
		int d =Integer.parseInt(st.nextToken());
		va = new Cleaner(x,y,d);
		arr = new int [N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(clean()) {
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==2) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	public static boolean clean() {
		if(arr[va.x][va.y]==0) {
			arr[va.x][va.y] =2;
		}
		int d = va.dir-1;
		for(int i=0;i<4;i++,d--) {
			if(d==-1) {
				d = 3;
			}
			int r = va.x+dirs[d][0];
			int c = va.y+dirs[d][1];
			if(!isin(r,c) || arr[r][c]!=0) {
				continue;
			}
			if(arr[r][c]==0) {
				va.x =r;
				va.y =c;
				va.dir =d;
				return true;
			}
		}

		int r = va.x-dirs[va.dir][0];
		int c = va.y-dirs[va.dir][1];
		if(isin(r,c) && arr[r][c]!=1) {
			va.x = r;
			va.y = c;
			return true;
		}
		return false;
	}
	public static boolean isin(int x, int y) {
		return x > 0 && y > 0 && x <= N && y <= M;
	}
	static class Cleaner{
		int x,y;
		int dir;
		public Cleaner(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
}
