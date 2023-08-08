import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int[] parent;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		parent = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1;i<=N;i++)
			graph[i] = new ArrayList<>();
		
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		
		
		dfs(1);

		for(int i=2;i<=N;i++) {
			sb.append(parent[i]+"\n");
		}
		
		System.out.println(sb);
	}
	
	private static void dfs(int u) {
		for(int v : graph[u]) {
			if(!visited[v]) {
				parent[v] = u;
				visited[v] = true;
				dfs(v);
			}
		}
	}
	}