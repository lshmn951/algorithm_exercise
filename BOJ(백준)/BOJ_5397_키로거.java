package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_5397_키로거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character > st1 = new Stack<Character>();
		Stack<Character > st2 = new Stack<Character>();
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			
			String str = br.readLine();
			
			for(int j=0;j<str.length();j++) {
				char temp = str.charAt(j);
				if(temp>='A' && temp<='Z' ||temp>='a'&&temp<='z'||temp>='0'&&temp<='9') {
					st1.push(temp);
				}
				else {
					if(temp=='<') {
						if(!st1.isEmpty()) {
							st2.push(st1.pop());
						}
					}
					else if(temp=='>') {
						if(!st2.isEmpty()) {
							st1.push(st2.pop());
						}
					}
					else if(temp=='-') {
						if(!st1.isEmpty()) {
							st1.pop();
						}
					}
				}
			}
			while(!st2.isEmpty()) {
				st1.push(st2.pop());
			}
			StringBuilder sb = new StringBuilder();
			while(!st1.isEmpty()) {
				sb.append(st1.pop());
			}
			sb.reverse();
			System.out.println(sb.toString());
		}
		
	}

}
