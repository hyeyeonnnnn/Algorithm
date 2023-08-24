import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int[] parents;
	static ArrayList<Node> nodeList;
	
	static class Node implements Comparable<Node> {
		int from;
		int to;
		int cost;
		
		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	private static int findSet(int v) {
		if(parents[v]==v)
			return v;
		else
			return parents[v] = findSet(parents[v]);
	}
	
	private static boolean union(int from, int to) {
		int fromRoot = findSet(from);
		int toRoot = findSet(to);
		
		if(fromRoot == toRoot)
			return false;
		else
			parents[toRoot] = fromRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			long total = 0;
			long sum = 0;
			
			if(V==0 && E==0)
				break;
			parents = new int[V+1];
			nodeList = new ArrayList<>();
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				total += cost;
				nodeList.add(new Node(from, to, cost));
			}
		
				
		for(int i=1;i<=V;i++) {
			parents[i] = i;
		}
		
		Collections.sort(nodeList);
		
		int cnt = 0;
		for(Node n : nodeList) {
			if(union(n.from, n.to)) {
				sum += n.cost;
				cnt++;
				if(cnt==V-1)
					break;
			}
		}
		System.out.println(total-sum);		

		}

		
	}
}