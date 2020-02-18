package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브 {
	static int n,x,y,d,g;
	static boolean [][] arr= new boolean [101][101];
	static int[][] dirs = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++) {
			list.clear();
			st = new StringTokenizer(bf.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			arr[y][x] = true;
			y += dirs[d][0];
			x += dirs[d][1];
			arr[y][x] = true;
			list.add(d);
			dragon(y, x, 1);
		}
		int sum=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j] && arr[i+1][j] && arr[i][j+1] && arr[i+1][j+1]) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
	public static void dragon(int r,int c,int cnt) {
		if(cnt==g+1) {
			return;
		}
		else {
			int temp = list.size();
			int temp2;
			for(int i=temp-1;i>=0;i--) {
				temp2 = (list.get(i)+1)%4;
				r += dirs[temp2][0];
				c += dirs[temp2][1];
				list.add(temp2);
				arr[r][c] = true;
			}
			dragon(r,c,cnt+1);
		}
	}
}
