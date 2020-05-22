package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {
	static int d,w,k;
	static int [][] film;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			film = new int [d][w];
			min = Integer.MAX_VALUE;
			for(int i=0;i<d;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//System.out.println(check());
			dfs(0,0);
			System.out.println("#"+tc+" "+min);
		}
	}
	
	public static void dfs(int r,int count) {
		if(count>=min) return ;
		if(r==d) {
			if(check()) {//성능 검사 체크
				min = Math.min(min, count);
			}
			return;
		}else {
			dfs(r+1,count); // r번째 막에 양품 투입 X
			
			
			int [] copy = film[r].clone();
			Arrays.fill(film[r], 0);
			dfs(r+1,count+1); // r번째 막에 A 투입
			
			
			Arrays.fill(film[r], 1);
			dfs(r+1,count+1); // r번째 막에 B 투입
			film[r] = copy.clone();
		}
	}
	
	public static boolean check() {
		out:for(int i=0;i<w;i++) {
			int before = film[0][i];
			int cnt = 1;
			for(int j=1;j<d;j++) {
				if(film[j][i]==before) {
					cnt++;
				}else {
					cnt=1;
					before = film[j][i];
				}
				if(cnt==k) {
					continue out;
				}
			}
			return false;
		}
		return true;
	}

}
