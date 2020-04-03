package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9659_다항식계산 {
	private static final int mod = 998244353;
	static int n,m;
	static int []t;
	static int []a;
	static int []b;
	static long []x;
	static long fibo[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			t = new int [n+1];
			a = new int [n+1];
			b = new int [n+1];
			fibo = new long [n+1];
			for(int i=2;i<=n;i++) {
				st = new StringTokenizer(br.readLine());
				t[i] = Integer.parseInt(st.nextToken());
				a[i] = Integer.parseInt(st.nextToken());
				b[i] = Integer.parseInt(st.nextToken());
			}
			m = Integer.parseInt(br.readLine());
			x = new long[m+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=m;i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			System.out.print("#"+tc+" ");
			for(int i=1;i<=m;i++) {
				Arrays.fill(fibo, 0);
				fibo[0] = 1;
				fibo[1] = x[i];
				for(int j=2;j<=n;j++) {
					if(t[j]==1) {
						fibo[j] = (fibo[a[j]]+fibo[b[j]])%mod;
					}else if(t[j]==2) {
						fibo[j] = (a[j] * fibo[b[j]])%mod;
					}else if(t[j]==3) {
						fibo[j] = (fibo[a[j]]*fibo[b[j]])%mod;
					}
				}
				System.out.print(fibo[n]+" ");
			}
			System.out.println();
		}
	}

}
