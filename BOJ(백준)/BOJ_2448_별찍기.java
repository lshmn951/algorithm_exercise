package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_2448_별찍기 {
	static char [][]arr= new char [3072][3072*2];
	
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine());
		star(n,0,n-1);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n*2;j++) {
				sb.append((arr[i][j]=='*')?'*':' ');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void star(int n,int r,int c) {
		if(n==3) {
			arr[r][c] = '*';
			
			arr[r+1][c-1] ='*';
			arr[r+1][c+1] ='*';
			
			arr[r+2][c-2] ='*';
			arr[r+2][c-1] ='*';
			arr[r+2][c] ='*';
			arr[r+2][c+1] ='*';
			arr[r+2][c+2] ='*';
			return;
		}
		star(n/2,r,c);
		star(n/2,r+n/2,c-n/2);
		star(n/2,r+n/2,c+n/2);		
	}
}
