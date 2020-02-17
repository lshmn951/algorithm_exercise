package algo_exercise.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1258_행렬찾기 {
	static List<Array> list;
	static int n;
	static int [][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int tc = Integer.parseInt(bf.readLine());
		for(int t=1;t<=tc;t++) {
			list = new ArrayList<>();
			n = Integer.parseInt(bf.readLine());
			arr = new int [n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]>0) {
						arr[i][j]=0;
						bfs(i,j);
					}
				}
			}
			Collections.sort(list, new Comparator<Array>() {

				@Override
				public int compare(Array o1, Array o2) {
					if(o1.size<o2.size) {
						return -1;
					}
					else if(o1.size>o2.size) {
						return 1;
					}
					else {
						if(o1.r<o2.r) {
							return -1;
						}
						else if(o1.r>o2.r) {
							return 1;
						}
						else {
							return 0;
						}
					}
				}
			});
			System.out.print("#"+t+" "+list.size()+" ");
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i).r+" "+list.get(i).c+" ");
			}
			System.out.println();
		}
	}
	public static void bfs(int x,int y) {
		Queue<Array> que = new LinkedList<>();
		que.add(new Array(1,1,x,y,1));
		while(!que.isEmpty()) {
			Array temp = que.poll();
			if(isin(temp.x+1,temp.y)&& arr[temp.x+1][temp.y]>0) {
				arr[temp.x+1][temp.y] = 0;
				que.add(new Array(temp.r+1,temp.c,temp.x+1,temp.y,temp.size+1));
			}
			if(isin(temp.x,temp.y+1)&& arr[temp.x][temp.y+1]>0) {
				arr[temp.x][temp.y+1] = 0;
				que.add(new Array(temp.r,temp.c+1,temp.x,temp.y+1,temp.size+1));
			}
			if(que.size()==0) {
				list.add(new Array(temp.r,temp.c,temp.x,temp.y,temp.r*temp.c));
			}
		}
		
	}
	public static boolean isin(int x,int y) {
		return x>=0 && y>=0 && x<n && y<n;
	}
	static class Array{
		int r,c;
		int x,y;
		int size;
		public Array(int r, int c, int x, int y, int size) {

			this.r = r;
			this.c = c;
			this.x = x;
			this.y = y;
			this.size = size;
		}
		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + ", x=" + x + ", y=" + y + ", size=" + size + "]";
		}
		
	}
}
