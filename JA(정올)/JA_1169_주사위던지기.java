package algo_exercise.JA;

import java.util.Arrays;
import java.util.Scanner;

public class JA_1169_주사위던지기 {
	static int[] dices ;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		dices = new int[N];
		switch(M) {
		case 1:
			game1(0);
			break;
		case 2:
			game2(0,1);
			break;
			
		case 3:
			game3(0,new boolean[7]);
			break;
			
		default:
			break;
		}
	}
	public static void print() {
		for(int d:dices) {
			System.out.print(d+" ");
		}
		System.out.println();
		return;
	}
	public static void game1(int idx) {
		if(idx == N) {
			print();
			return;
		}
		for(int i=1;i<=6;i++) {
			dices[idx] =i;
			game1(idx+1);
		}
	}
	
	public static void game2(int idx,int before) {
		if(idx == N) {
			print();
			return;
		}
		for(int i=before;i<=6;i++) {
			dices[idx]=i;
			game2(idx+1,i);
		}
	}
	
	public static void game3(int idx,boolean []visit) {
		if(idx==N) {
			print();
			return;
		}
		for(int i=1;i<=6;i++) {
			if(!visit[i]) {
				visit[i]=true;
				dices[idx]=i;
				game3(idx+1,visit);
				visit[i]=false;
			}
		}
	}
}
