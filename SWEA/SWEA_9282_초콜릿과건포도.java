package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9282_초콜릿과건포도 {
	static int n,m;
	static int [][] arr;
	static int [][] sum;
	static int [][][][]visit;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int [n+1][m+1];
			sum = new int [n+1][m+1];
			visit = new int[n+1][m+1][n+1][m+1];
			for(int i=1;i<=n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1;j<=m;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					sum[i][j] = sum[i-1][j]+sum[i][j-1]+arr[i][j]-sum[i-1][j-1];
				}
			}
			int res = div(1,1,n,m);
			System.out.println("#"+tc+" "+(res));
		}
		
	}
	public static int div(int x1,int y1,int x2,int y2) {
		if(x1==x2 && y1==y2) {
			return 0;
		}
		if(visit[x1][y1][x2][y2]!=0) {
			return visit[x1][y1][x2][y2];
		}
		visit[x1][y1][x2][y2] = Integer.MAX_VALUE;
		int sums = sum[x2][y2]-sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1];
		for(int i=y1;i<y2;i++) {
			visit[x1][y1][x2][y2] = Math.min(visit[x1][y1][x2][y2],sums + div(x1,y1,x2,i)+div(x1,i+1,x2,y2));
		}
		for(int i=x1;i<x2;i++) {
			visit[x1][y1][x2][y2] = Math.min(visit[x1][y1][x2][y2],sums + div(x1,y1,i,y2)+div(i+1,y1,x2,y2));
		}
		
		return visit[x1][y1][x2][y2];
	}

}
