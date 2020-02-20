package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 19.
 * @see https://www.acmicpc.net/problem/9320
 * @mem
 * @time
 * @caution 조합과 순열 double형 오차체크가 가장 중요 
 */
public class BOJ_9320_금고열기 {
	static int [] arr = new int [4];
	static int [] nums = new int [4];
	static char [] oper = new char [3];
	static char [] temp = {'+','-','*','/'};
	static boolean b= false;
	static int a = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<4;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			b= false;
			numper(0,new boolean[4]);
			
			if(b) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	public static void numper(int k, boolean [] visit) {
		if(k==4) {
			opermu(0);
		}
		else {
			for(int i=0;i<4;i++) {
				if(!visit[i]) {
					visit[i] = true;
					nums[k] = arr[i];
					numper(k+1,visit);
					visit[i] = false;
				}
			}
		}
	}
	public static void opermu(int k) {
		if(k==3) {
			calc();
			a +=5;
		}
		else {
			for(int i=0;i<4;i++) {
					oper[k] = temp[i];
					opermu(k+1);
			}
		}
	}
	public static void calc() {
		
		if(Math.abs(one2(one2(one2(nums[0],oper[0],nums[1]),oper[1],nums[2]),oper[2],nums[3])-24)<=0.00000001) {
			b = true;
			return;
		}
		if(Math.abs(one2(one2(nums[0],oper[0],one2(nums[1],oper[1],nums[2])),oper[2],nums[3])-24)<=0.00000001) {
			b = true;
			return;
		}
		if(Math.abs(one2(one2(nums[0],oper[0],nums[1]),oper[1],one2(nums[2],oper[2],nums[3]))-24)<=0.00000001) {
			b = true;
			return;
		}
		if(Math.abs(one2(nums[0],oper[0],one2(nums[1],oper[1],one2(nums[2],oper[2],nums[3])))-24)<=0.00000001) {
			b = true;
			return ;
		}
		if(Math.abs(one2(nums[0],oper[0],one2(one2(nums[1],oper[1],nums[2]),oper[2],nums[3]))-24)<=0.00000001) {
			b = true;
			return ;
		}
	}

	public static double one2(double temp1,char a,double temp2) {
		if(a=='+') {
			return temp1 + temp2;
		}
		else if(a=='-') {
			return temp1 - temp2;
		}
		else if(a=='*') {
			return temp1 * temp2;
		}
		else {
			if(temp2==0) {
				return -1234567;
			}
			return temp1 / temp2;
		}
	}
}
