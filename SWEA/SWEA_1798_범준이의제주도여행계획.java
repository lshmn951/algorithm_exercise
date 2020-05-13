package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1798_범준이의제주도여행계획 {
	static int N,M;
	static int [][]graph;
	static char [] point;
	static int [][] score;
	static List<Integer> temp;
	static List<Integer> res;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new int [N+1][N+1];
			point = new char [N+1];
			score = new int [N+1][2];
			temp = new ArrayList<Integer>();
			res = new ArrayList<Integer>();
			max = 0;
			for(int i=1;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=i+1;j<=N;j++) {
					graph[i][j] = graph[j][i] =  Integer.parseInt(st.nextToken());
				}
			}
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				point[i] = st.nextToken().charAt(0);
				if(point[i]=='P') {
					score[i][0] = Integer.parseInt(st.nextToken());
					score[i][1] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(1,new boolean[N+1],0,1,0);
			System.out.print("#"+tc+" ");
			if(max==0) {
				System.out.println(0);
			}else {
				System.out.print(max+" ");
				for(int i=0;i<res.size();i++) {
					System.out.print(res.get(i)+" ");
				}
				System.out.println();
			}
		}
	}
	public static void dfs(int k,boolean []visit,int sco,int cur,int time) {
		if(M==k && time<=540 && cur==1) {
			// 마지막 날 공항에 도착한 경우
			if(max<sco) {
				// 만족도가 더 높으면 새롭게 갱신
				max = sco;
				res.clear();
				for(int i=0;i<temp.size();i++) {
					res.add(temp.get(i));
				}
				return;
			}
		}
		boolean flag = false;// 하루 일과를 끝마칠 경우를 표시할 플래그
		for(int i=1;i<=N;i++) {
			if(cur!=i) {
				if(point[i]=='P') {
					// 관광포인트 순회
					int sum = time+graph[cur][i]+score[i][0];
					if(sum<=540 && !visit[i]) {
						flag = true;
						visit[i] = true;
						temp.add(i);
						dfs(k,visit,sco+score[i][1],i,sum);
						temp.remove(temp.size()-1);
						visit[i] = false;
					}
				}
			}
		}
		if(!flag && point[cur]=='P' && M!=k) {
			// 마지막 날이 아니면서 하루 일과를 끝마칠때는 호텔에 가야한다
			for(int i=1;i<=N;i++) {
				if(point[i]=='H') {
					int sum = time+graph[cur][i];
					if(sum<=540) {
						temp.add(i);
						dfs(k+1,visit,sco,i,0);
						temp.remove(temp.size()-1);
					}
				}
			}
		}
		if(!flag && point[cur]=='P' && M==k) {
			// 마지막 날 이면서 하루 일과를 끝마칠때는 공항에 가야한다.
			int sum = time+graph[cur][1];
			if(sum<=540) {
				temp.add(1);
				dfs(k,visit,sco,1,sum);
				temp.remove(temp.size()-1);
			}
		}
	}
}
