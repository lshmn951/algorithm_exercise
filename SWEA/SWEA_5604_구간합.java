package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5604_구간합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			long a = Long.parseLong(str1);
			if(a>0) {
				a-=1;
			}
			long result = calc(str2)-calc(Long.toString(a));
			System.out.print("#"+tc+" ");
			System.out.println(result);
			//System.out.println();
		}
	}
	public static long calc(String temp) {
		long answer = 0;
		int len = temp.length();
		
		if(len==1) {
			int t = Integer.parseInt(temp);
			for(int i=1;i<=t;i++) {
				answer+=i;
			}
		}
		else {
			long cur = Long.parseLong(temp);
			long div = (long)Math.pow(10, len-1);
			long fr = cur/div;
			long mod = cur%div;
			long res = calc(Long.toString(div-1));
			for(long i=0;i<fr;i++) {
				answer+=i*div;
				answer+=res;
			}
			answer += fr*(mod+1);
			answer += calc(temp.substring(1));
		}
		return answer;
	}
}
