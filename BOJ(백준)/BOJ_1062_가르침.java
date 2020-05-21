package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062_가르침 {
	static int n,k;
	static int max;
	static String [] str ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if(k<5) {
			System.out.println(0);
		}else if(k==26) {
			System.out.println(n);
		}else {
			max = 0;
			str = new String [n];
			boolean [] visit = new boolean[26];
			for(int i=0;i<n;i++) {
				str[i] = br.readLine();
			}
			for(int i=0;i<n;i++) {
				str[i] = str[i].substring(4,str[i].length()-4);
			}
			visit['a'-'a'] = visit['n'-'a'] = visit['t'-'a']=visit['i'-'a']=visit['c'-'a']=true;
			combination(k-5, 0, 0, visit);
			System.out.println(max);
		}
	}
	public static void combination(int r,int k,int before,boolean [] visit) {
		if(r==k) {
			int cnt =0;
			out:for(int i=0;i<n;i++) {
				for(int j=0;j<str[i].length();j++) {
					if(!visit[str[i].charAt(j)-'a']) {
						continue out;
					}
				}
				cnt++;
			}
			max = Math.max(max, cnt);
		}else {
			for(int i=before;i<26;i++) {
				if(!visit[i]) {
					visit[i] = true;
					combination(r, k+1, i+1, visit);
					visit[i] = false;
				}
			}
		}
	}
	
}
