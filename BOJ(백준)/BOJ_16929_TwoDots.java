package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16929_TwoDots {
	static int N,M;
	static char [][] map ;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean [][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		visit = new boolean [N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visit[i][j]) {
					visit[i][j] = true;
					if(isCycle(i, j, -1, -1, map[i][j])) {
						System.out.println("Yes");
						return ;
					}
				}
			}
		}
		System.out.println("No");
	}
	public static boolean isCycle(int x,int y,int px,int py,char cur) {
		for(int i=0;i<4;i++) {
			int r = x+dirs[i][0];
			int c = y+dirs[i][1];
			if(r<0||c<0||r>=N||c>=M) {
				continue;
			}
			if(r==px&&c==py) {
				continue;
			}
			if(map[r][c]==cur) {
				if(visit[r][c]) {
					return true;
				}else {
					visit[r][c] = true;
					if(isCycle(r, c, x, y, cur)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
