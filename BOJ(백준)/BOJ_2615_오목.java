package algo_exercise.BOJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_2615_오목 {
	static int [][] dirs = {{-1,0,1,0},{-1,1,1,-1},{0,1,0,-1},{-1,-1,1,1}};

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		// 구현하세요.
		int [][] arr= new int [20][20];
		for(int i=1;i<20;i++) {
			for(int j=1;j<20;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int count;
		int mini;
		int minj;
		int r1,c1;
		int r2,c2;
		for(int i=1;i<20;i++) {
			for(int j=1;j<20;j++) {
				if(arr[i][j]==1) {
					for(int k=0;k<4;k++) {
						count = 1;
						mini = i;
						minj = j;
						r1 = i+dirs[k][0];
						c1 = j+dirs[k][1];
						r2 = i+dirs[k][2];
						c2 = j+dirs[k][3];
						while(isin(r1,c1)&&arr[r1][c1]==1) {
							if(k==0 || k==3) {
								if(mini<r1) {
									mini = r1;
									minj = c1;
								}
							}
							count++;
							r1 +=dirs[k][0];
							c1 +=dirs[k][1];
						}
						while(isin(r2,c2)&&arr[r2][c2]==1) {
							if(k==1 || k==2) {
								if(mini<r2) {
									mini = r2;
									minj = c2;
								}
							}
							count++;
							r2 +=dirs[k][2];
							c2 +=dirs[k][3];
						}
						if(count==5) {
							System.out.println(1);
							System.out.println(mini+" "+minj);
							return ;
						}
					}
					
				}
				else if(arr[i][j]==2) {
					for(int k=0;k<4;k++) {
						count = 1;
						mini = i;
						minj = j;
						r1 = i+dirs[k][0];
						c1 = j+dirs[k][1];
						r2 = i+dirs[k][2];
						c2 = j+dirs[k][3];
						while(isin(r1,c1)&&arr[r1][c1]==2) {
							if(k==0 || k==3) {
								if(mini<r1) {
									mini = r1;
									minj = c1;
								}
							}
							count++;
							r1 +=dirs[k][0];
							c1 +=dirs[k][1];
						}
						while(isin(r2,c2)&&arr[r2][c2]==2) {
							if(k==1 || k==2) {
								if(mini<r2) {
									mini = r2;
									minj = c2;
								}
							}
							count++;
							r2 +=dirs[k][2];
							c2 +=dirs[k][3];
						}
						if(count==5) {
							System.out.println(2);
							System.out.println(mini+" "+minj);
							return ;
						}
					}
				}
			}
		}
		System.out.println(0);
		
	}
	public static boolean isin(int r,int c) {
		return r>0 && c>0 && r<=19 && c<=19;
	}

}

