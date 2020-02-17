package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 10.
 * @see https://www.acmicpc.net/problem/17136
 * @mem
 * @time
 * @caution 완탐..재귀로 품
 */

public class BOJ_17136_색종이붙이기 {
	static boolean [][]arr;

	static boolean c= false;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		arr = new boolean[10][10];

		int [] paper = {5,5,5,5,5};
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean qwe = false;
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<10;j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					arr[i][j] = true;
					qwe = true;
				}
			}
		}
		outer :for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(arr[i][j]) {
					per(i,j,paper);
					break outer;
				}
			}
		}
		if(qwe) {
			if(min==Integer.MAX_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(min);
			}
		}
		else {
			System.out.println(0);
		}
	}
	public static void per(int x,int y,int [] paper) {
		boolean c = true;
		boolean [][] copy = new boolean[10][10];;
		for(int i=0;i<10;i++) {
			copy[i] = arr[i].clone();
		}
		for(int i=5;i>0;i--) {
			if(check(x,y,i) && paper[i-1]>0) {
				paper[i-1]--;
				c = true;
				outer2 :for(int q=x;q<10;q++) {
					if(q==x) {
						for(int w=y;w<10;w++) {
							if(arr[q][w]) {
								per(q,w,paper);
								c = false;
								break outer2;
							}
						}
					}
					else {
						for(int w=0;w<10;w++) {
							if(arr[q][w]) {
								per(q,w,paper);
								c= false;
								break outer2;
							}
						}
					}
				}
				if(c) {
					int sum=0;
					for(int q=0;q<5;q++) {
						sum += (5-paper[q]);
					}
					min = Math.min(min, sum);
				}
				paper[i-1]++;
				for(int q=0;q<10;q++) {
					arr[q] = copy[q].clone();
				}
			}
		}

	}
	public static boolean check(int x,int y,int size) {
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(!isin(i,j)||!arr[i][j]  ) {
					return false;
				}
			}
		}
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				arr[i][j] = false;
			}
		}


		return true;
	}
	public static boolean isin(int x,int y) {
		return x>=0 && y>=0 && x<10 && y<10;
	}
}