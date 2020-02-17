package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 7.
 * @see https://www.acmicpc.net/problem/2567
 * @mem
 * @time
 * @caution 꼭짓점은 2번 카운트 해줘야 둘레가 나온다.
 */

public class BOJ_2567_색종이2 {
	static int [][]dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	static int [][]arr;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int n = Integer.parseInt(bf.readLine());
		int cnt;
		int sum=0;
		arr= new int [100][100];
		boolean [][] aiu = new boolean[100][100];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for(int j=c;j<c+10;j++) {
				for(int k=r;k<r+10;k++) {
					arr[j][k] = 1;
					aiu[j][k] = true;
				}
			}
		}
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				cnt = 0;
				if(arr[i][j]==1) {
					for(int q=0;q<4;q++) {
						int x = i+dirs[q][0];
						int y = j+dirs[q][1];
						if(isin(x,y) && arr[x][y]==1) {
							cnt++;
						}
					}
				}
				if(cnt==4) {
					aiu[i][j] = false;
				}
				if(cnt==2) {
					if(edge(i,j)) {
						sum++;
					}
				}
			}
		}
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(aiu[i][j]) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
	public static boolean edge(int x,int y) {
		if(isin(x,y-1) && isin(x,y+1)) {
			if(arr[x][y-1]==1 && arr[x][y+1]==1) {
				return false;
			}
		}
		else if(isin(x-1,y) && isin(x+1,y)) {
			if(arr[x-1][y]==1 && arr[x+1][y]==1) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isin(int x,int y) {
		return x>=0 && y>=0 && x<100 && y<100;
	}

}
