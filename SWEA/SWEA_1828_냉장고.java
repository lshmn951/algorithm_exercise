package algo_exercise.SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_1828_냉장고 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Ref> list = new ArrayList<>();
		List<Integer> arr = new ArrayList<>();
		int N = sc.nextInt();
		int sum=0;
		int max=0;
		int maxi=0;
		
		for(int i=0;i<N;i++) {
			int xi = sc.nextInt();
			int yi = sc.nextInt();
			arr.add(yi);
			list.add(new Ref(xi,yi));
		}
		Collections.sort(arr);
		while(!arr.isEmpty()) {
			for(int i=0;i<list.size();i++) {
				if(arr.get(0)>=list.get(i).xi && arr.get(0)<=list.get(i).yi) {
					
				}
			}
		}
		System.out.println(sum);
	}
	static class Ref{
		int xi,yi;

		public Ref(int xi, int yi) {
			this.xi = xi;
			this.yi = yi;
		}
		
	}
}
