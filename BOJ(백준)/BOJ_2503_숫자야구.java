package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_2503_숫자야구 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int count=0;
		Integer [][]arr = new Integer[n][3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(Integer i=123;i<=987;i++) {
			String str1 = i.toString();
			if(str1.charAt(0)=='0' || str1.charAt(1)=='0' ||str1.charAt(2)=='0') {
				continue;
			}
			else if(str1.charAt(0)==str1.charAt(1)||str1.charAt(0)==str1.charAt(2)||str1.charAt(1)==str1.charAt(2)) {
				continue;
			}
			else {
				if(check(str1,arr,n)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static boolean check(String str1,Integer [][]arr,int n) {
		for(int i=0;i<n;i++) {
			String str2 = arr[i][0].toString();
			int strike=0;
			int ball=0;
			for(int j=0;j<3;j++) {
				if(str1.charAt(j)==str2.charAt(j)) {
					strike++;
				}
			}
			if(strike!=arr[i][1]) {
				return false;
			}
			for(int j=0;j<3;j++) {
				for(int k=0;k<3;k++) {
					if(j!=k) {
						if(str1.charAt(j)==str2.charAt(k)) {
							ball++;
						}
					}
				}
			}
			if(ball!=arr[i][2]) {
				return false;
			}
		}
		return true;
	}

}
