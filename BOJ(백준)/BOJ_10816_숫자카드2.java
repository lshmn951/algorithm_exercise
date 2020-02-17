package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {
	public static int []card;
	public static int n;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		card = new int [n];
		for(int i=0;i<n;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		int m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<m;i++) {
			int input = Integer.parseInt(st.nextToken());
			int up = upper(input);
			int lo = lower(input);
			if(up == n-1 && input==card[n-1]) {
				up++;
			}
			System.out.print((up-lo)+" ");
		}
		
	}
	
	public static int lower(int target) {
		int low = 0 ;
		int high = card.length-1;
		int mid;
		while(low<high) {
			mid = (low+high)/2;
			if(card[mid]>=target) {
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
		return high;
	}
	
	public static int upper(int target) {
		int low = 0 ;
		int high = card.length-1;
		int mid;
		while(low<high) {
			mid = (low+high)/2;
			if(card[mid]>target) {
				high = mid;
			}
			else {
				low = mid+1;
			} 
		}
		return high;
	}
}
