package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7699_수지의수지맞는여행 {
	static boolean visit[];
	static char arr[][] ;
	static int R,C;
	static int max =0;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			max = 0;
			visit = new boolean [26];
			arr = new char [R][C];
			for(int i=0;i<R;i++) {
				String str = br.readLine();
				for(int j=0;j<C;j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			visit[arr[0][0]-'A'] = true;
			dfs(0,0,1);
			System.out.println("#"+tc+" "+max);
		}
	}
	public static void dfs(int x,int y,int num) {
		max = Math.max(max, num);
		for(int i=0;i<4;i++) {
			int r = x+dirs[i][0];
			int c = y+dirs[i][1];
			if(r<0||c<0||r>=R||c>=C) {
				continue;
			}
			int d = arr[r][c]-'A';
			if(!visit[d]) {
				visit[d] =true;
				dfs(r,c,num+1);
				visit[d] = false;
			}
			
		}
	}
}
