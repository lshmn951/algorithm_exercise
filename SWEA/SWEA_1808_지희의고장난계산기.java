package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1808_지희의고장난계산기 {
	static int []arr=new int [10];
	static int x;
	static int dp[] = new int [1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int pre = 0;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp, 0, pre, 0);;
			for(int i=0;i<10;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				dp[i] = arr[i];
			}
			x = Integer.parseInt(br.readLine());
			calc(x);
			System.out.print("#"+tc+" ");
			if(dp[x]==Integer.MAX_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(dp[x]+1);
			}
			pre = x;
		}
	}
	public static int calc(int n) {
		if(dp[n]!=0) {
			return dp[n];
		}
		dp[n] = check(n);
		for(int i=1;i<=(int)Math.sqrt(n);i++) {
			if(n%i==0) {
				int temp1 = calc(i);
				int temp2 = calc(n/i);
				dp[n] = Math.min(dp[n], (temp1==Integer.MAX_VALUE||temp2==Integer.MAX_VALUE)?Integer.MAX_VALUE:temp1+temp2+1);
			}
		}
		return dp[n];
	}
	public static int check(int n) {
		String str = Integer.toString(n);
		for(int i=0;i<str.length();i++) {
			int temp = str.charAt(i)-'0';
			if(arr[temp]==0) {
				return Integer.MAX_VALUE; 
			}
		}
		return str.length();
	}
}
