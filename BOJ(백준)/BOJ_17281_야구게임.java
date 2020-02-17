package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_야구게임 {
	static int n;
	static int [][] arr ;
	static int [][] game;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		arr = new int [n][9];
		game = new int [n][9];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		per(0,new int[9],new boolean [9]);
		System.out.println(max);
	}
	public static void per(int k, int[] temp,boolean [] visit) {
		if(k==3) {
			temp[k]=0;
			per(k+1,temp,visit);
		}
		else if(k==9) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<9;j++) {
					game[i][j] = arr[i][temp[j]];
				}
			}
			max = Math.max(max, baseball());
		}
		else {
			for(int i=1;i<9;i++) {
				if(!visit[i]) {
					visit[i]= true;
					temp[k] = i;
					per(k+1,temp,visit);
					visit[i] = false;
				}
			}
		}
	}
	public static int baseball() {
		int out = 0;
		int score = 0;
		int idx = 0;
		int [] cur = new int[3];
		for(int i=0;i<n;i++) {
			out = 0;
			cur[2] = cur[1] = cur[0] = 0;
			while(out<3) {
				if(game[i][idx]==0) {
					out++;
				}
				else if(game[i][idx]==1) {
					if(cur[2]==1) {
						score++;
					}
					for(int j=2;j>0;j--) {
						cur[j] = cur[j-1];
					}
					cur[0] = 1;
				}
				else if(game[i][idx]==2) {
					if(cur[2]==1) {
						score++;
					}
					if(cur[1]==1) {
						score++;
					}
					cur[2] = cur[0];
					cur[1] = 1;
					cur[0] = 0;
				}
				else if(game[i][idx]==3) {
					int sum=0;
					for(int j=0;j<3;j++) {
						sum+= cur[j];
						cur[j]=0;
					}
					score+=sum;
					cur[2] = 1;
				}
				else if(game[i][idx]==4) {
					int sum=0;
					for(int j=0;j<3;j++) {
						sum+= cur[j];
						cur[j]=0;
					}
					score+=sum;
					score++;
				}
				idx = (idx+1)%9;
			}
		}
		
		return score;
	}
}
