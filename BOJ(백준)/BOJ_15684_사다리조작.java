package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15684_사다리조작 {
	static int n,m,h;
	static int [][] arr;
	static int [][] copy;
	static List<Point> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int [h+1][n+1];
		copy = new int [h+1][n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = y+1;
			arr[x][y+1] = y;
		}

		for(int i=1;i<=h;i++) {
			for(int j=1;j<n;j++) {
				if(arr[i][j]==0 && arr[i][j+1]==0) {
					//list.add(new Point(i,j)); //추가로 설치할 수 있는 가로선 리스트
				}
			}
		}
		int result=0;
		for(int i=0;i<list.size();i++) {//i 개수 만큼 사다리를 설치해본다
			if(i>3) {
				result = -1;
				break;
			}
			if(com(i,0,new Point[i],0)) {
				result = i;
				break;
			}
			
		}
		if(list.size()==0) {
			if(ladder(new Point[0])) {
				System.out.println(0);
			}
			else {
				System.out.println(-1);
			}
		}
		else {
			System.out.println(result);
		}

	}
	public static boolean com(int r,int k,Point[] p,int before) {//r개의 사다리를 조합으로 뽑아냄
		if(r==k) {
			if(ladder(p)) {
				
				return true;
			}
			return false;
		}
		for(int i=before;i<list.size();i++) {
			p[k] = list.get(i);
			if(com(r,k+1,p,i+1)) {
				return true;
			}
		}
		return false;
	}
	public static boolean ladder(Point[] p) {//사다리 타기 - i번째가 내려가서 i번이 나오는지 체크
		for(int i=1;i<=h;i++) {
			copy[i] = arr[i].clone();
		}
		for(int i=0;i<p.length;i++) {
			copy[p[i].x][p[i].y] = p[i].y+1;
			copy[p[i].x][p[i].y+1] = p[i].y;
		}
		for(int i=1;i<=n;i++) {
			int c = i;
			for(int j=1;j<=h;j++) {
				if(copy[j][c]!=0) {
					c = copy[j][c];
				}
			}
			if(c!=i) {
				return false;
			}
		}
		return true;
	}
	public static boolean isin(int x, int y) {
		return x > 0 && y > 0 && x <=h && y <= n;
	}
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
