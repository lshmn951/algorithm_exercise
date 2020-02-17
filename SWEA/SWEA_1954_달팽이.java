package algo_exercise.SWEA;

import java.util.Scanner;

public class SWEA_1954_달팽이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			System.out.println("#"+i);
			int N = sc.nextInt();
			int [][] arr = new int [N+2][N+2];
			for(int j=0;j<N+2;j++) {
				arr[0][j] = 1;
				arr[N+1][j] = 1;
			}
			for(int j=0;j<N+2;j++) {
				arr[j][0] = 1;
				arr[j][N+1] = 1;
			}
			int count = N*N;
			int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
			int r=1;
			int c=1;
			int d=0;
			int e=1;
			while(count-->0) {
				arr[r][c] = e++;
				int rt = r+dir[d%4][0];
				int ct = c+dir[d%4][1];
				if(arr[rt][ct]==0) {
					r = rt;
					c = ct;
				}
				else {
					d++;
					r = r+dir[d%4][0];
					c = c+dir[d%4][1];
				}
			}
			for(int k=1;k<=N;k++) {
				for(int q=1;q<=N;q++) {
					System.out.print(arr[k][q]+" ");
				}
				System.out.println();
			}
		}
	}

}
