package algo_exercise.JA;

import java.util.Scanner;

public class JA_1438_색종이초 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] arr= new int[100][100];
		for(int t=0;t<n;t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					arr[i][j]=1;
				}
			}
		}
		int sum = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]==1) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}

}
