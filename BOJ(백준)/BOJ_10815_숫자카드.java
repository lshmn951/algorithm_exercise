package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int N = Integer.parseInt(bf.readLine());
		int []arr = new int [N];
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<M;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(Arrays.binarySearch(arr, temp)>-1) {
				sb.append(1).append(" ");
			}
			else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
		
	}
}
