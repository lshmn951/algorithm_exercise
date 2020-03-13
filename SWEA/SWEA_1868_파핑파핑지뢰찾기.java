package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1868_파핑파핑지뢰찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			Solver s = new Solver();
			System.out.print("#"+tc+" ");
			System.out.println(s.solution());
		}
	}
	private static class Solver{
		int n;
		char [][]map;
		boolean [][]visit;
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 },
				{1,1},{1,-1},{-1,1},{-1,-1}	};
		int res;
		int cnt;
		public Solver() throws NumberFormatException, IOException {
			res=0;
			cnt=0;
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			visit = new boolean[n][n];
			for(int i=0;i<n;i++) {
				String str = br.readLine();
				for(int j=0;j<n;j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='*') {
						visit[i][j] = true;
					}else {
						res++;
					}
				}
			}
		}
		private boolean check(int x,int y) {
			for(int i=0;i<8;i++) {
				int r = x+dirs[i][0];
				int c = y+dirs[i][1];
				if(r<0||c<0||r>n-1||c>n-1) {
					continue;
				}
				if(map[r][c]=='*') {
					return false;
				}
			}
			return true;
		}
		private void click(int x,int y) {
			for(int i=0;i<8;i++) {
				int r = x+dirs[i][0];
				int c = y+dirs[i][1];
				if(r<0||c<0||r>n-1||c>n-1) {
					continue;
				}
				if(!visit[r][c]) {
					visit[r][c] = true;
					res--;
					if(check(r,c)) {
						click(r,c);
					}
				}
			}
		}
		public int solution() {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visit[i][j] && check(i,j)) {
						visit[i][j] = true;
						res--;
						cnt++;
						click(i, j);
					}
				}
			}
			return res+cnt;
		}
	}
}
