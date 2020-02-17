package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_1969_DNA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [][] arr = new int[4][m];
		String [] str = new String[n];
		for(int i=0;i<n;i++) {
			str[i] = sc.next();
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(str[j].charAt(i)=='A') {
					arr[0][i]++;
				}
				if(str[j].charAt(i)=='C') {
					arr[1][i]++;
				}
				if(str[j].charAt(i)=='G') {
					arr[2][i]++;
				}
				if(str[j].charAt(i)=='T') {
					arr[3][i]++;
				}
			}
		}
		int result=0;
		for(int i=0;i<m;i++) {
			int sum = arr[0][i];
			int max = arr[0][i];
			int maxi = 0;
			for(int j=1;j<4;j++) {
				sum+=arr[j][i];
				if(arr[j][i]>max) {
					max = arr[j][i];
					maxi = j;
				}
			}
			result += sum - max;
			switch(maxi) {
			case 0:
				sb.append('A');
				break;
			case 1:
				sb.append('C');
				break;
			case 2:
				sb.append('G');
				break;
			case 3:
				sb.append('T');
				break;
			}
		}
		sb.append("\n");
		sb.append(result);
		System.out.println(sb);
	}

}
