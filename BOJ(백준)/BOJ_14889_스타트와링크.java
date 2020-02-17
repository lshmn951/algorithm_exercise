package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	static int n;
	static int [][]arr;
	static int min = Integer.MAX_VALUE;
	static int [] start;
	static int [] link;
	static int stsum;
	static int lisum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in) );
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		start = new int [n/2];
		link = new int [n/2];
		arr = new int [n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		com(0,0,new boolean[n]);
		System.out.println(min);
	}
	
	public static void com(int k,int before,boolean [] temp) {
		if(k==n/2) {
			int q =0;
			stsum=0;
			lisum=0;
			for(int i=0;i<n;i++) {
				if(!temp[i]) {
					link[q++] = i;
				}
			}
			com2(0,0,new int[2],new int[2]);
			int m = stsum>lisum ? stsum-lisum: lisum-stsum;
			min = Math.min(min, m);
		}
		else {
			for(int i=before;i<n;i++) {
				temp[i] = true;
				start[k] = i;
				com(k+1,i+1,temp);
				temp[i] = false;
			}
		}
	}
	public static void com2(int k,int before,int [] temp,int []temp2) {
		if(k==2) {
			stsum+= arr[temp[0]][temp[1]] + arr[temp[1]][temp[0]];
			lisum+= arr[temp2[0]][temp2[1]] + arr[temp2[1]][temp2[0]];
		}
		else {
			for(int i=before;i<n/2;i++) {
				temp[k] = start[i];
				temp2[k] = link[i];
				com2(k+1,i+1,temp,temp2);
			}
		}
	}
}
