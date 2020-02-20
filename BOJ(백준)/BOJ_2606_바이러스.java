package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 
 * @author 이성현
 * @since 2020. 2. 19.
 * @see https://www.acmicpc.net/problem/2606
 * @mem
 * @time
 * @caution bfs 그래프
 */
public class BOJ_2606_바이러스 {
	static int [][] arr;
	static boolean [] visit;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		int k = Integer.parseInt(bf.readLine());
		arr = new int [N+1][N+1];
		visit = new boolean [N+1];
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(1);
		while(!que.isEmpty()) {
			int temp = que.poll();
			if(visit[temp]) {
				continue;
			}
			visit[temp] = true;
			for(int i=1;i<=N;i++) {
				if(arr[temp][i]==1) {
					que.add(i);
				}
			}
		}

		int result = 0;
		for(int i=1;i<=N;i++) {
			if(visit[i]) {
				result++;
			}
		}
		if(result>0) {
			result--;
		}
		System.out.println(result);
	}

}
