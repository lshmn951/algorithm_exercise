package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {
	static int n,m,k;
	static int [][] arr;
	static int [][] arr2;
	static Deque<Integer> [][] trees;
	static int [][] dirs= {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
	static int alive=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int [n+1][n+1];
		arr2 = new int [n+1][n+1];
		trees = new Deque [n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				trees[i][j] = new ArrayDeque<Integer>();
			}
		}
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = 5;
			}
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			trees[x][y].add(z);
			alive++;
		}
		
		for(int i=0;i<k;i++) {
			year();
		}
		System.out.println(alive);
	}
	public static void year() {
		for(int i=1;i<n+1;i++) {//봄
			for(int j=1;j<n+1;j++) {
				int size = trees[i][j].size();
				int num =0;
				for(int q=0;q<size;q++) {
					int temp = trees[i][j].peek();
					if(arr[i][j]<temp) {
						break;
					}
					else {
						arr[i][j] -=temp;
						trees[i][j].pop();
						trees[i][j].add(temp+1);
						num++;
					}
				}
				for(int q=0;q<size-num;q++) {
					int temp = trees[i][j].pop();
					arr[i][j] += temp/2;
					alive--;
				}
			}
		}
		for(int i=1;i<n+1;i++) {//가을
			for(int j=1;j<n+1;j++) {
				int size = trees[i][j].size();
				for(int q=0;q<size;q++) {
					int temp = trees[i][j].pop();
					if(temp%5==0) {
						for(int d=0;d<8;d++) {
							int r = i+dirs[d][0];
							int c = j+dirs[d][1];
							if(!isin(r,c)) {
								continue;
							}
							trees[r][c].push(1);
							alive++;
						}
					}
					trees[i][j].add(temp);
				}
				
			}
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				arr[i][j] +=arr2[i][j];
			}
		}
	}
	public static boolean isin(int x, int y) {
		return x>0 && y>0 && x<=n && y<=n;
	}
}
