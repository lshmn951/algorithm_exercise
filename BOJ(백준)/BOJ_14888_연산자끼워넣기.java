package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	static int n;
	static int [] arr;
	static char [] oper;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		arr = new int [n];
		oper = new char [n-1];
		int idx = 0;
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<4;i++) {
			int t = Integer.parseInt(st.nextToken());
			for(int j=0;j<t;j++) {
				if(i==0) {
					oper[idx++] = '+';
				}
				else if(i==1) {
					oper[idx++] = '-';
				}
				else if(i==2) {
					oper[idx++] = '*';
				}
				else if(i==3) {
					oper[idx++] = '/';
				}
			}
		}
		per(0,new boolean[n-1],arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	public static void per(int k,boolean [] visit,int temp) {
		if(k==n-1) {
			if(max<temp) {
				max = temp;
			}
			if(min >temp) {
				min = temp;
			}
		}
		else {
			for(int i=0;i<n-1;i++) {
				if(!visit[i]) {
					visit[i] = true;
					int store = temp;
					if(oper[i]=='+') {
						temp += arr[k+1];
						per(k+1,visit,temp);
						temp  = store;
					}
					else if(oper[i]=='-') {
						temp -= arr[k+1];
						per(k+1,visit,temp);
						temp  = store;
					}
					else if(oper[i]=='*') {
						temp *= arr[k+1];
						per(k+1,visit,temp);
						temp  = store;
					}
					else if(oper[i]=='/') {
						temp /= arr[k+1];
						per(k+1,visit,temp);
						temp  = store;
					}
					visit[i] = false;
				}
			}
		}
	}
}
