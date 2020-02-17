package algo_exercise.SWEA;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_8931_제로 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int n = sc.nextInt();
			Stack<Integer> st = new Stack<>();
			for(int i=0;i<n;i++) {
				int temp = sc.nextInt();
				if(temp!=0) {
					st.push(temp);
				}
				else {
					if(!st.isEmpty()) {
						st.pop();
					}
				}
			}
			int sum=0;
			while(!st.empty()) {
				sum+= st.pop();
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}
