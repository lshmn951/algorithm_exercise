package algo_exercise.JA;

import java.util.Scanner;

public class JA_1810_SnowWhite {
	static int [] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		arr= new int [9];
		for(int i= 0;i<9;i++) {
			arr[i] = sc.nextInt();
		}
		com(0,0,new int[7]);
	}
	public static void com(int k,int before,int []temp) {
		if(k==7) {
			int sum=0;
			
			for(int i=0;i<7;i++) {
				sum+=temp[i];
			}
			
			if(sum==100) {
				for(int i=0;i<7;i++) {
					System.out.println(temp[i]);
				}
			}
		}
		else{
			for(int i=before;i<9;i++) {
				temp[k] = arr[i];
				com(k+1,i+1,temp);
			}
		}
	}
}
