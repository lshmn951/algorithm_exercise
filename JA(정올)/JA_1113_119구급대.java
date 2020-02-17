package algo_exercise.JA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JA_1113_119구급대 {
	static int[] dirs1 = {1,-1};
	static int m,n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Table> que = new LinkedList<>();
		m = sc.nextInt();
		n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int [][] arr = new int[m][n];
		int [][] visit = new int[m][n];
		for(int i=0;i<m;i++) {
			Arrays.fill(visit[i],1000);
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		visit[0][0] = 1;
		if(arr[0][1]==1) {
			que.add(new Table(0,1,0,0));
			visit[0][1] = 1;
		}
		if(arr[1][0]==1) {
			que.add(new Table(1,0,1,0));
			visit[1][0] = 1;
		}
		while(!que.isEmpty()) {
			Table temp = que.poll();
			if(temp.x==r && temp.y==c) {
				continue;
			}
			else {
				for(int i=0;i<2;i++) {
					int x = temp.x +dirs1[i];
					int y = temp.y;
					if(isin(x,y)&&arr[x][y]==1) {
						if(temp.dir==0) {
							if(visit[x][y]>temp.curve+1) {
								que.add(new Table(x,y,1,temp.curve+1));
								visit[x][y] = temp.curve+1;
							}
						}
						else {
							if(visit[x][y]>temp.curve) {
								que.add(new Table(x,y,1,temp.curve));
								visit[x][y] = temp.curve;
							}
						}
					}
					x = temp.x;
					y = temp.y + dirs1[i];
					if(isin(x,y) && arr[x][y]==1) {
						if(temp.dir==0) {
							if(visit[x][y]>temp.curve) {
								que.add(new Table(x,y,0,temp.curve));
								visit[x][y]=temp.curve;
							}
						}
						else {
							if(visit[x][y]>temp.curve+1) {
								que.add(new Table(x,y,0,temp.curve+1));
								visit[x][y] =temp.curve+1;
							}
						}
					}
				}
			}
		}
		System.out.println(visit[r][c]);
	}
	static class Table{
		int x,y;
		int dir;
		int curve;
		public Table(int x, int y, int dir, int curve) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.curve = curve;
		}
	}
	public static boolean isin(int x,int y) {
		return x>=0 && y>=0 && x<m && y<n;
	}
}
