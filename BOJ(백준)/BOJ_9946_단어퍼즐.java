package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9946_단어퍼즐 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int [] arr1 = new int [26];
		int [] arr2 = new int [26];
		boolean b=false;
		for(int tc=1;;tc++) {
			b=true;
			arr1 = new int [26];
			arr2 = new int [26];
			String str1 = bf.readLine();
			String str2 = bf.readLine();
			if(str1.equals("END") && str2.equals("END")) {
				break;
			}
			for(int i=0;i<str1.length();i++) {
				arr1[str1.charAt(i)-'a']++;
			}
			for(int i=0;i<str2.length();i++) {
				arr2[str2.charAt(i)-'a']++;
			}
			
			for(int i=0;i<26;i++) {
				if(arr1[i]!=arr2[i]) {
					b = false;
					break;
				}
			}
			if(b) {
				System.out.println("Case "+tc+": same");
			}
			else {
				System.out.println("Case "+tc+": different");
			}
		}
	}

}
