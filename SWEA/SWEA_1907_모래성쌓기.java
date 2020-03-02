package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_1907_모래성쌓기 {
	static int [][] arr;
	static int [][] arr2;
	static boolean [][] visit;
	static int h,w;
	static int num;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 },{1,1},{1,-1},{-1,1},{-1,-1} };
	static Deque<Point > dq = new ArrayDeque<>();
	public static void main(String[] args) throws NumberFormatException, Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr = new int [h][w];
			visit = new boolean [h][w];
			dq = new ArrayDeque<>();
			for(int i=0;i<h;i++) {
				String str = br.readLine();
				for(int j=0;j<w;j++) {
					if(str.charAt(j)=='.') {
						arr[i][j] = 0;
					}
					else {
						arr[i][j] = str.charAt(j)-'0';
					}
				}
			}
			arr2 = new int [h][w];
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(arr[i][j]!=0) {
						int cnt=0;
						for(int k=0;k<8;k++) {
							int r = i+dirs[k][0];
							int c = j+dirs[k][1];
							if(arr[r][c]==0) {
								cnt++;
							}
						}
						arr2[i][j] = cnt;
						if(arr[i][j]<=cnt) {
							visit[i][j] = true;
							dq.add(new Point(i,j));
						}
					}
				}
			}
			num = 0;
			while(true) {
				if(day()) {
					break;
				}
				num++;
			}
			System.out.println("#"+tc+" "+num);
		}
	}
	public static boolean day() {
		if(dq.size()==0) {
			return true;
		}
		else {
			boolean b=false;
			int size = dq.size();
			while(size-->0) {
				Point temp = dq.pop();
				arr[temp.x][temp.y] = 0;
				arr2[temp.x][temp.y] = 0; 
				for(int k=0;k<8;k++) {
					int r = temp.x+dirs[k][0];
					int c = temp.y+dirs[k][1];
					if(arr[r][c]!=0) {
						arr2[r][c]++;
						if(arr[r][c]<=arr2[r][c] && !visit[r][c]) {
							visit[r][c] = true;
							dq.add(new Point(r,c));
						}
					}
				}
			}
			return false;
		}
	}
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
