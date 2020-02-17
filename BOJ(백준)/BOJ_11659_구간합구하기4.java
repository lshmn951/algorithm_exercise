package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(sc.nextToken());
		int M = Integer.parseInt(sc.nextToken());
		int arr[] = new int [N];
		sc = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(sc.nextToken());
		}
		int sum[] = new int [N+1];
		sum[1] = arr[0];
		sum[0] = 0;
		for(int i=1;i<=arr.length;i++) {
			sum[i] = sum[i-1] + arr[i-1];
		}
		for(int tc=0; tc<M;tc++) {
			sc = new StringTokenizer(bf.readLine());
			int i = Integer.parseInt(sc.nextToken());
			int j = Integer.parseInt(sc.nextToken());
			
			sb.append(sum[j]-sum[i-1]+ "\n");
		}
		System.out.println(sb);
	}

}
