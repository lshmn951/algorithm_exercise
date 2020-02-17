package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(sc.nextToken());
		int M = Integer.parseInt(sc.nextToken());
		int sums[][] = new int [N+1][N+1];
		for(int i=1;i<=N;i++) {
			sc = new StringTokenizer(bf.readLine());
			for(int j=1;j<=N;j++) {
				sums[i][j] = sums[i][j-1]+sums[i-1][j]-sums[i-1][j-1]+Integer.parseInt(sc.nextToken());
			}
		}
		for(int i=0;i<M;i++) {
			sc = new StringTokenizer(bf.readLine());
			int x1,y1,x2,y2;
			x1 = Integer.parseInt(sc.nextToken());
			y1 = Integer.parseInt(sc.nextToken());
			x2 = Integer.parseInt(sc.nextToken());
			y2 = Integer.parseInt(sc.nextToken());
			int temp = sums[x2][y2] - sums[x2][y1-1]-sums[x1-1][y2] +sums[x1-1][y1-1];
			sb.append(temp+"\n");
		}
		
		System.out.println(sb);
	}

}
