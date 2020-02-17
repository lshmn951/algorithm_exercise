package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11328_strfry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int [26];
		for(int i=0;i<N;i++) {
			String str = "Possible";
			char[] first = sc.next().toCharArray();
			char[] second = sc.next().toCharArray();
			
			Arrays.sort(first);
			Arrays.sort(second);
			if(first.length!= second.length) {
				str = "Impossible";
			}
			else {
				for(int j=0;j<first.length;j++) {
					if(first[j]!=second[j]) {
						str = "Impossible";
						break;
					}
				}
			}
			System.out.println(str);
		}
		
	}

}
