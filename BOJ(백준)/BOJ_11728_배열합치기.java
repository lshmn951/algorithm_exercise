package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11728_배열합치기 {
	static int n,m;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int [] arr1 = new int [n];
		int [] arr2 = new int [m];
		 st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		 st = new StringTokenizer(bf.readLine());
		for(int j=0;j<m;j++) {
			arr2[j] = Integer.parseInt(st.nextToken());
		}
		int idx1=0,idx2=0;
		while(idx1<n && idx2<m) {
			if(arr1[idx1]<=arr2[idx2]) {
				sb.append(arr1[idx1]).append(" ");
				idx1++;
			}
			else {
				sb.append(arr2[idx2]).append(" ");
				idx2++;
			}
		}
		while(idx1<n) {
			sb.append(arr1[idx1]).append(" ");
			idx1++;
		}
		while(idx2<m) {
			sb.append(arr2[idx2]).append(" ");
			idx2++;
		}
		System.out.println(sb);
	}

}
