package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_11650_좌표정렬하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[][] arr = new Integer[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<Integer []>() {

			@Override
			public int compare(Integer [] o1, Integer [] o2) {
				if(o1[0]<o2[0]) {
					return -1;
				}
				else if(o1[0]>o2[0]) {
					return 1;
				}
				else {
					return o1[1].compareTo(o2[1]);
				}
			}
		});
		for(int i=0;i<n;i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
	}

}
