package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17779_게리맨더링2 {
static int n;
	static int [][]people;
	static int [][] dir = {{1,-1},{1,1},{-1,1},{-1,-1}};
	static int [][] copy;
	static int sum=0;
	static int [] sums = new int [5];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		people = new int[n][n];

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				people[i][j] = Integer.parseInt(st.nextToken());
				sum += people[i][j];
			}
		}

		for(int i=1;i<n-1;i++) {
			for(int j=1;j<n-1;j++) {
				district(i, j);
			}
		}
		System.out.println(min);
	}
	public static void district(int x,int y) {
		int d1=1,d2=1;
		
		for(;x+d1+d2<n && y-d1>=0 && y+d2<n;d1++) {
			for(d2=1;x+d1+d2<n && y-d1>=0 && y+d2<n;d2++) {
				div(x,y,d1,d2);
			}
			d2 = 1;
		}
	}
	public static void div(int x,int y,int d1,int d2) {
		copy = new int[n][n];
		Arrays.fill(sums,0);
		for(int i=0;i<d1;i++) {
			x += dir[0][0];
			y += dir[0][1];
			copy[x][y] = 5;
		}
		for(int i=0;i<d2;i++) {
			x += dir[1][0];
			y += dir[1][1];
			copy[x][y] = 5;
		}
		for(int i=0;i<d1;i++) {
			x += dir[2][0];
			y += dir[2][1];
			copy[x][y] = 5;
		}
		for(int i=0;i<d2;i++) {
			x += dir[3][0];
			y += dir[3][1];
			copy[x][y] = 5;
		}
		
		for(int i=0;i<x+d1;i++) {
			for(int j=0;j<=y;j++) {

				if(copy[i][j]==5) {
					break;
				}
				else {
					sums[0] += people[i][j];
				}
			}
		}
		for(int i=0;i<=x+d2;i++) {
			for(int j=n-1;j>y;j--) {
				if(copy[i][j]==5) {
					break;
				}
				else {
					sums[1] += people[i][j];
				}
			}
		}
		for(int i=x+d1;i<n;i++) {
			for(int j=0;j<y-d1+d2;j++) {
				if(copy[i][j]==5) {
					break;
				}
				else {
					sums[2] += people[i][j];
				}
			}
		}
		for(int i=x+d2+1;i<n;i++) {
			for(int j=n-1;j>=y-d1+d2;j--) {
				if(copy[i][j]==5) {
					break;
				}
				else {
					sums[3] += people[i][j];
				}
			}
		}
		
		sums[4] = sum-(sums[0]+sums[1]+sums[2]+sums[3]);

		int mx=Integer.MIN_VALUE;
		int nx=Integer.MAX_VALUE;
		for(int i=0;i<5;i++) {
			if(sums[i]>mx) {
				mx = sums[i];
			}
			if(sums[i]<nx) {
				nx = sums[i];
			}
		}
		min = Math.min(min, mx-nx);
	}
}
