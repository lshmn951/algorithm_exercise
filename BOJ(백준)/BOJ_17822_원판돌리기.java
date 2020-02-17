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
 * @since 2020. 2. 17.
 * @see https://www.acmicpc.net/problem/17822
 * @mem
 * @time
 * @caution 시뮬레이션  - 리스트로 구현하면 틀렸다고 나오고 2차원배열로 구현하니까 맞음
 */
public class BOJ_17822_원판돌리기 {
	static int N,M,T;
	static int [][] arr;
	static int result = 0;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		arr = new int [N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			revolve(x,d,k);
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]>0) {
					result += arr[i][j];
				}
			}
		}
		System.out.println(result);
	}
	public static void revolve(int x,int d,int k) {
		int temp;
		if(d==0) {
			for(int i=x-1;i<N;i+=x) {
				for(int j=0;j<k;j++) {
					temp = arr[i][M-1];
					for(int q=M-1;q>0;q--) {
						arr[i][q] = arr[i][q-1];
					}
					arr[i][0] = temp;
				}
			}
		}
		else {
			for(int i=x-1;i<N;i+=x) {
				for(int j=0;j<k;j++) {
					temp = arr[i][0];
					for(int q=0;q<M-1;q++) {
						arr[i][q] = arr[i][q+1];
					}
					arr[i][M-1] = temp;
				}
			}
		}
		
		remove();
	}
	public static void remove() {
		List<Point> l = new ArrayList<>();
		double sum = 0;
		int cnt = 0 ;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=-1) {
					for(int q=0;q<4;q++) {
						int r = i+dirs[q][0];
						int c = j+dirs[q][1];
						if(r<0 || r>=N) {
							continue;
						}
						if(c==-1) {
							c = M-1;
						}
						if(c==M) {
							c = 0;
						}
						if(arr[r][c]==arr[i][j]) {
							l.add(new Point(i,j));
							break;
						}
					}
					sum+=arr[i][j];
					cnt++;
				}
			}
		}
		if(l.size()==0) {
			sum /= cnt;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]!=-1 && arr[i][j]>sum) {
						arr[i][j]--;
					}
					else if(arr[i][j]!=-1 && arr[i][j]<sum) {
						arr[i][j]++;
					}
				}
			}
		}
		else {
			for(int i=0;i<l.size();i++) {
				Point temp = l.get(i);
				arr[temp.x][temp.y] = -1; 
			}
		}
	}
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
