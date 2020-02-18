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

/**
 * 
 * @author 이성현
 * @since 2020. 2. 18.
 * @see https://www.acmicpc.net/problem/16236
 * @mem
 * @time
 * @caution BFS 응용 문제
 * 			시간초과는 무한루프일 경우에도 뜬다
 * 			상어의 위치도 방문처리 해주고
  			상어의 위치를 9로 표시하므로 상어의 크기와 9를 구분해주는게 필수
 */
public class BOJ_16236_아기상어 {
	static int n;
	static int [][] arr;
	static int [] feed = new int[7];
	static Shark shark;
	static boolean [][]visit;
	static boolean [][] svisit;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		arr  = new int[n][n];
		svisit = new boolean[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>0 && arr[i][j]<7) {
					feed[arr[i][j]]++;
				}
				if(arr[i][j]==9) {
					shark = new Shark(i,j,2,0,0);
				}
			}
		}
		while(check()) {
			if(!svisit[shark.x][shark.y]) {
				bfs();
			}
			else {
				break;
			}
		}
		System.out.println(shark.cnt);
	}
	public static void bfs() {
		int x=0,y=0;
		boolean b= false;
		int count=0;
		visit = new boolean [n][n];
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(shark.x,shark.y,0));
		visit[shark.x][shark.y] = true;
		svisit[shark.x][shark.y] = true;
		while(!que.isEmpty()) {
			Point temp = que.poll();
			if(count!=0 && temp.cnt>count) {
				continue;
			}
			
			if(arr[temp.x][temp.y]!=0&&arr[temp.x][temp.y]<shark.cur) {
				if(!b) {
					x= temp.x;
					y= temp.y;
					count = temp.cnt;
					b = true;
				}
				else {
					if(temp.cnt<count) {
						x = temp.x;
						y = temp.y;
						count = temp.cnt;
					}
					else if(temp.cnt==count) {
						if(temp.x<x) {
							y = temp.y;
							x = temp.x;
						}
						else if(temp.x==x) {
							if(temp.y<y) {
								x = temp.x;
								y = temp.y;
							}
						}
						
					}
				}
				
				continue;
			}
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(!isin(r,c)) {
					continue;
				}
				if(!visit[r][c] && arr[r][c]<=shark.cur) {
					visit[r][c] = true;
					que.add(new Point(r,c,temp.cnt+1));
				}
			}
		}
		
		if(b) {
			arr[shark.x][shark.y]=0;
			if(shark.cur<7) {
				shark.f++;
				if(shark.f==shark.cur) {
					shark.cur++;
					shark.f=0;
				}
			}
			shark.x= x;
			shark.y = y;
			shark.cnt+=count;
			feed[arr[x][y]]--;
			arr[x][y] = 9;
		}
	}
	public static boolean check() {
		for(int i=1;i<shark.cur;i++) {
			if(feed[i]>0) {
				return true;
			}
		}
		return false;
	}
	public static boolean isin(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n;
	}
	static class Point {
		int x, y;
		int cnt;
		public Point(int x, int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static class Shark{
		int x,y;
		int cur;
		int f;
		int cnt;
		public Shark(int x, int y, int cur, int f,int cnt) {
			this.x = x;
			this.y = y;
			this.cur = cur;
			this.f = f;
			this.cnt = cnt;
		}
	}
}
/*
 * 반례 모음 https://www.acmicpc.net/board/view/42021
 * 시간 초과 반례
 * 10
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 9

 */
