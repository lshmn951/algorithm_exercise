package algo_exercise.SWEA;

import java.util.Scanner;

public class SWEA_4408_자기방으로돌아가기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int []arr;
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			arr = new int [200];
			for(int q=0;q<N;q++) {
				int cur = sc.nextInt();
				int des = sc.nextInt();
				
				if(cur%2==1) {
					cur = (cur)/2;
				}
				else {
					cur = (cur-1)/2;
					
				}
				if(des%2==1) {
					des = des/2;
				}
				else {
					des = (des-1)/2;
				}
				
				if(cur<des) {
					for(int i=cur;i<=des;i++) {
						arr[i]++;
					}
				}
				else {
					for(int i=des;i<=cur;i++) {
						arr[i]++;
					}
				}
			}
			int max= 0;
			for(int i=0;i<200;i++) {
				if(max<arr[i]) {
					max = arr[i];
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}

}
