package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8275_햄스터 {
	static int []arr;
	static int [][]input;
	static int []res;
	static int n,x,m;
	static boolean b;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			b = false;
			arr = new int [n+1];
			res = new int [n+1];
			input = new int [m][3];
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
				input[i][2] = Integer.parseInt(st.nextToken());
			}
			per(1);
			if(!b) {
				System.out.println("#"+tc+" "+(-1));
			}
			else {
				System.out.print("#"+tc+" ");
				for(int i=1;i<=n;i++) {
					System.out.print(res[i]+" ");
				}
				System.out.println();
			}
		}
	}
	public static void per(int k) {
		if(k==n+1) {
			if(check()) {
				if(!b) {
					res = arr.clone();
					b= true;
				}
				else {
					change();
				}
			}
			return ;
		}
		for(int i=0;i<=x;i++) {
			arr[k] = i;
			per(k+1);
		}
	}
	public static boolean check() {
		boolean visit[] = new boolean[n+1];
		for(int i=0;i<m;i++) {
			int sum=0;
			for(int j=input[i][0];j<=input[i][1];j++) {
				sum+=arr[j];
				visit[j] = true;
			}
			if(sum!=input[i][2]) {
				return false;
			}
		}
		
		for(int i=1;i<n+1;i++) {
			if(!visit[i]) {
				arr[i] = x;
			}
		}
		return true;
	}
	public static void change() {
		int sum1=0;
		int sum2=0;
		for(int i=1;i<=n;i++) {
			sum1+=res[i];
		}
		for(int i=1;i<=n;i++) {
			sum2+=arr[i];
		}
		if(sum1<sum2) {
			res = arr.clone();
		}
		else if(sum1==sum2) {
			for(int i=1;i<=n;i++) {
				if(res[i]<arr[i]) {
					return;
				}
			}
			res = arr.clone();
		}
	}
}
