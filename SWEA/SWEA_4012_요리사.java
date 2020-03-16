package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static int [][]arr;
	static int n;
	static int sum;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			sum=0;
			min = Integer.MAX_VALUE;
			arr = new int [n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum+=arr[i][j];
				}
			}
			com1(0,0,new int [n/2]);
			System.out.println("#"+tc+" "+min);
		}
		
	}
	public static void com1(int k,int before,int [] temp) {
		if(n/2==k) {
			int []in = new int [n/2];
			int q=0;
			out:for(int i=0;i<n;i++) {
				for(int j=0;j<temp.length;j++) {
					if(i==temp[j]) {
						continue out;
					}
				}
				in[q++] = i;
			}
			int add1 = com2(0,temp,0,new int[2]);
			int add2 = com2(0,in,0,new int[2]);
			min = Math.min(min,Math.abs(add1-add2));
			return;
		}
		for(int i=before;i<n;i++) {
			temp[k]=i;
			com1(k+1,i+1,temp);
		}
	}
	public static int com2(int k,int [] temp,int before,int []num) {
		int add=0;
		if(2==k) {
			return arr[num[0]][num[1]]+arr[num[1]][num[0]];
		}
		for(int i=before;i<temp.length;i++) {
			num[k]=temp[i];
			add+=com2(k+1,temp,i+1,num);
		}
		return add;
	}
}
