package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 시뮬레이션
// 10이하로 움직이라고 나와있지만 10번이 되면 빠져나오게 해야 맞출수 있다.
public class BOJ_13460_구슬탈출2 {
	static char [][]arr;
	static boolean [][] visit;
	static int n,m;
	static Queue<Point > red = new LinkedList<>();
	static Queue<Point > blue = new LinkedList<>();
	static int [][] dirs= {{0,-1},{0,1},{-1,0},{1,0}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		visit = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j]=='R') {
					arr[i][j] = '.';
					red.add(new Point(i,j,0));
				}
				if(arr[i][j]=='B') {
					arr[i][j] = '.';
					blue.add(new Point(i,j,0));
				}
			}
		}
		int num=0;
		out:while(true) {
			Point r = red.poll();
			Point b = blue.poll();
			if(r.cnt>9) {
				num = -1;
				break;
			}
			for(int i=0;i<4;i++) {
				if(i==0) {//왼쪽
					if(r.x==b.x && r.y<b.y) {//빨간 공이 파란공 왼쪽
						if(move(i,1,r,b)) {
							num = r.cnt+1;
							break out ;
						}
					}
					else if(r.x==b.x && r.y>b.y) {//파란공이 빨간공 왼쪽
						if(move(i,2,r,b)) {
							num = r.cnt+1;
							break out ;
						}
					}
					else {
						if(move(i,1,r,b)) {
							num = r.cnt+1;
							break out ;
						}
					}
				}
				else if(i==1) {//오른쪽
					if(r.x==b.x && r.y<b.y) {//
						if(move(i,2,r,b)) {
							num = r.cnt+1;
							break out ;
						}
					}
					else if(r.x==b.x && r.y>b.y) {//
						if(move(i,1,r,b)) {
							num = r.cnt+1;
							break out ;
						}
					}
					else {
						
						if(move(i,1,r,b)) {
							num = r.cnt+1;
							break out ;
						}
					}
				}
				else if(i==2) {//위
					if(r.x<b.x && r.y==b.y) {//
						if(move(i,1,r,b)) {
							num = r.cnt+1;
							break out ;
						}
					}
					else if(r.x>b.x && r.y==b.y) {//
						if(move(i,2,r,b)) {
							num = r.cnt+1;
							break out ;
						}
					}
					else {
						if(move(i,1,r,b)) {
							num = r.cnt+1;
							break out ;
						}
					}
				}
				else if(i==3) {//아래
					if(r.x<b.x && r.y==b.y) {//
						if(move(i,2,r,b)) {
							num = r.cnt+1;
							break out ;
						}
					}
					else if(r.x>b.x && r.y==b.y) {//
						if(move(i,1,r,b)) {
							num = r.cnt+1;
							break out ;
						}
					}
					else {
						if(move(i,1,r,b)) {
							num = r.cnt+1;
							break out ;
						}
					}
				}
			}
		}
		System.out.println(num);
	}
	public static boolean move(int i,int fir,Point r,Point b) {
		boolean c= false;
		if(fir==1) {
			int x = r.x+dirs[i][0];
			int y = r.y+dirs[i][1];
			while(isin(x,y)) {
				if(arr[x][y]=='O') {
					x= -1;
					y = -1;
					c = true;
					break;
				}
				x +=dirs[i][0];
				y +=dirs[i][1];
			}
			
			x -=dirs[i][0];
			y -=dirs[i][1];
			int x1 = b.x+dirs[i][0];
			int y1 = b.y+dirs[i][1];
			while(isin(x1,y1)) {
				if(arr[x1][y1]=='O') {
					return false;
				}
				if(x1==x && y1==y) {
					break;
				}
				x1 +=dirs[i][0];
				y1 +=dirs[i][1];
			}
			x1 -=dirs[i][0];
			y1 -=dirs[i][1];
			if(!c) {
				red.add(new Point(x,y,r.cnt+1));
				blue.add(new Point(x1,y1,b.cnt+1));
			}
			/*
			 * System.out.println(i+" "+x+" "+y); System.out.println(i+" "+x1+" "+y1);
			 * 
			 * System.out.println();
			 */
		}
		else {
			int x = b.x+dirs[i][0];
			int y = b.y+dirs[i][1];
			while(isin(x,y)) {
				if(arr[x][y]=='O') {
					return false;
				}
				x +=dirs[i][0];
				y +=dirs[i][1];
			}
			x -=dirs[i][0];
			y -=dirs[i][1];
			int x1 = r.x+dirs[i][0];
			int y1 = r.y+dirs[i][1];
			while(isin(x1,y1)) {
				if(arr[x1][y1]=='O') {
					c = true;
					break;
				}
				if(x1==x && y1==y) {
					break;
				}
				x1 +=dirs[i][0];
				y1 +=dirs[i][1];
			}
			x1 -=dirs[i][0];
			y1 -=dirs[i][1];
			if(!c) {
				red.add(new Point(x1,y1,r.cnt+1));
				blue.add(new Point(x,y,b.cnt+1));
			}

		}
		
		return c;
	}
	public static boolean isin(int x,int y) {
		return arr[x][y]!='#';
	}
	static class Point {
		int x,y;
		int cnt;
		public Point(int x, int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
	}
}
// 반례https://www.acmicpc.net/board/view/23382