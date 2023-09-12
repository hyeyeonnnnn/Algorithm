import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] check;
	static int cnt;

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = true;

		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : graph.get(now)) {
				if(!check[next]) {
					cnt++;
					q.add(next);
					check[next] = true;
				}	
			}		
		}

	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		check = new boolean[n+1];

		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			int end = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			graph.get(start).add(end);
		}
		
		int max = Integer.MIN_VALUE;
		int[] arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			cnt = 0;
			bfs(i);
			arr[i] = cnt;

			max = Math.max(max, cnt);
			Arrays.fill(check, false);
		}
		
	
		for(int i=1;i<=n;i++) {
			if(arr[i]==max)
				sb.append(i+" ");
		}
		System.out.println(sb);
	}
	
}

