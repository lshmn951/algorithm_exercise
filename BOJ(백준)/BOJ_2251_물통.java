package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2251_물통 {
	static int a,b,c;
	static boolean [][][]visit;
	static List<Integer> result = new ArrayList<Integer>();
	static Queue<Water> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		visit = new boolean[a+1][b+1][c+1];
		que.add(new Water(0,0,c));
		while(!que.isEmpty()) {
			Water temp = que.poll();
			int x = temp.x;
			int y = temp.y;
			int z = temp.z;
			if(visit[x][y][z]) {
				continue;
			}

			visit[x][y][z] = true;

			if (x == 0)
				result.add(z);

			if (x + y > b)
				que.add(new Water(x+y-b,b,z));

			else
				que.add(new Water(0,x+y,z));

			if (x + z > c)
				que.add(new Water(x+y-c,y,c));

			else
				que.add(new Water(0,y,x+z));

			if (y + x > a)
				que.add(new Water(a,y+x-a,z));

			else
				que.add(new Water(y+x,0,z));

			if (y + z > c)
				que.add(new Water(x,y+z-c,c));

			else
				que.add(new Water(x,0,y+z));

			if (z + x > a)
				que.add(new Water(a,y,z+x-a));

			else
				que.add(new Water(z+x,y,0));

			if (y + z > b)
				que.add(new Water(x,b,z+y-b));

			else
				que.add(new Water(x,y+z,0));
		}
		Collections.sort(result);
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
	}
	static class Water{
		int x,y,z;
		public Water(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}
}
