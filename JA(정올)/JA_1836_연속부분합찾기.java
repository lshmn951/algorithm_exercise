package algo_exercise.JA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JA_1836_연속부분합찾기 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int []arr= new int [n];
		arr[0]=0;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int []dp = new int [n];
		int max = arr[0];
		dp[0] = arr[0];
		for(int i=1;i<n;i++) {
			if(dp[i-1]+arr[i]>arr[i]) {
				dp[i] = dp[i-1]+arr[i];
			}
			else {
				dp[i] = arr[i];
			}
			if(max<dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
		
	}

}
