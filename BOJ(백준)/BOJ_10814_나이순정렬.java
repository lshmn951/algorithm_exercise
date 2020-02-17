package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_10814_나이순정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Member [] mbs = new Member[n];
		for(int i=0;i<n;i++) {
			mbs[i] = new Member(sc.nextInt(),sc.next(),i+1);
		}
		Arrays.sort(mbs, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				if(o1.age.compareTo(o2.age)!=0) {
					return o1.age.compareTo(o2.age);
				}
				else {
					return o1.order.compareTo(o2.order);
				}
			}
		});
		for(int i=0;i<n;i++) {
			System.out.println(mbs[i].age+" "+mbs[i].name);
		}
	}
	
	static class Member{
		Integer age;
		String name;
		Integer order;
		public Member(Integer age,String name,Integer order) {
			this.age = age;
			this.name = name;
			this.order = order;
		}
	}
}
