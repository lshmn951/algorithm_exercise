package algo_exercise.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class SWEA_1233_사칙연산유효성검사 {
	static Node[] tree;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for(int i=1;i<=10;i++) {
			int n = Integer.parseInt(bf.readLine());
			sb = new StringBuilder();
			tree = new Node[n+1];
			
			for(int j=0;j<n;j++) {
				String str = bf.readLine();
				String []splited = str.split(" ");
				int v = Integer.parseInt(splited[0]);
				char c = splited[1].charAt(0);
				Node tnode = getNode(v);
				tnode.c = c;
				if(splited.length==4) {
					int l = Integer.parseInt(splited[2]);
					int r = Integer.parseInt(splited[3]);
					Node lnode = getNode(l);
					Node rnode = getNode(r);
					tnode.l = lnode;
					tnode.r = rnode;
				}
				else if(splited.length==3) {
					int l = Integer.parseInt(splited[2]);
					Node lnode = getNode(l);
					tnode.l = lnode;
				}
			}
			System.out.print("#"+i+" ");
			inOrder(tree[1]);
			boolean b = true;
			for(int j=0;j<sb.length()-1;j++) {
				if(sb.charAt(j)>='0' && sb.charAt(j)<='9' && sb.charAt(j+1)>='0' && sb.charAt(j+1)<='9'){
					b=false;
					break;
				}
				else if(!(sb.charAt(j)>='0' && sb.charAt(j)<='9') && !(sb.charAt(j+1)>='0' && sb.charAt(j+1)<='9')) {
					b=false;
					break;
				}
			}
			if(b) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
			
		}
	}
	public static void inOrder(Node node) {
		if(node==null) {
			return;
		}
		inOrder(node.l);
		sb.append(node.c);
		inOrder(node.r);
	}
	private static Node getNode(int idx) {
		if(tree[idx]==null) {
			tree[idx] = new Node(idx);
		}
		return tree[idx];
	}
	static class Node{
		char c;
		int idx;
		Node r,l;
		
		public Node(int idx) {
			this.idx = idx;
		}
	}
}
