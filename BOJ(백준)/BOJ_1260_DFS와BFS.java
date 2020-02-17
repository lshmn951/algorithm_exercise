package algo_exercise.BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1260_DFS와BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<Integer>();
		Queue<Integer> que = new LinkedList<Integer>();
		ArrayList<Integer> path = new ArrayList<>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		int [][] arr= new int [n+1][n+1];
		boolean [] visit = new boolean[n+1];
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		st.push(v);
		while(!st.isEmpty()) {
			int temp = st.pop();
			if(visit[temp]) {
				continue;
			}
			path.add(temp);
			visit[temp] = true;
			for(int i=n;i>0;i--) {
				if(arr[temp][i]==1 && !visit[i]) {
					st.push(i);
				}
			}
		}
		for(int i=0;i<path.size();i++) {
			System.out.print(path.get(i)+" ");
		}
		System.out.println();
		Arrays.fill(visit, false);
		path = new ArrayList<>();
		que.add(v);
		while(!que.isEmpty()) {
			int temp = que.poll();
			if(visit[temp]) {
				continue;
			}
			path.add(temp);
			visit[temp] = true;
			for(int i=1;i<=n;i++) {
				if(arr[temp][i]==1 && !visit[i]) {
					que.add(i);
				}
			}
		}
		for(int i=0;i<path.size();i++) {
			System.out.print(path.get(i)+" ");
		}
	}

}
