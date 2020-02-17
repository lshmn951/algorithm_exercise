package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_10819_차이를최대 {
	static int n;
	static int [] arr;
	static int [] temp;
	static int max = Integer.MIN_VALUE;
	static boolean visit[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int [n];
		temp = new int [n];
		visit = new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		per(0);
		System.out.println(max);
	}
	public static void per(int k) {
		if(k==arr.length) {
			cal();
		}
		else {
			for(int i=0;i<arr.length;i++) {
				if(!visit[i]) {
					temp[k]=arr[i];
					visit[i]=true;
					per(k+1);
					visit[i]=false;
				}
			}
		}
		
	}
	
	public static void cal() {
		int sum =0;
		for(int i=0;i<n-1;i++) {
			sum += Math.abs(temp[i]-temp[i+1]);
		}
		if(sum>max) {
			max = sum;
		}
	}
}
