package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_15649_N과M {
	static int[] nums;
	static int N;
	static int M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[M];
		per(0,new boolean [N+1]);
	}
	
	public static void per(int idx,boolean[] visit) {
		if(idx==M) {
			for(int i=0;i<M;i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(!visit[i]) {
				visit[i] = true;
				nums[idx]=i;
				per(idx+1,visit);
				visit[i]=false;
			}
		}
	}

}
