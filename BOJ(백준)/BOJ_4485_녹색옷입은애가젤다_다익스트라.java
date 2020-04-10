package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다_다익스트라 {
	public static int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc=0;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			tc++;
			if(n==0) {
				break;
			}
			int arr[][] = new int [n][n];
			int dist[][] = new int [n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dist[0][0] = arr[0][0];
			PriorityQueue<Zelda> pq = new PriorityQueue<>();
			pq.add(new Zelda(0,0,dist[0][0]));
			while(!pq.isEmpty()) {
				Zelda temp = pq.poll();
				for(int i=0;i<4;i++) {
					int r = temp.x+dirs[i][0];
					int c = temp.y+dirs[i][1];
					if(r<0||c<0||r>=n||c>=n) {
						continue;
					}
					if(dist[r][c]>dist[temp.x][temp.y]+arr[r][c]) {
						dist[r][c] = dist[temp.x][temp.y]+ arr[r][c];
						pq.remove(temp);
						pq.add(new Zelda(r,c,dist[r][c]));
					}
				}
			}
			System.out.println("Problem "+tc+": "+dist[n-1][n-1]);
		}
	}
	static class Zelda implements Comparable<Zelda>{
		int x,y;
		int dist;
		public Zelda(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Zelda o) {
			if(this.dist<o.dist) {
				return -1;
			}
			else {
				return 1;
			}
		}
		
	}
}
