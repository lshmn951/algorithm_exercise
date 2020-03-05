package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {
	static int n;
	static int arr[][];
	static boolean visit[];
	static int max= Integer.MIN_VALUE;
	static int[][] dirs = { { 1, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			max= Integer.MIN_VALUE;
			visit = new boolean [101];
			n = Integer.parseInt(br.readLine());
			arr = new int [n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<n-2;i++) {
				for(int j=1;j<n-1;j++) {
					int d1=1;
					int d2=1;
					for(;j-d1>=0 && i+d1+d2<n;d1++) {
						for(;i+d1+d2<n&&j+d2<n;d2++) {
							Arrays.fill(visit, false);
							check(i,j,d1,d2);
						}
						d2=1;
					}
				}
			}
			System.out.print("#"+tc+" ");
			System.out.println(max==Integer.MIN_VALUE?-1:max);
		}
	}
	public static void check(int r,int c,int d1,int d2) {
		int sum =0;
		
		for(int i=0;i<d1;i++) {
			r += dirs[0][0];
			c += dirs[0][1];
			if(visit[arr[r][c]]) {
				return;
			}
			else {
				visit[arr[r][c]] =true;
				sum++;
			}
		}
		for(int i=0;i<d2;i++) {
			r += dirs[1][0];
			c += dirs[1][1];
			if(visit[arr[r][c]]) {
				return;
			}
			else {
				visit[arr[r][c]] =true;
				sum++;
			}
		}
		for(int i=0;i<d1;i++) {
			r += dirs[2][0];
			c += dirs[2][1];
			if(visit[arr[r][c]]) {
				return;
			}
			else {
				visit[arr[r][c]] =true;
				sum++;
			}
		}
		for(int i=0;i<d2;i++) {
			r += dirs[3][0];
			c += dirs[3][1];
			if(visit[arr[r][c]]) {
				return;
			}
			else {
				visit[arr[r][c]] =true;
				sum++;
			}
		}
		max = Math.max(max, sum);
	}

}
