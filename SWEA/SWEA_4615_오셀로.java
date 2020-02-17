package algo_exercise.SWEA;

import java.util.Scanner;

public class SWEA_4615_오셀로 {
	static int [][] dirs = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int [][]arr = new int[n+1][n+1];
			arr[n/2][n/2] = 2;
			arr[n/2+1][n/2] = 1;
			arr[n/2+1][n/2+1] = 2;
			arr[n/2][n/2+1] = 1;
			for(int j=0;j<m;j++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int rock = sc.nextInt();
				arr[r][c] = rock;
				for(int cs=0;cs<8;cs++) {
					int ter = r+dirs[cs][0];
					int tec = c+dirs[cs][1];
					int bool = 0;
					while(ter>0 && tec>0 && ter<=n && tec<=n) {
						if(arr[ter][tec]==0) {
							break;
						}
						else if(arr[ter][tec]==rock) {
							bool = 1;
							break;
						}
						ter = ter+dirs[cs][0];
						tec = tec+dirs[cs][1];
					}
					if(bool==1) {
						ter = r+dirs[cs][0];
						tec = c+dirs[cs][1];
						while(ter>0 && tec>0 && ter<=n && tec<=n) {
							if(arr[ter][tec]==rock) {
								break;
							}
							else {
								arr[ter][tec]=rock;
							}
							ter = ter+dirs[cs][0];
							tec = tec+dirs[cs][1];
						}
					}
				}
			}
			int r1=0;
			int r2=0;
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=n;k++) {
					if(arr[j][k]==1) {
						r1++;
					}
					else if(arr[j][k]==2) {
						r2++;
					}
				}
			}
			System.out.println("#"+i+" "+r1+" "+r2);
		}
	}

}
