package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_15650_N과M2 {
	static int [] nums;
	static int n;
	static int m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		m = sc.nextInt();
		nums = new int [m];
		per(0,1,new boolean[n+1]);
	}
	
	public static void per(int idx,int before,boolean[] visit) {
		if(idx==m) {
			for(int i=0;i<m;i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=before;i<=n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				nums[idx]=i;
				per(idx+1,i,visit);
				visit[i]=false;
			}
		}
	}
}
