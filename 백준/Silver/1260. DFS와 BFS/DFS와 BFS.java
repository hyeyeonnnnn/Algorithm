import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int M;
	static int N;
	static int V;
	static int[][] graph;
	static int[][] graph2;
	static boolean[] visited;

	
	static void dfs(int x) {
		visited[x] = true;
		
		System.out.print(x+" ");
		
		for(int i=1;i<=N;i++) {
			if(!visited[i] && graph[x][i]==1)
				dfs(i);
		}	
	}
	
	static void bfs(int x) {
		boolean[] visited2 = new boolean[N+1];
		Queue<Integer> que = new LinkedList<Integer>();
		
		visited2[x] = true;
		que.offer(x);
		
		while(!que.isEmpty()) {
			int node = que.poll();
			System.out.print(node+" ");
			for(int i=1;i<=N;i++) {
				if(!visited2[i] && graph2[node][i]==1) {
					que.offer(i);
					visited2[i] = true;
				}
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		graph2 = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			graph[x][y] = graph[y][x] = 1;
			graph2[x][y] = graph2[y][x] = 1;
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
	}
}