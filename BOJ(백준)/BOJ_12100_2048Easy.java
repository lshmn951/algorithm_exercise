package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 
 * @author 이성현
 * @since 2020. 2. 20.
 * @see https://www.acmicpc.net/problem/12100
 * @mem
 * @time
 * @caution 시뮬레이션 구현 인덱스 설정이 복잡하다...
 */
public class BOJ_12100_2048Easy {
	static int n;
	static int [][] arr;

	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		arr= new int [n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		
		System.out.println(max);
	}
	public static void dfs(int k) {//4방향씩 총 5번 게임을 진행
		int [][] copy = new int [n][n];
		if(k==5) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					max = Math.max(max, arr[i][j]);
				}
			}
			return;
		}
		else {
			for(int i=0;i<n;i++) {
				copy[i] = arr[i].clone(); //각 게임을 진행하고 원래 상태로 돌리기 위한 copy배열
			}
			for(int i=0;i<4;i++) {//4방향으로 게임 진행
				game(i);
				dfs(k+1);
				for(int j=0;j<n;j++) {
					arr[j] = copy[j].clone(); 
				}
			}
		}
	}
	public static void game(int d) {
		boolean [] visit;
		if(d==0) { // 위로 
			for(int i=0;i<n;i++) {
				visit = new boolean [n];
				for(int j=1;j<n;j++) {
					int temp = arr[j][i];
					for(int k=j-1;k>=0;k--) {
						if(arr[k][i]!=0) {//숫자를 만남
							if(visit[k]) {//이미 합쳐진 숫자일 경우
								arr[k+1][i] = temp;
							}
							else {//합쳐지지 않은 숫자
								if(arr[k][i]==temp) {//같은 숫자를 만남
									arr[k+1][i] = 0;
									arr[k][i] += temp;
									visit[k] = true;
								}
								else {//다른 숫자를 만남
									arr[k+1][i] = temp;
								}
							}
							break;
						}
						else {//빈칸으로 이동
							arr[k+1][i] = 0;
							arr[k][i] = temp;
						}
					}
				}
			}
		}
		else if(d==1) {//오른쪽으로
			for(int i=0;i<n;i++) {
				visit = new boolean [n];
				for(int j=n-2;j>=0;j--) {
					int temp = arr[i][j];
					for(int k=j+1;k<n;k++) {
						if(arr[i][k]!=0) {
							if(visit[k]) {
								arr[i][k-1] = temp;
							}
							else {
								if(arr[i][k]==temp) {
									arr[i][k-1] = 0;
									arr[i][k] += temp;
									visit[k] = true;
								}
								else {
									arr[i][k-1] = temp;
								}
							}
							break;
						}
						else {
							arr[i][k-1] = 0;
							arr[i][k] = temp;
						}
					}

				}
			}
		}
		else if(d==2) { // 아래로
			for(int i=0;i<n;i++) {
				visit = new boolean [n];
				for(int j=n-2;j>=0;j--) {
					int temp = arr[j][i];
					for(int k=j+1;k<n;k++) {
						if(arr[k][i]!=0) {
							if(visit[k]) {
								arr[k-1][i] = temp;
							}
							else {
								if(arr[k][i]==temp) {
									arr[k-1][i] = 0;
									arr[k][i] += temp;
									visit[k] = true;
								}
								else {
									arr[k-1][i] = temp;
								}
							}
							break;
						}
						else {
							arr[k-1][i] = 0;
							arr[k][i] = temp;
						}
					}
				}
			}
		}
		else if(d==3) {//왼쪽으로
			for(int i=0;i<n;i++) {
				visit = new boolean [n];
				for(int j=1;j<n;j++) {
					int temp = arr[i][j];
					for(int k=j-1;k>=0;k--) {
						if(arr[i][k]!=0) {
							if(visit[k]) {
								arr[i][k+1] = temp;
							}
							else {
								if(arr[i][k]==temp) {
									arr[i][k+1] = 0;
									arr[i][k] += temp;
									visit[k] = true;
								}
								else {
									arr[i][k+1] = temp;
								}
							}
							break;
						}
						else {
							arr[i][k+1] = 0;
							arr[i][k] = temp;
						}
					}

				}
			}
		}
		/*for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();*/
	}
}
