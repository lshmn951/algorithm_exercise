package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	static int n,m;
	static int [][] arr;
	static int [][] visit;
	static int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Algo> que = new LinkedList<>();
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int [n][m];
		visit = new int [n][m];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = str.charAt(j)-'0';
				visit[i][j] = 10001;
			}
		}
		que.add(new Algo(0,0,0));
		visit[0][0] = 0;
		while(!que.isEmpty()) {
			Algo temp = que.poll();
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(!isin(r,c)) {
					continue;
				}
				if(arr[r][c]==0 && visit[r][c]>temp.cnt) {
					visit[r][c] = temp.cnt;
					que.add(new Algo(r,c,temp.cnt));
				}
				if(arr[r][c]==1 && visit[r][c]>temp.cnt+1) {
					visit[r][c] = temp.cnt+1;
					que.add(new Algo(r,c,temp.cnt+1));
				}
			}
		}
		System.out.println(visit[n-1][m-1]);
	}
	public static boolean isin(int x,int y) {
		return x>=0 && y>=0 && x<n && y<m;
	}
	static class Algo{
		int x,y;
		int cnt;
		public Algo(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
}
