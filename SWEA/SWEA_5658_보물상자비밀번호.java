package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA_5658_보물상자비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = N/4;
			int K = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			Map<String, Integer> map = new HashMap<String, Integer>();
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j+=M) {
					String temp = str.substring(j, j+M);
					if(map.containsKey(temp)) {
						continue;
					}
					int ig = Integer.parseInt(temp, 16);
					map.put(temp, ig);
					list.add(ig);
				}
				char end =str.charAt(str.length()-1);
				String sta = str.substring(0,str.length()-1);
				str = end+sta;
			}
			Collections.sort(list,new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					if(o1<o2) {
						return 1;
					}else if(o1>o2) {
						return -1;
					}
					else {
						return 0;
					}
				}
			});
			System.out.println("#"+tc+" "+list.get(K-1));
		}

	}
}
