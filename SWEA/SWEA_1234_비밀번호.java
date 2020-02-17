package algo_exercise.SWEA;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14_DEKAJcCFAYD&categoryId=AV14_DEKAJcCFAYD&categoryType=CODE
 * @mem
 * @time
 * @caution
 */

public class SWEA_1234_비밀번호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb= new StringBuilder();
		Scanner sc = new Scanner(System.in);
		for(int tc =1;tc<=10;tc++) {
			Stack<Character> st = new Stack<>();
			int len = sc.nextInt();
			String str = sc.next();
			char [] chars = new char[len];
			chars = str.toCharArray();
			for(int i=len-1;i>=0;i--) {
				if(st.isEmpty()) {
					st.add(chars[i]);
				}
				else {
					char temp = st.peek();
					if(temp!=chars[i]) {
						st.add(chars[i]);
					}
					else {
						st.pop();
						continue;
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			while(!st.isEmpty()) {
				sb.append(st.pop());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}

