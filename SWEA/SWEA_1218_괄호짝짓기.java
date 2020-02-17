package algo_exercise.SWEA;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String opener = "({[<";
		String closer = ")}]>";
		Stack<Integer> st = new Stack<>();
		for(int i=1;i<=10;i++) {
			int n = sc.nextInt();
			String str = sc.next();
			int bool = 1;
			st = new Stack<>();
			for(int j=0;j<n;j++) {
				if(opener.indexOf(str.substring(j, j+1))>=0) {
					st.add(opener.indexOf(str.substring(j, j+1)));
				}
				else {
					if(!st.isEmpty()) {
						int temp = st.peek();
						if(closer.indexOf(str.substring(j, j+1))!=temp) {
							bool=0;
							break;
						}
						else {
							st.pop();
						}
					}
					else {
						bool=0;
						break;
					}
				}
			}
			System.out.println("#"+i+" "+bool);
		}
	}

}
