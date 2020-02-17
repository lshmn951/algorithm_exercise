package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 11.
 * @see https://www.acmicpc.net/problem/17135
 * @mem
 * @time
 * @caution 궁수가 같은 적을 공격할 수 있으므로 바로바로 적을 지우는게 아니라 저장만 해놓고 나중에 한번에 지운다
 * 			거리를 구하는 방식을 잘보자...거리땜에 엄청 고민했다...
 */

public class BOJ_17135_캐슬디펜스 {
	static int N,M,D;
	static int [][]arr;
	static int max = 0;
	static int [][] copy; 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		copy = new int [N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		per(0,0,new boolean[M],new int[3]);
		System.out.println(max);
	}
	
	public static void per(int k, int before,boolean [] visit,int []temp) {
		if(k==3) {
			max = Math.max(max, defence(temp));
		}
		else {
			for(int i=before;i<M;i++) {
				if(!visit[i]) {
					visit[i] = true;
					temp[k] = i;
					per(k+1,i+1,visit,temp);
					visit[i] = false;
				}
			}
		}
	}
	
	public static int defence(int [] temp) {
		int sum = 0;
		for(int i=0;i<N;i++) {
			copy[i] = arr[i].clone();
		}
		
		for(int i=0;i<N;i++) {
			sum += attack(temp);
			for(int j=N-1;j>i;j--) {
				copy[j] = copy[j-1].clone();
			}
			Arrays.fill(copy[i], 0);
		}
		
		return sum;
	}
	public static int attack(int [] temp) {
		int sum=0;
		Point [] parr = new Point[3];
		
		for(int a=0;a<3;a++) {
			parr[a] = new Point(0,0,false);
			outer:for(int d=0;d<D;d++) {
				int r = N-1;
				int c = temp[a]-d;
				for(;c<=temp[a];c++,r--) {
					if(isin(r,c) && copy[r][c]==1) {
						parr[a].x = r;
						parr[a].y = c;
						parr[a].c = true;
						break outer;
					}
				}
				r += 2;
				for(;c<=temp[a]+d;c++,r++) {
					if(isin(r,c) && copy[r][c]==1) {
						parr[a].x = r;
						parr[a].y = c;
						parr[a].c = true;
						break outer;
					}
				}
			}
		}
		
		for(int i=0;i<3;i++) {
			if(parr[i].c) {
				if(copy[parr[i].x][parr[i].y]==1) {
					sum++;
				}
				copy[parr[i].x][parr[i].y]=0;
			}
		}
		return sum;
	}
	public static boolean isin(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
	static class Point{
		int x,y;
		boolean c;
		public Point(int x, int y,boolean c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
