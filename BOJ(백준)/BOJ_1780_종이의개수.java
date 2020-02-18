package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 18.
 * @see https://www.acmicpc.net/problem/1780
 * @mem
 * @time
 * @caution 종이 크기에 맞춰 재귀
 */

public class BOJ_1780_종이의개수 {
	static int n;
	static int [][] arr;
	static int [] paper = new int [3];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		arr = new int [n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recur(0,0,n);
		for(int i=0;i<3;i++) {
			System.out.println(paper[i]);
		}
	}
	public static void recur(int x,int y,int size) {
		if(check(x,y,size,arr[x][y])) {
			paper[arr[x][y]+1]++;
			return ;
		}
		else {
			for(int i=x;i<x+size;i+=size/3) {
				for(int j=y;j<y+size;j+=size/3) {
					recur(i,j,size/3);
				}
			}
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
