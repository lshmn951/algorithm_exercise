package algo_exercise.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2817_부분수열의합 {
	static int N,K;
	static int [] arr;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(bf.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(bf.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			for(int i=1;i<=N;i++) {
				com(i,0,0,new int[i]);
			}
			System.out.println("#"+tc+" "+cnt);
		}
		
	}
	public static void com(int r,int k,int before, int []temp) {
		if(k==r) {
			int sum=0;
			for(int i=0;i<r;i++) {
				sum+=temp[i];
			}
			if(sum==K) {
				cnt++;
			}
		}
		else {
			for(int i=before;i<N;i++) {
				temp[k] = arr[i];
				com(r,k+1,i+1,temp);
			}
		}
	}
}
