package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16684_하노삼의탑 {
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	static int []arr;
	static int K,N,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int [N];
		Arrays.fill(arr, 1);
		if(M==1) {
			hanoi(N,3,2,1);
		}
		else if(M==2) {
			hanoi2(N,3,1);
		}
		if(M==3) {
			hanoi3(N,1);
		}
		
	}
	public static void hanoi(int n,int des,int emp,int cur) {
		if(n==1) {
			arr[n-1] = des;
			count++;
			if(count==K) {
				System.out.println(Arrays.toString(arr));
			}
		}
		else {
			hanoi(n-1,emp,des,cur);
			arr[n-1] = des;
			count++;

			if(count==K) {
				System.out.println(Arrays.toString(arr));
			}
			hanoi(n-1,des,cur,emp);
		}
	}
	
	public static void hanoi2(int n,int des,int cur) {
		if(n==1) {
			arr[n-1] = des;
			count++;
			if(count==K) {
				System.out.println(Arrays.toString(arr));
			}
			System.out.println(Arrays.toString(arr));
		}
		else {
			if(cur==1) {
				hanoi2(n-1,2,1);
				hanoi2(n-1,3,2);
				arr[n-1] = 2;
				count++;
				if(count==K) {
					System.out.println(Arrays.toString(arr));
				}
				System.out.println(Arrays.toString(arr));
				cur = 2;
				hanoi2(n-1,2,3);
			}
			if(cur==2 && des==3) {
				hanoi2(n-1,1,2);
				arr[n-1] =3;
				count++;
				if(count==K) {
					System.out.println(Arrays.toString(arr));
				}
				System.out.println(Arrays.toString(arr));
				hanoi2(n-1,2,1);
				hanoi2(n-1,3,2);
			}
			else if(cur==2 && des==1) {
				hanoi2(n-1,3,2);
				arr[n-1] =1;
				count++;
				if(count==K) {
					System.out.println(Arrays.toString(arr));
				}
				System.out.println(Arrays.toString(arr));
				hanoi2(n-1,2,3);
				hanoi2(n-1,1,2);
			}
			if(cur==3 && n!=N) {
				hanoi2(n-1,2,3);
				hanoi2(n-1,1,2);
				arr[n-1] = 2;
				count++;
				if(count==K) {
					System.out.println(Arrays.toString(arr));
				}
				System.out.println(Arrays.toString(arr));
				hanoi2(n-1,2,1);
			}
			
		}
	}
	public static void hanoi3(int n,int cur) {
		if(n==1) {
			arr[n-1] = (cur%3)+1;
			System.out.println(Arrays.toString(arr));
		}
		else {
			if(arr[N-1]==2) {
				hanoi3(n-1,cur);
				hanoi3(n-1,(cur%3)+1);
				arr[n-1] = (cur%3)+1;
				System.out.println(Arrays.toString(arr));
				hanoi3(n-1,((cur%3)+1)%3+1);
				hanoi3(n-1,cur);
			}
			else {
				hanoi3(n-1,cur);
				hanoi3(n-1,(cur%3)+1);
				arr[n-1] = (cur%3)+1;
				System.out.println(Arrays.toString(arr));
				hanoi3(n-1,((cur%3)+1)%3+1);
				arr[n-1] = ((cur%3)+1)%3+1;
				System.out.println(Arrays.toString(arr));
				hanoi3(n-1,cur);
				hanoi3(n-1,(cur%3)+1);
			}
		}
	}
}
