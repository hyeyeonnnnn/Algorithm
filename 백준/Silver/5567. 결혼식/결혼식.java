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
	static int n,m;
	static ArrayList<Integer>[] graph;
	static int[] dp;
	static boolean[] check;
	static int cnt = 0;
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		check[x] = true;
		while(!q.isEmpty()) {
			int next = q.poll();
			for(int i:graph[next]) {
				if(!check[i] && dp[next]==1 || !check[i] &&dp[next]==2) {
					dp[i] = dp[next] + 1;
					q.add(i);
					check[i] = true;
					cnt++;
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		check = new boolean[n+1];
		dp = new int[n+1];
		for(int i=0;i<=n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<=m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start].add(end);
			graph[end].add(start);
		}
		
		dp[1] = 1;
		bfs(1);
		System.out.println(cnt);
	}
	
}
