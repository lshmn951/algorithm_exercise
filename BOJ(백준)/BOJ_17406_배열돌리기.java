package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 10.
 * @see https://www.acmicpc.net/problem/17406
 * @mem
 * @time
 * @caution 연산 순서를 순열로 구하고 각 회전연산을 수행하고 최솟값 구한다.
 */

public class BOJ_17406_배열돌리기 {
	static int N,M,K;
	static int [][] arr;
	static Revol [] re;
	static int [][] temp;
	static int min = Integer.MAX_VALUE;
	static int sum;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int [N+1][M+1];
		temp = new int [N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1;j<=M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		re = new Revol[K];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			re[i] = new Revol(r,c,s);
		}
		per(0,new Revol[K],new boolean[K]);
		System.out.println(min);
	}
	
	public static void per(int cnt,Revol[] rev,boolean [] visit) {
		// 연산을 재귀를 통해 순열 방식으로 구하기
		if(cnt==K) {
			for(int i=1;i<=N;i++) {
				temp[i] = arr[i].clone();
			}
			
			for(int i=0;i<K;i++) {
				revolve(temp,rev[i]);
			}
			for(int i=1;i<=N;i++) {
				sum=0;
				for(int j=1;j<=M;j++) {
					sum+=temp[i][j];
				}
				if(min>sum) {
					min = sum;
				}
			}
			return;
		}
		for(int i=0;i<K;i++) {
			if(!visit[i]) {
				visit[i]= true;
				rev[cnt] = new Revol(re[i]);
				per(cnt+1,rev,visit);
				visit[i] = false;
			}
		}
		
	}
	public static void revolve(int[][] temp,Revol revo) {
		//회전 연산
		for(int i=0;i<=revo.s;i++) {
			onerevolve(revo.r, revo.c, i, temp);
		}
	}
	public static void onerevolve(int r,int c,int s,int[][]temp) {
		if(s==0) {
			return;
		}
		else {
			int t = temp[r-s][c-s];
			for(int i=r-s;i<r-s+(2*s);i++) {
				temp[i][c-s] = temp[i+1][c-s];
			}
			for(int i=c-s;i<c-s+(2*s);i++) {
				temp[r+s][i] = temp[r+s][i+1];
			}
			for(int i=r+s;i>r-s;i--) {
				temp[i][c+s] = temp[i-1][c+s];
			}
			for(int i=c+s;i>c-s+1;i--) {
				temp[r-s][i] = temp[r-s][i-1];
			}
			temp[r-s][c-s+1] = t;
		}
	}
	static class Revol{
		int r;
		int c;
		int s;
		public Revol(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
		public Revol(Revol revol) {
			this.r = revol.r;
			this.c = revol.c;
			this.s = revol.s;
		}
		
	}
	
}
