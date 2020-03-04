package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_7988_내전경기 {
	static List<Integer> []effect;
	static boolean []team;
	static boolean []visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<String > list = new ArrayList<String>();
		List<Member> lists = new ArrayList<>();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int k = Integer.parseInt(br.readLine());
			list = new ArrayList<String>();
			lists = new ArrayList<>();
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				if(list.indexOf(s1)==-1) {
					list.add(s1);
				}
				if(list.indexOf(s2)==-1) {
					list.add(s2);
				}
				lists.add(new Member(s1,s2));
			}
			effect = new List[list.size()];
			team = new boolean[list.size()];
			visit = new boolean[list.size()];
			for(int i=0;i<list.size();i++) {
				effect[i] = new ArrayList<Integer>();
			}
			for(int i=0;i<lists.size();i++) {
				String s1 = lists.get(i).str1;
				String s2 = lists.get(i).str2;
				int in1 = 0;
				int in2 = 0;
				for(int j=0;j<list.size();j++) {
					if(s1.equals(list.get(j))) {
						in1 = j;
					}
					else if(s2.equals(list.get(j))) {
						in2 = j;
					}
				}
				effect[in1].add(in2);
				effect[in2].add(in1);
			}
			for(int i=0;i<team.length;i++) {
				if(!visit[i]) {
					visit[i] = true;
					dfs(i,true);
				}
			}
			boolean yes=true;
			for(int i=0;i<effect.length;i++) {
				for(int j=0;j<effect[i].size();j++) {
					int q = effect[i].get(j);
					if(team[i]==team[q]) {
						yes = false;
					}
				}
			}
			System.out.print("#"+tc+" ");
			System.out.println(yes?"Yes":"No");
		}
	}
	public static void dfs(int cur,boolean b) {
		team[cur] = b;
		for(int i=0;i<effect[cur].size();i++) {
			int des = effect[cur].get(i);
			if(!visit[des]) {
				visit[des] = true;
				dfs(des,!b);
			}
		}
	}
	static class Member{
		String str1;
		String str2;
		public Member(String str1, String str2) {
			this.str1 = str1;
			this.str2 = str2;
		}
	}
}
