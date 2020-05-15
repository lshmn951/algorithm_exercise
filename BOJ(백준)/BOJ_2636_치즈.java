package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 세로
		int m = Integer.parseInt(st.nextToken()); // 가로
		int [][] cheeze = new int [n][m];
		Queue<Point> que = new LinkedList<>();
		int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
		for(int i=0;i<n;i++) {
			st =  new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				cheeze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res=0;
		while(true) {
			que.add(new Point(0,0));
			int cnt = 0;
			boolean [][] erase = new boolean [n][m];
			boolean flag = false;
			while(!que.isEmpty()) {
				Point temp = que.poll();
				for(int i=0;i<4;i++) {
					int r = temp.x+dirs[i][0];
					int c = temp.y+dirs[i][1];
					if(r<0||c<0||r>=n||c>=m) {
						continue;
					}
					if(cheeze[r][c]==0 && !erase[r][c]) {
						erase[r][c] = true;
						que.add(new Point(r,c));
					}
					if(cheeze[r][c]==1 && !erase[r][c]) {
						erase[r][c] = true;
						cnt++;
					}
				}
			}
			res++;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(erase[i][j]) {
						cheeze[i][j] = 0;
					}
					if(cheeze[i][j]==1) {
						flag = true;
					}
				}
			}
			if(!flag) {
				System.out.println(res);
				System.out.println(cnt);
				break;
			}
		}
	}
	public static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
