package algo_exercise.BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1252_이진수덧셈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Scanner sc= new Scanner(System.in);
		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		String str1 = sc.next();
		String str2 = sc.next();
		boolean check = false;
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i)=='1') {
				check = true;
			}
			if(check) {
				st1.add(str1.charAt(i)-'0');
			}
		}
		check = false;
		for(int i=0;i<str2.length();i++) {
			if(str2.charAt(i)=='1') {
				check = true;
			}
			if(check) {
				st2.add(str2.charAt(i)-'0');
			}
		}
		int add=0;
		while((!st1.isEmpty() || !st2.isEmpty()) || add>0) {
			int tmp1=0;
			int tmp2=0;
			if(!st1.isEmpty()) {
				tmp1 = st1.pop();
			}
			if(!st2.isEmpty()) {
				tmp2 = st2.pop();
			}
			int sum = add + tmp1 +tmp2;
			if(sum==0) {
				sb.append(0);
				add = 0;
			}
			else if(sum==1) {
				sb.append(1);
				add = 0;
			}
			else if(sum==2) {
				sb.append(0);
				add = 1;
			}
			else if(sum==3) {
				sb.append(1);
				add = 1;
			}
		}
		if(sb.length()==0) {
			sb.append(0);
		}
		sb.reverse();
		System.out.println(sb);
		
	}

}
