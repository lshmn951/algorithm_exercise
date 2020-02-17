package algo_exercise.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 13.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc&categoryId=AV5LtJYKDzsDFAXc&categoryType=CODE
 * @mem
 * @time
 * @caution 숫자의 위치는 랜덤
 */

public class SWEA_1861_정사각형방 {
	static int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	static int t,n;
	
	static int [][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Point> que ;
		t = Integer.parseInt(bf.readLine());
		for(int tc=1;tc<=t;tc++) {
			n = Integer.parseInt(bf.readLine());
			que = new LinkedList<>();
			arr = new int[n][n];
			int room=0;
			int max=0;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					
					que.add(new Point(i,j,arr[i][j],1,arr[i][j]));
					
					while(!que.isEmpty()) {
						Point temp = que.poll();
					
						for(int k=0;k<4;k++) {
							int r = temp.x+dirs[k][0];
							int c = temp.y+dirs[k][1];
							if(isin(r,c) && (arr[r][c] == temp.cur+1)) {
							
								que.add(new Point(r,c,temp.s,temp.num+1,temp.cur+1));
							}
						}
						if(que.size()==0) {
							if(max<temp.num) {
								room = temp.s;
								max = temp.num;
							}
							else if(max==temp.num) {
								if(room>temp.s) {
									room = temp.s;
								}
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+room+" "+max);
		}
	}
	public static boolean isin(int x,int y) {
		return x>=0 && y>=0 && x<n && y<n;
	}
	static class Point{
		int x,y;
		int s;
		int num;
		int cur;
		public Point(int x, int y, int s, int num,int cur) {
			this.cur = cur;
			this.x = x;
			this.y = y;
			this.s = s;
			this.num = num;
		}
		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + ", s=" + s + ", num=" + num + ", cur=" + cur + "]";
		}
		
	}
}