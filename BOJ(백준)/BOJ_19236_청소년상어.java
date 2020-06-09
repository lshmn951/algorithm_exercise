package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 백준 BOJ 청소년 상어
public class BOJ_19236_청소년상어 {
	static int [][] dirs8 = {{0,0},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	static int ans;
	static int [][] map;
	static Fish shark;
	static Fish [] fish;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ans = 0;
		map = new int [4][4];
		shark = new Fish(0, 0,0);
		fish = new Fish[17];
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				fish[a] = new Fish(i,j,b);
				map[i][j] = a;
				if(i==0&j==0) {
					map[i][j] = -1;
					ans+=a;
					shark.dir = b;
					fish[a].dir = 0;
				}
			}
		}
		dfs(0,0,ans);
		System.out.println(ans);
	}
	public static void dfs(int sx,int sy,int cnt) {
		ans = Math.max(ans, cnt);
		move();
		int [][] copy = new int [4][4];
		Fish [] fcopy = new Fish [17];
		for(int i=0;i<4;i++) { // dfs 를 위한 맵 복사
			copy[i] = map[i].clone();
		}
		for(int i=1;i<17;i++) { // dfs 를 위한 물고기 객체 복사
			fcopy[i] = new Fish(fish[i].x,fish[i].y,fish[i].dir);
		}
		while(true) { // 상어의 방향을 따라 한 곳씩 따로 방문
			shark.x += dirs8[shark.dir][0];
			shark.y += dirs8[shark.dir][1];
			if(shark.x<0||shark.x>=4||shark.y<0||shark.y>=4) {// 범위를 벗어난 경우 상어는 집으로 돌아감
				break;
			}
			if(map[shark.x][shark.y]==0) { // 빈칸일 경우 생략
				continue;
			}
			int x = shark.x;
			int y = shark.y;
			int dir = shark.dir;
			int temp = map[x][y];
			int d = fish[temp].dir;
			map[sx][sy] = 0;
			map[x][y] = -1;
			shark.dir = d;
			fish[temp].dir=0;
			dfs(x,y,cnt+temp);
			for(int i=0;i<4;i++) {
				map[i] = copy[i].clone();
			}
			for(int i=1;i<17;i++) {
				fish[i] = new Fish(fcopy[i].x,fcopy[i].y,fcopy[i].dir);
			}
			map[x][y] = temp;
			shark.x = x;
			shark.y = y;
			shark.dir = dir;
			fish[temp].dir = d;
		}
	}
	public static void move() {
		// 물고기 이동
		for(int i=1;i<=16;i++) {
			if(fish[i].dir==0) {// 상어한테 먹힌 물고기는 생략
				continue;
			}
			for(int j=0;j<8;j++) {
				int d = fish[i].dir;
				int r = fish[i].x+dirs8[d][0];
				int c = fish[i].y+dirs8[d][1];
				if(r<0||c<0||r>=4||c>=4||map[r][c]==-1) {// 범위를 벗어나거나 상어가 있는 곳은 이동 불가
					fish[i].dir++;
					if(fish[i].dir==9) {
						fish[i].dir=1;
					}
					continue;
				}
				if(map[r][c]==0) { // 이동할 곳이 빈칸인 경우
					map[r][c] = i;
					map[fish[i].x][fish[i].y] = 0;
					fish[i].x = r;
					fish[i].y = c;
				}else { // 이동할 곳에 물고기가 있는 경우 스왑
					swap(fish[i].x,fish[i].y,r,c);
				}
				break;
			}
		}
	}
	public static void swap(int x1,int y1,int x2,int y2) { // 스왑을 위해 map 배열과 해당 fish 객체 갱신
		fish[map[x1][y1]].x=x2;
		fish[map[x1][y1]].y=y2;
		fish[map[x2][y2]].x=x1;
		fish[map[x2][y2]].y=y1;
		int temp = map[x2][y2];
		map[x2][y2] = map[x1][y1];
		map[x1][y1] = temp;
	}
	public static class Fish{
		int x,y;
		int dir;
		public Fish(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
}
