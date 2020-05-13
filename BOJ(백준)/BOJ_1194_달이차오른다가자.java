package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char [][] maze = new char[N][M];
		int res = -1;
		boolean [][][] visit = new boolean[N][M][64];
		int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
		Queue<MS> que = new LinkedList<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine(); 
			for(int j=0;j<M;j++) {
				maze[i][j] = str.charAt(j);
				if(maze[i][j]=='0') {
					que.add(new MS(i,j,0,0));
				}
			}
		}
		while(!que.isEmpty()) {
			MS temp = que.poll();
			if(maze[temp.x][temp.y]=='1') {
				//탈출할 수 있다면 이동횟수 저장후 탈출
				res = temp.cnt;
				break;
			}
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(r<0||c<0||r>=N||c>=M) {
					//범위를 벗어난 경우 무시
					continue;
				}
				if(maze[r][c]=='#') {
					//벽을 만난 경우 무시
					continue;
				}
				if(maze[r][c]>='a' && maze[r][c]<='f') {
					// key를 만난 경우 key값 저장
					int k = temp.key|(1<<(maze[r][c]-'a'));
					if(!visit[r][c][k]) {
						visit[r][c][k] = true;
						que.add(new MS(r,c, temp.cnt+1, k));
					}
				}
				else if(maze[r][c]>='A'&&maze[r][c]<='F') {
					// 문을 만난 경우 해당 key를 가지고 있다면 이동
					int d = 1<<(maze[r][c]-'A');
					if( (temp.key & d) > 0 && !visit[r][c][temp.key]) {
						visit[r][c][temp.key] = true;
						que.add(new MS(r, c, temp.cnt+1, temp.key));
					}
				}else {
					// 그 이외엔 평범하게 이동
					if(!visit[r][c][temp.key]) {
						visit[r][c][temp.key] = true;
						que.add(new MS(r,c,temp.cnt+1,temp.key));
					}
				}
			}
		}
		System.out.println(res);
	}
	public static class MS{
		int x,y;
		int cnt;
		int key;
		public MS(int x, int y, int cnt, int key) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
		
	}
}
