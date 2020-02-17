package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 7.
 * @see https://www.acmicpc.net/problem/16987
 * @mem 15088KB
 * @time 232ms
 * @caution 다음 재귀로 넘어갈때 언제나 다음으로 가는게 아니라 무언가를 깼던가 자기 자신이 깰수 없는 상황에서만 넘어간다
 * 			마지막 녀석이 깨졌을 경우와 안깨졌을 경우를 잘 따져서 생각해야 한다.
 */

public class BOJ_16987_계란으로계란치기 {
	static int n;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		Egg []eggs = new Egg[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			int input1 = Integer.parseInt(st.nextToken());
			int input2 = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(input1,input2);
		}
		broken(0,eggs);
		if(n==1) {
			System.out.println(0);
		}
		else
			System.out.println(max);
	}
	
	public static void broken(int k,Egg[] temp) {
		if(k==n-1) {
			if(temp[k].s>0) {
				for(int i=0;i<n-1;i++) {
					if(temp[i].s>0) {
						int temp1 = temp[i].s;
						int temp2 = temp[k].s;
						temp[i].s -= temp[k].w;
						temp[k].s -= temp[i].w;
						int sum = 0;
						for(int j=0;j<n;j++) {
							if(temp[j].s<=0) {
								sum++;
							}
						}
						if(sum>max) {
							max = sum;
						}
						temp[i].s = temp1;
						temp[k].s = temp2;
					}
					else {
						int sum = 0;
						for(int j=0;j<n;j++) {
							if(temp[j].s<=0) {
								sum++;
							}
						}
						if(sum>max) {
							max = sum;
						}
					}
				}
			}
			else {
				int sum = 0;
				for(int j=0;j<n;j++) {
					if(temp[j].s<=0) {
						sum++;
					}
				}
				if(sum>max) {
					max = sum;
				}
			}
			
			return;
		}
		else {
			for(int i=0;i<n;i++) {
				if(k!=i &&temp[k].s>0 && temp[i].s>0) {
						int temp1 = temp[i].s;
						int temp2 = temp[k].s;
						temp[i].s -= temp[k].w;
						temp[k].s -= temp[i].w;
						broken(k+1,temp);
						temp[i].s = temp1;
						temp[k].s = temp2;
				}
			}
			if(temp[k].s<=0) {
				broken(k+1,temp);
			}
		}
	}
	
	public static class Egg{
		int s,w;

		public Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}

		@Override
		public String toString() {
			return "[s=" + s + ", w=" + w + "]";
		}
		
	}
}
