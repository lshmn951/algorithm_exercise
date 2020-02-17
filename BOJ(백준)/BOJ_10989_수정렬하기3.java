package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10989_수정렬하기3 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int n = Integer.valueOf(bf.readLine());
		int []arr = new int [10001];
		for(int i=0;i<n;i++) {
			arr[Integer.valueOf(bf.readLine())]++;
		}
		for(int i=1;i<=10000;i++) {
			for(int j=0;arr[i]>j;j++) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}

}
