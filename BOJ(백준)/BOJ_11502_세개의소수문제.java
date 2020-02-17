package algo_exercise.BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11502_세개의소수문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> thtn = new ArrayList<>();
		thtn.add(2);
		boolean b = false;
		for(int i=3;i<1000;i++) {
			b= false;
			for(int j=0;j<thtn.size();j++) {
				if(i%thtn.get(j)==0) {
					b=true;
					break;
				}
			}
			if(!b) {
				thtn.add(i);
			}
		}
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int [] arr = new int[3];
			int n = sc.nextInt();
			int idx=thtn.size();
			b = false;
			for(int j=0;j<thtn.size();j++) {
				if(n<thtn.get(j)) {
					idx=j;
					break;
				}
			}
			outer:for(int a=0;a<idx;a++) {
				for(int s=0;s<idx;s++) {
					for(int c=0;c<idx;c++) {
						if(thtn.get(a)+thtn.get(s)+thtn.get(c)==n) {
							arr[0] = thtn.get(a);
							arr[1] = thtn.get(s);
							arr[2] = thtn.get(c);
							b= true;
							break outer;
						}
					}
				}
			}
			if(b) {
				for(int j=0;j<3;j++) {
					System.out.print(arr[j]+" ");
				}
			}
			else {
				System.out.print(0);
			}
			System.out.println();
		}
	}

}
