package algo_exercise.SWEA;

import java.util.Scanner;

public class SWEA_1210_Ladder1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb= new StringBuilder();
		int arr[][] = new int [100][100];
		int visit[][] = new int [100][100];
		int start = 0;
		int r=0,c=0;
		Scanner sc = new Scanner(System.in);
		
		for(int i=1;i<=10;i++) {
			sc.nextInt();
			sb.append("#"+i+" ");
			for(r=0;r<100;r++) {
				for(c=0;c<100;c++) {
					arr[r][c] = sc.nextInt();
					visit[r][c] = 0;
				}
			}
			
			start=0;
			for(c=0;c<100;c++) {
				if(arr[99][c]==2) {
					start = c;
					break;
				}
			}
			r=98;
			for(;r>0;) {
				visit[r][start]=1;
				if(start+1<100 && arr[r][start+1]==1 && visit[r][start+1]==0) {
					start++;
				}
				else if(start-1>=0 && arr[r][start-1]==1 && visit[r][start-1]==0) {
					start--;
				}
				else if(start-1>=0 && start+1<100) {
					if(visit[r][start-1]==1 || arr[r][start-1]==0 && visit[r][start+1]==1||arr[r][start+1]==0) {
						r--;
					}
				}
				else {
					r--;
				}
			}
			
			
			sb.append(start+ "\n");
		}
		System.out.println(sb);
	}
	

}
