package algo_exercise.JA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class JA_1224_계산기3 {
	public static String str;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<=10;tc++) {
			int n = sc.nextInt();
			str = sc.next();
			System.out.println("#"+tc+" "+calc(getPostfixNotation()));
		}
		
	}
	public static int getOrder(char c) {
		if(c=='*' || c=='/') {
			return 4;
		}
		else if(c=='+'|| c=='-') {
			return 3;
		}
		else if(c=='(') {
			return 2;
		}
		else if(c==')') {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	private static List<Character> getPostfixNotation(){
		List<Character> postfixNotation = new ArrayList<>();
		
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<str.length();i++) {
			char c= str.charAt(i);
			int order = getOrder(c);
			if(order==0) {
				postfixNotation.add(c);//숫자는 그냥 출력
			}
			else if(order==2) {
				stack.push(c);//여는 괄호는 무조건 push
			}
			else if(order==1) {//닫는 괄호: 여는 괄호 만날때까지 pop-->add
				while(true){
					char top = stack.pop();
					if(top=='(') {
						break;
					}
					else {
						postfixNotation.add(top);
					}
				}
			}
			else {//일반 연산자가 왔다면..
				while(true) {
					if(stack.isEmpty()) {
						break;
					}
					char top = stack.peek();
					if(getOrder(top)>=order) {
						postfixNotation.add(stack.pop());
					}
					else {
						break;
					}
				}
				//원탑의 조건이 완성 되었으므로 내가 들어간다~
				stack.push(c);
			}
			
		}
		while(!stack.isEmpty()) {
			postfixNotation.add(stack.pop());
		}
		return postfixNotation;
	}
	
	private static int calc(List<Character> postfix) {
		//피 연산자를 담아놓은 stack
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<postfix.size();i++) {
			char c = postfix.get(i);
			if(getOrder(c)==0) {
				stack.push(c-'0');
			}
			else {
				Integer temp1 = stack.pop();
				Integer temp2 = stack.pop();
				if(c=='+') {
					stack.push(temp1+temp2);
				}
				else if(c=='-') {
					stack.push(temp2-temp1);
				}
				else if(c=='*') {
					stack.push(temp2*temp1);
				}
				else if(c=='/') {
					stack.push(temp2/temp1);
				}
			}
		}
		return stack.pop();
	}
}
