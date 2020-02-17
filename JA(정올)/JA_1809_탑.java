
package algo_exercise.JA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class JA_1809_탑 {

	 public static void main(String[] args) throws Exception {
	        // TODO Auto-generated method stub
		 	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 	StringBuilder sb = new StringBuilder();
	        StringTokenizer st;
	        Stack<Tower> stack1 = new Stack<>();
	        int n = Integer.parseInt(bf.readLine());
	        int [] ekq = new int[n];
	        
	        st = new StringTokenizer(bf.readLine());
	        int h = Integer.parseInt(st.nextToken());
	        
	        stack1.push(new Tower(1,h));
	        sb.append(0).append(" ");
	        for(int i=1;i<n;i++) {
	        	h = Integer.parseInt(st.nextToken());
	        	Tower temp = stack1.peek();
	        	if(temp.height>h) {
	        		sb.append(temp.idx).append(" ");
	        		stack1.push(new Tower(i+1,h));
	        	}
	        	else {
	        		while(!stack1.isEmpty()) {
	        			temp = stack1.peek();
	        			if(temp.height<h) {
	        				stack1.pop();
	        				continue;
	        			}
	        			else {
	        				break;
	        			}
	        		}
	        		if(!stack1.isEmpty()) {
	        			sb.append(temp.idx).append(" ");
	        		}
	        		else {
	        			sb.append(0).append(" ");
	        		}
	        		stack1.push(new Tower(i+1,h));
	        	}
	        }
	        System.out.println(sb);
	 }       
	 
	 static class Tower{
		 int idx;
		 int height;
		public Tower(int idx, int height) {
			super();
			this.idx = idx;
			this.height = height;
		}
		 
	 }
}

