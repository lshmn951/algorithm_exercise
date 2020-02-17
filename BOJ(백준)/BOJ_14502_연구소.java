package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14502_연구소 {
	
	public static int [][]dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	public static int [][] arr;
	public static int N,M;
	public static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr= new int [N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		buildwall(0,0,0);
		System.out.println(max);
	}
	
	public static void buildwall(int r,int c,int count) {
		if(count==3) {
			int ma = spread();
			if(ma>max) {
				max = ma;
			}
			return;
		}
		for(int i=r;i<N;i++) {
			if(i>r) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]==0) {
						if(j==M-1) {
							arr[i][j]=1;
							buildwall(r+1,0,count+1);
							arr[i][j]=0;
						}
						else {
							arr[i][j] =1;
							buildwall(r,c+1,count+1);
							arr[i][j] =0;
						}
					}
				}
			}
			else {
				for(int j=c;j<M;j++) {
					if(arr[i][j]==0) {
						if(j==M-1) {
							arr[i][j]=1;
							buildwall(r+1,0,count+1);
							arr[i][j]=0;
						}
						else {
							arr[i][j] =1;
							buildwall(r,c+1,count+1);
							arr[i][j] =0;
						}
					}
				}
			}
		}
	}
	
	public static int spread() {
		int [][]temp = new int [N][M];
		for(int i=0;i<N;i++) {
			temp[i] = arr[i].clone();
		}
		
		Queue<Point> que = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(temp[i][j]==2) {
					Point tmp = new Point(i,j);
					que.add(tmp);
				}
			}
		}
		
		while(!que.isEmpty()) {
			int r = que.peek().x;
			int c = que.poll().y;
			for(int i=0;i<4;i++) {
				int r1 = r+dirs[i][0];
				int c1 = c+dirs[i][1];
				if(isin(r1,c1) && temp[r1][c1]==0) {
					temp[r1][c1] = 2;
					que.add(new Point(r1,c1));
				}
			}
		}
		
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(temp[i][j]==0) {
					sum++;
				}
			}
		}
		return sum;
	}
	
	public static class Point {
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean isin(int r,int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
}
