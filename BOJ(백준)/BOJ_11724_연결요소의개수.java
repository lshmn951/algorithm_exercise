package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
	static int[][]arr;
	static boolean[] visit;
	static int N,M;
	static int sum=0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N+1][N+1];
		visit = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int in1 = Integer.parseInt(st.nextToken());
			int in2 = Integer.parseInt(st.nextToken());
			arr[in1][in2] = 1;
		}
		for(int i=1;i<=N;i++) {
			if(!visit[i]) {
				dfs(i);
				sum++;
			}
		}
		System.out.println(sum);
	}
	public static void dfs(int k) {
		visit[k] = true;
		for(int i=1;i<=N;i++) {
			if(arr[k][i]==1) {
				arr[k][i]=0;
				dfs(i);
			}
			if(arr[i][k]==1) {
				arr[i][k]=0;
				dfs(i);
			}
		}
	}
}
