package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4530_극한의청소작업 {
	static String str1,str2;
	static long num1,num2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			str1 = st.nextToken();
			str2 = st.nextToken();
			long num1 = change(str1);
			long num2 = change(str2);
			long res = Math.abs(num1-num2);
			if((num1<0 && num2>0) ||(num1>0&&num2<0)) {
				res--;
			}
			System.out.println("#"+tc+" "+res);
		}
	}
	public static long change(String str) {
		long temp= 0;
		boolean minus=false;
		if(str.charAt(0)=='-') {
			minus = true;
			str = str.substring(1);
		}
		long nine = 1;
		for(int i=str.length()-1;i>=0;i--,nine*=9) {
			long c = str.charAt(i)-'0';
			if(c>3) {
				c--;
			}
			temp += c*nine;
		}
		if(minus) {
			temp *= -1;
		}
		return temp;
	}
}
