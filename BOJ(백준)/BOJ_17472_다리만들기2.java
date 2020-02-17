package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {
	static int N,M,is;
	static int [][] arr;
	static int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	static int [][] bri;
	static int min = Integer.MAX_VALUE;
	static List<Bridge> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		is = 2;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1) {
					arr[i][j]=is;
					dfs(i,j);
					is++;
				}
			}
		}
		bri = new int [is][is];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0) {
					makeBridge(i, j, arr[i][j]);
				}
			}
		}
		is -= 3;
		if(list.size()==0) {
			System.out.println(-1);
		}
		else {
			per(0,0,new Bridge[is]);
			if(min == Integer.MAX_VALUE) {
				System.out.println(-1);
			}
			else
				System.out.println(min);
		}
	}
	
	public static void per(int k,int before,Bridge[] temp) {
		if(k==is) {
			int sum=0;
			bri = new int [is+3][is+3];
			for(int i=0;i<k;i++) {
				sum+=temp[i].leng;
				bri[temp[i].is1][temp[i].is2] =1;
				bri[temp[i].is2][temp[i].is1] =1;
			}
			if(islink(temp[0].is1)) {
				min = Math.min(sum, min);
			}
		}
		else {
			for(int i=before;i<list.size();i++) {
				temp[k] = list.get(i);
				per(k+1,i+1,temp);
			}
		}
	}
	public static boolean islink(int s) {
		Queue<Integer> que = new LinkedList<Integer>();
		boolean [] vi = new boolean[is+1];
		que.add(s);
		while(!que.isEmpty()) {
			int t = que.poll();
			if(vi[t-2]) {
				continue;
			}
			vi[t-2] = true;
			for(int i=2;i<bri.length;i++) {
				if(bri[t][i]==1 && !vi[i-2]) {
					que.add(i);
				}
			}
		}
		for(int i=0;i<vi.length;i++) {
			if(!vi[i]) {
				return false;
			}
		}
		return true;
	}
	public static boolean isin(int r,int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
	public static void dfs(int x,int y) {
		for(int i=0;i<4;i++) {
			int tx = x+dirs[i][0];
			int ty = y+dirs[i][1];
			if(isin(tx,ty)&&arr[tx][ty]!=is && arr[tx][ty]!=0) {
				arr[tx][ty] = is;
				dfs(tx,ty);
			}
		}
	}
	public static void makeBridge(int x,int y,int i) {
		for(int j=0;j<4;j++) {
			int cnt=0;
			int r = x+dirs[j][0];
			int c = y+dirs[j][1];
			while(isin(r,c) && arr[r][c]!=i) {
				cnt++;
				if(arr[r][c]!=0 &&arr[r][c]!=i) {
					if(cnt>2) {
						if(bri[i][arr[r][c]]==1) {
							for(int k=0;k<list.size();k++) {
								if(list.get(k).is1==i && list.get(k).is2==arr[r][c] ||
										list.get(k).is2==i && list.get(k).is1==arr[r][c]) {
									list.get(k).leng = Math.min(list.get(k).leng, cnt-1);
								}
							}
							
						}
						else {
							bri[i][arr[r][c]] =1;
							bri[arr[r][c]][i] =1;
							list.add(new Bridge(i,arr[r][c],cnt-1));
							
						}
					}
					break;
				}
				r += dirs[j][0];
				c += dirs[j][1];
			}
		}
	}

	static class Bridge{
		int is1,is2;
		int leng;
		public Bridge(int is1, int is2, int leng) {
			this.is1 = is1;
			this.is2 = is2;
			this.leng = leng;
		}
		@Override
		public String toString() {
			return "[is1=" + is1 + ", is2=" + is2 + ", leng=" + leng + "]";
		}

	}
}
