package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 18.
 * @see https://www.acmicpc.net/problem/2630
 * @mem
 * @time
 * @caution 종이 크기에 맞춰 재귀
 */
public class BOJ_2630_색종이만들기 {
	static int n;
	static int [][] arr;
	static int [] paper = new int [2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recur(0,0,n);
		System.out.println(paper[0]);
		System.out.println(paper[1]);
	}
	public static void recur(int x,int y,int size) {
		if(check(x,y,size,arr[x][y])) {
			paper[arr[x][y]]++;
			return ;
		}
		else {
			recur(x,y,size/2);
			recur(x+size/2,y,size/2);
			recur(x,y+size/2,size/2);
			recur(x+size/2,y+size/2,size/2);
		}
	}
	public static boolean check(int x,int y,int size,int start) {
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(arr[i][j]!=start) {
					return false;
				}
			}
		}
		return true;
	}
}
