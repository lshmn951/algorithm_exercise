package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//MST (최소신장트리 문제)
//Prim(프림) 기법을 이용한 풀이

public class SWEA_1251_하나로_prim {

	public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            int n = Integer.parseInt(br.readLine());
            Point []p= new Point[n];
            List<Point> []ad = new List[n];
            boolean []visit = new boolean[n];
            for(int i=0;i<n;i++) {
                p[i] = new Point(0,0);
                ad[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                p[i].x = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                p[i].y = Long.parseLong(st.nextToken());
            }
            for(int i=0;i<n;i++) {
                for(int j=i+1;j<n;j++) {
                    long distx = (p[i].x - p[j].x) * (p[i].x - p[j].x);
                    long disty = (p[i].y - p[j].y) * (p[i].y - p[j].y);
                    ad[i].add(new Point(j,distx+disty));
                    ad[j].add(new Point(i,distx+disty));
                }
            }
            double e = Double.parseDouble(br.readLine());
 
            PriorityQueue<Link> que = new PriorityQueue<>();
            for(int i=0;i<ad[0].size();i++) {
                Point q = ad[0].get(i);
                que.add(new Link(0,(int)q.x,q.y));
            }
             
            visit[0] = true;
            int cnt =0;
            long res = 0;
            while(true) { 
                Link temp = que.poll(); 
                if(visit[temp.y]) { 
                    continue; 
                }
                visit[temp.y]= true; 
                res += temp.cost; 
                cnt++; 
                if(cnt==n-1) break; 
                for(int i=0;i<ad[temp.y].size();i++) {
                    Point q = ad[temp.y].get(i);
                    if(!visit[(int)q.x]) {
                        que.add(new Link(temp.y,(int)q.x,q.y));
                    }
                }
            }
            System.out.print("#"+tc+" ");
            System.out.println(Math.round(res*e));
        }
    }
    static class Point{
        long x,y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Link implements Comparable<Link>{
        int x,y;
        long cost;
        @Override
        public int compareTo(Link o) {
            if(this.cost<o.cost) {
                return -1;
            }
            else {
                return 1;
            }
        }
        public Link(int x, int y, long cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        @Override
        public String toString() {
            return "Link [x=" + x + ", y=" + y + ", cost=" + cost + "]";
        }
    }
}
