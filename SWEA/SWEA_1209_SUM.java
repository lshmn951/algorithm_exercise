package algo_exercise.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13_BWKACUCFAYh&categoryId=AV13_BWKACUCFAYh&categoryType=CODE
 * @mem
 * @time
 * @caution
 */

public class SWEA_1209_SUM {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=1;i<=10;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int max = Integer.MIN_VALUE;
			int [][]arr = new int [100][100];
			for(int r=0;r<100;r++) {
				st = new StringTokenizer(bf.readLine());
				int sum = 0;
				for(int c=0;c<100;c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
					sum+=arr[r][c];
				}
				max = Math.max(max, sum);
			}
			int sum2=0;
			int sum3=0;
			for(int c=0;c<100;c++) {
				int sum = 0;
				for(int r=0;r<100;r++) {
					sum += arr[r][c];
				}
				max = Math.max(max, sum);
				sum2+=arr[c][c];
				sum3+=arr[99-c][c];
			}
			max = Math.max(max, sum2);
			max = Math.max(max, sum3);
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
