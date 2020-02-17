package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1992_쿼드트리 {
	static int [][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			String str = sc.next();
			for(int j=0;j<n;j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		quadtree(0,0,n);
	}
	public static void quadtree(int sr,int sc,int size) {
		int temp = quadcheck(sr,sc,size);
		if(temp>-1) {
			System.out.print(temp);
			return ;
		}
		else if(size==1) {
			System.out.print(arr[sr][sc]);
			return ;
		}
		System.out.print("(");
		quadtree(sr,sc,size/2);
		quadtree(sr,sc+size/2,size/2);
		quadtree(sr+size/2,sc,size/2);
		quadtree(sr+size/2,sc+size/2,size/2);
		System.out.print(")");
		
	}
	
	public static int quadcheck(int sr,int sc,int size) {
		int start = arr[sr][sc];
		for(int i=sr;i<sr+size;i++) {
			for(int j=sc;j<sc+size;j++) {
				if(start!=arr[i][j]) {
					return -1;
				}
			}
		}
		return start;
		
	}
}
