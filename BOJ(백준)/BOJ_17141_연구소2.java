package boj;

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
 * @since 2020. 2. 23.
 * @see https://www.acmicpc.net/problem/17141
 * @mem
 * @time
 * @caution 조합과 bfs 
 * 			3와 다르게 활성화된  바이러스만 카운트에서 제외하면 된다.
 */
public class BOJ_17141_연구소2 {
	static int N;
	static int K;
	static int [][] arr;
	static int [][] copy;
	static List<Virus> vlist;
	static int [][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		vlist = new ArrayList<>();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int [N][N];
		copy = new int [N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					arr[i][j]=-1;
				}
				if(arr[i][j]==2) {
					arr[i][j]= 0;
					vlist.add(new Virus(i,j,0));
				}
			}
		}
		com(0,new Virus[K],0);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}
	public static void com(int r,Virus [] v,int before) {
		if(r==K) {
			int result = virus(v);
			if(result!=-1) {
				min = Math.min(result, min);
			}
		}
		else {
			for(int i=before;i<vlist.size();i++) {
				v[r] = vlist.get(i);
				com(r+1,v,i+1);
			}
		}
	}
	public static int virus(Virus [] v) {
		copy = new int [N][N];
		int max = 0;
		for(int i=0;i<N;i++) {
			copy[i] = arr[i].clone();
		}
		Queue<Virus> que = new LinkedList<>();
		for(int i=0;i<K;i++) {
			que.add(v[i]);
		}

		while(!que.isEmpty()) {
			Virus temp = que.poll();
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(!isin(r,c)) {
					continue;
				}
				if(arr[r][c]==-1) {
					continue;
				}
				if(copy[r][c]==0) {
					copy[r][c] = temp.cnt+1;
					que.add(new Virus(r,c,temp.cnt+1));
				}
			}
		}
		for(int i=0;i<v.length;i++) {
			copy[v[i].x][v[i].y]=-2;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copy[i][j]==0) {
					return -1;
				}
				max = Math.max(max, copy[i][j]);
			}
		}
		return max;
	}
	public static boolean isin(int x,int y) {
		return x>=0 && y>=0 && x<N && y<N;
	}
	static class Virus{
		int x,y;
		int cnt;
		public Virus(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

}
