package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6719_성수의프로그래밍강좌시청 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			double arr[] = new double [n];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			double answer = 0;
			for(int i=n-k;i<n;i++) {
				answer = (answer+arr[i])/2;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}

}
