package algo_exercise.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class SWEA_1231_중위순회 {
	static Node[] tree;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for(int i=1;i<=10;i++) {
			int n = Integer.parseInt(bf.readLine());
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
			System.out.println();
		}
	}
	public static void inOrder(Node node) {
		if(node==null) {
			return;
		}
		inOrder(node.l);
		System.out.print(node.c);
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
