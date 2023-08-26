import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parents;
	static ArrayList<Node> nodeList;
	
	static class Node implements Comparable<Node> {
		int start;
		int end;
		double cost;
		
		public Node(int start, int end, double cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			if(this.cost > o.cost)
				return 1;
			else
				return -1;
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
			parents[fromRoot] = toRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			
			int[][] arr = new int[N+1][2]; //우주신의 좌표
					
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				arr[i][0] = x;
				arr[i][1] = y;
			}
		
			for(int i=1;i<=N;i++) {
				parents[i] = i;
			}

			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
	
				union(from, to);
			}

	
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			//연결 가능한 모든 통로 큐에 추가
			for(int i=1;i<N;i++) {
				for(int j=i+1; j<N+1;j++) {
					int x1 = arr[i][0];
					int y1 = arr[i][1];
					int x2 = arr[j][0];
					int y2 = arr[j][1];
					
					double cost = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
					
					pq.add(new Node(i, j, cost));
				}
			}
		
		
		
		double sum = 0;
		while(!pq.isEmpty()) {
				Node node = pq.poll();
				
				if(union(node.start, node.end))
					sum += node.cost;
			
		}
		System.out.println(String.format("%.2f", sum));		


		
	}
}