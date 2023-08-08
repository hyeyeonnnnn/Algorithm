import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	static int k;
	static int[] arr;
	static List<ArrayList<Integer>> tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		k = Integer.parseInt(br.readLine());
		arr = new int[(int)Math.pow(2, k)-1];
		tree = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<k;i++) {
			tree.add(new ArrayList<>());
		}
		
		dfs(0,arr.length-1,0);
		
		for(int i=0;i<k;i++) {
			for(int j:tree.get(i)) {
				sb.append(j+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int start, int end, int depth) {
		if(depth==k)
			return;
		
		int mid = (start+end)/2;
		tree.get(depth).add(arr[mid]);
		
		dfs(start,mid-1,depth+1);
		dfs(mid+1,end,depth+1);
	}
	}