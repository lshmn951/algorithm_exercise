package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_11729_하노이탑 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sb.append((int)(Math.pow(2, N))-1).append("\n");
		hanoi(N,3,2,1);
		System.out.println(sb);
		
	}
	public static void hanoi(int N,int des,int emp,int cur) {
		if(N==1) {
			sb.append(cur).append(" ").append(des).append("\n");
			return;
		}
		else {
			hanoi(N-1,emp,des,cur);
			sb.append(cur).append(" ").append(des).append("\n");
			hanoi(N-1,des,cur,emp);
		}
	}
}
