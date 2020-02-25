package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17140_이차원배열과연산 {
	static int r,c,k;
	static int x,y;
	static int [][] arr = new int [100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<=100;i++) {
			if(arr[r][c]==k) {
				System.out.println(i);
				return;
			}
			x = rmax();
			y = cmax();
			if(x>=y) {
				roper();
				/*
				 * for(int j=0;j<x;j++) { System.out.println(Arrays.toString(arr[j])); }
				 */
			}
			else {
				coper();
			}
		}
		System.out.println(-1);
	}
	public static void roper() {
		int [] count = new int [101];
		PriorityQueue<Number> pq = new PriorityQueue<>();
		Number temp;
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(arr[i][j]==0) {
					continue;
				}
				count[arr[i][j]]++;
				arr[i][j] = 0;
			}
			for(int j=1;j<=100;j++) {
				if(count[j]>0) {
					pq.add(new Number(j,count[j]));
					count[j] = 0;
				}
			}
			for(int j=0;j<100;j+=2) {
				if(pq.isEmpty()) {
					break;
				}
				temp = pq.poll();
				arr[i][j] = temp.idx;
				arr[i][j+1] = temp.num;	
			}
			while(!pq.isEmpty()) {
				pq.poll();
			}
		}
	}
	public static void coper() {
		int [] count = new int [101];
		PriorityQueue<Number> pq = new PriorityQueue<>();
		Number temp;
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				if(arr[j][i]==0) {
					continue;
				}
				count[arr[j][i]]++;
				arr[j][i] = 0;
			}
			for(int j=1;j<=100;j++) {
				if(count[j]>0) {
					pq.add(new Number(j,count[j]));
					count[j] = 0;
				}
			}
			for(int j=0;j<100;j+=2) {
				if(pq.isEmpty()) {
					break;
				}
				temp = pq.poll();
				arr[j][i] = temp.idx;
				arr[j+1][i] = temp.num;	
			}
			while(!pq.isEmpty()) {
				pq.poll();
			}
		}
	}
	public static int rmax() {
		int i;
		boolean b=true;
		for(i=0;b;i++) {
			b = false;
			for(int j=0;j<100;j++) {
				if(arr[i][j]>0) {
					b=true;
					continue;
				}
			}
			if(!b) {
				break;
			}
		}
		return i;
	}
	public static int cmax() {
		int i;
		boolean b=true;
		for(i=0;b;i++) {
			b = false;
			for(int j=0;j<100;j++) {
				if(arr[j][i]>0) {
					b=true;
					continue;
				}
			}
			if(!b) {
				break;
			}
		}
		return i;
	}
	static class Number implements Comparable<Number>{
		int idx;
		int num;
		public Number(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
		@Override
		public int compareTo(Number o) {
			if(this.num<o.num) {
				return -1;
			}
			else if(this.num>o.num) {
				return 1;
			}
			else {
				if(this.idx<o.idx) {
					return -1;
				}
				else if(this.idx>o.idx) {
					return 1;
				}
				else {
					return 0;
				}
			}
		}
		
	}
}
