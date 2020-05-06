package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {
	static int win[];
	static int draw[];
	static int lose[];
	static int country[][];
	static int idx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc=0;tc<4;tc++) {
			st = new StringTokenizer(br.readLine());
			win = new int [6];
			draw = new int [6];
			lose = new int [6];
			country = new int [15][2];
			int total = 0;
			idx = 0;
			for(int i=0;i<6;i++) {
				win[i] = Integer.parseInt(st.nextToken());
				draw[i] = Integer.parseInt(st.nextToken());
				lose[i] = Integer.parseInt(st.nextToken());
				total += win[i] + draw[i]+lose[i];
			}
			if(total!=30) {
				System.out.print("0 ");
				continue;
			}
			combination(0,0, new int [2]);
			if(game(0)) {
				System.out.print("1 ");
			}else {
				System.out.print("0 ");
			}
		}
	}
	public static void combination(int k,int before,int [] temp) {
		if(2==k) {
			country[idx][0] = temp[0];
			country[idx++][1] = temp[1];
		}else {
			for(int i=before;i<6;i++) {
				temp[k] = i;
				combination(k+1, i+1, temp);
			}
		}
	}
	public static boolean game(int k) {
		if(k==15) {
			return true;
		}else {
			int c1 = country[k][0];
			int c2 = country[k][1];
			
			if(win[c1]>0 &&lose[c2]>0) {
				win[c1]--;
				lose[c2]--;
				if(game(k+1)) {
					return true;
				};
				win[c1]++;
				lose[c2]++;
			}
			
			if(draw[c1]>0 && draw[c2]>0) {
				draw[c1]--;
				draw[c2]--;
				if(game(k+1)) {
					return true;
				};
				draw[c1]++;
				draw[c2]++;
			}
			
			if(win[c2]>0 &&lose[c1]>0) {
				win[c2]--;
				lose[c1]--;
				if(game(k+1)) {
					return true;
				};
				win[c2]++;
				lose[c1]++;
			}
		}
		return false;
	}
}
