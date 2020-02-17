package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_2477_참외밭 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int maxw=0;
		int ww=0;
		int maxh=0;
		int hh=0;
		int []arr = new int [6];
		for(int i=0;i<6;i++) {
			int dir = sc.nextInt();
			arr[i] = sc.nextInt();
			if(dir==1 || dir==2) {
				if(maxw<arr[i]) {
					maxw = arr[i];
				}
			}
			else {
				if(maxh<arr[i]) {
					maxh = arr[i];
				}
			}
		}
		
		for(int i=0;i<6;i++) {
			if(maxw == arr[(i+1)%6]+arr[(i+5)%6]) {
				hh = arr[i];
			}
			if(maxh==arr[(i+1)%6]+arr[(i+5)%6]) {
				ww = arr[i];
			}
		}
		int result = k *((maxw*maxh)-(ww*hh));
		System.out.println(result);
	}

}
