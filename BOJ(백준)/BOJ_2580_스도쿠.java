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
 * @see https://www.acmicpc.net/problem/2580
 * @mem
 * @time
 * @caution 숫자를 넣어도 되는지 체크하고 재귀 돌리는 백트래킹
 * 			1~9까지 넣었는데 안되면 0으로 초기화해서 먼저 불린 재귀가 다시 돌아가게 해줘야함
 */
public class BOJ_2580_스도쿠 {
	static int [][] arr= new int[10][10];
	static List<Point> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		list = new ArrayList<>();
		for(int i=1;i<=9;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1;j<=9;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) {
					list.add(new Point(i,j));
				}
			}
		}
		
		per(list.size(),0);
	}
	static class Point{
		int x,y;

		public Point(int x, int y) {

			this.x = x;
			this.y = y;
		}

		
	}
	public static boolean per(int r,int k) {
		
		if(r==k) {
			for(int i=1;i<=9;i++) {
				for(int j=1;j<=9;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			return true;
		}
		else {
			Point t = list.get(k);
			for(int i=1;i<=9;i++) {
				arr[t.x][t.y]= i;
				if(promising(t.x, t.y)) {
					if(per(r,k+1)) {
						return true;
					}
				}
			}
			arr[t.x][t.y]=0;
		}
		return false;
	}
	public static boolean promising(int r,int c) {
	
		int [] visit = new int [10];
		for(int i=1;i<=9;i++) {
			visit[arr[r][i]]++;
			if(arr[r][i]!=0 && visit[arr[r][i]]>1) {
				return false;
			}
		}

		Arrays.fill(visit, 0);
		for(int i=1;i<=9;i++) {
			visit[arr[i][c]]++;
			if(arr[i][c]!=0 && visit[arr[i][c]]>1) {
				return false;
			}
		}

		Arrays.fill(visit, 0);
		if(r>=1 && r<=3) {
			if(c>=1 && c<=3) {
				for(int i=1;i<=3;i++) {
					for(int j=1;j<=3;j++) {
						visit[arr[i][j]]++;
						if(arr[i][j]!=0 && visit[arr[i][j]]>1) {
							return false;
						}
					}
				}
			}
			else if(c>=4 && c<=6) {
				for(int i=1;i<=3;i++) {
					for(int j=4;j<=6;j++) {
						visit[arr[i][j]]++;
						if(arr[i][j]!=0 && visit[arr[i][j]]>1) {
							return false;
						}
					}
				}
			}
			else {
				for(int i=1;i<=3;i++) {
					for(int j=7;j<=9;j++) {
						visit[arr[i][j]]++;
						if(arr[i][j]!=0 && visit[arr[i][j]]>1) {
							return false;
						}
					}
				}
			}
		}
		else if(r>=4 && r<=6) {
			if(c>=1 && c<=3) {
				for(int i=4;i<=6;i++) {
					for(int j=1;j<=3;j++) {
						visit[arr[i][j]]++;
						if(arr[i][j]!=0 && visit[arr[i][j]]>1) {
							return false;
						}
					}
				}
			}
			else if(c>=4 && c<=6) {
				for(int i=4;i<=6;i++) {
					for(int j=4;j<=6;j++) {
						visit[arr[i][j]]++;
						if(arr[i][j]!=0 && visit[arr[i][j]]>1) {
							return false;
						}
					}
				}
			}
			else {
				for(int i=4;i<=6;i++) {
					for(int j=7;j<=9;j++) {
						visit[arr[i][j]]++;
						if(arr[i][j]!=0 && visit[arr[i][j]]>1) {
							return false;
						}
					}
				}
			}
		}
		else {
			if(c>=1 && c<=3) {
				for(int i=7;i<=9;i++) {
					for(int j=1;j<=3;j++) {
						visit[arr[i][j]]++;
						if(arr[i][j]!=0 && visit[arr[i][j]]>1) {
							return false;
						}
					}
				}
			}
			else if(c>=4 && c<=6) {
				for(int i=7;i<=9;i++) {
					for(int j=4;j<=6;j++) {
						visit[arr[i][j]]++;
						if(arr[i][j]!=0 && visit[arr[i][j]]>1) {
							return false;
						}
					}
				}
			}
			else {
				for(int i=7;i<=9;i++) {
					for(int j=7;j<=9;j++) {
						visit[arr[i][j]]++;
						if(arr[i][j]!=0 && visit[arr[i][j]]>1) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}
}
