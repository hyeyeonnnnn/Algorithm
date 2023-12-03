import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static int cnt = 0;
	static int max_cnt = Integer.MIN_VALUE;
	static int node;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> counts = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	static void dfs(int index, int depth) {
		for(int i=0;i<graph.get(index).size();i++) {
			int next = graph.get(index).get(i);
			int value = counts.get(index).get(i);
			if(!visited[next]) {
				visited[next] = true;
				cnt += value;
				dfs(next, depth+1);
				max_cnt = Math.max(max_cnt, cnt); //최대값 찾기
				if(max_cnt == cnt) node = next;
				cnt -= value; //cnt 회복
				visited[next] = false;
			}			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		V = Integer.parseInt(br.readLine());
		
		for(int i=0;i<V+1;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<V+1;i++) {
			counts.add(new ArrayList<Integer>());
		}
		
		for(int i=1;i<V+1;i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());

			int j=0;
			while(true) {
				int next = Integer.parseInt(st.nextToken());
				if(next == -1) break;
				if((j+1)%2 == 1)
					graph.get(index).add(next);
				else
					counts.get(index).add(next);
				j++;
			}
		}
		
	
		visited = new boolean[V+1];
		visited[1] = true;
		cnt = 0;
		dfs(1,0);
		
		visited = new boolean[V+1];
		visited[node] = true;
		cnt = 0;
		dfs(node,0);
		System.out.println(max_cnt);
   }
}