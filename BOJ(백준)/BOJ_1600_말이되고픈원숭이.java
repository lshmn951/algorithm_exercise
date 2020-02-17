package algo_exercise.BOJ;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 10.
 * @see https://www.acmicpc.net/problem/1600
 * @mem
 * @time
 * @caution
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	static int K,W,H;
	static int [][]arr;
	static int [][] horse = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
	static int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean [][][] visit;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Monkey> que = new LinkedList<Monkey>();
		int result=-1;
		K = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		visit = new boolean [H][W][31];
		
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<W;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		que.add(new Monkey(0,0,0,0));
		while(!que.isEmpty()) {
			Monkey temp = que.poll();
			if(temp.x==H-1 && temp.y==W-1) {
				result = temp.hor+temp.dir;
				while(!que.isEmpty()) {
					que.poll();
				}
			}
			else {
				if(temp.hor<K) {
					for(int i=0;i<8;i++) {
						int r = temp.x+horse[i][0];
						int c = temp.y+horse[i][1];
						if(isin(r,c)&&arr[r][c]==0&&!visit[r][c][temp.hor+1]) {
							que.add(new Monkey(r,c,temp.hor+1,temp.dir));
							visit[r][c][temp.hor+1] =true;
						}
					}
				}
				for(int i=0;i<4;i++) {
					int r = temp.x+dirs[i][0];
					int c = temp.y+dirs[i][1];
					if(isin(r,c)&&arr[r][c]==0&&!visit[r][c][temp.hor]) {
						que.add(new Monkey(r,c,temp.hor,temp.dir+1));
						visit[r][c][temp.hor]=true;
					}
				}
			}
		}
		System.out.println(result);
	}
	
	static class Monkey{
		int x,y;
		int hor;
		int dir;
		public Monkey(int x, int y, int hor, int dir) {
			this.x = x;
			this.y = y;
			this.hor = hor;
			this.dir = dir;
		}
	}
	public static boolean isin(int r,int c) {
		return r>=0 && c>=0 && r<H && c<W;
	}
}