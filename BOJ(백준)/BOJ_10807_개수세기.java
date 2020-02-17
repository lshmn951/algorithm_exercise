package algo_exercise.BOJ;

import java.util.Scanner;

public class BOJ_10807_개수세기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[] = new int [201];
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			int input = sc.nextInt();
			arr[input+100]++;
		}
		int v = sc.nextInt();
		System.out.println(arr[v+100]);
	}

}
