package algo_exercise.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2063_D1_중간값찾기_이성현 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = scanner.nextInt();
		}
		sort(arr);
		System.out.println(arr[N/2]);
		
	}
	public static void sort(int[] arr) {
		// TODO Auto-generated method stub
		
		for(int i=arr.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
