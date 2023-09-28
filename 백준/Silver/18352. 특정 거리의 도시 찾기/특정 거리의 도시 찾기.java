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
	static int n,m,k,x;
	static ArrayList<Integer>[] graph;
	static ArrayList<Integer> result = new ArrayList<>();
	static boolean[] check;
	static int[] dp;
	
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();	
		check[x] = true;
		
		q.add(x);
		while(!q.isEmpty()) {
			int next = q.poll();
			for(int i : graph[next]) {
				if(!check[i]) {
					check[i] = true;
					dp[i] = Math.min(dp[next] + 1, dp[i]);
					q.add(i);
					if(dp[i]==k) {
						result.add(i+1);
					}
					
				}
			}
		}
		
		
		if(result.size() ==0)
			result.add(-1);
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n];
		check = new boolean[n];
		dp = new int[n];
		
		for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
		
		for(int i=0;i<n;i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[x-1] = 0;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x-1].add(y-1);
		}
		
		bfs(x-1);
		
		Collections.sort(result);
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));
		
	}
		
}

