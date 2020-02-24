package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {
	static int f,s,g,u,d;
	static boolean [] visit;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Move >que = new LinkedList<>();
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		visit = new boolean [f+1];
		que.add(new Move(s,0));
		int num=-1;
		visit[s]=true;
		while(!que.isEmpty()) {
			Move temp = que.poll();
			if(temp.x==g) {
				num = temp.y;
				break;
			}
			if(temp.x+u<=f && !visit[temp.x+u]) {
				visit[temp.x+u]=true;
				que.add(new Move(temp.x+u,temp.y+1));
			}
			if(temp.x-d>0&&!visit[temp.x-d]) {
				visit[temp.x-d]=true;
				que.add(new Move(temp.x-d,temp.y+1));
			}
		}
		if(num==-1) {
			System.out.println("use the stairs");
		}
		else {
			System.out.println(num);
		}
	}
	static class Move{
		int x,y;

		public Move(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
