package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BOJ_17069_파이프옮기기2 {
	static int n;
	static int [][] arr;
	static int [][] dirs = {{0,1},{1,1},{1,0}};
	static long [][][] dp;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		dp = new long [3][n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(search(0,1,0));
	}
	
	public static long search(int x,int y,int dir) {
		if(x==n-1 && y==n-1) {
			return 1;
		}
		if(dp[dir][x][y]>0) {
			return dp[dir][x][y];
		}
		
		for(int i=0;i<3;i++) {
			if(i==0 && dir==2 || i==2&&dir==0) {
				continue;
			}
			
			int tempx = x+dirs[i][0];
			int tempy = y+dirs[i][1];
			if(tempx>=n || tempy>=n || arr[tempx][tempy]==1) {
				continue;
			}
			if(i==1 && (arr[tempx-1][tempy]==1 || arr[tempx][tempy-1]==1)) {
				continue;
			}
			dp[dir][x][y]+=search(tempx,tempy,i);
		}
		return dp[dir][x][y];
	}
}