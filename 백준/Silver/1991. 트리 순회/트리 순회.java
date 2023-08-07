import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	static Node node = new Node('A', null, null);
	
	static class Node{
		char value;
		Node left;
		Node right;
		
		Node(char value, Node left, Node right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	private static void insertNode(Node temp, char root, char left, char right) {
		if(temp.value==root) {
			temp.left = (left =='.' ? null : new Node(left, null, null));
			temp.right = (right=='.' ? null : new Node(right, null, null));
		}
		else {
			if(temp.left != null)
				insertNode(temp.left, root, left, right);
			if(temp.right != null)
				insertNode(temp.right, root, left, right);
		}
	}
	
	//전위
	private static void preOrder(Node node) {
		if(node==null) return;
		System.out.print(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	//중위
	private static void inOrder(Node node) {
		if(node==null) return;
		inOrder(node.left);
		System.out.print(node.value);
		inOrder(node.right);
	}
	
	//후위
	private static void postOrder(Node node) {
		if(node==null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			insertNode(node, root, left, right);
			
		}
		
		preOrder(node);
		System.out.println();
		inOrder(node);
		System.out.println();
		postOrder(node);
		System.out.println();
	}
	
	}