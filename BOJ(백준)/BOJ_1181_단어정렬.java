package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1181_단어정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String [] str = new String[n];
		for(int i=0;i<n;i++) {
			str[i] = sc.next();
		}
		Arrays.sort(str,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()<o2.length()) {
					return -1;
				}
				else if(o1.length()>o2.length()) {
					return 1;
				}
				else {
					return o1.compareTo(o2);
				}
			}
		});
		String temp = str[0];
		System.out.println(temp);
		for(int i=0;i<n;i++) {
			if(temp.compareTo(str[i])!=0) {
				System.out.println(str[i]);
				temp = str[i];
			}
		}
	}

}
