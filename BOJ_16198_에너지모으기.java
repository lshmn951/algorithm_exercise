package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16198_에너지모으기 {
	static int n;
	static List<Integer> list = new ArrayList<Integer>();
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		recur(0);
		System.out.println(max);
	}

	public static void recur(int temp) {
		if(list.size()==2) {
			max = Math.max(max, temp);
		}
		for(int i=1;i<list.size()-1;i++) {
			int t = list.get(i);
			temp += list.get(i-1)*list.get(i+1);
			list.remove(i);
			recur(temp);
			list.add(i, t);
			temp -= list.get(i-1)*list.get(i+1);
		}
	}

}
