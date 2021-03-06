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
 * @since 2020. 2. 20.
 * @see https://www.acmicpc.net/problem/17142
 * @mem
 * @time
 * @caution 조합과 bfs 
 * 			0으로 돼있는 부분이 언제 채워졌나만 확인하면 되는 문제
 * 			활성과 비활성 바이러스 모두 카운트에서 제외
 */
public class BOJ_17142_연구소3 {
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
					arr[i][j]=-2;
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
				if(copy[r][c]==-2 || copy[r][c]==0) {
					copy[r][c] = temp.cnt+1;
					que.add(new Virus(r,c,temp.cnt+1));
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copy[i][j]==0) {
					return -1;
				}
				if(arr[i][j]==-2) {
					continue;
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
