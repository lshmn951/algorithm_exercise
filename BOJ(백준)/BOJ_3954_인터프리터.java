package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 11.
 * @see https://www.acmicpc.net/problem/3954
 * @mem
 * @time
 * @caution
 */

public class BOJ_3954_인터프리터 {
	static int sm,sc,si;
	static int [] arr;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		for(int tc=0;tc<t;tc++) {
			st = new StringTokenizer(bf.readLine());
			sm = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			si = Integer.parseInt(st.nextToken());
			arr = new int [sm];
			String str1 = bf.readLine();
			String str2 = bf.readLine();
			program(str1,str2);
		}

	}
	public static void program(String str1,String str2) {
		int idx=0,idx2=0;
		int l1=-1,l2=-1;
		int count=0;
		List<Character> inter = new ArrayList<Character>();
		List<Character> inser = new ArrayList<Character>();
		for(int i=0;i<str1.length();i++) {
			inter.add(str1.charAt(i));
		}
		for(int i=0;i<str2.length();i++) {
			inser.add(str2.charAt(i));
		}
		while(!inter.isEmpty() && count<50000000) {
			if(idx2>=inter.size()) {
				System.out.println("Terminates");
				return;
			}
			switch(inter.get(idx2)) {
			case'-':
				arr[idx] = (arr[idx]-1) < 0? 255:arr[idx]-1;
				break;

			case'+':
				arr[idx] = (arr[idx]+1)%256;
				break;

			case'<':
				idx = (idx-1)< 0? sm-1:idx-1;
				break;

			case'>':
				idx = (idx+1)%sm;
				break;

			case'[':
				if(arr[idx]==0) {
					int lco = 1;
					for(int l=idx2+1;l<inter.size();l++) {
						if(inter.get(l)=='[') {
							lco++;
						}
						else if(inter.get(l)==']') {
							lco--;
						}
						if(lco==0) {
							idx2=l;
							break;
						}
					}
				}
				break;

			case']':
				if(arr[idx]!=0) {
					int rco = 1;
					boolean b = false;
					if(idx2>l2) {
						l2 = idx2;
						b= true;
					}
					for(int l=idx2-1;l>=0;l--) {
						if(inter.get(l)==']') {
							rco++;
						}
						else if(inter.get(l)=='[') {
							rco--;
						}
						if(rco==0) {
							idx2=l;
							if(b)
								l1 = l;
							break;
						}
					}
				}
				break;

			case'.':
				break;

			case',':
				if(!inser.isEmpty()) {
					arr[idx] = (int)inser.get(0);
					inser.remove(0);
				}
				else {
					arr[idx] = 255;
				}
				break;

			}
			idx2++;
			count++;
		}
		System.out.println("Loops"+" "+l1+" "+l2);
	}
}
