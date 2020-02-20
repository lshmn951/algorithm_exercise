package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 20.
 * @see https://www.acmicpc.net/problem/15683
 * @mem
 * @time
 * @caution 사방탐색 완탐 시뮬레이션
 */
public class BOJ_15683_감시 {
	static int N,M;
	static int [][] arr;
	static List<Cctv> list = new ArrayList<>();
	static int[][] dirs = {{ 0, -1 } ,  { -1, 0 }, { 0, 1 }, { 1, 0 }};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>=1 && arr[i][j]<=5) {
					list.add(new Cctv(i,j,arr[i][j]));
				}
			}
		}
		
		recur(0);
		System.out.println(min);
	}
	public static void recur(int k) {
		int [] r = new int [4];
		int [] c = new int [4];
		List<Cctv> re = new ArrayList<>();
		if(k==list.size()) {
			int sum=0;
			for(int i=0;i<N;i++) {
				//System.out.println(Arrays.toString(arr[i]));
				for(int j=0;j<M;j++) {
					if(arr[i][j]==0) {
						sum++;
					}
				}
			}
			//System.out.println();
			min = Math.min(min, sum);
		}
		else {
			Cctv temp = list.get(k);
			if(temp.num==1) {
				for(int i=0;i<4;i++) {
					r[0] = temp.x+dirs[i][0];
					c[0] = temp.y+dirs[i][1];
					while(isin(r[0],c[0])) {
						if(arr[r[0]][c[0]]==6) {
							break;
						}
						else if(arr[r[0]][c[0]]==0) {
							arr[r[0]][c[0]] = 9;
							re.add(new Cctv(r[0],c[0],0));
						}
						r[0] = r[0]+dirs[i][0];
						c[0] = c[0]+dirs[i][1];
					}
					recur(k+1);
					for(int j=0;j<re.size();j++) {
						arr[re.get(j).x][re.get(j).y] = 0;
					}
					re.clear();
				}
			}
			else if(temp.num==2) {
				for(int i=0;i<2;i++) {
					for(int j=i;j<4;j+=2) {
						r[j] = temp.x+dirs[j][0];
						c[j] = temp.y+dirs[j][1];
						while(isin(r[j],c[j])) {
							if(arr[r[j]][c[j]]==6) {
								break;
							}
							else if(arr[r[j]][c[j]]==0) {
								arr[r[j]][c[j]] = 9;
								re.add(new Cctv(r[j],c[j],0));
							}
							r[j] = r[j]+dirs[j][0];
							c[j] = c[j]+dirs[j][1];
						}
					}
					recur(k+1);
					for(int j=0;j<re.size();j++) {
						arr[re.get(j).x][re.get(j).y] = 0;
					}
					re.clear();
				}
			}
			else if(temp.num==3) {
				for(int i=0;i<4;i++) {
					for(int j=i;j<i+2;j++) {
						int t = j%4;
						r[t] = temp.x+dirs[t][0];
						c[t] = temp.y+dirs[t][1];
						while(isin(r[t],c[t])) {
							if(arr[r[t]][c[t]]==6) {
								break;
							}
							else if(arr[r[t]][c[t]]==0) {
								arr[r[t]][c[t]] = 9;
								re.add(new Cctv(r[t],c[t],0));
							}
							r[t] = r[t]+dirs[t][0];
							c[t] = c[t]+dirs[t][1];
						}
					}
					recur(k+1);
					for(int j=0;j<re.size();j++) {
						arr[re.get(j).x][re.get(j).y] = 0;
					}
					re.clear();
				}
			}
			else if(temp.num==4) {
				for(int i=0;i<4;i++) {
					for(int j=i;j<i+3;j++) {
						int t = j%4;
						r[t] = temp.x+dirs[t][0];
						c[t] = temp.y+dirs[t][1];
						while(isin(r[t],c[t])) {
							
							if(arr[r[t]][c[t]]==6) {
								break;
							}
							else if(arr[r[t]][c[t]]==0) {
								arr[r[t]][c[t]] = 9;
								re.add(new Cctv(r[t],c[t],0));
							}
							r[t] = r[t]+dirs[t][0];
							c[t] = c[t]+dirs[t][1];
						}
					}
					recur(k+1);
					for(int j=0;j<re.size();j++) {
						arr[re.get(j).x][re.get(j).y] = 0;
					}
					re.clear();
				}
			}
			else if(temp.num==5) {
				for(int j=0;j<4;j++) {
					r[j] = temp.x+dirs[j][0];
					c[j] = temp.y+dirs[j][1];
					while(isin(r[j],c[j])) {
						if(arr[r[j]][c[j]]==6) {
							break;
						}
						else if(arr[r[j]][c[j]]==0) {
							arr[r[j]][c[j]] = 9;
							re.add(new Cctv(r[j],c[j],0));
						}
						r[j] = r[j]+dirs[j][0];
						c[j] = c[j]+dirs[j][1];
					}
				}
				recur(k+1);
				for(int j=0;j<re.size();j++) {
					arr[re.get(j).x][re.get(j).y] = 0;
				}
				re.clear();
			}
		}
	}
	public static boolean isin(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
	static class Cctv{
		int x,y;
		int num;
		public Cctv(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}

	}
}
