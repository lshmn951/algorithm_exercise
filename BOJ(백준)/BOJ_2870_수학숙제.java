package algo_exercise.BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2870_수학숙제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<>();
		Queue<Character> que = new LinkedList<Character>();
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String temp = sc.next();
			String str="";
			for(int j=0;j<temp.length();j++) {
				str="";
				char c = temp.charAt(j);
				if(c>='0' && c<='9') {
					que.add(c);
				}
				else {
					while(!que.isEmpty()) {
						str+=que.poll();
					}
					if(str.length()>0) {
						arr.add(erase(str));
						str="";
					}
				}
			}
			while(!que.isEmpty()) {
				str+=que.poll();
			}
			if(str.length()>0) {
				arr.add(erase(str));
				str="";
			}
		}
		Collections.sort(arr,new Comparator<String>() {

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
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
	}
	public static String erase(String str) {
		while(true) {
			if(str.length()==1) {
				return str;
			}
			else if(str.charAt(0)=='0') {
				str = str.substring(1);
			}
			else {
				return str;
			}
		}
	}
}
