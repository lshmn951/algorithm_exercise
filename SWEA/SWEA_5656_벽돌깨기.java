package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
	static int n,w,h;
	static int [][]arr;
	static int [] high;
	static int max;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			arr = new int [h][w];
			high = new int [w];
			max = Integer.MIN_VALUE;
			int sum =0;
			Arrays.fill(high, -1);
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]>0 &&high[j]==-1) {
							high[j] = i;//각 열(column)마다 부술수있는 가장 높은 벽돌 위치 저장
					}
					if(arr[i][j]>0) {
						sum++;
					}
				}
			}
			per(0,0);
			System.out.print("#"+tc+" ");
			System.out.println(sum-max);
		}
	}
	public static void per(int k,int count) {
		//중복순열을 통해 벽돌을 부술 수 있는 위치를 찾아내고 총 n번 벽돌을 부순다. 
		if(k==n) {
			max = Math.max(max, count);
			return;
		}
		
		int [][] copy = new int [h][w];
		int [] hcopy = new int[w];
		for(int i=0;i<h;i++) {
			copy[i] = arr[i].clone();
		}
		hcopy = high.clone();
		
		for(int i=0;i<w;i++) {
			int temp = hcopy[i];
			int cur;
			boolean zero;
			if(temp!= -1) {
				cur = crash(temp,i,arr[temp][i]);
				zero = down();
				if(!zero) {// 더 이상 부술 벽돌이 없다면 종료
					max = count+cur;
					return;
				}
				per(k+1,count+cur);
				for(int q=0;q<h;q++) {
					arr[q] = copy[q].clone();
				}
				high = hcopy.clone();
			}
		}
	}
	public static int crash(int x,int y,int size) {
		//dfs를 이용하여 벽돌을 연달아 부수어 나간다.
		int cnt=1;
		arr[x][y] = 0;
		for(int i=1;i<size;i++) {
			for(int j=0;j<4;j++) {
				int r = x+(dirs[j][0]*i);
				int c = y+(dirs[j][1]*i);
				if(r<0||c<0||r>h-1||c>w-1) {
					continue;
				}
				if(arr[r][c]>0) {
					cnt += crash(r,c,arr[r][c]);
				}
			}
		}
		return cnt;
	}
	public static boolean down() {
		//각 칼럼 별로 가장 낮은 위치의 0과 그 위에 1의 위치를 스왑하고 high 배열을 갱신시킨다.
		boolean b=false;
		for(int i=0;i<w;i++) {
			int hi = -1;
			boolean c = false;
			for(int j=h-1;j>=0;j--) {
				if(arr[j][i]==0&&hi==-1) {
					hi = j;
				}
				else if(arr[j][i]>0) {
					if(hi!=-1) {
						arr[hi][i] = arr[j][i];
						arr[j][i] = 0;
						high[i] = hi;
						hi = hi-1;
					}
					else if(hi==-1){
						high[i] = j;
					}
					b=true;
					c=true;
				}
			}
			if(!c) {
				high[i] = -1;
			}
		}
		return b;
	}
}
