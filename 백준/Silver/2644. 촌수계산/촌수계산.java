import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] graph;
	static int[] dp;
	static boolean[] check;
	static int cnt = 0;
	
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			check[now]= true;
			
			for(int i=0;i<n;i++) {
				if(graph[now][i]==1&&!check[i]) {			
					dp[i] = dp[now]+1;			
					q.add(i);
					}
				}
			}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		dp = new int[n];
		check = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x-1][y-1] = graph[y-1][x-1] = 1;
		}
		
		bfs(start-1);
		if(dp[end-1]==0)
			System.out.println(-1);
		else
			System.out.println(dp[end-1]);
	}	
}

