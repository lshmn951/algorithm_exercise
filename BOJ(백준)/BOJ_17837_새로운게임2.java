package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 19.
 * @see https://www.acmicpc.net/problem/17837
 * @mem
 * @time
 * @caution 시뮬레이션
 * 			말 객체를 링크드 리스트 형태로 구현 말의 위와 아래를 연결해주고
 * 			이동할때 자신과 연결된 말들을 함께 이동시킨다.
 * 			말을 이동시킬때 모든 말의 좌표를 안바꿔준 것 때문에 고생 좀 했다.... 
 * 			좌표에 해당하는 말의 수를 표현하는 nums배열과
 * 			해당 좌표의 가장 꼭대기에 해당하는 말 번호를 표현하는 count배열을 씀 
 */

public class BOJ_17837_새로운게임2 {
	static int N,K;
	static int [][] arr;
	static int [][] count;
	static int[][] dirs = {{0,0}, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static Horse [] horses;
	static int [][] nums;
	static int cnt;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int [N+1][N+1];
		count = new int [N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		horses = new Horse[K+1];
		for(int i=1;i<=K;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			count[x][y] = i;
			horses[i] = new Horse(x,y,dir,i,null,null);
		}
		cnt=1;

		while(cnt<=1000) {
			if(!turn()) {
				break;
			}
			cnt++;
		}
		if(cnt>1000) {
			System.out.println(-1);
		}
		else {
			System.out.println(cnt);
		}
	}
	public static boolean turn() {
		for(int h=1;h<=K;h++) {
			int r = horses[h].x+dirs[horses[h].dir][0];
			int c = horses[h].y+dirs[horses[h].dir][1];
			if(!isin(r,c)||arr[r][c]==2) {
				r = horses[h].x-dirs[horses[h].dir][0];
				c = horses[h].y-dirs[horses[h].dir][1];
				if(horses[h].dir==1) {
					horses[h].dir = 2;
				}
				else if(horses[h].dir==2) {
					horses[h].dir = 1;
				}
				else if(horses[h].dir==3) {
					horses[h].dir = 4;
				}
				else if(horses[h].dir==4) {
					horses[h].dir = 3;
				}
				if(!isin(r,c)||arr[r][c]==2) {
					continue;
				}
			}

			if(horses[h].down!=null) {
				count[horses[h].x][horses[h].y] = horses[h].down.num;
				horses[h].down.up = null;
				horses[h].down = null;
			}
			else {
				count[horses[h].x][horses[h].y] = 0;
			}
			
			horses[h].x = r;
			horses[h].y = c;
			
			if(arr[r][c]==0) {
				if(count[r][c]==0) {
					Horse temp = horses[h];
					while(true) {
						count[r][c] = temp.num;
						temp.x = r;
						temp.y = c;
						if(temp.up==null) {
							break;
						}
						temp = temp.up;
					}
				}
				else {
					horses[count[r][c]].up = horses[h];
					horses[h].down = horses[count[r][c]];
					Horse temp = horses[h];
					while(true) {
						count[r][c] = temp.num;
						temp.x = r;
						temp.y = c;
						if(temp.up==null) {
							break;
						}
						temp = temp.up;
					}
				}
			}
			if(arr[r][c]==1) {
				if(count[r][c]==0) {
					if(horses[h].up==null) {
						count[r][c] = h;
					}
					else {
						Horse temp = horses[h].up;
						horses[h].up = null;
						horses[h].down = temp;
						while(temp.down!=null) {
							Horse t = temp.down;
							temp.x = r;
							temp.y = c;
							temp.down = temp.up;
							temp.up = t;
							if(temp.down==null) {
								break;
							}
							temp = temp.down;
						}
						count[r][c] = h;
					}
				}
				else {
					if(horses[h].up==null) {
						horses[count[r][c]].up = horses[h];
						horses[h].down = horses[count[r][c]];
						count[r][c] = h;
					}
					else {
						Horse temp = horses[h].up;
						horses[h].up = null;
						horses[h].down = temp;
						while(temp.down!=null) {
							Horse t = temp.down;
							temp.x = r;
							temp.y = c;
							temp.down = temp.up;
							temp.up = t;
							if(temp.down==null) {
								break;
							}
							temp = temp.down;
						}
						horses[count[r][c]].up = temp;
						temp.down = horses[count[r][c]];
						count[r][c] = h;
					}

				}
			}
			nums = new int [N+1][N+1];
			for(int i=1;i<=K;i++) {
				nums[horses[i].x][horses[i].y]++;
			}
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(nums[i][j]>=4) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public static boolean isin(int x, int y) {
		return x > 0 && y > 0 && x <= N && y <= N;
	}
	static class Horse{
		int x,y,dir;
		int num;
		Horse up;
		Horse down;
		public Horse(int x, int y, int dir,int num, Horse up, Horse down) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
			this.up = up;
			this.down = down;
		}
	}
}
