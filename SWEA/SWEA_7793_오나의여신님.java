package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_7793_오나의여신님 {
	static int n,m;
	static char [][] arr;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int count =0;
			arr = new char [n][m];
			Deque<Point> dq = new ArrayDeque<>();
			for(int i=0;i<n;i++) {
				String str = br.readLine();
				for(int j=0;j<m;j++) {
					arr[i][j] = str.charAt(j);
					if(arr[i][j]=='*') {
						dq.push(new Point(i,j,arr[i][j],0));
					}
					if(arr[i][j]=='S') {
						dq.add(new Point(i,j,arr[i][j],0));
					}
				}
			}
			outer :while(!dq.isEmpty()) {
				int size = dq.size();
				while(size-->0) {
					Point temp = dq.pop();
					for(int i=0;i<4;i++) {
						int r = temp.x+dirs[i][0];
						int c = temp.y+dirs[i][1];
						if(r<0||c<0||r>=n||c>=m) {
							continue;
						}
						if(temp.c=='*') {
							if(arr[r][c]=='.') {
								arr[r][c]='*';
								dq.add(new Point(r,c,temp.c,0));
							}
						}
						else if(temp.c=='S') {
							if(arr[r][c]=='.') {
								arr[r][c] = 'S';
								dq.add(new Point(r,c,temp.c,temp.cnt+1));
							}
							else if(arr[r][c]=='D') {
								count = temp.cnt+1;
								dq.clear();
								break outer;
							}
						}

					}
				}
			}
			System.out.print("#"+tc+" ");
			System.out.println(count==0?"GAME OVER":count);
		}
	}
	static class Point{
		int x,y;
		char c;
		int cnt;
		public Point(int x, int y, char c, int cnt) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.cnt = cnt;
		}
	}
}