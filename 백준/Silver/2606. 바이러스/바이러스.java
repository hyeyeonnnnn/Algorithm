import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int M;
	static int N;
	static int[][] graph;
	static boolean[] visited;
	static int cnt = 0;
	
	static void dfs(int x) {
		visited[x] = true;
		
		for(int i=1;i<=N;i++) {
			if(!visited[i] && graph[x][i]==1) {
				cnt++;
				dfs(i);
			}
		}	
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
				
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = graph[y][x] = 1;
		}
		
		dfs(1);
		System.out.println(cnt);
	}
}