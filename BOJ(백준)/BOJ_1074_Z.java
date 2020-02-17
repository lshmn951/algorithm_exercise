package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_1074_Z {
	static int num = 0;
	static int result = 0;
	static int r;
	static int c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 1<<sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		ZZZZ(0,n-1,0,n-1,n-1);
		System.out.println(result);
		
	}

	public static void ZZZZ(int str,int endr,int stc,int endc,int size) {
		if(endr-str==1 && endc-stc==1) {
			for(int i=str;i<=endr;i++) {
				for(int j=stc;j<=endc;j++) {
					if(i==r && j==c) {
						result = num;
					}
					num++;
				}
			}
			return;
		}
		else {
			ZZZZ(str,str+size/2,stc,stc+size/2,size/2);
			ZZZZ(str,str+size/2,endc-size/2,endc,size/2);
			ZZZZ(endr-size/2,endr,stc,stc+size/2,size/2);
			ZZZZ(endr-size/2,endr,endc-size/2,endc,size/2);
		}
	}
	
}
