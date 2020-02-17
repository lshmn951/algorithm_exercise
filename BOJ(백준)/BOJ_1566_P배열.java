package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_1566_P배열 {
	static int N,M;
	static int zero;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int [][]arr = new int [N][M];
		int [] vq = new int [N];
		int [] vw = new int [M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		if(zero==1) {
			System.out.println(-1);
		}
		else
			System.out.println(min);
	}
	
	public static int wornl(int arr[][],int count,int[] q,int[] w) {
		if(zerocheck(arr)) {
			zero = 1;
			return -1;
		}
		if(rightcheck(arr)) {
			if(min>count) {
				min = count;
			}
			return count;
		}
		if(count >N+M) {
			return -1;
		}
		for(int i=0;i<N;i++) {
			if(q[i]!=1) {
				for(int j=0;j<M;j++) {
					arr[i][j] *= -1;
				}
				q[i]=1;
				wornl(arr,count+1,q,w);
				q[i]=0;
				for(int j=0;j<M;j++) {
					arr[i][j] *= -1;
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			if(w[i]!=1) {
				for(int j=0;j<N;j++) {
					arr[j][i] *= -1;
				}
				w[i]=1;
				wornl(arr,count+1,q,w);
				w[i]=0;
				for(int j=0;j<N;j++) {
					arr[j][i] *= -1;
				}
			}
		}
		return -1;
	}
	
	public static boolean zerocheck(int arr[][]) {
		int temp;
		for(int i=0;i<N;i++) {
			temp = 0;
			for(int j=0;j<M;j++) {
				temp += arr[i][j];
			}
			if(temp==0) {
				return true;
			}
		}
		for(int i=0;i<M;i++) {
			temp = 0;
			for(int j=0;j<N;j++) {
				temp += arr[j][i];
			}
			if(temp==0) {
				return true;
			}
		}
		return false;
	}
	public static boolean rightcheck(int arr[][]) {
		int temp;
		for(int i=0;i<N;i++) {
			temp = 0;
			for(int j=0;j<M;j++) {
				temp += arr[i][j];
			}
			if(temp<0) {
				return false;
			}
		}
		for(int i=0;i<M;i++) {
			temp = 0;
			for(int j=0;j<N;j++) {
				temp += arr[j][i];
			}
			if(temp<0) {
				return false;
			}
		}
		return true;
	}
}

