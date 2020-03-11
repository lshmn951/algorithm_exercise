package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//MST (최소신장트리 문제)
//Kruskal(크루스칼) - union_find 기법을 이용한 풀이

public class SWEA_1251_하나로_kruskal {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			long [] px = new long [n];
			long [] py = new long [n];
			int []p = new int [n];
			List<Link> lists = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				px[i] = Long.parseLong(st.nextToken());
				p[i] = -1;
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				py[i] = Long.parseLong(st.nextToken());
			}
			double e = Double.parseDouble(br.readLine());
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					long distx = (px[i] - px[j]) * (px[i] - px[j]);
					long disty = (py[i] - py[j]) * (py[i] - py[j]);
					lists.add(new Link(i,j,distx+disty));
				}
			}
			Collections.sort(lists);
			int cnt = 0;
			long res = 0;
			for(int i=0;i<lists.size();i++) {
				Link temp = lists.get(i);
				if(!group(temp.x,temp.y,p)) {
					continue;
				}
				res+=temp.cost;
				cnt++;
				if(cnt==n-1) break;
			}
			System.out.print("#"+tc+" ");
			System.out.println(Math.round(res*e));
		}
	}
	public static boolean group(int u,int v,int []p) {
		u = find(u,p);
		v = find(v,p);
		if(u==v) {
			return false;
		}
		if(p[u]==p[v]) {
			p[u]--;
		}
		if(p[u]<p[v]) {
			p[v] = u;
		}
		else {
			p[u] = v;
		}
		return true;
	}
	public static int find(int x,int []p) {
		if(p[x]<0) {
			return x;
		}
		return p[x] = find(p[x],p);
	}
	static class Link implements Comparable<Link>{
		int x,y;
		long cost;
		@Override
		public int compareTo(Link o) {
			if(this.cost<o.cost) {
				return -1;
			}
			else {
				return 1;
			}
		}
		public Link(int x, int y, long cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Link [x=" + x + ", y=" + y + ", cost=" + cost + "]";
		}
	}
}