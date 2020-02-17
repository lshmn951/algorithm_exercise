package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 7.
 * @see https://www.acmicpc.net/problem/17070
 * @mem
 * @time
 * @caution 큐 쓰면 시간초과....재귀로 풀어야한다.
 */

public class BOJ_17070_파이프옮기기1 {
	static int n;
	static int [][] arr;
	static int [][] dirs = {{0,1},{1,1},{1,0}};
	static int sum =0;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		search(0,1,0);
		System.out.println(sum);
	}
	
	public static void search(int x,int y,int dir) {
		if(x==n-1 && y==n-1) {
			sum++;
			return ;
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
			search(tempx,tempy,i);
		}
	}
}
