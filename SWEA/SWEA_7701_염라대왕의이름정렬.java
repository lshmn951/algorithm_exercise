package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_7701_염라대왕의이름정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					 int r = o1.length() - o2.length();
	                    if (r == 0)
	                        return o1.compareTo(o2);
	                    else
	                        return r;
				}
			});
			for(int i=0;i<n;i++) {
				set.add(br.readLine());
			}
			sb.append("#").append(tc).append("\n");
			for(String str:set) {
				sb.append(str).append("\n");
			}
		}
		System.out.println(sb);
	}

}
