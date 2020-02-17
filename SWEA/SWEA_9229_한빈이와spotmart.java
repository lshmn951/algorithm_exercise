package algo_exercise.SWEA;

import java.util.Scanner;

public class SWEA_9229_한빈이와spotmart {
	static int max = 0,N,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			max = 0;
			System.out.print("#"+i+" ");
			N = sc.nextInt();
			M = sc.nextInt();
			int arr[] = new int [N];
			for(int j=0;j<N;j++) {
				arr[j]=sc.nextInt();
			}
			snack(arr,0,0,0);
			if(max == 0) {
				System.out.println("-1");
			}
			else {
				System.out.println(max);
			}
		}
	}
	
	public static void snack(int[] arr, int i, int cnt, int sum) {
		if(sum>M) {
			return ;
		}
		if(cnt==2) {
			if(max<sum) {
				max = sum;
			}
			return;
		}
		if(i==N) {
			return;
		}
		snack(arr,i+1,cnt+1,sum+arr[i]);
		snack(arr,i+1,cnt,sum);
	}

}
