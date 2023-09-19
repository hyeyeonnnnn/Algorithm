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
	static boolean[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> q;
	static int max = Integer.MIN_VALUE;
	static void bfs() {		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			check[nowX][nowY] = true;
			for(int i=0;i<4;i++) {
				int nextX = nowX+dx[i];
				int nextY = nowY+dy[i];
				if(nextX>=0&&nextX<n && nextY>=0&&nextY<m) {
					if(graph[nextX][nextY]==0&&!check[nextX][nextY]) {
						check[nextX][nextY] = true;
						q.add(new int[] {nextX, nextY});
						graph[nextX][nextY] = graph[nowX][nowY]+1;
						if(max<graph[nextX][nextY])
							max = graph[nextX][nextY];
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		check = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q = new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(graph[i][j]==1) {
					q.add(new int[] {i, j});
				}	
			}
		}
		
		boolean is_zero = false;
		loop:
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(graph[i][j]==0) {
					is_zero = true;
					break loop;
				}	
			}
		}
		
		if(!is_zero) {
			System.out.println(0);
		}
		else {
			bfs();
			loop:
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(graph[i][j]==0) {
						is_zero = false;
						break loop;
					}	
				}
			}
			if(!is_zero) {
				System.out.println(-1);
			}
			else {
				System.out.println(max-1);
			}
		}	
	
	}	
}

