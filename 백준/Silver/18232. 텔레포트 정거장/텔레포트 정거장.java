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
	static int n,m,s,e;
	static ArrayList<Integer>[] graph;
	static int[] dp;
	static int[] dx = {1,-1};
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		while(!q.isEmpty()) {
			int next = q.poll();
			if(next==e) {
				break;
			}
			for(int i=0;i<2;i++) {
				int value = next+dx[i];
				if(value>=0 && value<=n)
					if(dp[value]==0){
						dp[value] = dp[next] + 1;
						q.add(value);	
					}			
			}
			
			for(int i:graph[next]) {
				if(dp[i]==0) {
					dp[i] = dp[next] + 1;
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
		
		graph = new ArrayList[n+1];
	
		dp = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
	
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int tel1 = Integer.parseInt(st.nextToken());
			int tel2 = Integer.parseInt(st.nextToken());
			graph[tel1].add(tel2);
			graph[tel2].add(tel1);
		}
		
		bfs(s);
		System.out.println(dp[e]);
	}
		
}

