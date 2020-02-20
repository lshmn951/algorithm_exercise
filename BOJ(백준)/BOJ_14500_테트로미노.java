package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 20.
 * @see https://www.acmicpc.net/problem/14500
 * @mem
 * @time
 * @caution 예제로 주어진 5가지 모양의 회전과 대칭 모든 상황을 봐야하는 완탐
 */
public class BOJ_14500_테트로미노 {
	static int [][][] tetro = {{{0,0},{0,1},{0,2},{0,3}}, //길쭉한 모양
								{{0,0},{1,0},{2,0},{3,0}},
								
								{{0,0},{0,1},{1,0},{1,1}}, //정사각형
								
								{{0,0},{1,0},{2,0},{2,1}}, //ㄴ 자 모양
								{{0,0},{0,1},{0,2},{-1,2}},
								{{0,0},{-1,0},{-2,0},{-2,-1}},
								{{0,0},{0,-1},{0,-2},{1,-2}},
								
								{{0,0},{1,0},{2,0},{2,-1}}, //ㄴ 자 대칭 모양
								{{0,0},{0,1},{0,2},{1,2}},
								{{0,0},{-1,0},{-2,0},{-2,1}},
								{{0,0},{0,-1},{0,-2},{-1,-2}},
								
								{{0,0},{1,0},{1,1},{2,1}}, // 지그재그 모양
								{{0,0},{0,1},{-1,1},{-1,2}},
								
								{{0,0},{1,0},{1,-1},{2,-1}}, //지그재그 대칭
								{{0,0},{0,1},{1,1},{1,2}},
								
								{{0,0},{0,1},{0,2},{1,1}}, //ㅜ 모양
								{{0,0},{-1,0},{-2,0},{-1,1}},
								{{0,0},{0,-1},{0,-2},{-1,-1}},
								{{0,0},{1,0},{2,0},{1,-1}}};
	static int [][] arr;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		int max = 0;
		int []r = new int [4];
		int []c = new int [4];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				out:for(int k=0;k<tetro.length;k++) {
					int sum = 0;
					for(int w=0;w<4;w++) {
						r[w] = i+tetro[k][w][0];
						c[w] = j+tetro[k][w][1];
						if(!isin(r[w],c[w])) {
							continue out;
						}
						sum += arr[r[w]][c[w]];
					}
					max = Math.max(max, sum);
				}
			}
		}
		System.out.println(max);
	}
	public static boolean isin(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

}
