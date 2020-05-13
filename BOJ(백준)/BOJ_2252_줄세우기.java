package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer> [] list = new List[n+1];
		int [] indegree = new int [n+1]; 
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=0;i<=n;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int j=0;j<m;j++) {
			st = new StringTokenizer(br.readLine());
			int in1 = Integer.parseInt(st.nextToken());
			int in2 = Integer.parseInt(st.nextToken());
			list[in1].add(in2);
			indegree[in2]++;
		}
		for(int i=1;i<=n;i++) {
			if(indegree[i]==0) {
				que.add(i);
			}
		}
		while(!que.isEmpty()) {
			int temp = que.poll();
			sb.append(temp).append(" ");
			for(int i=0;i<list[temp].size();i++) {
				int next = list[temp].get(i);
				if(--indegree[next]==0) {
					que.add(next);
				}
			}
		}
		System.out.println(sb);
	}

}
