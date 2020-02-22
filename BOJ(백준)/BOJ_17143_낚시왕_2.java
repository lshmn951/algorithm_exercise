package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕_2 {
	static int x,y,m;
	static Shark [][] arr;
	static Shark [][] arr2;
	static int [] rmove;
	static int [] cmove;
	static int rm,cm;
	static int [][] dirs = {{0,0},{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new Shark [x][y];
		arr2 = new Shark [x][y];

		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			arr[r][c] = (new Shark(s,d,z));
		}


		for(int i=0;i<y;i++) { 
			for(int j=0;j<x;j++) { 
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
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(arr[i][j]==null) {
					continue;
				}
				Shark temp = arr[i][j];
				int num = temp.s;
				int r = i+temp.s*dirs[temp.d][0];
				int c = j+temp.s*dirs[temp.d][1];
				if(r<0) {
					r = -r;
					temp.d = 2;
				}
				if(r>(x-1)) {
					int a = r/(x-1);
					int b = r%(x-1);
					if(a%2!=0) {
						temp.d=1;
						r=(x-1)-b;
					}
					else {
						r = b;
					}
				}
				if(c<0) {
					c = -c;
					temp.d = 3;
				}
				if(c>(y-1)) {
					int a = c/(y-1);
					int b = c%(y-1);
					if(a%2!=0) {
						temp.d=4;
						c=(y-1)-b;
					}
					else {
						c = b;
					}
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
		for (int i = 0; i <x; i++) {
			for (int j = 0; j < y; j++) {
				if(arr2[i][j]==null) {
					continue;
				}
				arr[i][j] = arr2[i][j];
				arr2[i][j] = null;
			}
		}
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