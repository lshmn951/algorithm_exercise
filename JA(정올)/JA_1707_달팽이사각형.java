package algo_exercise.JA;

import java.util.Scanner;

public class JA_1707_달팽이사각형 {
	static int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int [][]arr = new int [n][n];
		int number = 1;
		int r=0;
		int c=-1;
		int d=0;
		while(number <= (n*n)) {
			int tr = r+dirs[d][0];
			int tc = c+dirs[d][1];
			if(tr>=0 && tc>=0 && tr<n && tc<n && arr[tr][tc]==0) {
				arr[tr][tc]= number++;
				r = tr;
				c = tc;
			}
			else {
				d = (d+1)%4;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
