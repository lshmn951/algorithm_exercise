package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 10.
 * @see https://www.acmicpc.net/problem/16637
 * @mem
 * @time
 * @caution 재귀 완탐 문제 연산없는 한글자 스트링만 조심하면 됨.
 */

public class BOJ_16637_괄호추가하기 {
	static int n;
	static String str;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		str = bf.readLine();
		oper(str.substring(1),str.charAt(0)-'0');
		if(str.length()==1) {
			System.out.println(str);
		}
		else {
			System.out.println(max);
		}
	}
	public static void oper(String src,int temp) {
		if(src.length()<=4) {
			if(src.length()==2) {
				if(src.charAt(0)=='+') {
					max = Math.max(max, temp+(src.charAt(1)-'0'));
				}
				else if(src.charAt(0)=='*') {
					max = Math.max(max, temp*(src.charAt(1)-'0'));
				}
				else  {
					max = Math.max(max, temp-(src.charAt(1)-'0'));
				}
			}
			else if(src.length()==4) {
				if(src.charAt(0)=='+') {
					oper(src.substring(2),temp+(src.charAt(1)-'0'));
					max = Math.max(max, temp+calc(src.substring(1)));
				}
				else if(src.charAt(0)=='*') {
					oper(src.substring(2),temp*(src.charAt(1)-'0'));
					max = Math.max(max, temp*calc(src.substring(1)));
				}
				else  {
					oper(src.substring(2),temp-(src.charAt(1)-'0'));
					max = Math.max(max, temp-calc(src.substring(1)));
				}
			}
		}
		else {
			if(src.charAt(0)=='+') {
				oper(src.substring(2),temp + (src.charAt(1)-'0'));
				oper(src.substring(4),temp+calc(src.substring(1)));
			}
			else if(src.charAt(0)=='-') {
				oper(src.substring(2),temp - (src.charAt(1)-'0'));
				oper(src.substring(4),temp-calc(src.substring(1)));
			}
			else if(src.charAt(0)=='*') {
				oper(src.substring(2),temp * (src.charAt(1)-'0'));
				oper(src.substring(4),temp*calc(src.substring(1)));
			}
		}
	}
	public static int calc(String s) {
		if(s.charAt(1)=='+') {
			return (s.charAt(0)-'0') + (s.charAt(2)-'0');
		}
		else if(s.charAt(1)=='*') {
			return (s.charAt(0)-'0') * (s.charAt(2)-'0');
		}
		else  {
			return (s.charAt(0)-'0') - (s.charAt(2)-'0');
		}
	}
	
}
