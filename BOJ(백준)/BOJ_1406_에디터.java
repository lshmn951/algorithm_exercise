package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class BOJ_1406_에디터 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character > st1 = new Stack<Character>();
		Stack<Character > st2 = new Stack<Character>();
		String input = br.readLine();
		for(int i=0;i<input.length();i++) {
			st1.push(input.charAt(i));
		}
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String in = br.readLine();
			if(in.charAt(0)=='P') {
				char temp = in.charAt(2);
				st1.push(temp);
			}
			else if(in.charAt(0)=='L') {
				if(!st1.isEmpty()) {
					st2.push(st1.pop());
				}
			}
			else if(in.charAt(0)=='B') {
				if(!st1.isEmpty()) {
					st1.pop();
				}
			}
			else if(in.charAt(0)=='D') {
				if(!st2.isEmpty()) {
					st1.push(st2.pop());
				}
			}
		}
		while(!st2.isEmpty()) {
			st1.push(st2.pop());
		}
		while(!st1.isEmpty()) {
			sb.append(st1.pop());
		}
		sb.reverse();
		System.out.println(sb);
		br.close();
	}

}
