package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17144_미세먼지안녕 {
	static int R,C;
	static int[][]arr;
	static int[][]dirs = {{0,-1},{1,0},{0,1},{-1,0}};
	static int r1,r2;
	static class Room {
		int r;
		int c;
		int dust;
		public Room(int r, int c, int dust) {
			this.r = r;
			this.c = c;
			this.dust = dust;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		int T = sc.nextInt();
		r1=-1;
		r2=-1;
		arr= new int [R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==-1&&r1==-1) {
					r1=i;
					r2=i+1;
				}
			}
		}
		for(int i=0;i<T;i++) {
			dust();
			air();
		}
		int sum=2;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sum+=arr[i][j];
			}
		}
		System.out.println(sum);
	}
	public static boolean isin(int x,int y) {
		return (x>=0 && y>=0 && x<R && y<C) && !(y==0&&(x==r1||x==r2));
	}
	
	public static void dust() {
		Queue<Room> que = new LinkedList<>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]/5>0) {
					que.add(new Room(i,j,arr[i][j]/5));
				}
			}
		}
		
		while(!que.isEmpty()) {
			Room temp = que.poll();
			int x= temp.r;
			int y = temp.c;
			int d = temp.dust;
			int cnt=0;
			for(int i=0;i<4;i++) {
				int tx = x+dirs[i][0];
				int ty = y+dirs[i][1];
				if(isin(tx,ty)) {
					arr[tx][ty] +=d;
					cnt++;
				}
			}
			arr[x][y] -= cnt*d;
		}
	}
	public static void air() {
		int i,j;
		for(i=r1-1;i>0;i--) {
			arr[i][0] = arr[i-1][0];
		}
		for(j=r2+1;j<R-1;j++) {
			arr[j][0] = arr[j+1][0];
		}
		for(int k=0;k<C-1;k++) {
			arr[0][k] = arr[0][k+1];
			arr[R-1][k] = arr[R-1][k+1];
		}
		for(i=0;i<r1;i++) {
			arr[i][C-1] = arr[i+1][C-1];
		}
		for(j=R-1;j>r2;j--) {
			arr[j][C-1] = arr[j-1][C-1];
		}
		for(int k=C-1;k>1;k--) {
			arr[r1][k] = arr[r1][k-1];
			arr[r2][k] = arr[r2][k-1];
		}
		arr[r1][1] = 0;
		arr[r2][1] = 0;
	}
}