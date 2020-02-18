package algo_exercise.BOJ;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1914_hanoi {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger b = new BigInteger("2").pow(N).subtract(BigInteger.ONE);
		if(N>20) {
			System.out.println(b);
			return;
		}
		int a = (int) (Math.pow(2, N)-1);
		sb.append(a).append("\n");
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
