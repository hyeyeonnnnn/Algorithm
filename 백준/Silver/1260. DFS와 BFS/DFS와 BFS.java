import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static boolean[] check1;
	static boolean[] check2;
	static int n, m;
	
	static void dfs(int start) {
		check1[start] = true;
		System.out.print(start+" ");
		
		for(int i=1;i<=n;i++) {
			if(graph[start][i]==1 && !check1[i]) {
				dfs(i);
			}		
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		check2[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now+" ");
			
			for(int i=1;i<=n;i++) {
				if(graph[now][i]==1 && !check2[i]) {
					check2[i] = true;
					q.add(i);
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		graph = new int[n+1][n+1];
		check1 = new boolean[n+1];
		check2 = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start][end] = graph[end][start] = 1;
		}
		
		dfs(v);
		System.out.println();
		bfs(v);
		System.out.println();
		
	}
	
}

