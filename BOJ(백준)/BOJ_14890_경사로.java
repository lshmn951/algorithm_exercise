package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 7.
 * @see https://www.acmicpc.net/problem/14890
 * @mem
 * @time
 * @caution 범위 지정 실수하면 계속 틀린다...
 */

public class BOJ_14890_경사로 {
	static int N;
	static int L;
	static int [][] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sum=0;
		for(int i=0;i<N;i++) {
			if(rcheck(i)) {
				sum++;
			}
			if(ccheck(i)) {
				sum++;
			}
		}
		System.out.println(sum);
	}
	
	
	public static boolean rcheck(int r) {
		int [] temp = arr[r];
		boolean [] visit = new boolean [N];
		for(int i=0;i<N;i++) {
			if(i==0) {
				if(temp[1]==temp[0]) {
					continue;
				}
				if(1+L>N) {
					return false;
				}
				if(temp[1]<temp[0]) {
					for(int j=1;j<1+L;j++) {
						if(temp[j]!=temp[i]-1) {
							return false;
						}
						else {
							if(visit[j]) {
								return false;
							}
							else {
								visit[j] = true;
							}
						}
					}
				}
			}
			else if(i==N-1) {
				if(temp[i]==temp[i-1]) {
					continue;
				}
				if(N-2-L<-1) {
					return false;
				}
				if(temp[i]>temp[i-1]) {
					for(int j=N-2;j>N-2-L;j--) {
						if(temp[j]!=temp[i]-1) {
							return false;
						}
						else {
							if(visit[j]) {
								return false;
							}
							else {
								visit[j] = true;
							}
						}
					}
				}
			}
			else {
				if(temp[i]>temp[i-1]) {
					if(i<L) {
						return false;
					}
					else {
						if(i-1-L<-1) {
							return false;
						}
						for(int j=i-1;j>i-1-L;j--) {
							if(temp[j]!=temp[i]-1) {
								return false;
							}
							else {
								if(visit[j]) {
									return false;
								}
								else {
									visit[j] = true;
								}
							}
						}
					}
				}
				if(temp[i]>temp[i+1]) {
					if(i+L>=N) {
						return false;
					}
					else {
						if(i+1+L>N) {
							return false;
						}
						for(int j=i+1;j<i+1+L;j++) {
							if(temp[j]!=temp[i]-1) {
								return false;
							}
							else {
								if(visit[j]) {
									return false;
								}
								else {
									visit[j] = true;
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
	public static boolean ccheck(int c) {
		int [] temp = new int [N];
		for(int i=0;i<N;i++) {
			temp[i] = arr[i][c];
		}
		boolean [] visit = new boolean [N];
		for(int i=0;i<N;i++) {
			if(i==0) {
				if(temp[1]==temp[0]) {
					continue;
				}
				if(1+L>N) {
					return false;
				}
				if(temp[1]<temp[0]) {
					for(int j=1;j<1+L;j++) {
						if(temp[j]!=temp[i]-1) {
							return false;
						}
						else {
							if(visit[j]) {
								return false;
							}
							else {
								visit[j] = true;
							}
						}
					}
				}
			}
			else if(i==N-1) {
				if(temp[i]==temp[i-1]) {
					continue;
				}
				if(N-2-L<-1) {
					return false;
				}
				if(temp[i]>temp[i-1]) {
					for(int j=N-2;j>N-2-L;j--) {
						if(temp[j]!=temp[i]-1) {
							return false;
						}
						else {
							if(visit[j]) {
								return false;
							}
							else {
								visit[j] = true;
							}
						}
					}
				}
			}
			else {
				if(temp[i]>temp[i-1]) {
					if(i<L) {
						return false;
					}
					else {
						if(i-1-L<-1) {
							return false;
						}
						for(int j=i-1;j>i-1-L;j--) {
							if(temp[j]!=temp[i]-1) {
								return false;
							}
							else {
								if(visit[j]) {
									return false;
								}
								else {
									visit[j] = true;
								}
							}
						}
					}
				}
				if(temp[i]>temp[i+1]) {
					if(i+L>=N) {
						return false;
					}
					else {
						if(i+1+L>N) {
							return false;
						}
						for(int j=i+1;j<i+1+L;j++) {
							if(temp[j]!=temp[i]-1) {
								return false;
							}
							else {
								if(visit[j]) {
									return false;
								}
								else {
									visit[j] = true;
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
}
