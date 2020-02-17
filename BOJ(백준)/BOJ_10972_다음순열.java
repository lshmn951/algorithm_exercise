package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 17.
 * @see https://www.acmicpc.net/problem/10972
 * @mem
 * @time
 * @caution next_permutation 구현문제
 */

public class BOJ_10972_다음순열 {
	static int [] arr;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(next()) {
			for(int i=0;i<n;i++) {
				System.out.print(arr[i]+" ");
			}
		}
		else {
			System.out.println(-1);
		}
	}
	public static boolean next() {
		boolean b = false;
		int i,j;
		for(i=n-2;i>=0;i--) {
			if(arr[i]<arr[i+1]) {
				b= true;
				break;
			}
		}
		if(!b) {
			return false;
		}
		for(j=n-1;j>i;j--) {
			if(arr[j]>arr[i]) {
				break;
			}
		}
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		Arrays.sort(arr, i+1, n);
		return b;
	}
}
