package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static int [][] dirs = {{-1,1},{0,1},{1,1}};
	static boolean [][] rjsanf;
	static int r,c;
	static int max = 0;
	static boolean che= false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		rjsanf = new boolean[r][c];
		for(int i=0;i<r;i++) {
			String str = bf.readLine();
			for(int j=0;j<c;j++) {
				if(str.charAt(j)=='x') {
					rjsanf[i][j] = true;
				}
			}
		}
		for(int i=0;i<r;i++) {
			che = false;
			dfs(i,0);
		}
		System.out.println(max);
	}
	public static void dfs(int x,int y) {
		if(y==c-1) {
			max++;
			che = true;
			return ;
		}
		else {
			for(int i=0;i<3;i++) {
				int rx = x+dirs[i][0];
				int cy = y+dirs[i][1];
				if(isin(rx,cy)&&!rjsanf[rx][cy]) {
					rjsanf[rx][cy] = true;
					dfs(rx,cy);
					if(che) {
						return;
					}
				}
			}
		}
	}
	public static boolean isin(int x,int y) {
		return x>=0 && y>=0 && x<r && y<c;
	}
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
