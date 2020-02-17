package algo_exercise.JA;

import java.util.Scanner;

public class JA_2074_홀수마방진 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int [][]arr = new int [n][n];
		
		int x = 0;
		int y = n/2;
		int number = 1;
		
		while(number<=n*n) {
			arr[x][y] = number;
			
			if(number%n==0) {
				x++;
				number++;
			}
			else {
				x--;
				y--;
				if(x<0) {
					x = n-1;
				}
				if(y<0) {
					y = n-1;
				}
				number++;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
