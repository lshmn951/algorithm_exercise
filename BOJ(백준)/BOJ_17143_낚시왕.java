package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {
	static int x,y,m;
	static Shark [][] arr;
	static Shark [][] arr2;
	static int [][] dirs = {{0,0},{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new Shark [x+1][y+1];
		arr2 = new Shark [x+1][y+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			arr[r][c] = (new Shark(s,d,z));
		}

		for(int i=1;i<=y;i++) { 
			for(int j=1;j<=x;j++) { 
				if(arr[j][i]!=null) {
					result += arr[j][i].z;
					arr[j][i] = null;
					break;
				}
			}
			move(); 
		}

		//move();
		System.out.println(result);
	}
	public static void move() {
		for(int i=1;i<=x;i++) {
			for(int j=1;j<=y;j++) {
				if(arr[i][j]==null) {
					continue;
				}
				Shark temp = arr[i][j];
				int num = temp.s;
				int r = i;
				int c = j;
				while(num>0) {
					r+=dirs[temp.d][0];
					c+=dirs[temp.d][1];
					if(!isin(r,c)) {
						if(temp.d==1) {
							temp.d=2;
						}
						else if(temp.d==2) {
							temp.d=1;
						}
						if(temp.d==3) {
							temp.d=4;
						}
						else if(temp.d==4) {
							temp.d=3;
						}
						r+=dirs[temp.d][0]*2;
						c+=dirs[temp.d][1]*2;
					}
					num--;
				}
				if(arr2[r][c]==null) {
					arr2[r][c] = new Shark(temp.s,temp.d,temp.z);
				}
				else {
					if(arr2[r][c].z<temp.z) {
						arr2[r][c]= new Shark(temp.s,temp.d,temp.z);
					}
				}
				arr[i][j] = null;
			}
		}
		for (int i = 1; i <=x; i++) {
			for (int j = 1; j <= y; j++) {
				if(arr2[i][j]==null) {
					continue;
				}
				arr[i][j] = arr2[i][j];
				arr2[i][j] = null;
			}
		}
	}
	public static boolean isin(int r,int c) {
		return r>0 && c>0 && r<=x && c<=y;
	}
	static class Shark{
		int s,d,z;

		public Shark( int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}
}
//반례 https://www.acmicpc.net/board/view/42484
// https://www.acmicpc.net/board/view/42206