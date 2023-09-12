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
	static boolean[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0,-1, 1};
	static int n, m;

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			check[nowX][nowY] = true;
			for(int i=0;i<4;i++) {
				int nextX = nowX+dx[i];
				int nextY = nowY+dy[i];
				if(nextX>=1&&nextX<=n&&nextY>=1&&nextY<=m && graph[nextX][nextY]==1&&!check[nextX][nextY]) {
					check[nextX][nextY] = true;
					q.add(new int[] {nextX, nextY});
					graph[nextX][nextY] = graph[nowX][nowY]+1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n+1][m+1];
		check = new boolean[n+1][m+1];

		for(int i=1;i<=n;i++) {
			String arr = br.readLine();
			for(int j=1;j<=m;j++) {
				graph[i][j] = arr.charAt(j-1)-'0';
			}
		}
		
				
		bfs(1,1);
		
		System.out.println(graph[n][m]);
		
	}
	
}

