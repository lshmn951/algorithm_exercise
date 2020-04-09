package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_1197_최소스패닝트리 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		PriorityQueue<Tree> pq = new PriorityQueue<>();
		int res = 0;
		int p[] = new int [v+1];
		for(int i=0;i<=v;i++) {
			p[i] = i;
		}
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Tree(a,b,c));
		}
		while(!pq.isEmpty()) {
			Tree temp = pq.poll();
			if(!union(temp.a,temp.b,p)) {
				continue;
			}
			res += temp.c;
		}
		System.out.println(res);
	}
	public static int find(int x,int[]p) {
		if(x==p[x]) {
			return x;
		}
		else {
			return p[x] = find(p[x],p);
		}
	}
	public static boolean union(int x,int y,int[]p) {
		int u = find(x,p);
		int v = find(y,p);
		if(u==v) {
			return false;
		}
		else {
			p[v] = p[u];
		}
		return true;
	}
	static class Tree implements Comparable<Tree>{
		int a,b;
		int c;
		public Tree(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Tree o) {
			if(this.c<o.c) {
				return -1;
			}
			else {
				return 1;
			}
		}
		
	}
}
