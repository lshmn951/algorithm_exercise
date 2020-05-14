package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {
	static int n,m;
	static List<Integer> [] high;
	static List<Integer> [] low;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			high = new List[n+1];
			low = new List[n+1];
			int answer = 0;
			for(int i=0;i<=n;i++) {
				high[i] = new ArrayList<Integer>();
				low[i] = new ArrayList<Integer>();
			}
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int in1 = Integer.parseInt(st.nextToken());
				int in2 = Integer.parseInt(st.nextToken());
				high[in1].add(in2);
				low[in2].add(in1);
			}
			for(int i=1;i<=n;i++) {
				int res = highCheck(i,new boolean[n+1])+lowCheck(i, new boolean[n+1]);
				if(res==n-1) {
					answer++;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	public static int highCheck(int cur,boolean []visit) {
		int sum=0;
		for(int i=0;i<high[cur].size();i++) {
			int child = high[cur].get(i);
			if(!visit[child]) {
				visit[child] = true;
				sum++;
				sum+=highCheck(child,visit);
			}
			
		}
		return sum;
	}
	public static int lowCheck(int cur,boolean []visit) {
		int sum=0;
		for(int i=0;i<low[cur].size();i++) {
			int child = low[cur].get(i);
			if(!visit[child]) {
				visit[child] = true;
				sum++;
				sum+=lowCheck(child,visit);
			}
		}
		return sum;
	}
}
