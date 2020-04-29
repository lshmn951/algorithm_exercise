package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4050_재관이의대량할인 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int [n];
			long sum = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum+=arr[i];
			}
			Arrays.sort(arr);
			for(int i=n-3;i>=0;i-=3) {
				sum -= arr[i];
			}
			System.out.println("#"+tc+" "+sum);
		}
	}

}
