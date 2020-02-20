package algo_exercise.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_7965_퀴즈 {
	static int mod = 1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int tc=1;tc<=T;tc++) {
			long sum=0;
			int N = Integer.parseInt(bf.readLine());
			for(int i=1;i<=N;i++) {
				sum = (sum+calc(i,i))%mod;
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
	public static long calc(int a,int b) {
		if(b==1) {
			return a;
		}
		else if(b%2==1) {
			long temp = calc(a,b/2);
			temp = (temp*temp)%mod;
			temp = (temp*a)%mod;
			return temp;
		}
		else {
			long temp = calc(a,b/2);
			temp = (temp*temp)%mod;
			return temp;
		}
	}
}
