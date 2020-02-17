package algo_exercise.SWEA;

import java.util.Scanner;

public class SWEA_1204_D2_최빈수구하기_이성현 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb= new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		int tc = scanner.nextInt();
		for(int i=1;i<=tc;i++) {
			int[] arr = new int[101];
			int cs = scanner.nextInt();
			sb.append("#").append(i).append(" ");
			for(int j=1;j<=1000;j++) {
				int input = scanner.nextInt();
				arr[input]++;
			}
			int max = 0;
			int maxi = 0;
			for(int j=1;j<101;j++) {
				if(arr[j]>=max) {
					max = arr[j];
					maxi = j;
				}
			}
			sb.append(maxi).append("\n");
		}
		System.out.println(sb);
	}

}
