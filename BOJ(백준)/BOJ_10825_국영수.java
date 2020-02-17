package algo_exercise.BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_10825_국영수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Student []st = new Student[n];
		for(int i =0;i<n;i++) {
			st[i] = new Student(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(st, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				if(o1.lang.compareTo(o2.lang)!=0) {
					return o2.lang.compareTo(o1.lang);
				}
				else {
					if(o1.engl.compareTo(o2.engl)!=0) {
						return o1.engl.compareTo(o2.engl);
					}
					else {
						if(o1.math.compareTo(o2.math)!=0) {
							return o2.math.compareTo(o1.math);
						}
						else {
							return o1.name.compareTo(o2.name);
						}
					}
				}
			}
		});
		
		for(int i=0;i<n;i++) {
			System.out.println(st[i].name);
		}
	}
	static class Student{
		String name;
		Integer lang;
		Integer engl;
		Integer math;
		public Student(String name,Integer lang,Integer engl,Integer math) {
			this.name = name;
			this.lang = lang;
			this.engl = engl;
			this.math = math;
		}
	}

}
