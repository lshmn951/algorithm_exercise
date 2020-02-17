package algo_exercise.BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_11179_2진수뒤집기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Integer N = sc.nextInt();
		String str = Integer.toBinaryString(N);
		Stack<Character> st = new Stack<>();
		for(int i=0;i<str.length();i++) {
			st.push(str.charAt(i));
		}
		boolean b = false;
		String src="";
		while(!st.isEmpty()) {
			char a = st.pop();
			if(a=='1') {
				b =true;
			}
			if(b) {
				src += a;
			}
		}
		System.out.println(ten(src));
	}
	public static int ten(String src) {
		int i=src.length()-1;
		int temp =0;
		for(int j=1;i>=0;i--,j*=2) {
			if(src.charAt(i)=='1') {
				temp += j;
			}
		}
		return temp;
	}
}
