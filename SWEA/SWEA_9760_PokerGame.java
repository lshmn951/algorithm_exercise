package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9760_PokerGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String str = br.readLine();
			String []strs = str.split(" ");
			boolean shape[] = new boolean [4];
			int nums[] = new int [13];
			int arr[] = new int [5];
			for(int i=0;i<5;i++) {
				int s = suit(strs[i].charAt(0));
				shape[s]=true;
				int n = rank(strs[i].charAt(1));
				nums[n]++;
				arr[i] = n;
			}
			Arrays.sort(arr);
			System.out.println(Arrays.toString(shape));
			System.out.println(Arrays.toString(nums));
			System.out.println(Arrays.toString(arr));
			boolean pair = false;
			boolean pair2 = false;
			boolean triple = false;
			boolean four = false;
			for(int i=0;i<13;i++) {
				if(nums[i]==2) {
					if(pair) {
						pair2 = true;
					}
					pair = true;
				}
				else if(nums[i]==3) {
					triple = true;
				}
				else if(nums[i]==4) {
					four = true;
				}
			}
			boolean flush = false;
			int cnt = 0;
			for(int i=0;i<4;i++) {
				if(shape[i]) {
					cnt++;
				}
			}
			if(cnt==1) {
				flush = true;
			}
			boolean straight = false;
			boolean straightf = false;
			if(flush) {
				if(arr[0]==0) {
					boolean flag = true;
					for(int i=1;i<=4;i++) {
						if(arr[i]!=8+i) {
							flag = false;
							break;
						}
					}
					if(flag) {
						straightf = true;
					}
				}
			}
			boolean flag = true;
			for(int i=0;i<4;i++) {
				if(arr[i+1]!=arr[i]+1) {
					flag = false;
					break;
				}
			}
			if(flag) {
				straight = true;
			}
			System.out.print("#"+tc+" ");
			if(straightf) {
				System.out.println("Straight Flush");
			}else if(flush && straight) {				
				System.out.println("Straight Flush");
			}else if(four) {
				System.out.println("Four of a kind");
			}else if(triple && pair) {
				System.out.println("Full House");
			}else if(flush) {
				System.out.println("Flush");
			}else if(straight) {
				System.out.println("Straight");
			}else if(triple) {
				System.out.println("Three of a kind");
			}else if(pair) {
				if(pair2) {
					System.out.println("Two pair");
				}
				else {
					System.out.println("One pair");
				}
			}else {
				System.out.println("High card");
			}	
		}
	}
	public static int suit(char c) {
		if(c=='S') {
			return 0;
		}
		else if(c=='D') {
			return 1;
		}
		else if(c=='H') {
			return 2;
		}
		else if(c=='C') {
			return 3;
		}
		return 0;
	}
	public static int rank(char c) {
		if(c=='A') {
			return 0;
		}
		else if(c=='T') {
			return 9;
		}
		else if(c=='J') {
			return 10;
		}
		else if(c=='Q') {
			return 11;
		}
		else if(c=='K') {
			return 12;
		}
		else {
			return c -'1';
		}
	}
	
}
