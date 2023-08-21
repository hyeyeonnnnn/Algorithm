import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int M;
	static int[][] graph;
	static boolean[] visited;
	
	static void dfs(int x) {
		visited[x] = true;		
		
		for(int i=1;i<=N;i++) {
				if(!visited[i] && graph[x][i]==1)
					dfs(i);
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=1;i<=M;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			graph[x][y] = graph[y][x] = 1;
		}
		
		int total = 0;
		for(int x=1;x<=N;x++) {
				if(!visited[x]) {
					dfs(x);
					total++;
				}
			}
		
	
		
		System.out.println(total);
	}
}